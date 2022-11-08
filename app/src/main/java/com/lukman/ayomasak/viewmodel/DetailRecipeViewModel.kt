package com.lukman.ayomasak.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lukman.ayomasak.model.DetailRecipe
import com.lukman.ayomasak.model.DetailRecipeResponse
import com.lukman.ayomasak.model.Results
import com.lukman.ayomasak.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailRecipeViewModel(private val application: Application): ViewModel() {

    private val detailRecipe = MutableLiveData<Results>()

    fun setDetailRecipe(key: String){
        Repository.getDetailRecipes(key).enqueue(object : Callback<Results>{
            override fun onResponse(
                call: Call<Results>,
                response: Response<Results>
            ) {
                if (response.isSuccessful){
                    detailRecipe.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Results>, t: Throwable) {
                Toast.makeText(application, "Error : ${t.message.toString()}", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun getDetailRecipe(): LiveData<Results> = detailRecipe
}