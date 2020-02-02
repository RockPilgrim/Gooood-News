package my.rockpilgrim.goooodnews.data.pogo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_table")
data class SaveArticle(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    var title: String,

    var category: String,

    var date: String,

    var url: String,

    var fullText: String
){
    var favorite = true
}