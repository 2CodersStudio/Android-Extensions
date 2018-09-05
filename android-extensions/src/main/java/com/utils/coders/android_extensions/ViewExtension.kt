package com.utils.coders.android_extensions

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View

fun View.rounded(rounded: Float = 14f, color: Int = Color.WHITE){
    val shape = GradientDrawable()
    shape.cornerRadius = rounded
    shape.setTint(color)
    this.background = shape
}