package com.example.pleasedontbered2

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginClass(

    @Expose
    @SerializedName("success") val success: Int,


    @Expose
    @SerializedName("usr_id") val usr_id: String,

    @Expose
    @SerializedName("profile") val profile: String?,


)
