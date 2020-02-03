package my.rockpilgrim.goooodnews.data

interface DataInformation : DataCard {

    fun getImage(position: Int): String
    fun getFullText(position: Int): String
}