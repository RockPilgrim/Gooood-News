package my.rockpilgrim.goooodnews.ui.list

import android.view.View
import android.widget.CompoundButton
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*
import my.rockpilgrim.goooodnews.di.App
import javax.inject.Inject

class ListItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var conteiner: View
    private lateinit var favoriteButton:ToggleButton

    @Inject
    lateinit var itemRequest: ItemRequest


    fun bind(itemListener: OnitemListener?) {
        App.appComponent.inject(this)
        conteiner = itemView.itemContainer

        itemView.itemTitleTextView.setText(itemRequest.getTitle(adapterPosition))
        itemView.itemDateTextView.setText(itemRequest.getDate(adapterPosition))
        favoriteButton=itemView.favoriteButton

        favoriteButton.isChecked = itemRequest.isFavorite(adapterPosition)

        favoriteButton.setOnClickListener {
            itemRequest.setFavorite(adapterPosition, favoriteButton.isChecked)
        }
        conteiner.setOnClickListener {
            itemListener!!.onClick(adapterPosition)
        }
    }
}
