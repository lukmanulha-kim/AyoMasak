package com.lukman.ayomasak.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lukman.ayomasak.databinding.ItemCategoryBinding
import com.lukman.ayomasak.model.Category

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    var category = mutableListOf<Category>()

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category){
            binding.apply {
                tvCategory.text = category.category
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(category[position])
    }

    override fun getItemCount(): Int = category.size
}