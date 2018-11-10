package com.kotlintemplates.DIRetroitList.Model

import com.google.gson.annotations.SerializedName

data class RetroModel(@SerializedName("id") var id: Int, @SerializedName("title") val title: String, @SerializedName("body") val body: String)