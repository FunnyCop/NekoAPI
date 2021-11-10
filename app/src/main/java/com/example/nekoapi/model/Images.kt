package com.example.nekoapi.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

/** Data class that represents a list of images */
@JsonClass(generateAdapter = true) @Parcelize data class Images(

    val url: List<Image>

) : Parcelable {

    /** Data class that represents an image */
    @JsonClass(generateAdapter = true) @Parcelize data class Image(

        val url: String,
        @Json(name = "artist_href") val artistHref: String,
        @Json(name = "artist_name") val artistName: String,
        @Json(name = "source_url") val sourceUrl: String

    ) : Parcelable

}