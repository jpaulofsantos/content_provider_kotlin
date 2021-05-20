package com.example.contentprovider

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contentprovider.database.NotesDatabaseHelper.Companion.DESCRIPTION_NOTES
import com.example.contentprovider.database.NotesDatabaseHelper.Companion.TITLE_NOTES

class NotesAdapter(private val listener: NoteClickedListener) : RecyclerView.Adapter<NotesViweHolder> () {

    private var cursor: Cursor? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViweHolder =
        NotesViweHolder(LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false))

    override fun onBindViewHolder(holder: NotesViweHolder, position: Int) { //pegando as strings das colunas do database (baseado na position do viewholder)
        cursor?.moveToPosition(position)
        holder.noteTitle.text = cursor?.getString(cursor?.getColumnIndex(TITLE_NOTES) as Int)
        holder.noteDescription.text = cursor?.getString(cursor?.getColumnIndex(DESCRIPTION_NOTES) as Int)
        holder.noteButtomRemove.setOnClickListener {
            cursor?.moveToPosition(position)
            listener.noteRemoveItem(cursor)
            notifyDataSetChanged()
        }

        holder.itemView.setOnClickListener{
            listener.noteClickedItem(cursor as Cursor)
        }
    }

    override fun getItemCount(): Int = if (cursor != null) cursor?.count as Int else 0

    fun setCursor(newCursor: Cursor?) {
        cursor = newCursor
        notifyDataSetChanged()

    }


}

class NotesViweHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val noteTitle = itemView.findViewById(R.id.note_title) as TextView
    val noteDescription = itemView.findViewById(R.id.note_description) as TextView
    val noteButtomRemove = itemView.findViewById(R.id.note_buttom_remove) as Button



}