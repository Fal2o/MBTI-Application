package com.example.pleasedontbered2

import android.net.Uri
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log
import coil.compose.rememberAsyncImagePainter
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import java.io.FileOutputStream


@Composable
fun PostScreen(navController: NavController){

    var thread by remember { mutableStateOf("") }
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
            text = "Add Post",style = TextStyle(
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
                Text(text = "Start a thread ...", color = Color.Gray)
            }
            BasicTextField(
                value = thread,
                onValueChange = { thread = it },
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
                }
            }

        if(imageUri == null){
            Image(painter = painterResource(id = R.drawable.baseline_attachment_24),
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
                Image(painter = if (imageUri != null){
                    rememberAsyncImagePainter(imageUri)
                }else{
                    painterResource(id = R.drawable.baseline_close_24)
                },
                    contentDescription = null,
                    modifier = Modifier
                )
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Remove Img",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .clickable { imageUri = null }
                )
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

        TextButton(
            onClick = {
                Log.e("img test1","${imageUri}")
                val inputStream = contextForToast.contentResolver.openInputStream(imageUri!!)
                    ?: throw Exception("Failed to open input stream")
                val imageFile = File.createTempFile("image",".jpg")
                val outputStream = FileOutputStream(imageFile)
                inputStream.copyTo(outputStream)
                inputStream.close()
                outputStream.close()

                val requestBody = imageFile.asRequestBody("image/jpeg".toMediaTypeOrNull())
                val imagePart = MultipartBody.Part.createFormData("image",imageFile.name,requestBody)

                val usr_id = UsrItems.usr_id.toRequestBody("text/plain".toMediaTypeOrNull())
                val text = thread.toRequestBody("text/plain".toMediaTypeOrNull())
                Log.e("img test","${imagePart}")
                Log.e("usr_id usr_id","${usr_id}")

                createClient.createPostWithImg(
                    usr_id = usr_id,
                    post_text = text,
                    img_post = imagePart
                ).enqueue(object : Callback<PostData> {
                    override fun onResponse(call: Call<PostData>, response: Response<PostData>) {
                        if (response.isSuccessful) {
                            Toast.makeText(contextForToast, "Successfully Inserted", Toast.LENGTH_SHORT).show()
                            if (navController.currentBackStack.value.size >= 2) {
                                navController.popBackStack()
                            }
//                            navController.navigate(Screen.ComunityScreen.route)
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
                text = "Post",
                style = TextStyle(fontSize = 20.sp),
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ComunityScreenView(){
    val navController = rememberNavController()
    PostScreen(navController = navController)
}