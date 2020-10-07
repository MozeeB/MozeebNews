package id.cikup.detikclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.cikup.detikclone.R
import id.cikup.detikclone.model.Article

class NewsAdapter(c: Context?, data: List<Article>?) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    var dataItem: List<Article>? = data
    var mContext: Context? = c

    override fun getItemCount(): Int {
        return dataItem?.size!!
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(mContext).inflate(R.layout.item_news, p0, false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.judul?.text = dataItem?.get(p1)?.title
        p0.description?.text = dataItem?.get(p1)?.description
        Picasso.get().load(dataItem?.get(p1)?.urlToImage).into(p0.image)

        p0.itemView.setOnClickListener {
            val bundle = bundleOf(
                "title" to dataItem?.get(p1)?.title,
                "description" to dataItem?.get(p1)?.description,
                "image" to dataItem?.get(p1)?.urlToImage,
                "author" to dataItem?.get(p1)?.author,
                "date" to dataItem?.get(p1)?.publishedAt
            )
            it.findNavController().navigate(R.id.action_homeFragment_to_detailNewsFragment, bundle)
        }
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var judul = itemView?.findViewById<TextView>(R.id.titleNewsItemView)
        var description = itemView?.findViewById<TextView>(R.id.descriptionNewsItemView)
        var image = itemView?.findViewById<ImageView>(R.id.imageNewsItemView)



    }

}