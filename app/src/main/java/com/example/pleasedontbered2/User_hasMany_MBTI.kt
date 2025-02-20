package com.example.pleasedontbered2

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User_hasMany_MBTI(
    @Expose
    @SerializedName("user_id") val user_id: String,

    @Expose
    @SerializedName("mbti_id") val mbti_id: String,
)
