package com.gnss.fortunetelling.bean

data class ListBean(
    val stars:List<Stars>,
    val bottomLeft:List<String>,
    val bottomRight:List<String>,
    val bottomCenter:List<String>,
    val center:String
)

data class Stars(
    val big:String,
    val small:String
)