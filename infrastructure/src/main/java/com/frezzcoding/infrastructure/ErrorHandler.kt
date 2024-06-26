package com.frezzcoding.infrastructure

import android.util.Log

fun String?.handleNullString(tag: String): String {
    if (this == null) {
        //add tracking
        Log.e("This field is null: ", tag)
        return ""
    }
    return this
}