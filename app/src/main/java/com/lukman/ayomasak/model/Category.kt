package com.lukman.ayomasak.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val category: String,
    val url: String,
    val key: String
): Parcelable
