package com.example.pleasedontbered2

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LikeData(

    @Expose
    @SerializedName("usr_id") val usr_id: String,

    @Expose
    @SerializedName("post_id") val post_id: Int,

    @Expose
    @SerializedName("status") val status: Int,

    @Expose
    @SerializedName("likes_count") val likes_count: Int,
)
