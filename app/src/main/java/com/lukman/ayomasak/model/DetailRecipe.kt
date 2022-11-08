package com.lukman.ayomasak.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailRecipe(
    val title: String,
    val thumb: String,
    val times: String,
    val difficulty: String,
    val desc: String,
    val ingredient: String,
    val step: String
): Parcelable
