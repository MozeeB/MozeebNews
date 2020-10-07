package id.cikup.detikclone.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import id.cikup.detikclone.R
import kotlinx.android.synthetic.main.fragment_detail_news.*

class DetailNewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_news, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val title = arguments?.get("title")
        val description = arguments?.get("description")
        val date = arguments?.get("date")
        val author = arguments?.get("author")
        val gambar = arguments?.get("image")

        Picasso.get().load(gambar.toString()).into(imageDetailFragmentIV)
        titleDetailNewsTV.text = title.toString()
        authorDetailNewsTV.text = author.toString()
        dateDetailNewsTV.text = date.toString()
        contentDetailNewsTV.text = description.toString()

    }
}