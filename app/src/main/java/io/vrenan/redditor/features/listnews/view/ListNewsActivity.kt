package io.vrenan.redditor.features.listnews.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.vrenan.redditor.R
import io.vrenan.redditor.features.listnews.viewmodel.ListNewsViewModel
import org.koin.android.ext.android.inject

class ListNewsActivity : AppCompatActivity() {

    val viewModel: ListNewsViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_news)
    }
}
