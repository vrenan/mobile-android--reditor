package io.vrenan.redditor.features.listnews.gateway.service

import io.reactivex.Single
import io.vrenan.redditor.features.listnews.gateway.NewsGateway
import io.vrenan.redditor.features.listnews.gateway.service.api.ApiRedditService
import io.vrenan.redditor.features.listnews.gateway.service.api.response.RedditNewsResponse
import io.vrenan.redditor.features.listnews.model.News
import java.net.URI
import java.net.URL

class NewsService(val apiRedditService: ApiRedditService): NewsGateway {

    override fun listNews(limit: Int): Single<List<News>> {
        return apiRedditService.getNewsResponse(limit).map(::parse)
    }

    fun parse(redditNewsResponse: RedditNewsResponse): List<News> {
        return redditNewsResponse.data.children.map {
            val response = it.data
            return@map News(
                author = response.author,
                title = response.title,
                numberComments = response.num_comments,
                created = response.created,
                thumbnail = URI(response.thumbnail),
                url = URI(response.url),
                permalink = URI(response.url),
                subredit = response.subreddit
            )
        }

    }

}