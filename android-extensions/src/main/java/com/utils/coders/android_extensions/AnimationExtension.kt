package com.utils.coders.android_extensions

import android.app.Activity
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import android.widget.TextView


/**
 * Created by alvaro on 15/2/18.
 */

fun View.fadeIn(duration: Long = 1000) {
    val fadeIn = AlphaAnimation(0f, 1f)
    fadeIn.interpolator = DecelerateInterpolator()
    fadeIn.duration = duration
    this.startAnimation(fadeIn)
    this.visibility = View.VISIBLE
}

fun View.fadeOut(finalViewState: Int = View.INVISIBLE, duration: Long = 1000) {
    val fadeIn = AlphaAnimation(1f, 0f)
    fadeIn.interpolator = DecelerateInterpolator()
    fadeIn.duration = duration
    this.startAnimation(fadeIn)
    this.visibility = finalViewState
}

fun View.startBounce() {
    val anim: Animation = AnimationUtils.loadAnimation(context, R.anim.start_bounce)
    anim.fillAfter = true
    anim.interpolator = DecelerateInterpolator()
    this.startAnimation(anim)
}

fun View.endBounce() {
    val anim: Animation = AnimationUtils.loadAnimation(context, R.anim.end_bounce)
    anim.interpolator = DecelerateInterpolator()
    this.startAnimation(anim)
}


fun TextView.replaceTextWithFade(newText: String,duration : Long = 1000) {
    val fadeOut = AlphaAnimation(1f, 0f)
    fadeOut.interpolator = DecelerateInterpolator()
    fadeOut.duration = duration
    this.startAnimation(fadeOut)
    this.visibility = View.INVISIBLE
    this.text = newText

    val fadeIn = AlphaAnimation(0f, 1f)
    fadeIn.interpolator = DecelerateInterpolator()
    fadeIn.duration = duration
    this.startAnimation(fadeIn)
    this.visibility = View.VISIBLE
}

fun Activity.fadeOutExitAnim() {
    overridePendingTransition(R.anim.fade_in, R.anim.fade_out)

}

fun Activity.fadeInEnterAnim() {
    overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
}


fun Activity.topToBotExitAnimation() {
    overridePendingTransition(R.anim.fade_in, R.anim.top_to_bottom_exit)
}

fun Activity.botToTopEnterAnimation() {
    overridePendingTransition(R.anim.bottom_to_top, R.anim.fade_in)
}

fun Activity.rightToLeftEnterAnimation() {
    overridePendingTransition(R.anim.right_to_left, R.anim.left_to_right)
}

fun Activity.leftToRightExitAnimation() {
    overridePendingTransition(R.anim.enter, R.anim.exit)
}