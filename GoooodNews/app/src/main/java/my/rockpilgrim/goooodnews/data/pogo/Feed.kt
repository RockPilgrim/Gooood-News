package my.rockpilgrim.retrofittest.pogo

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

@Xml
data class Feed(
    @Element(name = "channel")
    var channel: Channel
)
