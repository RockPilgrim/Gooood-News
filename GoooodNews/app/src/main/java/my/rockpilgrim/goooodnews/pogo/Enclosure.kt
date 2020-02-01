package my.rockpilgrim.goooodnews.pogo

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "enclosure")
data class Enclosure(

    @Attribute(name = "url")
    var url: String
)