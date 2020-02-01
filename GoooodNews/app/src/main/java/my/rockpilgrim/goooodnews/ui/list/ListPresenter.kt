package my.rockpilgrim.goooodnews.ui.list

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import my.rockpilgrim.goooodnews.R
import my.rockpilgrim.goooodnews.data.DataCard
import my.rockpilgrim.goooodnews.data.Model
import my.rockpilgrim.goooodnews.data.OnLoadListener
import my.rockpilgrim.goooodnews.di.App
import javax.inject.Inject

@InjectViewState
class ListPresenter(private val model: Model) : MvpPresenter<ListMvpView>(),
    ItemRequest {

    val TAG: String = "ListPresenter"


    init {
        Log.i(TAG, "init")
        App.appComponent.inject(this)

    }

    override fun attach() {
        Log.i(TAG,"attach()")
        load()
    }

    private fun load(){
        model.loadData(object : OnLoadListener {
            override fun loadDataSuccess() {
                viewState.dataSuccess()
            }
            override fun showError() {
                viewState.dataError()
            }
        })
    }

    override fun update() {
        load()
    }

    override fun getTitle(position: Int): String{
        return model.getTitle(position)
    }

    override fun getDate(position: Int): String{
        return model.getDate(position)
    }

    override fun getCount(): Int {
        return model.getCount()
    }
}