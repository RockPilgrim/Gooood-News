package my.rockpilgrim.retrofittest.pogo

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
data class Article(
    @field:Element(name = "title", required = false)
    @param:Element(name = "title", required = false)
    var title: String,

    @field:Element(name = "category", required = false)
    @param:Element(name = "category", required = false)
    var category: String,

    @field:Element(name = "pubDate", required = false)
    @param:Element(name = "pubDate", required = false)
    var date: String,

    /// TODO full text <yandex:full-text>
    @field:Element(name = "description", required = false)
    @param:Element(name = "description", required = false)
    var fullText: String)