package com.example.pleasedontbered2

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AllType(
    @Expose
    @SerializedName("id_mbti") val id_mbti: Int,


    @Expose
    @SerializedName("mbti_char") val mbti_char: String,


    @Expose
    @SerializedName("mbti_name") val mbti_name: String,

    @Expose
    @SerializedName("mbti_describe") val mbti_describe: String,

    ){}
