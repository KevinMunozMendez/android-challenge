package com.example.notbored.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notbored.R

class RecyclerAdapter : RecyclerView.Adapter<ViewHolder>() {

    var categories: MutableList<Categories> = ArrayList()

    fun RecyclerAdapter(categories: MutableList<Categories>) {
        this.categories = categories
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.item_activity,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = categories[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}