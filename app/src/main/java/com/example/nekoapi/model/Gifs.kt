package com.example.nekoapi.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

/** Data class that represents a list of gifs */
@JsonClass(generateAdapter = true) @Parcelize data class Gifs(

    val url: List<Gif>

) : Parcelable {

    /** Data class that represents a Gif */
    @JsonClass(generateAdapter = true) @Parcelize data class Gif(

        val url: String,
        @Json(name = "anime_name") val animeName: String

    ) : Parcelable

}
