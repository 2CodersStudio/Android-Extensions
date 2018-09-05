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

fun Activity.resizeImage(imageResource: Int): Drawable {
    val display = windowManager.defaultDisplay
    val deviceWidth = display.getWidth().toDouble()

    val bd = this.resources.getDrawable(imageResource) as BitmapDrawable
    val imageHeight = bd.bitmap.height.toDouble()
    val imageWidth = bd.bitmap.width.toDouble()

    val ratio = deviceWidth / imageWidth
    val newImageHeight = (imageHeight * ratio).toInt()

    val bMap = BitmapFactory.decodeResource(resources, imageResource)

    return BitmapDrawable(resources, getResizedBitmap(bMap, newImageHeight, deviceWidth.toInt()))
}

private fun getResizedBitmap(bm: Bitmap, newHeight: Int, newWidth: Int): Bitmap {

    val width = bm.width
    val height = bm.height

    val scaleWidth = newWidth.toFloat() / width
    val scaleHeight = newHeight.toFloat() / height
    val matrix = Matrix()
    matrix.postScale(scaleWidth, scaleHeight)
    return Bitmap.createBitmap(bm, 0, 0, width, height,
            matrix, false)
}

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
