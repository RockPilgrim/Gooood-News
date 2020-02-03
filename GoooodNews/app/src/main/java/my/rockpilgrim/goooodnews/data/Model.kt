package my.rockpilgrim.goooodnews.data

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import my.rockpilgrim.goooodnews.api.ApiRSS
import my.rockpilgrim.goooodnews.data.pogo.Article
import my.rockpilgrim.goooodnews.data.pogo.Feed
import java.util.*

class Model : DataInformation{

    private val subscriptions = CompositeDisposable()
    private val api: ApiRSS = ApiRSS.create()
    private var news = ArrayList<Article>()

    val TAG = "Model"


    fun loadAll(listener: OnLoadListener) {
        news = ArrayList<Article>()
        connectToDb()
        loadData(listener)
    }

    private fun loadData(listener: OnLoadListener){
        val subscribe = api.getFeed().subscribeOn(Schedulers.single())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ feed: Feed ->
                news.addAll(feed.channel.items)
                listener.loadDataSuccess()
                Log.i(TAG, "loadData() ${Thread.currentThread().name}, size: ${news.size}")
            }, { error ->
                Log.e(TAG, "error server connection", error)
                listener.showError()
            })
        subscriptions.add(subscribe)
    }

    private fun connectToDb() {
        val disposable = FavoriteData().loadData()
            .subscribeOn(Schedulers.single())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ favorites: List<Article> ->
                news.addAll(favorites)
                Log.i(TAG, "connectDb() ${Thread.currentThread().name}, size: ${news.size}")
            }, {error ->
                Log.i(TAG, "error localDb connection", error)
            })
        subscriptions.add(disposable)
    }

    private fun addToDb(article: Article) {
        val disposable = FavoriteData().addData(article)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ message: String ->
                Log.i(TAG, "addToDb() $message")
            }, {error ->
                Log.i(TAG, "error localDb add", error)
            })
        subscriptions.add(disposable)
    }

    private fun deleteFromDb(article: Article) {
        val disposable = FavoriteData().deleteData(article)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ message: String ->
                Log.i(TAG, "deleteFromDb() $message")
            }, {error ->
                Log.i(TAG, "error localDb delete", error)
            })
        subscriptions.add(disposable)
    }

    override fun getImage(position: Int): String {
        return news[position].url
    }

    override fun getFullText(position: Int): String {
        val fullText=news[position].fullText.replace("&quot;", "\"")
        return fullText
    }

    override fun findCategory(category: String) {
        val categoryNews = ArrayList<Article>()
        Log.i(TAG,"findCategory(${ category})")
        for (article in news) {
            if (article.category.equals(category)) {
                categoryNews.add(article)
            }
        }
        news = categoryNews
    }

    override fun getTitle(position: Int): String {
        val title = news[position].title.replace("&quot;", "\"")
        return title
    }

    override fun getDate(position: Int): String {
        return news[position].date
    }

    override fun getCategory(position: Int): String {
        return news[position].category
    }

    override fun isFavorite(position: Int): Boolean {
        return news[position].favorite
    }

    override fun setFavorite(position: Int, isFavorite: Boolean) {
        val article = news[position]
        article.favorite = isFavorite
        if (isFavorite) {
            addToDb(article)
        } else {
            deleteFromDb(article)
        }
    }

    override fun getCount(): Int {
        return news.size
    }
}