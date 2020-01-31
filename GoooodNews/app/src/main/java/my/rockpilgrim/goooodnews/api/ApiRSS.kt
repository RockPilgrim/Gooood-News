package my.rockpilgrim.goooodnews.api

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import my.rockpilgrim.retrofittest.pogo.Channel
import my.rockpilgrim.retrofittest.pogo.Feed
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET

interface ApiRSS {

    /// vesti.ru/vesti.rss
    @GET("vesti.rss")
    fun getFeed(): Observable<Feed>

    companion object Factory{
        fun create():ApiRSS{
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .baseUrl("https://vesti.ru/")
                .build()
            return retrofit.create(ApiRSS::class.java)
        }
    }
}