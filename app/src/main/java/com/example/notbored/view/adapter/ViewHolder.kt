package com.example.notbored.view.adapter

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.notbored.databinding.ItemActivityBinding
import com.example.notbored.view.Categories
import com.example.notbored.view.SuggestionActivity

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemActivityBinding.bind(view)

    fun bind(categories: Categories, context: Context, participants: String) {
        binding.tvName.text = categories.activity
        binding.itemView.setOnClickListener {
            context.startActivity(Intent(context, SuggestionActivity::class.java)
                .putExtra("type",categories.activity.lowercase())
                .putExtra("participants", participants)
            )
        }
    }

}
