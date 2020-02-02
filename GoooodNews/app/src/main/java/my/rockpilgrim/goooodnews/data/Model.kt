package my.rockpilgrim.goooodnews.data

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import my.rockpilgrim.goooodnews.api.ApiRSS
import my.rockpilgrim.retrofittest.pogo.Article
import my.rockpilgrim.retrofittest.pogo.Feed
import java.net.URL

class Model : DataInformation{

    private val subscriptions = CompositeDisposable()
    private val api: ApiRSS = ApiRSS.create()
    private lateinit var news: List<Article>
    val TAG = "Model"


    fun loadData(listener: OnLoadListener){
        Log.i(TAG, "loadData")

        val subscribe = api.getFeed().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ feed: Feed ->
                news = feed.channel.items
                listener.loadDataSuccess()
            }, { error ->
                Log.e(TAG, "error", error)
                listener.showError()
            })

        subscriptions.add(subscribe)
    }

    override fun getImage(position: Int): String {
        return news[position].url
    }

    override fun getFullText(position: Int): String {
        return news[position].fullText
    }

    override fun getTitle(position: Int): String {
        return news[position].title
    }

    override fun getDate(position: Int): String {
        return news[position].date
    }

    override fun isFavorite(position: Int): Boolean {
        return news[position].favorite
    }

    override fun setFavorite(position: Int, isFavorite: Boolean) {
        news[position].favorite = isFavorite
    }

    override fun getCount(): Int {
        return news.size
    }


}