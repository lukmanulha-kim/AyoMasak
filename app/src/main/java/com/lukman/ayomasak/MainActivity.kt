package com.lukman.ayomasak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.lukman.ayomasak.adapter.CategoryAdapter
import com.lukman.ayomasak.adapter.RecipesAdapter
import com.lukman.ayomasak.databinding.ActivityMainBinding
import com.lukman.ayomasak.model.Recipes
import com.lukman.ayomasak.viewmodel.CategoryViewModel
import com.lukman.ayomasak.viewmodel.RecipesViewModel
import com.lukman.ayomasak.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var recipesAdapter: RecipesAdapter
    private lateinit var recipesViewModel: RecipesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        categoryAdapter = CategoryAdapter()
        recipesAdapter = RecipesAdapter(::handleToDetail)

        categoryViewModel = ViewModelProvider(
            this,
            ViewModelFactory.getInstance(this.application)
        )[CategoryViewModel::class.java]

        recipesViewModel = ViewModelProvider(
            this,
            ViewModelFactory.getInstance(this.application)
        )[RecipesViewModel::class.java]

        showCategory()

        showRecipes()

    }

    private fun handleToDetail(recipes: Recipes) {

        Intent(this, DetailActivity::class.java).also {
            it.putExtra(DetailActivity.EXTRA_RECIPE, recipes)
            startActivity(it)
        }

    }

    private fun showCategory() {
        categoryViewModel.setCategory()

        categoryViewModel.getCategory().observe(this){
            when {
//                it.size == 0 -> {
//                    hideLoading()
//                }
                it != null -> {
                    categoryAdapter.category = it
                    binding.rvCategory.adapter = categoryAdapter
//                    hideLoading()
                }
                else -> {
//                    hideLoading()
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.emptyData),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun showRecipes() {
        recipesViewModel.setRecipes()

        recipesViewModel.getRecipes().observe(this){
            when {
//                it.size == 0 -> {
//                    hideLoading()
//                }
                it != null -> {
                    binding.rvRecipes.layoutManager = GridLayoutManager(applicationContext,2)
                    recipesAdapter.recipes = it
                    binding.rvRecipes.adapter = recipesAdapter
//                    hideLoading()
                }
                else -> {
//                    hideLoading()
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.emptyData),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}