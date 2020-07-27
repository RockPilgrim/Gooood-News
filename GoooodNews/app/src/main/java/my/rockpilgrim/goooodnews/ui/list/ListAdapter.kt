package my.rockpilgrim.goooodnews.ui.list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import my.rockpilgrim.goooodnews.databinding.ListItemBinding

class ListAdapter(private val itemRequest: ItemRequest) : RecyclerView.Adapter<ListItemHolder>() {

    companion object{
        val TAG = ListAdapter::class.java.simpleName
    }

    private var countItem: Int = 0
    private var itemListener: OnitemListener? = null

    fun setItemListener(itemListener: OnitemListener) {
        this.itemListener = itemListener
    }

    fun setItemCount(countItem: Int) {
        this.countItem = countItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListItemHolder(binding, itemRequest)
    }

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {
        holder.bind(itemListener!!,position)
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount() $countItem")
        return countItem
    }
}
