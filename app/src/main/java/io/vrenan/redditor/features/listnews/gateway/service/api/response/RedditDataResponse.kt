package io.vrenan.redditor.features.listnews.gateway.service.api.response

data class RedditDataResponse(
    val children: List<RedditChildrenResponse>,
    val after: String?,
    val before: String?
)
