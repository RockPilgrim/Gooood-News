package my.rockpilgrim.goooodnews.ui.list

interface ItemRequest {

    fun attach()
    fun update()
    fun findCategory(category: String)

    fun getTitle(position: Int): String
    fun getCategory(position: Int): String
    fun isFavorite(position: Int): Boolean
    fun setFavorite(position: Int,isFavorite:Boolean)
    fun getDate(position: Int): String
    fun getCount(): Int
}