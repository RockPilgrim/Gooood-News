package my.rockpilgrim.goooodnews.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*
import my.rockpilgrim.goooodnews.di.App
import javax.inject.Inject

class ListItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var conteiner: View

    @Inject
    lateinit var itemRequest: ItemRequest


    fun bind(itemListener: OnitemListener?) {
        App.appComponent.inject(this)
        conteiner = itemView.itemContainer

        itemView.itemTitleTextView.setText(itemRequest.getTitle(adapterPosition))
        itemView.itemDateTextView.setText(itemRequest.getDate(adapterPosition))

        conteiner.setOnClickListener {
            itemListener!!.onClick(adapterPosition)
        }
    }
}
