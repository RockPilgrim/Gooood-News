package my.rockpilgrim.goooodnews.data.base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import my.rockpilgrim.goooodnews.data.pogo.Article

@Database(entities = [Article::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao

    companion object {
        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, "favorite_table")
                .build()
    }
}