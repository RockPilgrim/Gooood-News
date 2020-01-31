package my.rockpilgrim.goooodnews.data

interface DataCard {

    fun getTitle(position: Int): String
    fun getDate(position: Int): String
    fun getCount(): Int
}