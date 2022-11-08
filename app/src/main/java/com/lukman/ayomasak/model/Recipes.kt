package com.lukman.ayomasak.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipes(
    val title: String,
    val thumb: String,
    val key: String,
    val times: String,
    val difficulty: String
):Parcelable
