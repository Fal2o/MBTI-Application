package com.example.pleasedontbered2

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RestrictedApi", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){
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

    Scaffold(
        modifier = Modifier.background(color = Color(android.graphics.Color.parseColor("#ede7f8"))),
        topBar = {
//            MyTopAppBar(contextForToast = contextForToast,"MBTI Application")
        },
        bottomBar = {
            MyBottomBar(navController = navController, contextForToast = contextForToast)
        }) {
        Column(
            Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = Color(android.graphics.Color.parseColor("#ede7f8")))
                .padding(16.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Log.e("img test1","${UsrItems.profile}")
                Image(painter = rememberAsyncImagePainter(UsrItems.profile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clickable {navController.currentBackStackEntry?.savedStateHandle?.set(
                            "data", ProfileClass(UsrItems.usr_id,UsrItems.usr_name,UsrItems.usr_gender,UsrItems.usr_mbti,UsrItems.role,UsrItems.profile))
                            navController.navigate(Screen.EditProfileScreen.route)

                        }
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier
                        .height(100.dp)
                        .padding(start = 14.dp)
                        .weight(0.7f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "${UsrItems.usr_name}",
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${UsrItems.usr_id}@kkumail.com",
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(top = 14.dp)
                    )
                }
            }
            var text by rememberSaveable { mutableStateOf("") }

            //แถวไอคอนแรก
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ){
                //box1
                Column(
                    Modifier
                        .weight(0.5f)
                        .padding(end = 12.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )

                        .clickable { navController.navigate(Screen.AreYouReady.route) }
                        .padding(top = 16.dp),

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(modifier = Modifier
                        .height(65.dp)
                        .width(75.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#7868e5")),
                            shape = RoundedCornerShape(20.dp)
                        ),
                        contentAlignment = Alignment.Center
                    ){
                        Image(painter = painterResource(id = R.drawable.quiz_2),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp),)
                    }

                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .height(40.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#Dad8ff")),
                            shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)

                        ), contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "Personality Test",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(android.graphics.Color.parseColor("#7868e5"))
                        )
                    }

                }

                //box2
                Column(
                    Modifier
                        .weight(0.5f)
                        .padding(start = 12.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { navController.navigate(Screen.History.route) }
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(modifier = Modifier
                        .height(65.dp)
                        .width(75.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#7868e5")),
                            shape = RoundedCornerShape(20.dp)
                        ),
                        contentAlignment = Alignment.Center
                    ){
                        Image(painter = painterResource(id = R.drawable.ic_3),
                            contentDescription = null,


                            )

                    }
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .height(40.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#Dad8ff")),
                            shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)

                        ), contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "Personality Record",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(android.graphics.Color.parseColor("#7868e5"))
                        )
                    }

                }

            }
            //แถวไอคอนสอง
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ){
                //box1
                Column(
                    Modifier
                        .weight(0.5f)
                        .padding(end = 12.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { navController.navigate(Screen.Type.route) }
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(modifier = Modifier
                        .height(65.dp)
                        .width(75.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#7868e5")),
                            shape = RoundedCornerShape(20.dp)
                        ),
                        contentAlignment = Alignment.Center
                    ){
                        Image(painter = painterResource(id = R.drawable.intelligence),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp),)
                    }

                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .height(40.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#Dad8ff")),
                            shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)

                        ), contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "Types",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(android.graphics.Color.parseColor("#7868e5"))
                        )
                    }

                }

                //box2
                Column(
                    Modifier
                        .weight(0.5f)
                        .padding(start = 12.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(modifier = Modifier
                        .height(65.dp)
                        .width(75.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#7868e5")),
                            shape = RoundedCornerShape(20.dp)
                        ),
                        contentAlignment = Alignment.Center
                    ){
                        Image(painter = painterResource(id = R.drawable.ic_1), contentDescription = null)
                    }
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .height(40.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#Dad8ff")),
                            shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)

                        ), contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "Function A Raidee",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(android.graphics.Color.parseColor("#7868e5"))
                        )
                    }

                }
            }

            ConstraintLayout(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .height(120.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor("#BFA3EF")),
                            Color(android.graphics.Color.parseColor("#BFA3EF"))
                        )
                    ), shape = RoundedCornerShape(25.dp)
                )
            ){
                val (img,text1,text2) = createRefs()
                Image(modifier = Modifier.constrainAs(img){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
                    painter = painterResource(id = R.drawable.arc), contentDescription = null)

                Text(text = "To Get Sleep",
                    fontSize =20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .constrainAs(text1){
                            top.linkTo(parent.top)
                            start.linkTo(img.end)
                            end.linkTo(parent.end)
                        }
                )

                Text(text = "We Need Finish Project",
                    fontSize =20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .constrainAs(text2){
                            top.linkTo(text1.bottom)
                            start.linkTo(text1.start)
                            end.linkTo(text1.end)
                            bottom.linkTo(parent.bottom)
                        }
                )
            }
        }
    }

}



