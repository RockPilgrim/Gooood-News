package my.rockpilgrim.retrofittest.pogo

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
data class Channel(
    @field:ElementList(name = "item", inline = true, required = false)
    @param:ElementList(name = "item", inline = true, required = false)
    val items: List<Article>,

    @field:Element(name = "title", required = false)
    @param:Element(name = "title", required = false)
    val title: String)