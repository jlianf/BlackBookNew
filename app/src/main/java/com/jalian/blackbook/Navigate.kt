package com.jalian.blackbook

import android.content.Context
import android.content.Intent

fun Context.intentTo(clazz: Class<*>) {
    val i = Intent(this, clazz)
    startActivity(i)

}