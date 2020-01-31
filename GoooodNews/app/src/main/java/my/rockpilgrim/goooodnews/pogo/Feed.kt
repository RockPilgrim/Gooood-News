package my.rockpilgrim.retrofittest.pogo

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class Feed(
    @field:Element(name = "channel", required = false)
    @param:Element(name = "channel", required = false)
    var channel: Channel)
