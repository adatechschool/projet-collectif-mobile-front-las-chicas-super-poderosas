package com.example.projet_collectif_mobile.models

import com.google.gson.annotations.SerializedName
import java.time.temporal.IsoFields

data class ClassJson (
    val records: List<SurfSpot>
){
    data class SurfSpot(
        //@SerializedName("Surf Break") val surfBreak: String,
        val id: String,
        val fields: Fields,
        val createdTime: String
    )
    data class Fields(
        @SerializedName("Surf Break") val surfBreak: List<String>,
        @SerializedName("Difficulty Level") val difficultyLevel: Int,
        val Destination: String,
        val Geocode: String,
        val Influencers: List<String>,
        @SerializedName("Magic Seaweed Link") val magicSeaweedLink: String,

        val Photos: List<PhotosObjects>,
        @SerializedName("Peak Surf Season Begins") val peakSurfSeasonBegins: String,
        @SerializedName("Destination State/Country") val destinationStateCountry: String,
        @SerializedName("Peak Surf Season Ends") val peakSurfSeasonEnds: String,
        val Address: String
    )
    data class PhotosObjects(
        val id: String,
        val url: String,
        val fileName: String,
        val size: Int,
        val type: String,
        val thumbnail: PhotoSize
    )
    data class PhotoSize(
        val small: PhotoInfo,
        val large: PhotoInfo,
        val full: PhotoInfo
    )
    data class PhotoInfo(
        val url: String,
        val width: Int,
        val height: Int
    )

}

