package com.utils.coders.android_extensions

import android.app.Activity
import android.graphics.drawable.Drawable
import android.graphics.drawable.BitmapDrawable
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.graphics.Matrix
import android.graphics.Point
import android.view.Display
import android.widget.ImageView


/**
 * Created by alvaro on 5/9/18.
 */



fun Activity.scaleImageFromScrensize(image: ImageView, percentage: Float = 0.5f) {
    val height: Int = getScreenHeight()
    val params = image.layoutParams
    params.height = (height * percentage).toInt()
    image.layoutParams = params
}

fun Activity.getScreenHeight(): Int {
    val display: Display = windowManager.defaultDisplay
    val size = Point()
    display.getSize(size)
    return size.y
}

fun Activity.getScreenWidth(): Int {
    val display: Display = windowManager.defaultDisplay
    val size = Point()
    display.getSize(size)
    return size.x
}
