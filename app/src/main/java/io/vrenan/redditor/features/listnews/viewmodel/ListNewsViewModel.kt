package io.vrenan.redditor.features.listnews.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.vrenan.redditor.features.listnews.gateway.NewsGateway
import io.vrenan.redditor.features.listnews.model.News

class ListNewsViewModel(private val gateway: NewsGateway): ViewModel() {

    val items: MutableLiveData<List<News>> = MutableLiveData()
    val loading: MutableLiveData<Boolean> = MutableLiveData()

    fun onResume() : Completable {
        loading.postValue(true)
        return gateway.listNews(10).flatMapCompletable {
            loading.postValue(false)
            items.postValue(it)
            return@flatMapCompletable Completable.complete()
        }
    }
}