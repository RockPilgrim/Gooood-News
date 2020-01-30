package my.rockpilgrim.goooodnews.data

import java.net.URL

class Model : DataInformation{


    override fun getImage(position: Int): String {
        return ""
    }

    override fun getFullText(position: Int): String {
        return "Lorem ipsum"
    }

    override fun getTitle(position: Int): String {
        return "Title not found"
    }

    override fun getDate(position: Int): String {
        return "Wed, 07 August 1890"
    }


}