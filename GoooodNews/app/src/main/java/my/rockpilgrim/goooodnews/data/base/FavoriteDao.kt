package my.rockpilgrim.goooodnews.data.base

import androidx.room.*
import my.rockpilgrim.retrofittest.pogo.Article

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorite_table")
    fun getAllPhoto(): List<Article>

    @Insert
    fun add(article:Article)

    @Delete
    fun delete(article:Article)

    @Update
    fun update(article:Article)
}