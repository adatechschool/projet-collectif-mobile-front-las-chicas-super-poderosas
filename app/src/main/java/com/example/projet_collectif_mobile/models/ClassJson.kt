package com.example.projet_collectif_mobile.models

import com.google.gson.annotations.SerializedName

data class Records(
    val records: List<SurfSpot>
)

data class SurfSpot(
    @SerializedName("Surf Break") val surfBreak: String,
    val Photos: String,
    val Address: String
)