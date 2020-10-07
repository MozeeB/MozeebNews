package id.cikup.detikclone.model

data class NewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)