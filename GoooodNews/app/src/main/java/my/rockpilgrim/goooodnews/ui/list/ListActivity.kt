package my.rockpilgrim.goooodnews.ui.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
        presenter.attach()
    }

    private fun initRecycler() {
        Log.i(TAG,"initRecycler()")
        adapter.setItemListener(getItemListener())
        adapter.itemCount=presenter.getCount()
        listRecyclerView.adapter = adapter
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
        initRecycler()
    }

    override fun dataError() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
