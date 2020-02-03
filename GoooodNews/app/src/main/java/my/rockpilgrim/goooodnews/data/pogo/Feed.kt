package my.rockpilgrim.goooodnews.data.pogo

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml
import my.rockpilgrim.goooodnews.data.pogo.Channel

@Xml
data class Feed(
    @Element(name = "channel")
    var channel: Channel
)
