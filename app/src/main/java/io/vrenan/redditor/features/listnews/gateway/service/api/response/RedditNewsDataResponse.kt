package io.vrenan.redditor.features.listnews.gateway.service.api.response

data class RedditNewsDataResponse(
    val author: String,
    val title: String,
    val num_comments: Int,
    val created: Long,
    val thumbnail: String,
    val url: String,
    val subreddit: String
)