package my.rockpilgrim.goooodnews.data

import android.util.Log
import io.reactivex.Single
import io.reactivex.SingleOnSubscribe
import my.rockpilgrim.goooodnews.di.App
import my.rockpilgrim.retrofittest.pogo.Article

class FavoriteData {

    private val favoriteDao = App.appDatabase.favoriteDao()

    fun loadData(): Single<List<Article>> {
        return Single.create(SingleOnSubscribe {
            Log.i("Data", Thread.currentThread().name)
            it.onSuccess(favoriteDao.getAllPhoto())
        })
    }
    fun addData(article: Article): Single<String> {
        return Single.create(SingleOnSubscribe {
            favoriteDao.add(article)
            it.onSuccess("Added ${article.title}")
        })
    }
    fun deleteData(article: Article): Single<String> {
        return Single.create(SingleOnSubscribe {
            favoriteDao.delete(article)
            it.onSuccess("Delete ${article.title}")
        })
    }
}