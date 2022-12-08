package com.higerphi.praktik.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.higerphi.praktik.R
import com.higerphi.praktik.model.Photo
import com.higerphi.praktik.model.Posts
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list.view.*

class PhotoListAdapter (var photos: ArrayList<Photo>,var posts: ArrayList<Posts>):
    RecyclerView.Adapter<PhotoListAdapter.ViewHolder>(){
    fun updatePhotos(newPhotos: List<Photo>){
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }
    fun updatePosts(newPosts: List<Posts>){
        posts.clear()
        posts.addAll(newPosts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent,false)
    )

    override fun getItemCount(): Int {
        return Math.min(photos.size, 10)
    }

    override fun onBindViewHolder(holder: PhotoListAdapter.ViewHolder, position: Int) {
        holder.bind(photos[position], posts[position])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        fun bind(photos: Photo, posts: Posts){
            itemView.setOnClickListener{view->
                Toast.makeText(itemView.context, photos.albumId.toString(), Toast.LENGTH_LONG).show()
            }
            Glide.with(itemView.context)
                .load(photos.thumbnailUrl + ".jpg")
                .into(itemView.imageView)

            var string = posts.title.toString()
            var arr = string.split(" ").take(2).toString()
            var post = arr.replace("[","").replace("]","").replace(",","")

            itemView.username.text = post
            itemView.post.text =  posts.body

            if (photos.id == posts.id){
                itemView.komentar.text = photos.title
                Glide.with(itemView.context)
                    .load(photos.thumbnailUrl + ".jpg")
                    .into(itemView.commentPict)
            }
        }
    }
}