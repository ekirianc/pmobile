package com.pm.latihan

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pm.latihan.catatan.Note
import kotlinx.android.synthetic.main.note_item.view.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class NoteAdapter : ListAdapter<Note, NoteAdapter.NoteHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Note>() {
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem.title == newItem.title &&
                        oldItem.tanggal == newItem.tanggal &&
                        oldItem.description == newItem.description &&
                        oldItem.priority == newItem.priority
            }

        }
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy")
        val formattedTime = current.format(formatter).toString()

    }
    private var listener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val currentNote: Note = getItem(position)
        holder.textViewTanggal.text = currentNote.tanggal
        holder.textViewTitle.text = currentNote.title
        if (currentNote.priority == true){
            holder.textViewPriority.setImageResource(R.drawable.ic_baseline_push_pin_24)
        }else{
            holder.textViewPriority.setImageResource(R.drawable.ic_baseline_hourglass_empty_24)
        }
        if (currentNote.description == ""){
            holder.textViewDescription.textSize = 0F
            holder.textViewDescription.setPadding(0,0,0,12)
        }else{
            holder.textViewDescription.text = currentNote.description
        }

    }
    fun getNoteAt(position: Int): Note {
        return getItem(position)
    }
    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener?.onItemClick(getItem(position))
                }
            }
        }
        var textViewTanggal: TextView = itemView.tanggal
        var textViewTitle: TextView = itemView.text_view_title
        var textViewPriority: ImageView = itemView.image_view_priority
        var textViewDescription: TextView = itemView.text_view_description
    }
    interface OnItemClickListener {
        fun onItemClick(note: Note)
    }
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}