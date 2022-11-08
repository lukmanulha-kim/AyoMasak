package com.lukman.ayomasak.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lukman.ayomasak.model.Recipes
import com.lukman.ayomasak.model.RecipesResponse
import com.lukman.ayomasak.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipesViewModel(private val application: Application): ViewModel() {

    private val listRecipes = MutableLiveData<MutableList<Recipes>>()

    fun setRecipes(){
        Repository.getRecipes().enqueue(object : Callback<RecipesResponse>{
            override fun onResponse(
                call: Call<RecipesResponse>,
                response: Response<RecipesResponse>
            ) {
                if (response.isSuccessful){
                    listRecipes.postValue(response.body()?.results)
                }
            }

            override fun onFailure(call: Call<RecipesResponse>, t: Throwable) {
                Toast.makeText(application, "Error : ${t.message.toString()}", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun getRecipes(): LiveData<MutableList<Recipes>> = listRecipes
}