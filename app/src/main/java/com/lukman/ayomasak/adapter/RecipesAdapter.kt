package com.lukman.ayomasak.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lukman.ayomasak.databinding.ItemRecipesBinding
import com.lukman.ayomasak.helper.loadImage
import com.lukman.ayomasak.model.Recipes

class RecipesAdapter(val handleToDetail: ((Recipes)) -> Unit): RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder>() {

    var recipes = mutableListOf<Recipes>()

    inner class RecipesViewHolder(private val binding: ItemRecipesBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(recipes: Recipes){
            binding.apply {
                tvRecipesname.text = recipes.title
                tvTimes.text = recipes.times
                tvLevel.text = recipes.difficulty
                ivFood.loadImage(recipes.thumb)
            }

            binding.toDetail.setOnClickListener {
                handleToDetail.invoke(recipes)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val binding = ItemRecipesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.bind(recipes[position])
    }

    override fun getItemCount(): Int = recipes.size
}