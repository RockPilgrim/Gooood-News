package my.rockpilgrim.goooodnews.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import my.rockpilgrim.goooodnews.R
import java.util.*

@BindingAdapter("app:data")
fun bindImageFromUrl(textView: TextView, date: String?) {
    if (date.isNullOrEmpty()) {
        textView.text = textView.context.getString(R.string.no_date)
    }else
        textView.text = formatDate(date)
}

fun formatDate(date: String): String {
    val tokenizer= StringTokenizer(date)
    tokenizer.nextToken()
    return tokenizer.nextToken() + " " + tokenizer.nextToken() + " " + tokenizer.nextToken() + ", " + tokenizer.nextToken()
}