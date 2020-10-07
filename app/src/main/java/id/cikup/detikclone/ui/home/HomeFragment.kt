package id.cikup.detikclone.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.cikup.detikclone.R
import id.cikup.detikclone.adapter.NewsAdapter
import id.cikup.detikclone.model.Article
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContruct.View {

    lateinit var presenter: HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = HomePresenter(this)
        presenter.getData()
    }

    override fun onFailed(message: String) {
        progressBarHolder.visibility = View.GONE
    }

    override fun showProgress() {
        progressBarHolder.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBarHolder.visibility = View.GONE

    }

    override fun showdata(dataItem: List<Article>) {
        newsRV.setHasFixedSize(true)
        newsRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        newsRV.adapter = NewsAdapter(this.requireContext(), dataItem)

    }
}