package my.rockpilgrim.goooodnews.data

import my.rockpilgrim.goooodnews.data.pogo.Article

interface DataInformation : DataCard {

    fun getArticle(position: Int): Article

    fun getImage(position: Int): String
    fun getFullText(position: Int): String
}