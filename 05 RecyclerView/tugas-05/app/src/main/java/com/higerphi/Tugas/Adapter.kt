package com.higerphi.Tugas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list.view.*

class Adapter (
    private val list:ArrayList<Users>,
    private val listener: OnItemClickListener
    ) : RecyclerView.Adapter<Adapter.Holder>(){

    val twitContent = arrayOf(
        "ah, i see i have discovered the best boon in the game",
        "good morning",
        "indomie good",
        "Why do the chicken cross the road?",
        "Not reza avanluna making french toast at 2AM",
        "P",
        "Duar",
        "off",
        "Hello"
    )

    override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): Holder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list,parent,false)
        return Holder(v)
    }

    override fun getItemCount (): Int = list.size

    override fun onBindViewHolder (holder: Holder, position: Int) {
        holder.view.nama.text = list.get(position).name
        holder.twit.text = twitContent[position]
    }

    inner class Holder (val view: View) : RecyclerView.ViewHolder (view), View.OnClickListener {
//        var namaUser: TextView
        var twit: TextView
        init {
            view.setOnClickListener(this)
            twit = itemView.findViewById(R.id.twit)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position  != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}
