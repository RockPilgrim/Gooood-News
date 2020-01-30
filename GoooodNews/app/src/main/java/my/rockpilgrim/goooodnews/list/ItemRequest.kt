package my.rockpilgrim.goooodnews.list

interface ItemRequest {

    fun getTitle(position: Int): String
    fun getDate(position: Int): String
}