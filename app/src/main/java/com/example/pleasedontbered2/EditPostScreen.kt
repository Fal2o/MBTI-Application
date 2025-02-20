package com.example.pleasedontbered2

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EditPost(navController : NavController){

    val data = navController.previousBackStackEntry?.savedStateHandle?.get<PostData>("data")
        ?: PostData(post_id = 0, usr_name = "", post_text = "",  time_stamp = null  , img_post = "", profile = "")

    var image by remember { mutableStateOf(data.img_post) }
    var thread by remember { mutableStateOf(data.post_text) }
    lateinit var sharedPreferences: SharedPreferencesManager
    val contextForToast = LocalContext.current.applicationContext
    sharedPreferences = SharedPreferencesManager(contextForToast)
    val userId = sharedPreferences.userId ?: ""
    val createClient = API.create()
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

    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)){

        val (crossPic,text,logo,userName,editText,attachMedia,
            replyText, button,imageBox) = createRefs()

        Image(painter = painterResource(id = R.drawable.baseline_close_24),
            contentDescription = "close",
            modifier = Modifier
                .constrainAs(crossPic) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .clickable {
                    navController.popBackStack()
                })
        Text(
            text = "Edit post",style = TextStyle(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp), modifier = Modifier.constrainAs(text){
                top.linkTo(crossPic.top)
                start.linkTo(crossPic.end, margin = 12.dp)
                bottom.linkTo(crossPic.bottom)
            }
        )

        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "photo",
            modifier = Modifier
                .constrainAs(logo) {
                    top.linkTo(text.bottom)
                    start.linkTo(parent.start)
                }
                .size(36.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop)

        Text(
            text = "${UsrItems.usr_name}",style = TextStyle(
                fontSize = 20.sp), modifier = Modifier.constrainAs(userName){
                top.linkTo(logo.top)
                start.linkTo(logo.end, margin = 12.dp,)
                bottom.linkTo(logo.bottom)
            }
        )

        Box(
            modifier = Modifier
                .constrainAs(editText) {
                    top.linkTo(userName.bottom)
                    start.linkTo(userName.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(attachMedia.top)
                }
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth()
        ) {
            if (thread.isEmpty()) {
                Text(text = "Edit a thread ...", color = Color.Gray)
            }
            BasicTextField(
                value = thread,
                onValueChange = {
                    thread = it
                                },
                textStyle = TextStyle.Default.copy(color = Color.Black),
                modifier = Modifier.fillMaxWidth()
            )
        }

        var imageUri by remember {
            mutableStateOf<Uri?>(null)
        }

        val launcher =
            rememberLauncherForActivityResult(
                contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
                uri?.let {
                    // Handle the selected image URI
                    imageUri = uri

                    image = uri.toString()
                }
            }

        if(imageUri == null){
            Image(painter = rememberAsyncImagePainter(image),
                contentDescription = "photo",
                modifier = Modifier
                    .constrainAs(attachMedia) {
                        top.linkTo(editText.bottom)
                        start.linkTo(editText.start)
                    }
                    .clickable {
                        launcher.launch("image/*")
                    })
        }else{
            Box(modifier = Modifier
                .background(Color.White)
                .padding(12.dp)
                .constrainAs(imageBox) {
                    top.linkTo(editText.bottom)
                    start.linkTo(editText.start)
                    end.linkTo(parent.end)
                }
                .height(250.dp)
            ) {
                    Image(
                        painter = rememberAsyncImagePainter(imageUri),
                        contentDescription = "photo",
                        modifier = Modifier.fillMaxSize()
                    )
//                Icon(
//                    imageVector = Icons.Default.Close,
//                    contentDescription = "Remove Img",
//                    modifier = Modifier
//                        .align(Alignment.TopEnd)
//                        .clickable { imageUri = null }
//                )
            }

        }

        Text(
            text = "Anyone can reply",
            style = TextStyle(fontSize = 20.sp),
            modifier = Modifier.constrainAs(replyText) {
                start.linkTo(parent.start, margin = 12.dp)
                bottom.linkTo(parent.bottom, margin = 12.dp)
            }
        )

        val contextForToast = LocalContext.current.applicationContext
        sharedPreferences = SharedPreferencesManager(contextForToast)
        val userId = sharedPreferences.userId ?: ""
        val createClient = API.create()
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

        TextButton(
            onClick = {

                Log.e("thread","${thread}")
                Log.e("imageUri","${imageUri}")
                val inputStream = contextForToast.contentResolver.openInputStream(imageUri!!)
                    ?: throw Exception("Failed to open input stream")
                val imageFile = File.createTempFile("image",".jpg")
                val outputStream = FileOutputStream(imageFile)
                inputStream.copyTo(outputStream)
                inputStream.close()
                outputStream.close()

                val requestBody = imageFile.asRequestBody("image/jpeg".toMediaTypeOrNull())
                val imagePart = MultipartBody.Part.createFormData("img_post",imageFile.name,requestBody)

                val id = data.post_id.toString().toRequestBody("text/plain".toMediaTypeOrNull())
                val text = thread.toRequestBody("text/plain".toMediaTypeOrNull())
                Log.e("img test","${imagePart}")

                createClient.updatePost(
                    post_id = data.post_id.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
                    usr_id = UsrItems.usr_id.toRequestBody("text/plain".toMediaTypeOrNull()),
                    post_text = text,
                    img_post = imagePart
                ).enqueue(object : Callback<PostData> {
                    override fun onResponse(call: Call<PostData>, response: Response<PostData>) {
                        if (response.isSuccessful) {
                            Log.e("data post_id","${data.post_id}")
                            Log.e("id ","${id}")
                            Log.e("text save ","${thread}")
                            Log.e("imagePart save ","${imageUri}")
                            Toast.makeText(contextForToast, "Successfully Update ", Toast.LENGTH_SHORT).show()

                            navController.popBackStack()

                        } else {
                            Toast.makeText(contextForToast, "Inserted Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onFailure(call: Call<PostData>, t: Throwable) {
                        Toast.makeText(contextForToast, "Error onFailure " + t.message, Toast.LENGTH_LONG).show()
                    }
                })
            }
            ,
            modifier = Modifier.constrainAs(button) {
                end.linkTo(parent.end, margin = 12.dp)
                bottom.linkTo(parent.bottom, margin = 12.dp)
            }
        ) {
            Text(
                text = "Edit Post",
                style = TextStyle(fontSize = 20.sp),
            )
        }
    }
}