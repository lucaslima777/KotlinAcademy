package com.lln.kotlinacademy.util

import android.content.Context
import android.widget.Toast

fun String.DB(): String {
    return this.trim()
}

fun showMessage(context: Context, msg: String) {
    Toast.makeText(
        context,
        msg,
        Toast.LENGTH_SHORT
    ).show()
}