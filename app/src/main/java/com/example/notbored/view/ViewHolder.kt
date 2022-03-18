package com.example.notbored.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.notbored.databinding.ItemActivityBinding

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemActivityBinding.bind(view)

    fun bind(categories: Categories) {
        binding.tvName.text = categories.activity
    }
}
