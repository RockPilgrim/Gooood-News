package my.rockpilgrim.goooodnews.data

interface DataCard {

    fun findCategory(category: String)

    fun getTitle(position: Int): String
    fun getDate(position: Int): String
    fun getCategory(position: Int): String
    fun isFavorite(position: Int): Boolean
    fun setFavorite(position: Int,isFavorite:Boolean)
    fun getCount(): Int
}