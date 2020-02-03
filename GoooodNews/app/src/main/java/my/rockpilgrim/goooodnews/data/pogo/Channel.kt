package my.rockpilgrim.goooodnews.data.pogo

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

@Xml
data class Channel(
    @Element(name = "item")
    var items: List<Article>
)
