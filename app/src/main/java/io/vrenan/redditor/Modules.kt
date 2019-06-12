package io.vrenan.redditor

import io.vrenan.redditor.features.listnews.viewmodel.ListNewsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    single {

    }
    
    viewModel {
        ListNewsViewModel(get())
    }
}