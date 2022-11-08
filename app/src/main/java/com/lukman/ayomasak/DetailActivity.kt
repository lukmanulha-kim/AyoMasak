package com.lukman.ayomasak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.lukman.ayomasak.adapter.SectionPagerAdapter
import com.lukman.ayomasak.databinding.ActivityDetailBinding
import com.lukman.ayomasak.helper.loadImage
import com.lukman.ayomasak.model.DetailRecipe
import com.lukman.ayomasak.model.Recipes
import com.lukman.ayomasak.viewmodel.DetailRecipeViewModel
import com.lukman.ayomasak.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailRecipeViewModel: DetailRecipeViewModel
    private lateinit var sectionPagerAdapter: SectionPagerAdapter
    private var bundle: Bundle ?= null
    private lateinit var recipe: Recipes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bundle = Bundle()

        detailRecipeViewModel = ViewModelProvider(
            this,
            ViewModelFactory.getInstance(this.application)
        )[DetailRecipeViewModel::class.java]

        sectionPagerAdapter = SectionPagerAdapter(this, bundle)

        intent?.let{
            recipe = it.getParcelableExtra<Recipes>(EXTRA_RECIPE) as Recipes
            val recipes = recipe.key

            binding.tvFoodname.text = recipe.title
            binding.tvTimedetail.text = recipe.times
            binding.ivFooddetail.loadImage(recipe.thumb)

//            Toast.makeText(this, "data : ${recipe}", Toast.LENGTH_SHORT).show()
            detailRecipeViewModel.setDetailRecipe(recipes)
            getDetailRecipe()

        }

        setPages()
    }

    private fun getDetailRecipe() {
        detailRecipeViewModel.getDetailRecipe().observe(this){
            if (it != null){
                Toast.makeText(this, "data : ${it}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setPages() {
        binding.apply {
            vpDetail.adapter = sectionPagerAdapter

            TabLayoutMediator(tabLayout, vpDetail){tab, position->
                tab.text = resources.getString(TAB_TITLES[position])
            }.attach()
        }
        supportActionBar?.elevation = 0f
    }

    companion object {
        const val EXTRA_RECIPE = "extra_recipe"
        private val TAB_TITLES = intArrayOf(R.string.tab1, R.string.tab2, R.string.tab3)
    }
}