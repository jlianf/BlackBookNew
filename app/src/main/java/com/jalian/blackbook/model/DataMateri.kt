package com.jalian.blackbook.model
import com.google.gson.annotations.SerializedName


class DataMateri : ArrayList<DataMateriItem>()

data class DataMateriItem(
    @SerializedName("fields")
    val fields: List<Field>,
    @SerializedName("subTitle")
    val subTitle: String,
    @SerializedName("title")
    val title: String
)

data class Field(
    @SerializedName("category")
    val category: String,
    @SerializedName("subTitle")
    val subTitle: String,
    @SerializedName("title")
    val title: String
)