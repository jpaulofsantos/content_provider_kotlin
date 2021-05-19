package com.example.contentprovider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter : RecyclerView.Adapter<NotesViweHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViweHolder =
        NotesViweHolder(LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false))

    override fun onBindViewHolder(holder: NotesViweHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}

class NotesViweHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

}