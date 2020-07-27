package my.rockpilgrim.goooodnews.ui.list

import android.view.View
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*
import my.rockpilgrim.goooodnews.data.pogo.Article
import my.rockpilgrim.goooodnews.databinding.ListItemBinding
import my.rockpilgrim.goooodnews.di.App
import javax.inject.Inject

class ListItemHolder(private val binding: ListItemBinding, private val itemRequest: ItemRequest) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var conteiner: View
    private lateinit var favoriteButton:ToggleButton
    private lateinit var categoryBtn:TextView


    fun bind(itemListener: OnitemListener?, position: Int) {
        App.getListComponent().inject(this)
        binding.article = itemRequest.getArticle(position)

        conteiner = itemView.itemContainer
        categoryBtn = itemView.categoryButton
        favoriteButton = itemView.favoriteButton

        setListeners(itemListener,position)
    }

    private fun setListeners(
        itemListener: OnitemListener?,
        position: Int
    ) {
        // Save favorite article
        favoriteButton.setOnClickListener {
            itemRequest.setFavorite(position, favoriteButton.isChecked)
        }
        // Show detail information
        conteiner.setOnClickListener {
            itemListener!!.onClick(position)
        }
        // Sort news by category
        categoryBtn.setOnClickListener {
            itemRequest.findCategory(category = categoryBtn.text.toString())
        }
    }
}
