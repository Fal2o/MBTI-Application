package com.example.pleasedontbered2

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ComunityScreen(navController: NavController){
    val createClient = API.create()
    val contextForToast = LocalContext.current.applicationContext
    val PostList = remember { mutableStateOf<List<PostData>>(emptyList()) }
    val loadData: suspend () -> Unit = {
        // เรียกใช้ showPost และรอให้ข้อมูลโหลดเสร็จสมบูรณ์
        showPost(
            PostList.value.toMutableList(),
            contextForToast,
            onDataLoaded = { newData ->
                // อัปเดตค่าของ PostList เมื่อข้อมูลถูกโหลด
                PostList.value = newData
            }
        )
    }
    LaunchedEffect(Unit) {
        loadData()
    }
    lateinit var sharedPreferences: SharedPreferencesManager
    sharedPreferences = SharedPreferencesManager(contextForToast)
    val userId = sharedPreferences.userId ?: ""
    val initialUser = ProfileClass(usr_id = "", usr_name = "", usr_mbti = "", usr_gender = "" ,role = "", profile = "",)
    var UsrItems by remember { mutableStateOf(initialUser) }

    ////// Check Lifecycle State
    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycleState by lifecycleOwner.lifecycle.currentStateFlow.collectAsState()
    LaunchedEffect(lifecycleState) {
        when (lifecycleState) {
            Lifecycle.State.DESTROYED -> {}
            Lifecycle.State.INITIALIZED -> {}
            Lifecycle.State.CREATED -> {}
            Lifecycle.State.STARTED -> {}
            Lifecycle.State.RESUMED -> {
                createClient.searchUser(userId).enqueue(object : Callback<ProfileClass> {
                    override fun onResponse(
                        call: Call<ProfileClass>,
                        response: Response<ProfileClass>
                    ) {
                        if (response.isSuccessful) {
                            UsrItems = ProfileClass(
                                response.body()!!.usr_id,
                                response.body()!!.usr_name,
                                response.body()!!.usr_mbti,
                                response.body()!!.usr_gender,
                                response.body()!!.role,
                                response.body()!!.profile
                            )
                        } else {
                            Toast.makeText(
                                contextForToast,
                                "User ID Not Found",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                    override fun onFailure(call: Call<ProfileClass>, t: Throwable) {
                        Toast.makeText(
                            contextForToast,
                            "Error onFailure " + t.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
            }
        }
    }
    Scaffold(
        topBar = {
//            MyTopAppBar(contextForToast = contextForToast, name = "Comunity")
        },
        floatingActionButton = {
            MyFloatingActionButton(navController = navController)
        }   ){
        LazyColumn(
            modifier = Modifier.padding(top = 8.dp) // เพิ่ม padding เพื่อให้มีระยะห่างด้านบน
        ){
            items(PostList.value.size){ index ->
                val postData = PostList.value[index]
                ComunityItem(UsrItems.usr_name,UsrItems.profile.toString(),UsrItems.usr_id,postData = postData,
                    onLikeClicked = { post ->
                        likePost(contextForToast, "${UsrItems.usr_id}", post.post_id,1)
                    },
                    onDislikeClicked = { post ->
                        dislikePost(contextForToast, "${UsrItems.usr_id}", post.post_id)
                    },
                    navController
                )




                if (index == PostList.value.size - 1) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { navController.popBackStack() },
                            modifier = Modifier.padding(end = 8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                        Text(text = "Back")
                    }
                }

            }

        }
    }

}

@Composable
fun MyFloatingActionButton(navController: NavController) {
    FloatingActionButton(
        onClick = { navController.navigate(Screen.PostScreen.route) },
    ) {
        Icon(
            imageVector = Icons.Default.Add, // ไอคอนของ Floating Action Button
            contentDescription = "Add", // คำอธิบายเมื่อใช้ Talkback หรือเครื่องอ่านหน้าจอ
            tint = Color.White // สีไอคอน
        )
    }
}


@Composable
fun ComunityItem(usr_name: String,profile:String,usr_id: String,postData: PostData,onLikeClicked: (PostData) -> Unit,onDislikeClicked: (PostData) -> Unit,navController: NavController){
    var isLiked by remember { mutableStateOf(false) }
    val contextForToast = LocalContext.current.applicationContext
    // รหัสโพสต์
    val postId = postData.post_id

    // จำนวนของ like สำหรับโพสต์นี้
    var likesCount by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        getLikesForPost(
            postId = postId,
            onLikesLoaded = { count ->
                likesCount = count
            },
            onFailure = { errorMessage ->
                Log.e("errorMessage",errorMessage)
            }
        )
    }
    Log.e("count","${likesCount}")
    Log.e("post_id","${postId}")

    getLikesForPostStatus(
        usr_id = usr_id,
        postId = postId,
        onStatusLoaded = { liked ->
            isLiked = liked
        },
        onFailure = { errorMessage ->
            Log.e("errorMessage", errorMessage)
        }
    )

    Column {

        Divider(color = Color.LightGray, thickness = 1.dp)
    }
    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        val(userImage,userName,date,time,title,title2,image,likeIcon,likesCountText,deleteIcon,editIcon) = createRefs()
        Column() {

        }
        Image(painter = rememberAsyncImagePainter(postData.profile),
            contentDescription = "photo",
            modifier = Modifier
                .constrainAs(userImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .size(36.dp)
                .background(Color.White)
                .clip(CircleShape),
            contentScale = ContentScale.Crop)



        Text(
            text = "name : ${postData.usr_name}",
            style = TextStyle(fontSize = 20.sp),
            modifier = Modifier.constrainAs(userName){
                top.linkTo(userImage.top)
                start.linkTo(userImage.end, margin = 12.dp,)
                bottom.linkTo(userImage.bottom)
            }
        )

        Text(
            text = postData.post_text+"\nPosted Time:${postData.time_stamp}",
            style = TextStyle(fontSize = 20.sp),
            modifier = Modifier.constrainAs(title){
                top.linkTo(userName.bottom, margin = 8.dp)
                start.linkTo(userName.start)
            }
        )

        Text(
            text ="${postData.time_stamp}",
            style = TextStyle(fontSize = 20.sp),
            modifier = Modifier.constrainAs(title2){
                top.linkTo(image.top, margin = 8.dp)
                start.linkTo(image.start)
            }
        )


        Card(modifier = Modifier
            .constrainAs(image){
                top.linkTo(title.bottom, margin = 8.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ){
            Image(painter = rememberAsyncImagePainter(postData.img_post),
                contentDescription = "close",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )
        }



        IconButton(
            onClick = {
                if (isLiked) {
                    // ถ้ากดยกเลิกถูกใจ
                    likesCount -= 1
                    onDislikeClicked(postData)
                } else {
                    // ถ้ากดถูกใจ
                    likesCount += 1
                    onLikeClicked(postData)
                }
                isLiked = !isLiked // เปลี่ยนสถานะ isLiked
            },
            modifier = Modifier
                .constrainAs(likeIcon) {
                    top.linkTo(image.bottom)
                    end.linkTo(image.start)
                }
                .size(36.dp)
                .padding(start = 18.dp)
        ) {
            Icon(
                imageVector = if (isLiked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = "Like",
                tint = if (isLiked) Color.Red else Color.Unspecified // สลับสีของไอคอนหัวใจ
            )

        }
        Text(
            text = "$likesCount Likes",
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier.constrainAs(likesCountText) {
                top.linkTo(image.bottom)
                start.linkTo(likeIcon.end)
            }
        )
        if(postData.usr_name ==usr_name ){
            IconButton(
                onClick = {
                    softedeletePost(postData.post_id,navController,contextForToast)
                },
                modifier = Modifier
                    .constrainAs(deleteIcon) {
                        top.linkTo(image.bottom)
                        end.linkTo(parent.end)
                    }
                    .size(36.dp)
                    .padding(start = 18.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete post",
                    tint = Color.Gray
                )
            }
            IconButton(
                onClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        "data", PostData(post_id = postData.post_id, usr_name = postData.usr_name, post_text = postData.post_text,  time_stamp = postData.time_stamp  , img_post = postData.img_post, profile = postData.profile)
                    )
                    navController.navigate(Screen.EditPost.route)
                },
                modifier = Modifier
                    .constrainAs(editIcon) {
                        top.linkTo(likeIcon.bottom)
                        start.linkTo(parent.start)
                    }
                    .size(36.dp)
                    .padding(start = 18.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit post",
                    tint = Color.Gray
                )
            }
        }



    }
}

fun softedeletePost(postId: Int,navController: NavController,contextForToast: Context) {
    val createClient = API.create()
    createClient.softDeleteUsrPost(postId).enqueue(object : Callback<PostData> {
        override fun onResponse(call: Call<PostData>, response: Response<PostData>) {
            if (response.isSuccessful) {
                Toast.makeText(contextForToast, "Post deleted successfully", Toast.LENGTH_SHORT).show()
                navController.navigate(Screen.ComunityScreen.route) {
                    popUpTo(Screen.ComunityScreen.route) { inclusive = true }
                }
            } else {
                Toast.makeText(contextForToast, "Failed to soft delete MBTI", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<PostData>, t: Throwable) {
            Toast.makeText(contextForToast, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
        }
    })
}


@Preview(showBackground = true)
@Composable
fun ComunityScreen(){
    val navController = rememberNavController()

    ComunityScreen(navController)
}

fun showPost(
    itemsList: MutableList<PostData>,
    context: Context,
    onDataLoaded: (List<PostData>) -> Unit // เพิ่มพารามิเตอร์ใหม่เพื่อส่งผลลัพธ์กลับไปยัง Composable
) {
    val createClient = API.create()
    createClient.retrievePost().enqueue(object : Callback<List<PostData>> {
        override fun onResponse(
            call: Call<List<PostData>>,
            response: Response<List<PostData>>
        ) {
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    itemsList.clear()
                    itemsList.addAll(body)
                    // แสดง Toast เมื่อรับข้อมูลสำเร็จ
//                    Toast.makeText(context, "Data loaded successfully", Toast.LENGTH_SHORT).show()
                    Log.e("ItemListisSuccessful", itemsList.toString())
                    onDataLoaded(body) // เรียกฟังก์ชันที่ส่งผลลัพธ์กลับไปยัง Composable
                } else {
                    // แจ้งเตือนถ้าไม่มีข้อมูล
                    Toast.makeText(context, "No data available", Toast.LENGTH_SHORT).show()
                }
            } else {
                // แจ้งเตือนถ้าการร้องขอข้อมูลไม่สำเร็จ

                Toast.makeText(context, "Failed to load data", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<List<PostData>>, t: Throwable) {
            // แจ้งเตือนถ้าการเชื่อมต่อล้มเหลว

            Toast.makeText(context, "Failed to load data: ${t.message}", Toast.LENGTH_SHORT).show()
        }


    })
}

fun dislikePost(context: Context,userId: String, postId: Int) {
    val createClient = API.create()
    val apiService = createClient.dislikePost(userId, postId)
    apiService.enqueue(object : Callback<LikeData> {
        override fun onResponse(call: Call<LikeData>, response: Response<LikeData>) {
            if (response.isSuccessful) {
                // ถ้าสำเร็จในการยกเลิกการถูกใจ
                Toast.makeText(context, "Dislike successful", Toast.LENGTH_SHORT).show()
            } else {
                // ถ้าไม่สำเร็จในการยกเลิกการถูกใจ
                Toast.makeText(context, "Failed to dislike post", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<LikeData>, t: Throwable) {
            // เกิดข้อผิดพลาดในการเชื่อมต่อกับเซิร์ฟเวอร์
            Toast.makeText(context, "Failed to connect to server", Toast.LENGTH_SHORT).show()
        }
    })
}

fun likePost(context: Context,userId: String, postId: Int,status:Int) {
    val createClient = API.create()
    val apiService = createClient.likePost(userId, postId,status)
    apiService.enqueue(object : Callback<LikeData> {
        override fun onResponse(call: Call<LikeData>, response: Response<LikeData>) {
            if (response.isSuccessful) {
                // ถ้าสำเร็จในการยกเลิกการถูกใจ
                Toast.makeText(context, "Like successful", Toast.LENGTH_SHORT).show()
            } else {
                // ถ้าไม่สำเร็จในการยกเลิกการถูกใจ
                Toast.makeText(context, "Failed to dislike post", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<LikeData>, t: Throwable) {
            // เกิดข้อผิดพลาดในการเชื่อมต่อกับเซิร์ฟเวอร์
            Toast.makeText(context, "Failed to connect to server", Toast.LENGTH_SHORT).show()
        }
    })
}

fun getLikesForPost(
    postId: Int,
    onLikesLoaded: (Int) -> Unit,
    onFailure: (String) -> Unit
) {
    val createClient = API.create()
    val apiService = createClient.getLikes(postId)
    apiService.enqueue(object : Callback<LikeData> {
        override fun onResponse(call: Call<LikeData>, response: Response<LikeData>) {
            if (response.isSuccessful) {
                val likeData = response.body()
                if (likeData != null) {
                    // ถ้ามีข้อมูล LikeData ส่งกลับมา
                    val likesCount = likeData.likes_count
                    onLikesLoaded(likesCount)
                } else {
                    onFailure("Response body is null")
                }
            } else {
                onFailure("Failed to load likes for post: ${response.message()}")
            }
        }

        override fun onFailure(call: Call<LikeData>, t: Throwable) {
            onFailure("Failed to connect to server: ${t.message}")
        }
    })
}

fun getLikesForPostStatus(
    usr_id: String,
    postId: Int,
    onStatusLoaded: (Boolean) -> Unit,
    onFailure: (String) -> Unit
) {
    val createClient = API.create()
    val apiService = createClient.getLikesStatus(usr_id)
    apiService.enqueue(object : Callback<List<LikeData>> {
        override fun onResponse(call: Call<List<LikeData>>, response: Response<List<LikeData>>) {
            if (response.isSuccessful) {
                val likeDataList = response.body()
                if (likeDataList != null) {
                    // หาว่า postId นี้ถูกไลค์โดย usr_id หรือไม่
                    val isLiked = likeDataList.any { likeData ->
                        likeData.post_id == postId && likeData.status == 1
                    }
                    onStatusLoaded(isLiked)
                } else {
                    onFailure("Response body is null")
                }
            } else {
                onFailure("Failed to load likes status for user: ${response.message()}")
            }
        }

        override fun onFailure(call: Call<List<LikeData>>, t: Throwable) {
            onFailure("Failed to connect to server: ${t.message}")
        }
    })
}


