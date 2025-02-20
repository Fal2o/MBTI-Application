package com.example.pleasedontbered2

import android.net.Uri
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
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
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

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController) {
    val contextForToast = LocalContext.current
    val createClient = API.create()
    var UserID by remember { mutableStateOf("") }
    var UserName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    var gender by remember { mutableStateOf("") }

    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                // รับ URI ของรูปภาพที่เลือก
                imageUri = uri
            }
        }

    // สถานะเก็บ URI ของรูปภาพ


    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Register",
            fontSize = 25.sp
        )
        // เพิ่มฟิลด์รูปภาพ
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
            imageUri?.let { uri ->
                // แสดงรูปภาพถ้ามี URI
                Image(
                    painter =  rememberAsyncImagePainter(imageUri),
                    contentDescription = "photo",
                    modifier = Modifier
                        .fillMaxSize()
                )
            } ?: run {
                // แสดงไอคอนเมื่อยังไม่มีรูปภาพ
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "photo",
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = UserID,
            onValueChange = { newStudentID -> // Specify parameter name explicitly
                UserID = newStudentID
                isButtonEnabled = validateInput(UserID, password)
            },
            label = { Text("User ID") },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = UserName,
            onValueChange = { newstudentName -> // Specify parameter name explicitly
                UserName = newstudentName
                isButtonEnabled = validateInput(UserID, password)
            },
            label = { Text("Name") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) },
            modifier = Modifier.fillMaxWidth()
        )

        gender = (RadioGroupGender())

        OutlinedTextField(
            value = password,
            onValueChange = { newPassword -> // Specify parameter name explicitly
                password = newPassword
                isButtonEnabled = validateInput(UserID, password)
            },
            label = { Text("Password") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val inputStream = contextForToast.contentResolver.openInputStream(imageUri!!)
                    ?: throw Exception("Failed to open input stream")
                val imageFile = File.createTempFile("image",".jpg")
                val outputStream = FileOutputStream(imageFile)
                inputStream.copyTo(outputStream)
                inputStream.close()
                outputStream.close()

                val requestBody = imageFile.asRequestBody("image/jpeg".toMediaTypeOrNull())
                val imagePart = MultipartBody.Part.createFormData("image",imageFile.name,requestBody)

                val UserID = UserID.toRequestBody("text/plain".toMediaTypeOrNull())
                val UserName = UserName.toRequestBody("text/plain".toMediaTypeOrNull())
                val password = password.toRequestBody("text/plain".toMediaTypeOrNull())
                val gender = gender.toRequestBody("text/plain".toMediaTypeOrNull())

                keyboardController?.hide()
                focusManager.clearFocus()
                createClient.registerStudentProfile(
                    usr_id =  UserID,
                    usr_name = UserName,
                    usr_password = password,
                    usr_mbti = "".toRequestBody("text/plain".toMediaTypeOrNull()),
                    usr_gender = gender,
                    profile = imagePart
                ).enqueue(object : Callback<LoginClass> {
                    override fun onResponse(call: Call<LoginClass>, response: Response<LoginClass>) {
                        if (response.isSuccessful) {
                            Toast.makeText(contextForToast, "Successfully Registed", Toast.LENGTH_SHORT).show()
                            if (navController.currentBackStack.value.size >= 2) {
                                navController.popBackStack()
                            }
                            navController.navigate(Screen.Login.route)
                        } else {
                            Toast.makeText(contextForToast, "Inserted Failed", Toast.LENGTH_SHORT).show()
                        }
                    }


                    override fun onFailure(call: Call<LoginClass>, t: Throwable) {
                        Toast.makeText(contextForToast, "Error onFailure " + t.message, Toast.LENGTH_LONG).show()
                    }
                })
            },
            enabled = isButtonEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Register")
        }
        Text(
            text = "Back",
            modifier = Modifier
                .clickable {
                    if (navController.currentBackStack.value.size >= 2) {
                        navController.popBackStack()
                    }
                }
                .padding(8.dp) ,
            style = TextStyle(color = Color.Black, fontSize = 14.sp)
        )
    }
}




fun validateInput(studentID: String, password: String): Boolean =
    !studentID.isNullOrEmpty() && !password.isNullOrEmpty()


@Composable
fun Gender( mItems: List<String>, selected: String, setselected: (selected:String) -> Unit){
    Row(
        modifier = Modifier.fillMaxWidth(),
    ){
        mItems.forEach{ item ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = selected == item,
                    onClick = {
                        setselected(item) },
                    enabled = true,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Magenta)
                )
                Text(text = item, modifier = Modifier.padding(start = 2.dp))
            }
        }
    }
}

@Composable
fun RadioGroupGender(): String{
    val kinds = listOf("Male", "Female", "Other")
    val (selected, setselected) = remember { mutableStateOf("") }

    Column {
        Text(
            text = "Gender : $selected",
            textAlign = TextAlign.Start,
            modifier = Modifier

                .fillMaxWidth()
                .padding(start = 20.dp, top = 5.dp),
        )
        Row ( modifier = Modifier
            .fillMaxWidth()
//            .padding(start = 16.dp)
        ){
            Gender(
                mItems = kinds,
                selected, setselected
            )
        }
    }
    return selected
}
