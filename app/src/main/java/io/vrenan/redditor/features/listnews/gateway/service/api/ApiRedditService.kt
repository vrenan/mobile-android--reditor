package io.vrenan.redditor.features.listnews.gateway.service.api

import io.reactivex.Single
import io.vrenan.redditor.features.listnews.gateway.service.api.response.RedditNewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRedditService {
    @GET("/top.json")
    fun getNewsResponse(@Query("limit") limit: Int): Single<RedditNewsResponse>
}