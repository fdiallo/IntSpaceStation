package com.fallaye.intspacestation.models

import com.google.gson.annotations.SerializedName

data class ISSModel(
    @SerializedName("latitude") val latitude : String,
    @SerializedName("longitude") val longitude : String
)