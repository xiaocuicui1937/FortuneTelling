package com.gnss.fortunetelling

import android.app.Application
import android.content.res.Resources
import android.util.TypedValue
import com.google.gson.Gson

/**
 * 扩展函数
 * */
val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this, Resources.getSystem().displayMetrics
    )

inline fun <reified T> Gson.fromJson(json: String) = fromJson(json, T::class.java)

val Application.app
    get() = this