package io.vrenan.redditor.features.listnews.model

import java.net.URI

data class News(
    val author: String,
    val title: String,
    val numberComments: Int,
    val created: Long,
    val thumbnail: URI?,
    val url: URI?,
    val permalink: URI,
    val subredit: String
)
