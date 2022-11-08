package com.lukman.ayomasak.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lukman.ayomasak.model.Category
import com.lukman.ayomasak.model.CategoryResponse
import com.lukman.ayomasak.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryViewModel(private val application: Application): ViewModel() {

    private val listCategory = MutableLiveData<MutableList<Category>>()

    fun setCategory(){
        Repository.getCategory().enqueue(object : Callback<CategoryResponse>{
            override fun onResponse(
                call: Call<CategoryResponse>,
                response: Response<CategoryResponse>
            ) {
                if (response.isSuccessful){
                    listCategory.postValue(response.body()?.results)
                }
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                Toast.makeText(application, "Error : {${t.message.toString()}}", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun getCategory(): LiveData<MutableList<Category>> = listCategory
}