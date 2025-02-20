package com.example.pleasedontbered2

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileClass(
    @Expose
    @SerializedName("usr_id") val usr_id: String,

    @Expose
    @SerializedName("usr_name") val usr_name: String,


    @Expose
    @SerializedName("usr_mbti") val usr_mbti: String,

    @Expose
    @SerializedName("usr_gender") val usr_gender: String,

    @Expose
    @SerializedName("role") val role: String,

    @Expose
    @SerializedName("profile") val profile: String?,
): Parcelable{}
