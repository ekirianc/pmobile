package com.higerphi.praktik.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.higerphi.praktik.R
import com.higerphi.praktik.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ListViewModel
    private  var photoListAdapter = PhotoListAdapter(arrayListOf(),arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.fetchData()

        rv_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = photoListAdapter
        }
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.photos.observe(this, Observer{ photos->
            photos?.let{
                photoListAdapter.updatePhotos(it)
//                photoListAdapter.updatePhotos(it)
            }
        })
        viewModel.posts.observe(this, Observer{ posts->
            posts?.let{
                photoListAdapter.updatePosts(it)
            }

        })
    }
}