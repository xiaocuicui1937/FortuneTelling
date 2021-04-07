package com.gnss.fortunetelling

import android.app.Application
import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
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



fun String.showToast(duration: Int = Toast.LENGTH_SHORT){
    //MyApplication 这是一个直接获取全局context的类
    Toast.makeText(App.mContext,this,Toast.LENGTH_SHORT).show()
}
