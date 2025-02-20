package com.example.pleasedontbered2

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query


interface API {

//    @GET("allQuestion")
//    fun retrieveQuestion(): Call<List<Question>>
//
//    @GET("allAnswer")
//    fun retrieveAnswer(): Call<List<Answer>>

    @GET("allResgiter")
    fun retrieveStudent(): Call<List<ProfileClass>>

    @GET("allmbti_all")
    fun retrieveMbti(): Call<List<AllType>>

//    @GET("allmbti/{mbti_char}")
//    fun retrieveMbti(
//        @Path("mbti_char") mbti_char: String
//    ): Call<AllType>

    @GET("allmbtit")
    fun retrieveMbtit(
        @Query("mbti_char") mbti_char: String
    ): Call<List<AllType>>


    @GET("allPost")
    fun retrievePost(): Call<List<PostData>>

    @GET("Login/{usr_id}/{usr_password}")
    fun loginUser(
        @Path("usr_id") usr_id: String,
        @Path("usr_password") usr_password: String
    ): Call<LoginClass>


    @GET("search/{usr_id}")
    fun searchUser(
        @Path("usr_id") usr_id: String
    ): Call<ProfileClass>


    @FormUrlEncoded
    @POST("insertUserMbti")
    fun insertUserMbti(
        @Field("user_id") user_id: String,
        @Field("mbti_id") mbti_id: Int,

    ): Call<User_hasMany_MBTI>

    @GET("getUserMbti/{user_id}")
    fun getUserMbtiId(
        @Path("user_id") userId: String
    ): Call<List<User_hasMany_MBTI>>

    @PUT("delete_soft/{usr_id}/{mbti_id}") /// Soft Delete
    fun softDeleteUsrMbti(
        @Path("usr_id") usr_id: String,
        @Path("mbti_id") mbti_id: String)
    : Call<User_hasMany_MBTI>

    @PUT("delete_soft_post/{post_id}") /// Soft Delete
    fun softDeleteUsrPost(
        @Path("post_id") post_id: Int): Call<PostData>


    @PUT("restore_usrmbti/{usr_id}") /// Soft Delete
    fun restore_UsrMbti(
        @Path("usr_id") usr_id: String): Call<User_hasMany_MBTI>

    @FormUrlEncoded
    @POST("insertAccount")
    fun registerStudent(
        @Field("usr_id") usr_id: String,
        @Field("usr_name") usr_name: String,
        @Field("usr_password") usr_password: String,
        @Field("usr_mbti") usr_mbti: String,
        @Field("usr_gender") usr_gender: String

    ): Call<LoginClass>



    @Multipart
    @POST("insertAccountProfile")
    fun registerStudentProfile(
        @Part("usr_id") usr_id: RequestBody,
        @Part("usr_name") usr_name: RequestBody,
        @Part("usr_password") usr_password: RequestBody,
        @Part("usr_mbti") usr_mbti: RequestBody,
        @Part("usr_gender") usr_gender: RequestBody,
        @Part profile: MultipartBody.Part
    ):Call<LoginClass>

    @Multipart
    @PUT("editProfile/{usr_id}")
    fun editProfile(
        @Part("usr_id") usr_id: RequestBody,
        @Part("usr_name") usr_name: RequestBody,
        @Part("usr_gender") usr_gender: RequestBody,
        @Part("old_name") old_name: RequestBody,
        @Part profile: MultipartBody.Part
    ):Call<ProfileClass>

    @FormUrlEncoded
    @POST("editNamePost/{usr_name}")
    fun editnameinpost(
        @Field("usr_name") usr_name: String,
        @Field("old_name") old_name: String

    ): Call<PostData>

    @FormUrlEncoded
    @POST("likePost")
    fun likePost(
        @Field("usr_id") usr_id: String,
        @Field("post_id") post_id: Int,
        @Field("status") status: Int

    ): Call<LikeData>

    @FormUrlEncoded
    @POST("dislikePost")
    fun dislikePost(
        @Field("usr_id") usr_id: String,
        @Field("post_id") post_id: Int
    ): Call<LikeData>


    @GET("getLikesCount/{post_id}")
    fun getLikes(
        @Path("post_id") post_id: Int
    ): Call<LikeData>

    @GET("getLikesStatus/{usr_id}")
    fun getLikesStatus(
        @Path("usr_id") usr_id: String
    ): Call<List<LikeData>>

    @FormUrlEncoded
    @POST("addPost")
    fun createpost(
        @Field("usr_name") usr_name: String,
        @Field("post_text") post_text: String,
        @Field("time_stamp") time_stamp: String,
        @Field("img_post") img_post: String
    ): Call<PostData>

    @Multipart
    @POST("addPostWithImg")
    fun createPostWithImg(
        @Part("usr_id") usr_id: RequestBody,
        @Part("post_text") post_text: RequestBody,
        @Part img_post: MultipartBody.Part
    ): Call<PostData>


    @FormUrlEncoded
    @POST("addPostsUser")
    fun userHasManyPost(
        @Field("usr_id") usr_id: String,
        @Field("post_id") post_id: Int,
    ): Call<User_hasMany_Post>

    // สำหรับการดึงโพสต์ทั้งหมด
    @GET("allPosts")
    fun getAllPosts(): Call<List<PostData>>


    // สำหรับการดึงโพสต์ของผู้ใช้ที่ระบุด้วย postID
    @GET("postID/{post_text}")
    fun getUserPost_id(
        @Path("post_text") post_text: String
    ): Call<PostData>





    // สำหรับการลบโพสต์
    @DELETE("deletePost/{post_id}")
    suspend fun deletePost(@Path("post_id") postId: Int): Response<Void>
    abstract fun addPost(post_text: String, time_stamp: String): Call<PostData>

    @Multipart
    @PUT("postUpdate/{post_id}")
    fun updatePost(
        @Part("post_id") post_id: RequestBody,
        @Part("usr_id") usr_id: RequestBody,
        @Part("post_text") post_text: RequestBody,
        @Part img_post: MultipartBody.Part
    ): Call<PostData>



    companion object {
        fun create(): API{
            val apiClient: API = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(API::class.java)
            return apiClient
        }
    }
}