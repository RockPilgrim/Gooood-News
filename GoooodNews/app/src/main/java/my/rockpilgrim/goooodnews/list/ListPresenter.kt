package my.rockpilgrim.goooodnews.list

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import my.rockpilgrim.goooodnews.R
import my.rockpilgrim.goooodnews.data.DataCard
import my.rockpilgrim.goooodnews.di.App
import javax.inject.Inject

@InjectViewState
class ListPresenter() : MvpPresenter<ListMvpView>(),ItemRequest {

    val TAG: String = "ListPresenter"

    @Inject
    lateinit var dataCard:DataCard

    init {
        Log.i(TAG, "init")
        App.appComponent.inject(this)
    }

    fun test() {
        val TAG = "ListPresenter"
        Log.i(TAG, "test()")
    }

    override fun getTitle(position: Int): String{
        val title = (R.string.title_not_found)
        return dataCard.getTitle(position)
    }

    override fun getDate(position: Int): String{
        val date = (R.string.pubDate)
        return dataCard.getDate(position)
    }
}