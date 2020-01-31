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
//        var line = "Not found"

        val subscribe = api.getFeed().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ feed: Feed ->
/*                Log.i(TAG, feed.channel.title)
                Log.i(TAG, feed.channel.items.get(0).title)
                line = feed.channel.items.get(0).title*/
                news = feed.channel.items
                listener.loadDataSuccess()
            }, { error ->
                Log.e(TAG, "error", error)
                listener.showError()
            })

        subscriptions.add(subscribe)
        Log.i(TAG, "loadDataEnd")
    }

    override fun getImage(position: Int): String {
        return ""
    }

    override fun getFullText(position: Int): String {
        return news.get(position).fullText
//        return "Lorem"
    }

    override fun getTitle(position: Int): String {
        return news.get(position).title
    }

    override fun getDate(position: Int): String {
        return news.get(position).date
//        return ""
    }

    override fun getCount(): Int {
        return news.size
    }


}