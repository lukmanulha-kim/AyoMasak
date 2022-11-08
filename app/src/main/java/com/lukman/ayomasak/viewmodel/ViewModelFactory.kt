package com.lukman.ayomasak.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory private constructor(private val application: Application) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                CategoryViewModel(application) as T
            }

            modelClass.isAssignableFrom(RecipesViewModel::class.java) -> {
                RecipesViewModel(application) as T
            }

            modelClass.isAssignableFrom(DetailRecipeViewModel::class.java) -> {
                DetailRecipeViewModel(application) as T
            }

            else -> {
                throw IllegalArgumentException("Unknown Model Class ${modelClass.name}")
            }
        }
    }

    companion object{
        private var  INSTANCE : ViewModelFactory?=null

        fun getInstance(application: Application?):ViewModelFactory =
            INSTANCE?: synchronized(this){
                val instance = ViewModelFactory(application as Application)
                INSTANCE = instance
                instance
            }
    }
}