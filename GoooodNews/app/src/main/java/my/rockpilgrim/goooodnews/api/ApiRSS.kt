package my.rockpilgrim.goooodnews.api

import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import io.reactivex.Observable
import my.rockpilgrim.retrofittest.pogo.Feed
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.http.GET

interface ApiRSS {

    /// vesti.ru/vesti.rss
    @GET("vesti.rss")
    fun getFeed(): Observable<Feed>

    companion object Factory{
        fun create():ApiRSS{

            val tikXml= TikXml.Builder()
                .exceptionOnUnreadXml(false)
                .build()
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(TikXmlConverterFactory.create(tikXml))
                .baseUrl("https://vesti.ru/")
                .build()
            return retrofit.create(ApiRSS::class.java)
        }
    }
}