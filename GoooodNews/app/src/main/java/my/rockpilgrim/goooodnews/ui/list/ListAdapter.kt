package my.rockpilgrim.goooodnews.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import my.rockpilgrim.goooodnews.R

class ListAdapter : RecyclerView.Adapter<ListItemHolder>() {

    private var countItem: Int = 0
    private var itemListener: OnitemListener? = null

    fun setItemListener(itemListener: OnitemListener) {
        this.itemListener = itemListener
    }

    fun setItemCount(countItem: Int) {
        this.countItem = countItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ListItemHolder(root)
    }

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {
        holder.bind(itemListener!!)
    }

    override fun getItemCount(): Int {
        return countItem
    }
}
