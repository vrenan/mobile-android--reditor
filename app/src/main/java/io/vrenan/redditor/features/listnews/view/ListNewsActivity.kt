package io.vrenan.redditor.features.listnews.view

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.vrenan.redditor.R
import io.vrenan.redditor.features.listnews.model.News
import io.vrenan.redditor.features.listnews.view.adapter.ListNewsAdapter
import io.vrenan.redditor.features.listnews.viewmodel.ListNewsViewModel
import kotlinx.android.synthetic.main.activity_list_news.*
import org.koin.android.ext.android.inject

class ListNewsActivity : AppCompatActivity() {

    val viewModel: ListNewsViewModel by inject()
    val adapter: ListNewsAdapter = ListNewsAdapter()
    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_news)
        progressDialog = createDialog(this)
        prepare(recyclerView, adapter)
        bind(this, viewModel)
    }

    private fun createDialog(context: Context): ProgressDialog {
       return ProgressDialog(context)
    }

    private fun bindUpdateList(it: List<News>) {
        adapter.update(it)
    }

    private fun bindIsLoading(isLoading: Boolean) {
        if(isLoading) {
            progressDialog?.show()
            return
        }
        progressDialog?.dismiss()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun onDestroy() {
        progressDialog = null
        super.onDestroy()
    }

    private fun prepare(recyclerView: RecyclerView, adapter: ListNewsAdapter) {
        recyclerView.layoutManager = createLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun bind(context: Context, viewModel: ListNewsViewModel) {
        viewModel.items.observe(this, Observer(::bindUpdateList))
        viewModel.loading.observe(this, Observer(::bindIsLoading))
    }

    private fun createLayoutManager(context: Context): LinearLayoutManager {
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        return linearLayoutManager
    }
}
