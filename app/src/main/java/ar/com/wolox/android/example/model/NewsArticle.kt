package ar.com.wolox.android.example.model

data class NewsArticle constructor(
    val title: String,
    val picture: String,
    val text: String,
    val createdAt: String,
    val likes: ArrayList<Int>
)
