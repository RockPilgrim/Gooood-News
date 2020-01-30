package my.rockpilgrim.goooodnews.list

import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.list_activity.*
import my.rockpilgrim.goooodnews.R
import my.rockpilgrim.goooodnews.di.App
import my.rockpilgrim.goooodnews.information.InformationActivity
import javax.inject.Inject


class ListActivity : MvpAppCompatActivity(),ListMvpView {

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

        presenter.test()
        initRecycler()
    }

    private fun initRecycler() {
        adapter.setItemListener(getItemListener())
        listRecyclerView.adapter = adapter
    }

    private fun getItemListener(): OnitemListener = object : OnitemListener {
        override fun onClick(position: Int) {
            intent = Intent(this@ListActivity, InformationActivity().javaClass)
            intent.putExtra(InformationActivity().TAG, position)
            startActivity(intent)
        }
    }

    override fun update() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
