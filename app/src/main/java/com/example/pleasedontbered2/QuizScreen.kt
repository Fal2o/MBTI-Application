package com.example.pleasedontbered2
import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionViewModel : ViewModel() {
    val answers: MutableList<String> = mutableListOf()
    val maxProgress = 1.0f
    val progress = mutableStateOf(0.0f)


    fun incrementProgress1() {
        if (progress.value < maxProgress) {
            progress.value += 0.10f
        }
    }
    fun incrementProgress2() {
        if (progress.value < maxProgress) {
            progress.value += 0.15f
        }
    }
    fun incrementProgressResult() {
        if (progress.value < maxProgress) {
            progress.value += maxProgress - progress.value
        }
    }
    fun decrementProgress() {
        if (progress.value > 0.0f) {
            progress.value -= 0.10f
        }
    }

    fun clearAnswers() {
        answers.clear()
    }
    fun clearProgress() {
        progress.value = 0.0f
    }


}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AreYouReady(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.enfj),
            contentDescription = null,
            modifier = Modifier.size(150.dp) // ปรับขนาดภาพให้เล็กลง
        )
        Text(
            text = "Personality Test",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp),
            modifier = Modifier.padding(10.dp)
        )

        Button(
            onClick = { navController.navigate(Screen.QuizTest.route) },
            modifier = Modifier.padding(vertical = 16.dp),
            colors = ButtonDefaults.buttonColors(
                Color(android.graphics.Color.parseColor("#Dad8ff")),
                contentColor = Color.Black
            )
        ) {
            Text(text = "START THE TEST")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "CANCEL",
                modifier = Modifier
                    .clickable {
                        navController.popBackStack()
                    } ,
                style = TextStyle(color = Color.Black, fontSize = 14.sp)

            )


        }

    }
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuestionScreenTest(navController: NavController, viewModel: QuestionViewModel) {
    val contextForToast = LocalContext.current
    val progress = viewModel.progress.value

    //top bottombar
    Scaffold(
        topBar = { MyTopAppBar(contextForToast = contextForToast,"MBTI Test") },
//        bottomBar = { MyBottomBar(navController = navController,contextForToast = contextForToast) }
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "ถ้าเจอเพื่อนใหม่ครั้งแรก",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )

                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        navController.navigate(Screen.QuizTest12.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(25.dp),
                ) {
                    Text(text = "เริ่มคุยกับคนอื่นก่อน")
                }

                Button(
                    onClick = {
                        viewModel.incrementProgress2()
                        navController.navigate(Screen.QuizTest13.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "ส่วนใหญ่คนอื่นจะเริ่มเข้ามาคุยก่อน")
                }

            }
        }

    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuestionScreenTest12(navController: NavController, viewModel: QuestionViewModel ) {
    val contextForToast = LocalContext.current
    val progress = viewModel.progress.value
    Scaffold(
        topBar = { MyTopAppBar(contextForToast = contextForToast,"MBTI Test")

        },
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "ทำอะไรในช่วงวันหยุด",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        navController.navigate(Screen.QuizTest13.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(25.dp),
                ) {
                    Text(text = "ออกไปเจอเพื่อน")
                }

                Button(
                    onClick = {
                        viewModel.incrementProgress2()
                        viewModel.answers.add("I")
                        Log.e("Test", "Last Answer: ${viewModel.answers.lastOrNull()}")
                        navController.navigate(Screen.QuizTest2.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "อยู่คนเดียวก็สบายใจดีนะ")
                }

                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        navController.navigate(Screen.QuizTest13.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "ได้หมด ชอบที่จะเจอเพื่อนแต่บางครั้งก็อยากอยู่เงียบ...")
                }
                IconButton(
                    onClick = {
                        if (viewModel.answers.size > 0 ) {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                            viewModel.answers.removeLastOrNull()
                        } else {
                            viewModel.progress.value -= 0.1f /12.0f
                            viewModel.decrementProgress()
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.Start)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }

            }
        }

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuestionScreenTest13(navController: NavController, viewModel: QuestionViewModel) {
    val contextForToast = LocalContext.current
    val progress = viewModel.progress.value
    Scaffold(
            topBar = { MyTopAppBar(contextForToast = contextForToast,"MBTI Test")
        },
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "ตอนอยู่กับเพื่อนเป็นคนยังไง?",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )

                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        viewModel.answers.add("I")
                        Log.e("Test", "Last Answer: ${viewModel.answers.lastOrNull()}")
                        navController.navigate(Screen.QuizTest2.route)

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(25.dp),
                ) {
                    Text(text = "ชอบที่จะคุยเบาๆกับเพื่อนกลุ่มเล็กๆ")
                }

                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        viewModel.answers.add("E")
                        Log.e("Test", "Last Answer: ${viewModel.answers.lastOrNull()}")
                        Log.e("TestChar2", "Char2: ${viewModel.answers}")

                        navController.navigate(Screen.QuizTest2.route)

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "ชอบเมาธ์มอย บรรยากาศที่น่าตื่นเต้น สนุกสนาน")
                }

                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        viewModel.answers.add("I")
                        Log.e("Test", "Last Answer: ${viewModel.answers.lastOrNull()}")
                        navController.navigate(Screen.QuizTest2.route)

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "ชอบความสนุกสนานแต่ไม่ชอบความวุ่นวาย")
                }
                IconButton(
                    onClick = {
                        if (viewModel.answers.size > 0  ) {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                            viewModel.answers.removeLastOrNull()
                        } else {
                            viewModel.progress.value -= 0.1f /12.0f
                            viewModel.decrementProgress()
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.Start)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }

            }
        }

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuestionScreenTest2(navController: NavController, viewModel: QuestionViewModel ) {
    val contextForToast = LocalContext.current
    Scaffold(
        topBar = { MyTopAppBar(contextForToast = contextForToast,"MBTI Test")
        },
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "คิดว่าอะไรสำคัญกว่ากัน?",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                val progress = viewModel.progress.value
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )

                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        navController.navigate(Screen.QuizTest22.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(25.dp),
                ) {
                    Text(text = "ถ้าไม่มีปัจจุบัน ก็ไม่มีอนาคต")
                }

                Button(
                    onClick = {
                        viewModel.incrementProgress2()
                        navController.navigate(Screen.QuizTest23.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "ถ้าไม่มีแพลนในอนาคต ก็ไม่มีความกระตือรืนร้น")
                }
                IconButton(
                    onClick = {
                        if (viewModel.answers.size == 1  ) {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                            viewModel.answers.removeLastOrNull()
                        } else {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.Start)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuestionScreenTest22(navController: NavController, viewModel: QuestionViewModel) {
    val contextForToast = LocalContext.current
    Scaffold(
        topBar = { MyTopAppBar(contextForToast = contextForToast,"MBTI Test")

        },
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "ตอนทำงานเป็นคนยังไง?",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                val progress = viewModel.progress.value
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        navController.navigate(Screen.QuizTest23.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(25.dp),
                ) {
                    Text(text = "ทำตามคนอื่นๆทำ")
                }

                Button(
                    onClick = {
                        viewModel.incrementProgress2()
                        viewModel.answers.add("N")
                        Log.e("Test", "Last Answer: ${viewModel.answers.lastOrNull()}")
                        navController.navigate(Screen.QuizTest3.route)

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "ชอบทำตามสไตล์ตัวเอง")
                }

                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        navController.navigate(Screen.QuizTest23.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "แล้วแต่สถานการณ์")
                }
                IconButton(
                    onClick = {
                        if (viewModel.answers.size == 1 ) {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                            viewModel.answers.removeLastOrNull()
                        } else {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.Start)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuestionScreenTest23(navController: NavController, viewModel: QuestionViewModel ) {

    val contextForToast = LocalContext.current
    Scaffold(
        topBar = { MyTopAppBar(contextForToast = contextForToast,"MBTI Test")

        },
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "คนอื่นๆ พูดถึงเราว่า...",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                val progress = viewModel.progress.value
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        viewModel.answers.add("S")
                        Log.e("Test", "Last Answer: ${viewModel.answers.lastOrNull()}")
                        navController.navigate(Screen.QuizTest3.route)

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(25.dp),
                ) {
                    Text(text = "เป็นคนสม่ำเสมอ เเละมีความอดทน")
                }

                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        viewModel.answers.add("N")
                        Log.e("Test", "Last Answer: ${viewModel.answers.lastOrNull()}")
                        navController.navigate(Screen.QuizTest3.route)

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "เป็นคนมีความคิดสร้างสรรค์เเละโดดเด่นไม่เหมือนใคร")
                }
                IconButton(
                    onClick = {
                        if (viewModel.answers.size == 1) {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                            viewModel.answers.removeLastOrNull()
                        } else {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.Start)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuestionScreenTest3(navController: NavController, viewModel: QuestionViewModel ) {

    val contextForToast = LocalContext.current
    Scaffold(
        topBar = { MyTopAppBar(contextForToast = contextForToast,"MBTI Test")

        },
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "ถ้ามีคนมาขอร้องให้ช่วย",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                val progress = viewModel.progress.value
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        navController.navigate(Screen.QuizTest32.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(25.dp),
                ) {
                    Text(text = "ลังเลนิดหน่อยแต่ส่วนใหญ่เเล้วก็ยอมทำให้")
                }

                Button(
                    onClick = {
                        viewModel.incrementProgress2()
                        navController.navigate(Screen.QuizTest33.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "พูดอย่างชัดเจนว่า ไม่ได้!")
                }
                IconButton(
                    onClick = {
                        if (viewModel.answers.size == 2  ) {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                            viewModel.answers.removeLastOrNull()
                        } else {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.Start)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuestionScreenTest32(navController: NavController, viewModel: QuestionViewModel ) {

    val contextForToast = LocalContext.current
    Scaffold(
        topBar = { MyTopAppBar(contextForToast = contextForToast,"MBTI Test")

        },
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "ถ้าโกรธ...",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                val progress = viewModel.progress.value
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        navController.navigate(Screen.QuizTest33.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(25.dp),
                ) {
                    Text(text = "เถียงด้วยตรรกะเเละเหตุผล")
                }

                Button(
                    onClick = {
                        viewModel.incrementProgress2()
                        viewModel.answers.add("F")
                        Log.e("Test", "Last Answer: ${viewModel.answers.lastOrNull()}")
                        navController.navigate(Screen.QuizTest4.route)

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "อยู่ภายในใจเป็นหมื่นล้านคำ ไม่พูดแต่น้ำตามาเเล้ว")
                }

                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        navController.navigate(Screen.QuizTest33.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "เป็นทั้งคู่เเล้วแต่สถานการณ์")
                }
                IconButton(
                    onClick = {
                        if (viewModel.answers.size == 2 ) {
                            viewModel.incrementProgress2()
                            navController.popBackStack()
                            viewModel.answers.removeLastOrNull()
                        } else {
                            viewModel.incrementProgress2()
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.Start)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuestionScreenTest33(navController: NavController, viewModel: QuestionViewModel) {

    val contextForToast = LocalContext.current
    Scaffold(
        topBar = { MyTopAppBar(contextForToast = contextForToast,"MBTI Test")

        },
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "เพื่อนมาปรึกษาแต่ฝ่ายผิด จะ...",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                val progress = viewModel.progress.value
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        viewModel.answers.add("F")
                        Log.e("Test", "Last Answer: ${viewModel.answers.lastOrNull()}")
                        navController.navigate(Screen.QuizTest4.route)

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(25.dp),
                ) {
                    Text(text = "ถ้าพูดตรงๆเพื่อนอาจจะเสียใจ เลยพูดแบบอ้อมๆ")
                }

                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        viewModel.answers.add("T")
                        Log.e("Test", "Last Answer: ${viewModel.answers.lastOrNull()}")
                        navController.navigate(Screen.QuizTest4.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "บอกเพื่อนไปตรงๆ ว่าผิดตรงไหน")
                }

                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        viewModel.answers.add("F")
                        Log.e("Test", "Last Answer: ${viewModel.answers.lastOrNull()}")
                        navController.navigate(Screen.QuizTest4.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "ให้คำปรึกษาแตกต่างกันไปตามเพื่อนแต่ละคน")
                }
                IconButton(
                    onClick = {
                        if (viewModel.answers.size == 2 ) {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                            viewModel.answers.removeLastOrNull()
                        } else {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.Start)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuestionScreenTest4(navController: NavController, viewModel: QuestionViewModel) {

    val contextForToast = LocalContext.current
    Scaffold(
        topBar = { MyTopAppBar(contextForToast = contextForToast,"MBTI Test")

        },
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "เมื่อต้องเตรียมของ...",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                val progress = viewModel.progress.value
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        navController.navigate(Screen.QuizTest42.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(25.dp),
                ) {
                    Text(text = "พรุ่งนี้ค่อยทำละกัน เเล้วก็ลืม")
                }

                Button(
                    onClick = {
                        viewModel.incrementProgress2()
                        navController.navigate(Screen.QuizTest43.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "เตรียมตัวล่วงหน้า 1 วัน")
                }
                IconButton(
                    onClick = {
                        if (viewModel.answers.size == 3  ) {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                            viewModel.answers.removeLastOrNull()
                        } else {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.Start)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuestionScreenTest42(navController: NavController, viewModel: QuestionViewModel) {

    val contextForToast = LocalContext.current
    Scaffold(
        topBar = { MyTopAppBar(contextForToast = contextForToast,"MBTI Test")

        },
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "หลังเลิกเรียนหรือเลิกงานกำลังจะกลับบ้าน แต่เพื่อนชวน...",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                val progress = viewModel.progress.value
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
                Button(
                    onClick = {

                        viewModel.incrementProgress1()
                        navController.navigate(Screen.QuizTest43.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(25.dp),
                ) {
                    Text(text = "โอเคเลย! ได้เสมอ! ชีวิตไม่มีข้อจำกัด")
                }

                Button(
                    onClick = {
                        viewModel.incrementProgressResult()
                        viewModel.answers.add("J")
                        Log.e("Test", "Last Answer: ${viewModel.answers.lastOrNull()}")
                        navController.navigate(Screen.Result.route)

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "ไม่ได้อยู่ในแพลที่วางไว้ ลำบากใจจัง")
                }
                Button(
                    onClick = {
                        viewModel.incrementProgress1()
                        navController.navigate(Screen.QuizTest43.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "วันนี้เหนือยเเล้ว ขอพักเถอะนะ")
                }
                IconButton(
                    onClick = {
                        if (viewModel.answers.size == 3 ) {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                            viewModel.answers.removeLastOrNull()
                        } else {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.Start)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuestionScreenTest43(navController: NavController, viewModel: QuestionViewModel){

    val contextForToast = LocalContext.current
    Scaffold(
        topBar = { MyTopAppBar(contextForToast = contextForToast,"MBTI Test")
        },
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "เวลาไปเที่ยว...",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                val progress = viewModel.progress.value
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
                Button(
                    onClick = {
                        viewModel.incrementProgressResult()
                        viewModel.answers.add("P")
                        Log.e("Test", "Last Answer: ${viewModel.answers.lastOrNull()}")
                        navController.navigate(Screen.Result.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(25.dp),
                ) {
                    Text(text = "ยืดหยุ่นตามสถานการณ์ ทำทุกอย่างที่อยากทำในตอนนั้น")
                }

                Button(
                    onClick = {
                        viewModel.incrementProgressResult()
                        viewModel.answers.add("J")
                        Log.e("Test", "Last Answer: ${viewModel.answers.lastOrNull()}")
                        navController.navigate(Screen.Result.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "ชอบที่จะทำตามแผน ต้องทำได้ตามที่วางไว้")
                }
                IconButton(
                    onClick = {
                        if (viewModel.answers.size == 3 ) {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                            viewModel.answers.removeLastOrNull()
                        } else {
                            viewModel.decrementProgress()
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.Start)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun Result(navController: NavController, viewModel: QuestionViewModel) {

    val resultMBTI = viewModel.answers.joinToString("")
    lateinit var sharedPreferences: SharedPreferencesManager
    val contextForToast = LocalContext.current.applicationContext
    sharedPreferences = SharedPreferencesManager(contextForToast)
    val userId = sharedPreferences.userId ?: ""
    val createClient = API.create()
    val initialUser = ProfileClass(usr_id = "", usr_name = "", usr_mbti = "", usr_gender = "" ,role = "", profile = "")
    var UsrItems by remember { mutableStateOf(initialUser) }
    var mbti_id = 0
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

    Log.e("Result id",UsrItems.usr_id)
    Scaffold(
        topBar = { MyTopAppBar(contextForToast = contextForToast,"Result")
        }) {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "ผลลัพธ์ของคุณคือ",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "${resultMBTI}",
                    style = TextStyle(fontSize = 60.sp, fontWeight = FontWeight.ExtraBold, color = Color.Black),
                    modifier = Modifier.padding(bottom = 28.dp)
                )
                Button(
                    onClick = {
                    if(resultMBTI == "ENFJ") {
                        mbti_id = 1
                        saveUserMbti(UsrItems.usr_id, mbti_id, contextForToast)
                        navController.navigate(Screen.ENFJ.route)
                    }
                        if(resultMBTI == "ENTJ") {
                            mbti_id = 2
                            Log.e("Result mbti", mbti_id.toString())
                            Log.e("Result id",UsrItems.usr_id)
                            saveUserMbti(UsrItems.usr_id, mbti_id, contextForToast)
                            navController.navigate(Screen.ENTJ.route)
                        }
                    if(resultMBTI == "ENTP"){
                        mbti_id = 3
                        saveUserMbti(UsrItems.usr_id, mbti_id, contextForToast)
                        navController.navigate(Screen.ENTP.route)
                    }
                    if(resultMBTI == "ENFP"){
                        mbti_id = 4
                        saveUserMbti(UsrItems.usr_id, mbti_id, contextForToast)
                        navController.navigate(Screen.ENFP.route)
                    }
                    if(resultMBTI == "ESFP") {
                        mbti_id = 5
                        saveUserMbti(UsrItems.usr_id, mbti_id, contextForToast)
                        navController.navigate(Screen.ESFP.route)
                    }
                    if(resultMBTI == "ESFJ"){
                        mbti_id = 6
                        saveUserMbti(UsrItems.usr_id, mbti_id, contextForToast)
                        navController.navigate(Screen.ESFJ.route)
                    }
                    if(resultMBTI == "ESTP"){
                        mbti_id = 7
                        saveUserMbti(UsrItems.usr_id, mbti_id, contextForToast)
                        navController.navigate(Screen.ESTP.route)
                    }
                    if(resultMBTI == "ESTJ") {
                        mbti_id = 8
                        saveUserMbti(UsrItems.usr_id, mbti_id, contextForToast)
                        navController.navigate(Screen.ESTJ.route)
                    }
                    if(resultMBTI == "INFJ") {
                        mbti_id = 9
                        saveUserMbti(UsrItems.usr_id, mbti_id, contextForToast)
                        navController.navigate(Screen.INFJ.route)
                    }
                    if(resultMBTI == "INTJ") {
                        mbti_id = 10
                        saveUserMbti(UsrItems.usr_id, mbti_id, contextForToast)
                        navController.navigate(Screen.INTJ.route)
                    }
                    if(resultMBTI == "INTP") {
                        mbti_id = 11
                        saveUserMbti(UsrItems.usr_id, mbti_id, contextForToast)
                        navController.navigate(Screen.INTP.route)
                    }
                    if(resultMBTI == "INFP") {
                        mbti_id = 12
                        saveUserMbti(UsrItems.usr_id, mbti_id, contextForToast)
                        navController.navigate(Screen.INFP.route)
                    }
                    if(resultMBTI == "ISFP") {
                        mbti_id = 13
                        saveUserMbti(UsrItems.usr_id, mbti_id, contextForToast)
                        navController.navigate(Screen.ISFP.route)
                    }
                    if(resultMBTI == "ISFJ") {
                        mbti_id = 14
                        saveUserMbti(UsrItems.usr_id, mbti_id, contextForToast)
                        navController.navigate(Screen.ISFJ.route)
                    }
                    if(resultMBTI == "ISTP") {
                        mbti_id = 15
                        saveUserMbti(UsrItems.usr_id, mbti_id, contextForToast)
                        navController.navigate(Screen.ISTP.route)
                    }
                    if(resultMBTI == "ISTJ"){
                        mbti_id = 16
                        saveUserMbti(UsrItems.usr_id, mbti_id, contextForToast)
                        navController.navigate(Screen.ISTJ.route)
                    }

                        viewModel.clearAnswers()
                        viewModel.clearProgress()

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(25.dp),
//                colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "อ่านเพิ่มเติม")
                }

                Log.e("All answers", "All answers: ${viewModel.answers}")
            }
        }

    }

}

@Preview
@Composable
fun PreviewQuestionScreenTest() {
    val navController = rememberNavController()
    AreYouReady(navController)
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
fun saveUserMbti(usr_id: String, mbti_id: Int, contextForToast: Context) {
    val createClient = API.create()

    createClient.insertUserMbti(usr_id, mbti_id).enqueue(object :
        Callback<User_hasMany_MBTI> {
        override fun onResponse(call: Call<User_hasMany_MBTI>, response: Response<User_hasMany_MBTI>) {
            if (response.isSuccessful) {
                Toast.makeText(contextForToast, "Saved! ", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(contextForToast, "You already Saved!", Toast.LENGTH_LONG).show()
            }
        }

        override fun onFailure(call: Call<User_hasMany_MBTI>, t: Throwable) {
            Toast.makeText(contextForToast, "Error onFailure: " + t.message, Toast.LENGTH_LONG).show()
        }
    })
}

