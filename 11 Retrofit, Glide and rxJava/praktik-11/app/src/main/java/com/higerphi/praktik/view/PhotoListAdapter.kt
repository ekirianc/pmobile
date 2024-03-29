package com.higerphi.praktik.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.higerphi.praktik.R
import com.higerphi.praktik.model.Photo
import kotlinx.android.synthetic.main.item_list.view.*

class PhotoListAdapter (var photos: ArrayList<Photo>):
    RecyclerView.Adapter<PhotoListAdapter.ViewHolder>(){
    fun updatePhotos(newPhotos: List<Photo>){
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent,false)
    )

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: PhotoListAdapter.ViewHolder, position: Int) {
        holder.bind(photos[position])
    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(photos: Photo){
            itemView.tvTitle.text = photos.title
            itemView.setOnClickListener{view->
                Toast.makeText(itemView.context, "Hello", Toast.LENGTH_LONG).show()
            }
            Glide.with(itemView.context)
                .load(photos.thumbnailUrl + ".jpg")
                .into(itemView.imageView)
        }
    }
}