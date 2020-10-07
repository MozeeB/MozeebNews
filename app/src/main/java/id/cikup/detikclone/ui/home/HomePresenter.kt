package id.cikup.detikclone.ui.home

import id.cikup.detikclone.model.Article
import id.cikup.detikclone.model.NewsModel
import id.cikup.detikclone.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNCHECKED_CAST")
class HomePresenter(model: HomeContruct.View): HomeContruct.Presenter {

    var view :HomeContruct.View? = null

    init {
        view = model
    }
    override fun getData() {
        view?.showProgress()
        ApiConfig.create().getNews().enqueue(object : Callback<NewsModel>{
            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                view?.hideProgress()
                if (response.isSuccessful){
                    view?.showdata(response.body()?.articles as List<Article>)
                }else{
                    view?.onFailed(response.toString())
                }
            }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                view?.onFailed(t.toString())
            }
        })
    }

}