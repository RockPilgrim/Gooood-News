package my.rockpilgrim.goooodnews.ui.list

interface ItemRequest {

    fun attach()
    fun update()

    fun getTitle(position: Int): String
    fun getDate(position: Int): String
    fun getCount(): Int
}