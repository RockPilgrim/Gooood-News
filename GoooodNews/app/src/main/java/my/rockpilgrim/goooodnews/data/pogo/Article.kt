package my.rockpilgrim.goooodnews.data.pogo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tickaroo.tikxml.annotation.*

@Entity(tableName = "favorite_table")
@Xml(name = "item")
data class Article constructor(

    @PrimaryKey
    @PropertyElement(name = "title")
    var title: String,

    @PropertyElement(name = "category")
    var category: String,

    @Path("enclosure")
    @Attribute(name = "url")
    private var mUrl: String? = "https://cdn-st1.rtr-vesti.ru/vh/pictures/b/298/268/3.jpg",


    @PropertyElement(name = "pubDate")
    var date: String = "Tue, 07 Jul 2020 20:39:00 +0300",


    @PropertyElement(name = "yandex:full-text")
    var fullText: String
){
    var favorite = false

    var url: String = mUrl ?: ""

}