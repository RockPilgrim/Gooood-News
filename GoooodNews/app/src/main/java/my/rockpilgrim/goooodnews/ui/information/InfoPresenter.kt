package my.rockpilgrim.goooodnews.ui.information

interface InfoPresenter {

    fun getTitle(position: Int): String
    fun getFullText(position: Int): String
    fun getImage(position: Int): String
}