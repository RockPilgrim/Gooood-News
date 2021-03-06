package my.rockpilgrim.goooodnews.ui.list

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import my.rockpilgrim.goooodnews.data.Model
import my.rockpilgrim.goooodnews.data.OnLoadListener
import my.rockpilgrim.goooodnews.data.pogo.Article
import my.rockpilgrim.goooodnews.di.App

@InjectViewState
class ListPresenter(private val model: Model) : MvpPresenter<ListMvpView>(), ItemRequest {

    companion object{
        val TAG: String = ListPresenter::class.java.simpleName
    }


    init {
        Log.i(TAG, "init")
        App.appComponent.inject(this)
    }

    override fun attach() {
        Log.i(TAG,"attach()")
//        load()
    }

    private fun load(){
        model.loadAll(object : OnLoadListener {
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

    override fun findCategory(category: String) {
        model.findCategory(category)
        viewState.update()
    }

    override fun getArticle(position: Int): Article {
        return model.getArticle(position)
    }

    override fun getTitle(position: Int): String{
        return model.getTitle(position)
    }

    override fun getCategory(position: Int): String {
        return model.getCategory(position)
    }

    override fun isFavorite(position: Int): Boolean {
        return model.isFavorite(position)
    }

    override fun setFavorite(position: Int, isFavorite: Boolean) {

        model.setFavorite(position, isFavorite)
    }

    override fun getDate(position: Int): String{
        return model.getDate(position)
    }

    override fun getCount(): Int {
        return model.getCount()
    }
}