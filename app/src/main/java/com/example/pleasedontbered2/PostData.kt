package com.example.pleasedontbered2

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.sql.Timestamp
@Parcelize
data class PostData(
    @Expose
    @SerializedName("post_id") val post_id: Int,

    @Expose
    @SerializedName("usr_name") val usr_name: String,

    @Expose
    @SerializedName("post_text") val post_text: String,

    @Expose
    @SerializedName("time_stamp") val time_stamp: Timestamp?,

    @Expose
    @SerializedName("img_post") val img_post: String,

    @Expose
    @SerializedName("profile") val profile: String ): Parcelable {}


