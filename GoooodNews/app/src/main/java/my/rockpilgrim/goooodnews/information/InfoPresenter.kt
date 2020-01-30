package my.rockpilgrim.goooodnews.information

interface InfoPresenter {

    fun getTitle(position: Int): String
    fun getDate(position: Int): String
    fun getFullText(position: Int): String
    fun getImage(position: Int): String
}