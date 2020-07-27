package my.rockpilgrim.goooodnews.ui.information

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import my.rockpilgrim.goooodnews.data.DataInformation
import my.rockpilgrim.goooodnews.data.pogo.Article
import my.rockpilgrim.goooodnews.di.App

@InjectViewState
class InformationPresenter(private val model: DataInformation) : MvpPresenter<InfoMvpView>(),
    InfoPresenter {

    companion object{
        val TAG = InformationPresenter::class.java.simpleName
    }


    init {
        App.appComponent.inject(this)
        Log.i(TAG, "init")
    }

    override fun getArticle(position: Int): Article {
        return model.getArticle(position)
    }

    override fun getTitle(position: Int): String {
        return model.getTitle(position)
    }

    override fun getFullText(position: Int): String {
        return model.getFullText(position)
    }

    override fun getImage(position: Int): String {
        return model.getImage(position)
    }

}