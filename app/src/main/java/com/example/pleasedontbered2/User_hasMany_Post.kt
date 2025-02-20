package com.example.pleasedontbered2

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User_hasMany_Post(
    @Expose
    @SerializedName("usr_id") val usr_id: String,

    @Expose
    @SerializedName("post_id") val post_id: String,
)
