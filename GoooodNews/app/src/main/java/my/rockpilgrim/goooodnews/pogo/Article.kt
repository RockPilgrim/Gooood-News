package my.rockpilgrim.retrofittest.pogo

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import my.rockpilgrim.goooodnews.pogo.Enclosure

@Xml(name = "item")
data class Article constructor(

    @PropertyElement(name = "title")
    var title: String,

    @PropertyElement(name = "category")
    var category: String,

    @PropertyElement(name = "pubDate")
    var date: String,

    @Element
    var enclosure:Enclosure,

    @PropertyElement(name = "yandex:full-text")
    var fullText: String
)