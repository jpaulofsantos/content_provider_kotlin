package com.example.contentprovider.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class NotesDatabaseHelper(context:Context): SQLiteOpenHelper(context, "databaseNotes", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    companion object {
        //tabelas com primeira letra maiuscula e colunas com a primeira letra minuscula
        const val TABLE_NOTES: String = "Notes"
        const val TITLE_NOTES: String = "title"
        const val DESCRIPTION_NOTES: String = "description"
    }
}