package my.rockpilgrim.goooodnews.data

import java.net.URL

interface DataInformation : DataCard {

    fun getImage(position: Int): String
    fun getFullText(position: Int): String
}