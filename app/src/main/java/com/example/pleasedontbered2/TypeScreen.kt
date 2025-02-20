package com.example.pleasedontbered2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Insets.add
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RestrictedApi", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TypeScreen(navController: NavController) {
    val contextForToast = LocalContext.current.applicationContext
    var textFildechar by remember { mutableStateOf("") }
    val createClient = API.create()

    val mbtiList = remember { mutableStateOf<List<AllType>>(emptyList()) }
    val loadData: suspend () -> Unit = {
        // เรียกใช้ showData และรอให้ข้อมูลโหลดเสร็จสมบูรณ์
        showDataMbti(
            mbtiList.value.toMutableList(),
            contextForToast,
            onDataLoaded = { newData ->
                // อัปเดตค่าของ mbtiList เมื่อข้อมูลถูกโหลด
                mbtiList.value = newData
            })
    }
    LaunchedEffect(Unit) {
        loadData()
    }

    Scaffold(
        topBar = {
            MyTopAppBar(contextForToast = contextForToast, name = "All Type")
        },

        floatingActionButton = {
            BackButton(navController = navController)
        }) {
        Column {
            Spacer(modifier = Modifier.height(68.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Search:",
                    fontSize = 20.sp
                )

                OutlinedTextField(
                    modifier = Modifier
                        .width(230.dp)
                        .padding(10.dp),
                    value = textFildechar,
                    onValueChange = { textFildechar = it },
                    label = { Text("MBTI Char") }
                )
                Button(onClick = {
                    if(textFildechar.trim().isEmpty()){
                        Log.e("isEmpty","${textFildechar}")
                        showDataMbti(
                            mbtiList.value.toMutableList(),
                            contextForToast,
                            onDataLoaded = { newData ->
                                mbtiList.value = newData
                            }
                        )
                    }
                    else{
                        Log.e("else","${textFildechar}")
                        mbtiList.value = emptyList()
                        createClient.retrieveMbtit(textFildechar)
                            .enqueue(object : Callback<List<AllType>>{
                                override fun onResponse(
                                    call: Call<List<AllType>>,
                                    response: Response<List<AllType>>
                                ) {
                                    if (response.isSuccessful){
                                        mbtiList.value = response.body() ?: emptyList()
                                        Toast.makeText(contextForToast,
                                            "Data Found", Toast.LENGTH_LONG).show()
                                    } else {
                                        Toast.makeText(contextForToast,
                                            "Data Not Found", Toast.LENGTH_LONG).show()
                                    }
                                }

                                override fun onFailure(call: Call<List<AllType>>, t: Throwable) {
                                    Toast.makeText(contextForToast,
                                        "Error onFailure" + t.message, Toast.LENGTH_LONG).show()
                                    Log.e("onFailure","${t.message}")
                                }
                            })

                    }//end if
                })
                {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                }
            }
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    itemsIndexed(
                        items = mbtiList.value.chunked(2) // แบ่ง List เป็นชุดของสองรายการ
                    ) { index, pair ->

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp, vertical = 8.dp)
                        ) {
                            for (item in pair) {
                                Card(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(horizontal = 4.dp)
                                        .fillMaxWidth()
                                        .height(130.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color.White,
                                    ),
                                    elevation = CardDefaults.cardElevation(
                                        defaultElevation = 2.dp
                                    ),
                                    shape = RoundedCornerShape(corner = CornerSize(16.dp)),
                                    onClick = {
//                                    Toast.makeText(
//                                        contextForToast,
//                                        "Click on ${item.mbti_char}.",
//                                        Toast.LENGTH_SHORT
//                                    ).show()
                                        navController.navigate("${item.mbti_char}")
                                    }
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .fillMaxSize(),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.Start // กำหนดให้ข้อความชิดซ้าย
                                    ) {
                                        Text(
                                            text = "${item.mbti_char}",
                                            fontWeight = FontWeight.Bold,
                                            style = TextStyle(fontSize = 20.sp),
                                            color = Color.Black, // กำหนดสีข้อความ
                                            modifier = Modifier.padding(top = 12.dp) // เพิ่มช่องว่างด้านบนของ Text
                                        )
                                        Divider(modifier = Modifier.padding(vertical = 4.dp)) // เพิ่มเส้นกั้นระหว่าง mbti_char และ mbti_name
                                        Text(
                                            text = "${item.mbti_name}",
                                            color = Color.Gray, // กำหนดสีข้อความ
                                            style = TextStyle(fontSize = 16.sp),
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

        }
    }
}
    fun showDataMbti(
        itemsList: MutableList<AllType>,
        context: Context,
        onDataLoaded: (List<AllType>) -> Unit // เพิ่มพารามิเตอร์ใหม่เพื่อส่งผลลัพธ์กลับไปยัง Composable
    ) {
        val createClient = API.create()
        createClient.retrieveMbti().enqueue(object : Callback<List<AllType>> {
            override fun onResponse(
                call: Call<List<AllType>>,
                response: Response<List<AllType>>
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
                        // ในที่นี้คุณอาจใช้ผู้เรียกใช้งาน Composable หรือสถานะใน Composable เพื่อแสดงข้อความผิดพลาดหรือแจ้งเตือน
//                    Toast.makeText(context, "No data available", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // แจ้งเตือนถ้าการร้องขอข้อมูลไม่สำเร็จ
                    // ในที่นี้คุณอาจใช้ผู้เรียกใช้งาน Composable หรือสถานะใน Composable เพื่อแสดงข้อความผิดพลาดหรือแจ้งเตือน
//                Toast.makeText(context, "Failed to load data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<AllType>>, t: Throwable) {
                // แจ้งเตือนถ้าการเชื่อมต่อล้มเหลว
                // ในที่นี้คุณอาจใช้ผู้เรียกใช้งาน Composable หรือสถานะใน Composable เพื่อแสดงข้อความผิดพลาดหรือแจ้งเตือน
//            Toast.makeText(context, "Failed to load data: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

