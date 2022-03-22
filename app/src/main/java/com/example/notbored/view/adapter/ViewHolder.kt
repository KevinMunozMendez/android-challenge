package com.example.notbored.view.adapter

import android.content.Context
import android.content.Intent
import android.view.ContextMenu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.notbored.databinding.ItemActivityBinding
import com.example.notbored.view.Categories
import com.example.notbored.view.CategoriesActivity
import com.example.notbored.view.SuggestionActivity
import com.google.android.material.snackbar.Snackbar

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemActivityBinding.bind(view)

    fun bind(categories: Categories) {
        probando(categories)
        binding.tvName.text = categories.activity
    }

    fun probando(categories: Categories) {

        binding.itemView.setOnClickListener {
            Snackbar.make(binding.root, categories.activity, Snackbar.LENGTH_SHORT).show()
        }
    }


}
