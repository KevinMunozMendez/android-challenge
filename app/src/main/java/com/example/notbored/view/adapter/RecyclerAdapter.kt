package com.example.notbored.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.notbored.R
import com.example.notbored.view.Categories
import com.example.notbored.view.SuggestionActivity
import com.example.notbored.view.adapter.ViewHolder
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter : RecyclerView.Adapter<ViewHolder>(){

    var categories: MutableList<Categories> = ArrayList()

    fun RecyclerAdapter(categories: MutableList<Categories>) {
        this.categories = categories
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_activity, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = categories[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

}