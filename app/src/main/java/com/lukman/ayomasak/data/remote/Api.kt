package com.lukman.ayomasak.data.remote

import com.lukman.ayomasak.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("category/recipes")
    fun getCategory(): Call<CategoryResponse>

    @GET("recipes")
    fun getRecipes(): Call<RecipesResponse>

    @GET("recipe/{key}")
    fun detDetailRecipe(@Path("key") key: String): Call<Results>
}