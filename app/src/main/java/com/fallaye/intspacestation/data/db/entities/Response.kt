package com.fallaye.intspacestation.data.db.entities

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("duration") val duration: Int,
    @SerializedName("risetime") val risetime: Int
)