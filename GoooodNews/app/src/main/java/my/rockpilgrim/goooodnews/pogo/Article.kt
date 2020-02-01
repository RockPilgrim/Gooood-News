package my.rockpilgrim.retrofittest.pogo

import com.tickaroo.tikxml.annotation.*

@Xml(name = "item")
data class Article constructor(

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
)