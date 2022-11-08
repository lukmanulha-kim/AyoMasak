package com.lukman.ayomasak.repository

import com.lukman.ayomasak.data.remote.RetroClient
import com.lukman.ayomasak.model.*
import retrofit2.Call

object Repository {
    fun getCategory(): Call<CategoryResponse> = RetroClient.getInstance.getCategory()

    fun getRecipes(): Call<RecipesResponse> = RetroClient.getInstance.getRecipes()

    fun getDetailRecipes(key: String): Call<Results> = RetroClient.getInstance.detDetailRecipe(key)
}