package com.utils.coders.android_extensions

import android.util.Base64
import android.util.Patterns
import java.text.SimpleDateFormat
import java.util.*

enum class UsernameType {
    ALPHANUMERIC, NUMERIC, CHARACTERS
}

fun String.isValidEmail(): Boolean {
    //RESOURCE FROM http://emailregex.com/
    val reg = "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"
    return this.matches(reg.toRegex())
}

fun String.isValidPassword(): Boolean {
    val reg = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}\$"
    return this.matches(reg.toRegex())
}


fun String.encrypt(): String {

    return Base64.encodeToString(this.toByteArray(), Base64.DEFAULT)
}

fun String.decrypt(): String {
    return String(Base64.decode(this, Base64.DEFAULT))
}

fun String.isValidUsername(type : UsernameType = UsernameType.ALPHANUMERIC): Boolean {
    val reg : String = when(type){
        UsernameType.ALPHANUMERIC ->{
            "^(?=.{8,20}\$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9]+(?<![_.])\$"
        }
        UsernameType.NUMERIC ->{
            "^(?=.{8,20}\$)(?![_.])(?!.*[_.]{2})[0-9]+(?<![_.])\$"
        }
        UsernameType.CHARACTERS ->{
            "^(?=.{8,20}\$)(?![_.])(?!.*[_.]{2})[a-zA-Z]+(?<![_.])\$"
        }
    }
    return this.matches(reg.toRegex())
}


