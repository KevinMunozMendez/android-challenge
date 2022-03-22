package com.example.notbored.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notbored.databinding.ActivityCategoriesBinding
import com.example.notbored.view.adapter.RecyclerAdapter
import com.google.android.material.snackbar.Snackbar

class CategoriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoriesBinding
    private val mAdapter : RecyclerAdapter = RecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        binding.rvActivities.setHasFixedSize(true)
        binding.rvActivities.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(getCategories(), this)
        binding.rvActivities.adapter = mAdapter
    }

    private fun getCategories(): MutableList<Categories> {
        var categories: MutableList<Categories> = ArrayList()
        categories.add(Categories("Education"))
        categories.add(Categories("Recreational"))
        categories.add(Categories("Social"))
        categories.add(Categories("Diy"))
        categories.add(Categories("Charity"))
        categories.add(Categories("Cooking"))
        categories.add(Categories("Relaxation"))
        categories.add(Categories("Music"))
        categories.add(Categories("Busywork"))
        return categories
    }
}