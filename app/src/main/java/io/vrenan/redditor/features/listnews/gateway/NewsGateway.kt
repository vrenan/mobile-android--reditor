package io.vrenan.redditor.features.listnews.gateway

import io.reactivex.Single
import io.vrenan.redditor.features.listnews.model.News

interface NewsGateway {
    fun listNews(limit: Int): Single<List<News>>
}