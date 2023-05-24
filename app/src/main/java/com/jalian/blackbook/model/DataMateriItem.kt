package com.jalian.blackbook.model


import com.google.gson.annotations.SerializedName

data class DataMateriItem(
    @SerializedName("fields")
    val fields: List<Field>,
    @SerializedName("subTitle")
    val subTitle: String,
    @SerializedName("title")
    val title: String
)