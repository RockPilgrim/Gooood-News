package my.rockpilgrim.goooodnews.ui.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.list_activity.*
import my.rockpilgrim.goooodnews.R
import my.rockpilgrim.goooodnews.di.App
import my.rockpilgrim.goooodnews.ui.information.InformationActivity
import javax.inject.Inject


class ListActivity : MvpAppCompatActivity(),
    ListMvpView {

    val TAG="ListActivity"
    private var isRecyclerInitilized = false

    @Inject
    lateinit var adapter: ListAdapter

    @Inject
    @InjectPresenter
    lateinit var presenter: ListPresenter

    @ProvidePresenter
    fun provideListPresenter(): ListPresenter = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)
        refreshLayout.isRefreshing = true
        presenter.attach()
    }

    private fun initRecycler() {
        Log.i(TAG,"initRecycler()")
        adapter.setItemListener(getItemListener())
        adapter.itemCount=presenter.getCount()
        listRecyclerView.adapter = adapter

        refreshLayout.setOnRefreshListener {
            presenter.update()
        }
        isRecyclerInitilized=true
    }

    private fun getItemListener(): OnitemListener = object :
        OnitemListener {
        override fun onClick(position: Int) {
            intent = Intent(this@ListActivity, InformationActivity().javaClass)
            intent.putExtra(InformationActivity().TAG, position)
            startActivity(intent)
        }
    }

    override fun dataSuccess() {
        update()
        refreshLayout.isRefreshing = false
    }

    override fun dataError() {
        refreshLayout.isRefreshing=false
        makeToast(getString(R.string.connection_error))
    }

    override fun update() {
        if (!isRecyclerInitilized) {
            initRecycler()
        } else {
            adapter.itemCount=presenter.getCount()
            adapter.notifyDataSetChanged()
        }
    }

    private fun makeToast(line: String) {
        Toast.makeText(this, line, Toast.LENGTH_SHORT).show()
    }
}
