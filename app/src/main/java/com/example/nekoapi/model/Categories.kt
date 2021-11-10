package com.example.nekoapi.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

/** A data class that represents all categories */
@JsonClass(generateAdapter = true) @Parcelize data class Categories(

    val baka: Category,
    val bite: Category,
    val blush: Category,
    val bored: Category,
    val cry: Category,
    val cuddle: Category,
    val dance: Category,
    val facepalm: Category,
    val feed: Category,
    val happy: Category,
    val highfive: Category,
    val hug: Category,
    val kiss: Category,
    val laugh: Category,
    val nekos: Category,
    val pat: Category,
    val poke: Category,
    val pout: Category,
    val shrug: Category,
    val slap: Category,
    val sleep: Category,
    val smile: Category,
    val smug: Category,
    val stare: Category,
    val think: Category,
    val thumbsup: Category,
    val tickle: Category,
    val wave: Category,
    val wink: Category

) : Parcelable {

    /** Data class that represents a category */
    @JsonClass(generateAdapter = true) @Parcelize data class Category(

        val min: String,
        val max: String,
        val format: String

    ) : Parcelable

    operator fun get(category: String?): Category {

        return when (category) {

            "baka" -> baka
            "bite" -> bite
            "blush" -> blush
            "bored" -> bored
            "cry" -> cry
            "cuddle" -> cuddle
            "dance" -> dance
            "facepalm" -> facepalm
            "feed" -> feed
            "happy" -> happy
            "highfive" -> highfive
            "hug" -> hug
            "kiss" -> kiss
            "laugh" -> laugh
            "nekos" -> nekos
            "pat" -> pat
            "poke" -> poke
            "pout" -> pout
            "shrug" -> shrug
            "sap" -> slap
            "sleep" -> sleep
            "smile" -> smile
            "smug" -> smug
            "stare" -> stare
            "think" -> think
            "thumbsup" -> thumbsup
            "tickle" -> tickle
            "wave" -> wave
            else -> wink

        }

    }

    val categoryArray get() = arrayOf(

        baka, bite, blush, bored, cry, cuddle, dance,
        facepalm, feed, happy, highfive, hug, kiss, laugh,
        nekos, pat, poke, pout, shrug, slap, sleep, smile,
        smug, stare, think, thumbsup, tickle, wave, wink

    )

    companion object {

        val namesArray get() = arrayOf(

            "baka", "bite", "blush", "bored", "cry", "cuddle", "dance",
            "facepalm", "feed", "happy", "highfive", "hug", "kiss", "laugh",
            "nekos", "pat", "poke", "pout", "shrug", "slap", "sleep", "smile",
            "smug", "stare", "think", "thumbsup", "tickle", "wave", "wink"

        )

    }

}
