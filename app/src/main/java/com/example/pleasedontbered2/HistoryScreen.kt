package com.example.pleasedontbered2

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Restore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun HistoryScreen(navController: NavHostController) {

    lateinit var sharedPreferences: SharedPreferencesManager
    val contextForToast = LocalContext.current.applicationContext
    sharedPreferences = SharedPreferencesManager(contextForToast)
    val userId = sharedPreferences.userId ?: ""
    val createClient = API.create()
    val initialUser =
        ProfileClass(usr_id = "", usr_name = "", usr_mbti = "", usr_gender = "", role = "", profile = "",)
    var UsrItems by remember { mutableStateOf(initialUser) }
    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycleState by lifecycleOwner.lifecycle.currentStateFlow.collectAsState()
    val mbtiList = remember { mutableStateOf<List<User_hasMany_MBTI>>(emptyList()) }
    val loadData: suspend () -> Unit = {
        // เรียกใช้ showData และรอให้ข้อมูลโหลดเสร็จสมบูรณ์
        showData(
            mbtiList.value.toMutableList(),
            userId,
            contextForToast,
            onDataLoaded = { newData ->
                // อัปเดตค่าของ mbtiList เมื่อข้อมูลถูกโหลด
                mbtiList.value = newData
            })
    }
    LaunchedEffect(Unit) {
        loadData()
    }


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
            MyTopAppBar(contextForToast = contextForToast, name = "History")
        },
        floatingActionButton = {
            BackButton(navController = navController)
        })
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(26.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(36.dp)) // เพิ่ม Spacer ด้านบนเพื่อขยับหน้าจอลง
            LazyColumn(
                modifier = Modifier.weight(1f), // เพิ่ม Modifier เพื่อให้ LazyColumn ถอยลงมาอีก
                verticalArrangement = Arrangement.spacedBy(12.dp) // ปรับระยะห่างระหว่างรายการ
            ) {
                itemsIndexed(
                    items = mbtiList.value
                ) { index, mbti ->
                    val (mbti_char, mbti_name) = mbtiCheck(mbti.mbti_id)

                    Card(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 4.dp) // ปรับระยะห่างของ Card
                            .fillMaxWidth()
                            .height(110.dp),
                        colors = CardDefaults.cardColors(
                            containerColor =  Color.White,
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        ),
                        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
                        onClick = {
                            navController.navigate("$mbti_char")
                        }
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "$mbti_char",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black, // กำหนดสีข้อความ
                                    modifier = Modifier.padding(top = 12.dp) // เพิ่มช่องว่างด้านบนของ Text
                                )
                                Divider(modifier = Modifier.padding(vertical = 4.dp)) // เพิ่มเส้นกั้นระหว่าง mbti_char และ mbti_name
                                Text(
                                    text = "${mbti_name}",
                                    color = Color.Gray // กำหนดสีข้อความ
                                )
                            }
                            IconButton(
                                onClick = {
                                    softDeleteUserMbti(contextForToast, userId,navController,mbti.mbti_id)
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "softdelete mbti",
                                    tint = Color.Gray
                                )
                            }
                        }
                    }
                }
            }

            IconButton(
                onClick = {
                    restoreUserMbti(contextForToast, userId,navController)
                },
                modifier = Modifier.align(Alignment.End) // จัดการตำแหน่งของปุ่มไปที่ล่างขวา
            ) {
                Icon(
                    imageVector = Icons.Default.Restore,
                    contentDescription = "Restore mbti",
                    tint = Color.Gray
                )
            }

        }
    }

}


fun showData(
    itemsList: MutableList<User_hasMany_MBTI>,
    userId: String,
    context: Context,
    onDataLoaded: (List<User_hasMany_MBTI>) -> Unit // เพิ่มพารามิเตอร์ใหม่เพื่อส่งผลลัพธ์กลับไปยัง Composable
) {
    val createClient = API.create()
    createClient.getUserMbtiId(userId).enqueue(object : Callback<List<User_hasMany_MBTI>> {
        override fun onResponse(
            call: Call<List<User_hasMany_MBTI>>,
            response: Response<List<User_hasMany_MBTI>>
        ) {
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    itemsList.clear()
                    itemsList.addAll(body)
                    // แสดง Toast เมื่อรับข้อมูลสำเร็จ
//                    Toast.makeText(context, "Data loaded successfully", Toast.LENGTH_SHORT).show()
                    Log.e("ItemList", itemsList.toString())
                    onDataLoaded(body) // เรียกฟังก์ชันที่ส่งผลลัพธ์กลับไปยัง Composable
                } else {
                    // แจ้งเตือนถ้าไม่มีข้อมูล
                    // ในที่นี้คุณอาจใช้ผู้เรียกใช้งาน Composable หรือสถานะใน Composable เพื่อแสดงข้อความผิดพลาดหรือแจ้งเตือน
//                    Toast.makeText(context, "No data available", Toast.LENGTH_SHORT).show()
                }
            } else {
                // แจ้งเตือนถ้าการร้องขอข้อมูลไม่สำเร็จ
                // ในที่นี้คุณอาจใช้ผู้เรียกใช้งาน Composable หรือสถานะใน Composable เพื่อแสดงข้อความผิดพลาดหรือแจ้งเตือน
                Toast.makeText(context, "Failed to load data", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<List<User_hasMany_MBTI>>, t: Throwable) {
            // แจ้งเตือนถ้าการเชื่อมต่อล้มเหลว
            // ในที่นี้คุณอาจใช้ผู้เรียกใช้งาน Composable หรือสถานะใน Composable เพื่อแสดงข้อความผิดพลาดหรือแจ้งเตือน
            Toast.makeText(context, "Failed to load data: ${t.message}", Toast.LENGTH_SHORT).show()
        }
    })
}

fun softDeleteUserMbti(contextForToast: Context, userId: String, navController: NavHostController,mbti_id: String) {
    val createClient = API.create()
    createClient.softDeleteUsrMbti(userId,mbti_id).enqueue(object : Callback<User_hasMany_MBTI> {
        override fun onResponse(call: Call<User_hasMany_MBTI>, response: Response<User_hasMany_MBTI>) {
            if (response.isSuccessful) {
                // ประมวลผลเมื่อเรียกใช้ฟังก์ชันสำเร็จ
                // เช่น อัปเดต UI หรือแสดงข้อความ
                Toast.makeText(contextForToast, "MBTI soft deleted successfully", Toast.LENGTH_SHORT).show()
                navController.navigate(Screen.History.route) {
                    popUpTo(Screen.History.route) { inclusive = true }
                }
            } else {
                // แจ้งเตือนเมื่อเกิดข้อผิดพลาดในการเรียกใช้ API
                Toast.makeText(contextForToast, "Failed to soft delete MBTI", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<User_hasMany_MBTI>, t: Throwable) {
            // แจ้งเตือนเมื่อการเชื่อมต่อล้มเหลว
            Toast.makeText(contextForToast, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
        }
    })
}

// เรียกใช้ฟังก์ชัน restore_UsrMbti เมื่อต้องการทำการคืนค่า MBTI
fun restoreUserMbti(contextForToast: Context,userId: String, navController: NavHostController) {
    val createClient = API.create()
    createClient.restore_UsrMbti(userId).enqueue(object : Callback<User_hasMany_MBTI> {
        override fun onResponse(call: Call<User_hasMany_MBTI>, response: Response<User_hasMany_MBTI>) {
            if (response.isSuccessful) {
                // ประมวลผลเมื่อเรียกใช้ฟังก์ชันสำเร็จ
                // เช่น อัปเดต UI หรือแสดงข้อความ
                Toast.makeText(contextForToast, "MBTI restored successfully", Toast.LENGTH_SHORT).show()
                navController.navigate(Screen.History.route) {
                    popUpTo(Screen.History.route) { inclusive = true }
                }
            } else {
                // แจ้งเตือนเมื่อเกิดข้อผิดพลาดในการเรียกใช้ API
                Toast.makeText(contextForToast, "Failed to restore MBTI", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<User_hasMany_MBTI>, t: Throwable) {
            // แจ้งเตือนเมื่อการเชื่อมต่อล้มเหลว
            Toast.makeText(contextForToast, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
        }
    })
}

fun mbtiCheck(mbti_id: String): Pair<String, String>{
    var mbti_char = ""
    var mbti_name = ""
    when (mbti_id) {
        1.toString() -> {
            mbti_char = "ENFJ"
            mbti_name = "ผู้เป็นตัวเอก"
        }
        2.toString() -> {
            mbti_char = "ENTJ"
            mbti_name = "ผู้บัญชาการ"
        }
        3.toString() -> {
            mbti_char = "ENTP"
            mbti_name = "นักโต้วาที"
        }
        4.toString() -> {
            mbti_char = "ENFP"
            mbti_name = "นักรณรงค์"
        }
        5.toString() -> {
            mbti_char = "ESFP"
            mbti_name = "ผู้มอบความบันเทิง"
        }
        6.toString() -> {
            mbti_char = "ESFJ"
            mbti_name = "ผู้ให้คำปรึกษา"
        }
        7.toString()-> {
            mbti_char = "ESTP"
            mbti_name = "ผู้ประกอบการ"
        }
        8.toString() -> {
            mbti_char = "ESTJ"
            mbti_name = "ผู้บริหาร"
        }
        9.toString() -> {
            mbti_char = "INFJ"
            mbti_name = "ผู้สนับสนุน"
        }
        10.toString() -> {
            mbti_char = "INTJ"
            mbti_name = "ผู้มีเหตุผล"
        }
        11.toString() -> {
            mbti_char = "INTP"
            mbti_name = "นักตรรกะ"
        }
        12.toString() -> {
            mbti_char = "INFP"
            mbti_name = "ผู้ไกล่เกลี่ย"
        }
        13.toString() -> {
            mbti_char = "ISFP"
            mbti_name = "นักผจญภัย"
        }
        14.toString() -> {
            mbti_char = "ISFJ"
            mbti_name = "ผู้พิทักษ์"
        }
        15.toString() -> {
            mbti_char = "ISTP"
            mbti_name = "ผู้มีความสามารถโดดเด่น"
        }
        16.toString() -> {
            mbti_char = "ISTJ"
            mbti_name = "นักคำนวณ"
        }
    }
    return Pair(mbti_char, mbti_name)
}

