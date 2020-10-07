package id.cikup.detikclone.ui.home

import id.cikup.detikclone.model.Article

interface HomeContruct {
    interface View{
        fun onFailed(message: String)
        fun showProgress()
        fun hideProgress()
        fun showdata(dataItem: List<Article>)
    }
    interface Presenter{
        fun getData()
    }
}