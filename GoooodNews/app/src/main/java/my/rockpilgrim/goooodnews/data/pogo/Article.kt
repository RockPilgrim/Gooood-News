package my.rockpilgrim.retrofittest.pogo

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

    @PropertyElement(name = "pubDate")
    var date: String,

    @Path("enclosure")
    @Attribute(name = "url")
    var url: String,

    @PropertyElement(name = "yandex:full-text")
    var fullText: String
){
    var favorite = false
}