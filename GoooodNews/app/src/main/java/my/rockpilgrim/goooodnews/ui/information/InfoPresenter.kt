package my.rockpilgrim.goooodnews.ui.information

import my.rockpilgrim.goooodnews.data.pogo.Article

interface InfoPresenter {

    fun getArticle(position: Int): Article

    fun getTitle(position: Int): String
    fun getFullText(position: Int): String
    fun getImage(position: Int): String
}