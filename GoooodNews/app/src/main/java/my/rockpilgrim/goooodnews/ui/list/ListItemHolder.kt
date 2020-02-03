package my.rockpilgrim.goooodnews.ui.list

import android.view.View
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*
import my.rockpilgrim.goooodnews.di.App
import javax.inject.Inject

class ListItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var conteiner: View
    private lateinit var favoriteButton:ToggleButton
    private lateinit var categoryBtn:TextView

    @Inject
    lateinit var itemRequest: ItemRequest


    fun bind(itemListener: OnitemListener?) {
        App.appComponent.inject(this)

        conteiner = itemView.itemContainer
        categoryBtn=itemView.categoryButton

        itemView.itemTitleTextView.text = itemRequest.getTitle(adapterPosition)
        itemView.itemDateTextView.text = itemRequest.getDate(adapterPosition)
        categoryBtn.text = itemRequest.getCategory(adapterPosition)
        favoriteButton=itemView.favoriteButton

        favoriteButton.isChecked = itemRequest.isFavorite(adapterPosition)

        setListeners(itemListener)
    }

    private fun setListeners(itemListener: OnitemListener?) {
        favoriteButton.setOnClickListener {
            itemRequest.setFavorite(adapterPosition, favoriteButton.isChecked)
        }
        conteiner.setOnClickListener {
            itemListener!!.onClick(adapterPosition)
        }
        categoryBtn.setOnClickListener {
            itemRequest.findCategory(category = categoryBtn.text.toString())
        }
    }
}
