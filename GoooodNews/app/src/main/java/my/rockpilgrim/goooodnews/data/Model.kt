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

    companion object{
        val TAG = Model::class.java.simpleName
    }

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
                Log.e(TAG, "loadData() error server connection", error)
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
                Log.i(TAG, "connectToDb() error localDb connection", error)
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

    override fun getArticle(position: Int) =
        news[position]

    override fun getImage(position: Int): String {
        return news[position].url
    }


    override fun getFullText(position: Int): String {
        return news[position].fullText
            .replace("&quot;", "\"")
            .replace("&#13;", "")
    }

    override fun findCategory(category: String) {
        val categoryNews = ArrayList<Article>()
        Log.i(TAG,"findCategory(${category})")
        for (article in news) {
            if (article.category == category) {
                categoryNews.add(article)
            }
        }
        Log.d(TAG, "findCategory() Category.Size: ${categoryNews.size} News.size: ${news.size}")
        news = categoryNews
    }

    override fun getTitle(position: Int): String {
        return news[position].title.replace("&quot;", "\"")
    }

    override fun getDate(position: Int): String {
        val tokenizer=StringTokenizer(news[position].date)
        tokenizer.nextToken()
        val line =
            tokenizer.nextToken() + " " + tokenizer.nextToken() + " " + tokenizer.nextToken() + ", " + tokenizer.nextToken()
        return line
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
        Log.d(TAG, "getCount() Size: ${news.size}")
        return news.size
    }
}