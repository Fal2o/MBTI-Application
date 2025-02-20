package com.example.pleasedontbered2

import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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

@Composable
fun EditRadioGroupUsage(s: String): String {
    val kinds = listOf("Male", "Female", "Other")
    var (selected, setSelected) = remember { mutableStateOf(s) }

    Text(
        text = "Gender: ${selected}",
        textAlign = TextAlign.Start,
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 10.dp),
    )

    Row(modifier = Modifier.fillMaxWidth().padding(start = 16.dp)) {
        EditRadioGroup(mItems = kinds, selected = selected, setSelected = setSelected)
    }

    return selected
}

@Composable
fun EditRadioGroup(
    mItems: List<String>,
    selected: String,
    setSelected: (selected: String) -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        mItems.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selected == item,
                    onClick = {
                        setSelected(item)
                    },
                    enabled = true,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Green
                    )
                )
                Text(
                    text = item,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
        }
    }
}

@Composable
fun EditProfileScreen(navController: NavHostController) {
    val data = navController.previousBackStackEntry?.savedStateHandle?.get<ProfileClass>("data")
        ?: ProfileClass(usr_id = "", usr_name = "", usr_mbti = "", usr_gender = "" ,role = "", profile = "")



    val contextForToast = LocalContext.current.applicationContext
    lateinit var sharedPreferences: SharedPreferencesManager
    sharedPreferences = SharedPreferencesManager(contextForToast)
    val userId = sharedPreferences.userId ?: ""
    Log.e("userId","${userId}")
    val createClient = API.create()
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val initialUser = ProfileClass(usr_id = "", usr_name = "", usr_mbti = "", usr_gender = "" ,role = "", profile = "",)
    var UsrItems by remember { mutableStateOf(initialUser) }
    var textFieldName = UsrItems.usr_name
    var oldname = UsrItems.usr_name
    var genderValue by remember { mutableStateOf(UsrItems.usr_gender) }
    var image by remember { mutableStateOf(UsrItems.profile) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    Log.e("UsrItems1","${UsrItems}")
    var Gender by remember { mutableStateOf(UsrItems.usr_gender) }
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
                                response.body()!!.profile,
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


    Log.e("UsrItems2","${UsrItems}")
    Log.e("usr_name","${textFieldName}")
    Log.e("gender test","${UsrItems.usr_gender}")
    Log.e("imageUri","${UsrItems.profile}")

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                // รับ URI ของรูปภาพที่เลือก
                imageUri = uri

                image = uri.toString()
            }
        }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Edit Profile",
            fontSize = 25.sp
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .clickable {
                    // เริ่มต้นเครื่องมือการเลือกรูปภาพเมื่อคลิก
                    launcher.launch("image/*")
                }
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            if(imageUri == null){
                Image(
                    painter = rememberAsyncImagePainter(UsrItems.profile),
                    contentDescription = "photo",
                    modifier = Modifier.fillMaxSize()
                )
            }else{
                Image(
                    painter = rememberAsyncImagePainter(imageUri),
                    contentDescription = "photo",
                    modifier = Modifier.fillMaxSize()
                )
            }

        }





        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = textFieldName,
            onValueChange = { textFieldName = it
                UsrItems = UsrItems.copy(usr_name =  it)
            },
            label = { Text("Name") },
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Name") },
            modifier = Modifier.fillMaxWidth()
        )
        var Gender by remember { mutableStateOf(data.usr_gender) }

        if(UsrItems.usr_gender == "Other") genderValue = EditRadioGroupUsage("Other")
        if(UsrItems.usr_gender == "Male") genderValue = EditRadioGroupUsage("Male")
        if(UsrItems.usr_gender == "Female") genderValue = EditRadioGroupUsage("Female")
        Log.e("Gender set UsrItems","${UsrItems.usr_gender}")
        Log.e("genderValue","${genderValue}")



        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                keyboardController?.hide()
                focusManager.clearFocus()
                Log.e("UsrItems usr_name","${UsrItems.usr_name}")
                Log.e("textFieldName","${textFieldName}")

                val inputStream = contextForToast.contentResolver.openInputStream(imageUri!!)
                    ?: throw Exception("Failed to open input stream")
                val imageFile = File.createTempFile("image",".jpg")
                val outputStream = FileOutputStream(imageFile)
                inputStream.copyTo(outputStream)
                inputStream.close()
                outputStream.close()

                val requestBody = imageFile.asRequestBody("image/jpeg".toMediaTypeOrNull())

                val imagePart = MultipartBody.Part.createFormData("profile",imageFile.name,requestBody)

                createClient.editProfile(
                    usr_id =userId.toRequestBody("text/plain".toMediaTypeOrNull()),
                    usr_name = UsrItems.usr_name.toRequestBody("text/plain".toMediaTypeOrNull()),
                    usr_gender = genderValue.toRequestBody("text/plain".toMediaTypeOrNull()),
                    profile = imagePart,
                    old_name = oldname.toRequestBody("text/plain".toMediaTypeOrNull())
                ).enqueue(object : Callback<ProfileClass> {
                    override fun onResponse(call: Call<ProfileClass>, response: Response<ProfileClass>) {
                        if (response.isSuccessful) {

                            Toast.makeText(contextForToast, "Successfully Updated", Toast.LENGTH_SHORT).show()
                            if (navController.currentBackStack.value.size >= 2) {
                                navController.popBackStack()
                            }
                        } else {
                            Toast.makeText(contextForToast, "Update Failed", Toast.LENGTH_SHORT).show()

                        }
                    }

                    override fun onFailure(call: Call<ProfileClass>, t: Throwable) {
                        Toast.makeText(contextForToast, "Error onFailure " + t.message, Toast.LENGTH_LONG).show()
                        Log.e("Error TEst","${t.message}")

                    }
                })
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Update")
        }
        Text(
            text = "Back",
            modifier = Modifier
                .clickable {
                    if (navController.currentBackStack.value.size >= 2) {
                        navController.popBackStack()
                    }
                }
                .padding(8.dp),
            style = TextStyle(color = Color.Black, fontSize = 14.sp)
        )
    }
}





