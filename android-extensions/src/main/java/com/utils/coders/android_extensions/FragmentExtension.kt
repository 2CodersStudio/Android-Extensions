package com.utils.coders.android_extensions

import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity


/**
 * Created by alvaro on 7/2/18.
 */

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commit()
}

fun AppCompatActivity.addFragment(fragment: Fragment, containerId: Int): Fragment {
    supportFragmentManager.inTransaction { add(containerId, fragment) }
    return fragment
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, containerId: Int) {
    supportFragmentManager.inTransaction { replace(containerId, fragment) }
}

fun AppCompatActivity.replaceFragmentWithSlideAnim(fragment: Fragment, containerId: Int) {
    supportFragmentManager.inTransaction { replace(containerId, fragment) }
}


fun Fragment.withParcelable(item: Any, key : String): Fragment {
    if (item is Parcelable) {
        val args = Bundle()
        args.putParcelable(key, item)
        this.arguments = args
    }

    return this
}