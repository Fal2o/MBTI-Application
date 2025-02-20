package com.example.pleasedontbered2

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ENTJ_faro(navController: NavController) {
    val contextForToast = LocalContext.current
    val backStackEntry = navController.previousBackStackEntry
    val routeFrom = backStackEntry?.destination?.route
    Scaffold(
        topBar = {
//            MyTopAppBarResult(contextForToast = contextForToast)
        },
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ){
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    Spacer(modifier = Modifier.height(80.dp))
                    Text(
                        text = "บุคลิกแบบ ENTJ",
                        style = TextStyle(fontSize = 40.sp, fontWeight = FontWeight.ExtraBold),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "คนมุทะลุที่เกลียดการทำให้คนอื่นรู้สึกเจ็บปวดที่สุด",
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "• นิสัย",
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Text(
                        text = "\t\t\t\tถ้าได้ทำงานกับคนที่น่าอึดอัด ก็จะแย่งงานทั้งหมดมาทำเองคนเดียว มีความมุมานะและความรับผิดชอบที่โดดเด่น รับผิดชอบงานทั้งหมดที่ทำอย่างเต็มที่ ไม่ชอบการเป็นเหยื่อ และไม่ชอบทำให้คนอื่นเป็นเหยื่อด้วย ถ้าไม่ใช่เรื่องของตัวเองก็ไม่สนใจหรอกน" +
                                "ะ ไม่ใช่คนที่ชอบพึ่งพาคนอื่นเท่าไร ชอบพึ่งตัวเองมากกว่า ถ้ามีคนมาระบายหรือปรึกษา ก็จะไม่ค่อยเออออตามด้วยเท่าไร มักจะบอกทางแก้แบบมีตรรกะและเหตุผลมากกว่า ชีวิตวุ่นวายอยู่ตลอด ทำงานเก่ง ก็เลยเป็นคนฉลาด เพราะแบบนี้หรือเปล่า ชีวิตก็เลยดูง่าย ๆ เรื่องที่ไม่ชอบต่อให้ตายก็ไม่มีทางทำเด็ดขาด! แต่ถ้าต้องทำจริงๆ ก็ไม่ลงทุนลงแรงมาก จะหาวิธีที่ง่ายที่สุดในการจัดการให้จบๆไป มีเป้าหมายที่ชัดเจนและก็มีความมั่นใจกับทุกอย่างก็เลยเป็นคนที่โดดเด่นและดูเซ็กซี่",
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Light),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "• สิ่งที่ต้องระวัง",
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Text(
                        text = "\t\t\t\tเพราะว่าเป็นคนฉลาด เวลาเจอคนที่ไม่ค่อยฉลาดหรือไม่ค่อยมีไหวพริบก็จะแอบรู้สึกเหยียด หงุดหงิดอยู่ในใจและใช้คำพูดสร้างความเจ็บปวดให้คนอื่นแบบตั้งใจอยู่บ่อยๆ ไม่ให้อภัยกับการทำผิดซ้ำซาก เกลียดคนโลเลและคนโง่แต่ดื้อที่สุด! เกลียดการที่ยังไม่ได้ลองทำแต่พูดว่าทำไม่ได้มาก! เป็นคนมุทะลุไม่เข้าใจประเพณีอะไรที่มันไร้ความยุติธรรม เป็นคนชอบเถียง มีความอยากเอาชนะ ถ้าความเห็นไม่ตรงกันก็ลองโต้วาทีกันดูสักตั้ง! ต้องชนะถึงจะเลิกไม่ชอบการโดนสั่งสอน",
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Light),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "• มักจะเข้าได้ดีกับคนแบบนี้",
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Text(
                        text = "\t\t\t\tชอบคนฉลาด มีวิสัยทัศน์ เชื่อใจและรับในตัวตนของคนกลุ่มนี้ได้ถ้าเป็นคนที่ใช้อารมณ์ตลอดเวลาก็ Say No! ถ้าเจอคนที่มีเสน่ห์และเป็นคนในสเปคก็จะตกหลุมรักได้อย่างง่าย ๆ เลย\n" +
                                "หงุดหงิดอยู่ในใจและใช้คำพูดสร้างความเจ็บปวดให้คนอื่นแบบตั้งใจอยู่บ่อยๆ ไม่ให้อภัยกับการทำผิดซ้ำซาก เกลียดคนโลเลและคนโง่แต่ดื้อที่สุด! เกลียดการที่ยังไม่ได้ลองทำแต่พูดว่าทำไม่ได้มาก! เป็นคนมุทะลุไม่เข้าใจประเพณีอะไรที่มันไร้ความยุติธรรม เป็นคนชอบเถียง มีความอยากเอาชนะ ถ้าความเห็นไม่ตรงกันก็ลองโต้วาทีกันดูสักตั้ง! ต้องชนะถึงจะเลิกไม่ชอบการโดนสั่งสอน",
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Light),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(){
                        Text(
                            text = "• บุคลิกที่เข้ากันได้ดี:",
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Text(
                            text = "INTP,INFP",
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Light),
                            modifier = Modifier.padding(horizontal = 0.dp)
                        )
                    }
                    Row( verticalAlignment = Alignment.CenterVertically){
                        Text(
                            text = "• บุคลิกที่ควรหลีกเลี่ยง:",
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Text(
                            text = "ไม่มี",
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Light),
                            modifier = Modifier.padding(horizontal = 0.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = " ",
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Light),
                            modifier = Modifier.padding(horizontal = 0.dp)
                        )
                    }
                    IconButton(
                        onClick = {
                            if (routeFrom == Screen.Result.route) {
                                navController.navigate(Screen.Home.route) // กลับไปยังหน้า Home ถ้าเป็นการเรียกจากหน้า Result
                            } else {
                                navController.popBackStack() // ให้ pop stack ถ้าไม่ได้เรียกจากหน้า Result
                            }
                        },
                        modifier = Modifier.padding(16.dp)
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
}

@Composable
fun INTJ(navController: NavController) {
    val backStackEntry = navController.previousBackStackEntry
    val routeFrom = backStackEntry?.destination?.route
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "INTJ TYPE",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            painter = painterResource(id= R.drawable.intj),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            text = "ผู้มีเหตุผล (Architect) (INTJ)",
            fontSize = 18.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = "ยิ่งสูงยิ่งเหงา คำ ๆ นี้อาจใช้ได้กับบุคลิกนี้ ในฐานะหนึ่งในประเภทบุคลิกภาพที่หายากที่สุด " +
                    "และเป็นหนึ่งในประเภทที่มีความสามารถมากที่สุด – ผู้มีเหตุผล (Architect) (INTJ) " +
                    "รู้เรื่องนี้เป็นอย่างดี ผู้มีเหตุผลมีเหตุผลและมีไหวพริบ ภูมิใจในความสามารถการคิดด้วยตนเอง " +
                    "รวมถึงมีความสามารถพิเศษที่น่าทึ่งในการมองสิ่งต่าง ๆ ได้อย่างทะลุปรุโปร่งสำหรับการหลอกลวงและความเสแสร้งใด ๆ" +
                    " แต่เนื่องจากจิตใจของพวกเขาไม่เคยหยุดนิ่ง ผู้มีเหตุผลจึงอาจประสบปัญหาในการหาคนที่สามารถวิเคราะห์ทุกสิ่ง" +
                    "ที่อยู่รอบตัวไปพร้อมกับพวกเขาอย่างไม่หยุดยั้งได้",
            fontSize = 12.sp ,

            )
        Image(
            painter = painterResource(id= R.drawable.intj_type),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(400.dp)
        )
        Text(text ="บุคลิกภาพและลักษณะเฉพาะตัวของ INTJ\n",fontSize = 16.sp , fontWeight = FontWeight.Bold )
        Text(
            text =
            "คนที่มีบุคลิกภาพแบบ INTJ เป็นคนที่ให้ความสำคัญกับวิสัยทัศน์ ความหมาย และความเป็นไปได้ พวกเขาใช้เวลาส่วนมากอยู่กับการคิดถึงสิ่งที่อยู่ในอนาคตและสิ่งที่เป็นนามธรรม พวกเขาชอบความซับซ้อนและสิ่งที่มีความท้าทายสูง\n" +
                    "\n" +
                    "- สร้างสรรค์ เห็นความเป็นไปได้ใหม่ๆ\n" +
                    "\n" +
                    "- มองการไกล ให้ความสำคัญกับวิสัยทัศน์ในระยะยาว\n" +
                    "\n" +
                    "นอกจากนี้พวกเขายังเป็นคนที่ใช้เหตุผลในการตัดสินใจและมองสิ่งต่างๆ อย่างเป็นกลาง โดยที่ INTJ จะสามารถมองเห็นข้อผิดพลาดของสิ่งต่างๆ ที่เกิดขึ้นได้อย่างง่ายดายจากการใช้เหตุผลของเขา เมื่อต้องตัดสินใจเขาจะมีความ\n" +
                    "\n" +
                    "- ชัดเจนและแม่นยำในสิ่งที่ตัดสินใจ\n" +
                    "\n" +
                    "- มีเหตุมีผล มองสิ่งต่างๆ อย่างเป็นกลาง\n" +
                    "\n")
        Text(text ="จุดแข็งของ INTJ\n",fontSize = 16.sp , fontWeight = FontWeight.Bold )

        Text(fontSize = 12.sp,text = "- สามารถทำสิ่งที่เป็นทฤษฎี นามธรรม ความเป็นไปได้ และความเชื่อมโยง\n" +
                "\n" +
                "- การวางแผน และวิสัยทัศน์ในระยะยาว\n" +
                "\n" +
                "- มีประสิทธิภาพ มาตรฐานสูง\n" +
                "\n" +
                "จุดอ่อนของ INTJ\n" +
                "- การปฏิสัมพันธ์ สื่อสารความรู้สึก และการสื่อสารกับคนที่อยู่รอบๆ\n" +
                "\n" +
                "- อาจใช้เวลาคิดและวางแผนสิ่งต่างๆ เกินความจำเป็น\n" +
                "\n" +
                "- บางครั้งอาจยึดติดกับความสมบูรณ์ หรืออุดมคติมากเกินไป\n" +
                "\n" +
                "\n" +
                "INTJ ในที่ทำงาน\n" +
                "- INTJ เป็นนักคิด นักวางแผน นักแก้ปัญหาที่ดีในที่ทำงาน พวกเขาสามารถเข้าใจเป้าหมายและวางแผนที่จะทำให้เป้าหมายเหล่านั้นเป็นความจริงได้ ในขณะเดียวกันก็สามารถค้นหาความเป็นไปได้ใหม่ๆ ที่ไม่ถูกจำกัดอยู่เพียงแต่ในกรอบ\n" +
                "\n" +
                "- INTJ จะรู้สึกกดดันเมื่อเผชิญการเปลี่ยนแผนหรือเป้าหมายที่กระทันหันอย่างต่อเนื่อง \n" +
                "\n" +
                "- รายละเอียดปลีกย่อยที่ถามโถมเข้ามาจำนวนมากจะทำให้ INTJ รู้สึกเครียดและหมดไฟได้\n" +
                "\n" +
                "- การเป็นผู้นำเป็นสิ่งที่ INTJ ไม่ชอบ แต่เมื่อต้องเป็นผู้นำ INTJ มักจะเป็นผู้นำที่เปิดกว้าง เขามักจะมีวิสัยทัศน์ และอนุญาตให้คนอื่นในทีมได้แสดงศักยภาพออกมาอย่างเต็มที่ในแบบของตัวเอง\n" +
                "\n" +
                "\n" +
                "วิธีการปฏิสัมพันธ์และดูแลคนที่มีบุคลิกภาพ INTJ\n" +
                "คนที่มีบุคลิกภาพแบบ INTJ มักชอบใช้เวลาอยู่เพียงลำพัง และเป็นบุคลิกภาพที่ใช้เวลาอยู่โดยลำพังมากที่สุดในบรรดาทุก type ทำให้การเข้าหา INTJ จึงเป็นสิ่งที่ค่อนข้างยาก นอกจากนี้ INTJ อาจหลีกเลี่ยงการปฏิสัมพันธ์กับคนอื่นหากเขามองไปยังภาพรวมของความสัมพันธ์เหล่านั้นในอนาคตแล้วพบว่ามันไม่เวิร์ค สามารถดูแล INTJ ได้โดย\n" +
                "\n" +
                "- ให้เวลา INTJ ในการตัดสินใจ คิดสร้างสรรค์สิ่งใหม่ๆ ก่อนที่จะมีการปรึกษาพูดคุย\n" +
                "\n" +
                "- เข้าใจว่า INTJ ให้ความสำคัญกับเป้าหมาย ทิศทาง และภาพรวมมาก \n" +
                "\n" +
                "- อนุญาตให้ INTJ สามารถใช้เวลาอยู่เพียงลำพังได้เมื่อเขาต้องการ\n")


        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                if (routeFrom == Screen.Result.route) {
                    navController.navigate(Screen.Home.route) // กลับไปยังหน้า Home ถ้าเป็นการเรียกจากหน้า Result
                } else {
                    navController.popBackStack() // ให้ pop stack ถ้าไม่ได้เรียกจากหน้า Result
                }
            },
        ) {
            Text(
                text = "Back",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ISTP(navController: NavController) {
    val context = LocalContext.current
    val backStackEntry = navController.previousBackStackEntry
    val routeFrom = backStackEntry?.destination?.route
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "TSTP TYPE",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            painter = painterResource(id= R.drawable.istp),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            text = "ผู้มีความสามารถโดดเด่น (Virtuoso) (ISTP)",
            fontSize = 18.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = "ผู้มีความสามารถโดดเด่น (Virtuoso) (ISTP) ชอบสำรวจด้วยตาและด้วยมือของพวกเขา" +
                    " พวกเขาชอบสัมผัสและสำรวจโลกรอบตัวเพื่อดูความสัมพันธ์กันของสิ่งต่าง ๆ " +
                    "อย่างชาญฉลาดและมีความอยากรู้อยากเห็นอย่างกระตือรือร้น คนที่มีบุคลิกภาพประเภทนี้เป็น \"ผู้สร้าง\" " +
                    "โดยธรรมชาติ พวกเขาจะย้ายจากโครงการหนึ่งไปต่อยังอีกโครงการ " +
                    "สร้างทั้งสิ่งที่มีประโยชน์และสิ่งที่มากเกินความต้องการเพื่อความสนุกสนาน" +
                    " ไปพร้อมกับเรียนรู้จากสภาพแวดล้อมรอบตัวขณะทำสิ่งต่าง ๆ " +
                    "บ่อยครั้งที่เราจะเห็นบุคลิกแบบผู้มีความสามารถโดดเด่นเป็นช่างเครื่องและวิศวกร" +
                    " ผู้มีความสามารถโดดเด่นจะพบความสุขไปกับการได้มือเปื้อนเพราะลงมือแยกชิ้นส่วนต่าง ๆ " +
                    "แล้วประกอบกลับเข้าไปใหม่เพื่อให้สิ่งนั้นดีขึ้นกว่าเดิม แม้จะเพียงเล็กน้อยก็ตาม",
            fontSize = 12.sp ,

            )
        Image(
            painter = painterResource(id= R.drawable.istp_type),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(400.dp)
        )

        Text(
            text = "บุคลิกภาพและลักษณะเฉพาะตัวของ ISTP\n" +
                    "ISTP ชอบสังเกตสิ่งที่เกิดขึ้นรอบตัวในปัจจุบัน และนำสิ่งเหล่านั้นมาวิเคราะห์ ประมวลผล พวกเขาเป็นนักแก้ปัญหาที่ใช้ข้อมูลที่ได้รับมาทุกอย่างในการตรวจสอบปัญหา และพร้อมที่จะปรับตัวกับความท้าทายใหม่ๆ ไม่ว่าภายนอกเขาจะแสดงออกว่าเป็นคนแบบใด แต่เขามักจะใช้เวลาส่วนใหญ่ไปกับการ\n" +
                    "\n" +
                    "วิเคราะห์ หาทางแก้ไขปัญหา พัฒนาสิ่งต่างๆ\n" +
                    "\n" +
                    "มองสิ่งต่างๆ ในเชิงตรรกะ\n" +
                    "\n" +
                    "ISTP เป็นคนที่ใช้เวลาอยู่กับปัจจุบัน เขาชอบเรียนรู้จากสิ่งที่จับต้องได้จริงมากกว่าทฤษฎี นามธรรม เขาจะรับมือกับสถานการณ์ที่เปลี่ยนแปลงอยู่เสมอได้ดี นอกจากนี้ ISTP ยังเป็นคนที่\n" +
                    "\n" +
                    "ให้ความสำคัญเกี่ยวกับรายละเอียด ข้อมูล\n" +
                    "\n" +
                    "อยู่กับความเป็นจริง สิ่งที่จับต้องได้\n" +
                    "\n" +
                    "\n" +
                    "จุดแข็งของ ISTP\n" +
                    "การวิเคราะห์เชิงตรรกะ\n" +
                    "\n" +
                    "เป็นนักลงมือทำ เรียนรู้ผ่านการลงมือทำได้ดี \n" +
                    "\n" +
                    "มองโลกตามความเป็นจริง\n" +
                    "\n" +
                    "จุดอ่อนของ ISTP\n" +
                    "เข้าถึงตัวยาก\n" +
                    "\n" +
                    "ไม่ค่อยเข้าใจเรื่องอารมณ์ ความรู้สึก\n" +
                    "\n" +
                    "เหนื่อยและพลังหมดอย่างรวดเร็ว เมื่อต้องพบปะผู้คนจำนวนมาก \n" +
                    "\n" +
                    "\n" +
                    "ISTP ในที่ทำงาน\n" +
                    "ISTP มักเป็นคนที่อยู่อย่างเงียบๆ ในที่ทำงาน เขามักจะชอบคิดวิเคราะห์สิ่งต่างๆ โดยลำพังมากกว่าการปรึกษาพูดคุยกับคนอื่น บ่อยครั้งเขาอาจมองว่าการประชุมและระดมความคิดเห็นเป็นสิ่งที่ไม่จำเป็น ISTP ชอบความท้าทายและลงมือทำสิ่งต่างๆ มากพอๆ กับการใช้เวลาคิด นอกจากนั้นเขายังสามารถรับมือกับความไม่แน่นอน การเปลี่ยนแปลงที่เกิดขึ้นได้เป็นอย่างดีด้วย\n" +
                    "\n" +
                    "ISTP มักจะเพิกเฉยความสำคัญของความสัมพันธ์ในที่ทำงานหรือเมื่อต้องปฏิสัมพันธ์กับผู้คน\n" +
                    "\n" +
                    "ISTP อาจเก็บความคิด ไอเดีย ต่างๆ ไว้คนเดียว หรือไม่รู้วิธีการที่แสดงมันออกมาอย่างเหมาะสม \n" +
                    "\n" +
                    "เมื่อ ISTP ได้เป็นผู้นำ เขามักจะเป็นผู้นำที่ทำให้ลูกน้องดูเป็นตัวอย่าง ให้ความสำคัญของการให้ลูกน้องรู้ระบบ ขั้นตอน แนวทางการทำงาน แล้วชอบให้ลูกน้องมีอิสระในการทำงาน\n" +
                    "\n" +
                    "\n" +
                    "วิธีการปฏิสัมพันธ์และดูแลคนที่มีบุคลิกภาพ ISTP\n" +
                    "ISTP มักจะเป็นคนที่ชอบอยู่คนเดียว บางครั้งพวกเขามักชอบทำในสิ่งที่ไม่ยุ่งเกี่ยวกับผู้คน เขามักจะถูกมองว่าเป็นคนที่เข้าถึงยากและเข้าใจยากด้วยเช่นกัน เราสามารถดูแล ISTP ได้โดย\n" +
                    "\n" +
                    "เคารพความเป็นส่วนตัวของ ISTP\n" +
                    "\n" +
                    "ให้ความสำคัญกับเรื่องส่วนตัวที่เขาพูดออกมาเพราะ ISTP ส่วนใหญ่มักชอบพูดเรื่องส่วนตัวออกมาเพียงครั้งเดียว \n" +
                    "\n" +
                    "ไม่ใช้ความรู้สึกในการบังคับ กระตุ้น ให้ ISTP ทำตามคำขอของคุณ",
            fontSize = 12.sp ,

            )
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                if (routeFrom == Screen.Result.route) {
                    navController.navigate(Screen.Home.route) // กลับไปยังหน้า Home ถ้าเป็นการเรียกจากหน้า Result
                } else {
                    navController.popBackStack() // ให้ pop stack ถ้าไม่ได้เรียกจากหน้า Result
                }
            },
        ) {
            Text(
                text = "Back",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ISTJ(navController: NavController) {
    val context = LocalContext.current
    val backStackEntry = navController.previousBackStackEntry
    val routeFrom = backStackEntry?.destination?.route
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "TSTJ TYPE",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            painter = painterResource(id= R.drawable.istj),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            text = "นักคำนวณ (Logistician) (ISTJ)",
            fontSize = 18.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = "นักคำนวณ (Logistician) (ISTJ) ภูมิใจในความซื่อสัตย์ของตน" +
                    " คนที่มีบุคลิกภาพประเภทนี้จริงใจและคิดอย่างที่พูด และเมื่อพวกเขามุ่งมั่นที่จะทำอะไรสักอย่าง " +
                    "พวกเขาจะมุ่งทำให้มันสำเร็จ\n" +
                    "\n" +
                    "บุคลิกภาพประเภทนี้มีจำนวนค่อนข้างมาก และแม้ว่านักคำนวณอาจไม่ทำตัวโดดเด่นหรือเรียกร้องความสนใจเป็นพิเศษ " +
                    "แต่พวกเขาก็ทำมากกว่าที่สังคมคาดหมายเพื่อดูแลให้สังคมอยู่บนรากฐานที่มั่นคงและมีเสถียรภาพ " +
                    "ในครอบครัวและชุมชนของพวกเขา นักคำนวณมักจะได้รับความเคารพในความน่าเชื่อถือ การลงมือปฏิบัติจริง" +
                    " และความสามารถในการยึดหลักเหตุผลและตรรกะ แม้ในสถานการณ์ที่ตึงเครียดที่สุดก็ตาม",
            fontSize = 12.sp ,

            )
        Image(
            painter = painterResource(id= R.drawable.istj_type),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(400.dp)
        )

        Text(
            text = "บุคลิกภาพและลักษณะเฉพาะตัวของ ISTJ\n" +
                    "ISTJ เป็นบุคลิกภาพที่ให้ความสำคัญ เกี่ยวกับความรับผิดชอบ หน้าที่ ที่มีต่องาน ครอบครัวและความสัมพันธ์ พวกเขาเป็นคนที่มองโลกตามความเป็นจริงและใช้เหตุผลในการตัดสินใจ นอกจากนี้พวกเขายังให้ความสำคัญกับสิ่งที่ผ่านมา สิ่งที่พวกเขาเคยเผชิญ และเรียนรู้จากสิ่งเหล่านั้น \n" +
                    "\n" +
                    "มองโลกตามความเป็นจริง ให้ความสำคัญกับรายละเอียด \n" +
                    "\n" +
                    "ให้ความสำคัญกับปัจจุบัน เรียนรู้จากประสบการณ์\n" +
                    "\n" +
                    "นอกจากนี้พวกเขายังเป็นคนที่ใช้เหตุผลในการตัดสินใจและมองสิ่งต่างๆ อย่างเป็นกลาง โดยที่ ISTJ จะสามารถมองเห็นข้อผิดพลาดของสิ่งต่างๆ ที่เกิดขึ้นได้อย่างง่ายดายจากการใช้เหตุผลของเขา เมื่อต้องตัดสินใจเขาจะมีความ\n" +
                    "\n" +
                    "ชัดเจนและแม่นยำในสิ่งที่ตัดสินใจ\n" +
                    "\n" +
                    "มีเหตุมีผล มองสิ่งต่างๆ อย่างเป็นกลาง\n" +
                    "\n" +
                    "\n" +
                    "จุดแข็งของ ISTJ\n" +
                    "ความสามารถในการจดจ่อกับรายละเอียด\n" +
                    "\n" +
                    "การวางแผน และวิสัยทัศน์ในระยะยาว\n" +
                    "\n" +
                    "มีประสิทธิภาพ มาตรฐานสูง\n" +
                    "\n" +
                    "จุดอ่อนของ ISTJ\n" +
                    "บางครั้งอาจมองสิ่งต่างๆ ที่เกิดขึ้นจากมุมมองของตัวเองมากเกินไป\n" +
                    "\n" +
                    "ไม่ค่อยเปลี่ยนแปลงหลังจากที่ได้ตัดสินใจหรือพอใจในประสบการณ์อะไรแล้ว\n" +
                    "\n" +
                    "ปฏิสัมพันธ์ด้วยยาก\n" +
                    "\n" +
                    "\n" +
                    "ISTJ ในที่ทำงาน\n" +
                    "ISTJ เป็นคนที่พึ่งพาได้ในที่ทำงาน พวกเขาเป็นคนที่มีความรับผิดชอบสูง มองโลกตามความเป็นจริง และมีเหตุมีผล เขาเป็นคนที่ทุ่มเทให้กับงานมาก ในเวลาทำงานเขาทำงานอย่างเต็มที่ และในเวลาที่พักผ่อนเขาก็ต้องพักผ่อนอย่างเต็มที่เช่นกัน \n" +
                    "\n" +
                    "ISTJ มีบุคลิกภาพที่สงบ นิ่งอยู่เสมอ ซึ่งอาจทำให้คนอื่นมองว่าเขาเป็นคนที่สนใจแต่การทำงาน และไม่ชอบมีปฏิสัมพันธ์กับผู้คน\n" +
                    "\n" +
                    "การเห็นความเชื่อมโยงของสิ่งต่างๆ เป็นสิ่งที่ยากสำหรับ ISTJ โดยเฉพาะหากสิ่งเหล่านั้นเป็นส่งที่ไม่สามารถจับต้องได้ เป็นนามธรรม  \n" +
                    "\n" +
                    "ISTJ สามารถเป็นพนักงานที่มีคุณภาพได้ในทุกระดับตั้งแต่ระดับปฏิบัติการ ผู้จัดการ หัวหน้าฝ่าย หรือผู้นำในองค์กร เมื่อพวกเขาได้รับคำแนะนำหรือแนวปฏิบัติที่ดีในการเป็นในตำแหน่งนั้นๆ \n" +
                    "\n" +
                    "\n" +
                    "เมื่อเป็นผู้นำ ISTJ จะเป็นผู้นำที่สามารถดูแลประสิทธิภาพของงานได้ดี และในขณะเดียวกันก็ยังสร้างความเคารพในองค์กรได้อย่างเหมาะสม\n" +
                    "\n" +
                    "\n" +
                    "วิธีการปฏิสัมพันธ์และดูแลคนที่มีบุคลิกภาพ ISTJ\n" +
                    "คนที่มีบุคลิกภาพแบบ ISTJ เป็นคนที่มองโลกตามความเป็นจริง ให้ความสำคัญกับองค์ความรู้ในเชิงปฏิบัติมากเป็นลำดับต้นๆ ในบรรดา type ต่างๆ เขามักจะเป็นคนที่เงียบ สงบ แต่เต็มไปด้วยความตั้งใจ \n" +
                    "\n" +
                    "คุณสามารถช่วย ISTJ ได้ด้วยการให้รายละเอียด ข้อมูล หลักฐานสนับสนุน เพื่อช่วยให้ ISTJ ลงมือปฏิบัติ และตัดสินใจได้อย่างมีประสิทธิภาพมากที่สุด\n" +
                    "\n" +
                    "ISTJ ชอบวิธีการทำงานที่เป็นระบบ เช่น ตารางเวลา ขั้นตอนการทำสิ่งต่างๆ จัดลำดับความสำคัญและความเร่งด่วนของงาน \n" +
                    "\n" +
                    "เข้าใจว่าการให้ ISTJ ระดมความคิดใหม่ๆ ในทันทีไม่ใช่สิ่งที่พวกเขาถนัด หากมีการประชุม คุณควรให้ ISTJ ได้ใช้เวลาคิด ก่อนที่จะมีการพูดคุย ถกเถียงหรือนำเสนองาน",
            fontSize = 12.sp ,

            )
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                if (routeFrom == Screen.Result.route) {
                    navController.navigate(Screen.Home.route) // กลับไปยังหน้า Home ถ้าเป็นการเรียกจากหน้า Result
                } else {
                    navController.popBackStack() // ให้ pop stack ถ้าไม่ได้เรียกจากหน้า Result
                }
            },
        ) {
            Text(
                text = "Back",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ISFP(navController: NavController) {
    val context = LocalContext.current
    val backStackEntry = navController.previousBackStackEntry
    val routeFrom = backStackEntry?.destination?.route
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ISFP TYPE",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            painter = painterResource(id= R.drawable.isfp),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            text = "นักผจญภัย (Adventurer) (ISFP)",
            fontSize = 18.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = "นักผจญภัย (Adventurer) (ISFP) เป็นศิลปินอย่างแท้จริงแม้ว่าจะไม่ได้เป็นไปตามความหมายอย่างที่" +
                    "เราเข้าใจกันทั่วไปก็ตาม สำหรับบุคลิกภาพประเภทนี้ ชีวิตคือผืนผ้าใบเพื่อให้ได้แสดงออก" +
                    " ตั้งแต่เสื้อผ้าหน้าผมที่พวกเขาสวมใส่ไปจนถึงการใช้เวลาว่าง นักผจญภัยแสดงออกในรูปแบบที่สะท้อน" +
                    "ให้เห็นอย่างชัดเจนว่าพวกเขาเป็นใครในฐานะบุคคลที่มีเอกลักษณ์เฉพาะตัว\n" +
                    "\n" +
                    "นักผจญภัยทุกคนมีเอกลักษณ์เฉพาะตัวอย่างแน่นอน พวกเขาอยากรู้อยากเห็นและกระตือรือร้นที่จะลองสิ่งใหม่ ๆ" +
                    " คนที่มีบุคลิกประเภทนี้มักมีความรักความหลงใหลและความสนใจที่น่าตื่นเต้นมากมาย " +
                    "ด้วยจิตวิญญาณแห่งการสำรวจและความสามารถในการค้นหาความสุขในชีวิตประจำวัน" +
                    " นักผจญภัยอาจเป็นหนึ่งในคนที่น่าสนใจที่สุดที่คุณเคยพบก็เป็นได้ สิ่งที่ย้อนแย้งเพียงสิ่งเดียวคือ" +
                    " นักผจญภัยมักถ่อมตัวและอ่อนน้อมถ่อมตนและมองตัวเองว่า “แค่ทำสิ่งที่ตัวเองชอบ” " +
                    "ดังนั้นพวกเขาอาจไม่รู้ด้วยซ้ำว่าตัวเองโดดเด่นแค่ไหน",
            fontSize = 12.sp ,

            )
        Image(
            painter = painterResource(id= R.drawable.isfp_type),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(400.dp)
        )

        Text(
            text = "บุคลิกภาพและลักษณะเฉพาะตัวของ ISFP\n" +
                    "ISFP เป็นคนที่อาศัยอยู่ในปัจจุบันด้วยความร่าเริงและเบิกบาน เขามักจะชอบอิสระและทำอะไรตามอำเภอใจตนเอง ISFP ให้ความสำคัญเกี่ยวกับเรื่องความสัมพันธ์ ความสนิทสนมกับคนอื่นค่อนข้างมาก แต่เขามักจะใช้เวลาในการพัฒนาความสนิทสนมขึ้นอย่างช้าๆ และมักจะเอาใจใส่คนใกล้ชิด คนสำคัญอย่างพิเศษในวิธีของตัวเอง\n" +
                    "\n" +
                    "อ่อนไหวต่อความรู้สึก \n" +
                    "\n" +
                    "เห็นอกเห็นใจคนอื่น ดูน่าไว้วางใจและเป็นมิตร\n" +
                    "\n" +
                    "ISFP เป็นคนที่ให้ความใส่ใจในรายละเอียดกับที่เกิดขึ้นรอบตัว เขามักจะชอบสิ่งที่เป็นไปได้จริง และเรียนรู้ผ่านการลงมือทำมากกว่าการจินตนาการถึงแนวคิดที่ช่างฝัน และดูจับต้องไม่ได้ในทางปฏิบัติ\n" +
                    "\n" +
                    "เห็นรายละเอียดต่างๆ ได้อย่างยอดเยี่ยม\n" +
                    "\n" +
                    "มองโลกตามความเป็นจริง  \n" +
                    "\n" +
                    "\n" +
                    "จุดแข็งของ ISFP\n" +
                    "ซื่อสัตย์ต่อคุณค่า คุณธรรมที่ตนเองให้ความสำคัญ\n" +
                    "\n" +
                    "เป็นมิตร ผู้คนรู้สึกสบายใจเมื่ออยู่ด้วย\n" +
                    "\n" +
                    "เป็นนักลงมือทำ ลงมือปฏิบัติสิ่งต่างๆ ได้ดี\n" +
                    "\n" +
                    "จุดอ่อนของ ISFP\n" +
                    "การคิดเรื่องนามธรรม ทฤษฎี\n" +
                    "\n" +
                    "ไม่สบายใจเมื่ออยู่ท่ามกลางความขัดแย้ง\n" +
                    "\n" +
                    "ต้องการพื้นที่ส่วนตัว \n" +
                    "\n" +
                    "\n" +
                    "ISFP ในที่ทำงาน\n" +
                    "ISFP เป็นคนที่ชอบลงมือทำสิ่งต่างๆ มากกว่าการคิด ระดมไอเดีย หรือวางแฟนในระยะยาว โดยที่สิ่งที่โดดเด่นของ ISFP คือการเข้าใจและช่วยเหลือคนอื่น เมื่อในที่ทำงานมีปัญหาเกี่ยวกับความสัมพันธ์ ISFP จะช่วยเหลือและทำให้เกิดบรรยากาศแห่งความเข้าใจกันได้โดยง่าย\n" +
                    "\n" +
                    "การทำงานที่เป็นนามธรรมมากเกินไปจะทำให้ ISFP เหนื่อยล้าและหมดไฟได้ง่าย\n" +
                    "\n" +
                    "ISFP ไม่ชอบที่ทำงานที่มีความขัดแย้ง การโต้เถียง หรือมีท่าทีไม่เป็นมิตร\n" +
                    "\n" +
                    "เมื่อ ISFP ได้เป็นผู้นำ เขามักจะเป็นผู้นำที่สุขุม นุ่มนวล และเน้นการลงมือทำให้เห็นเป็นตัวอย่าง และให้การสนับสนุนลูกน้อง\n" +
                    "\n" +
                    "\n" +
                    "วิธีการปฏิสัมพันธ์และดูแลคนที่มีบุคลิกภาพ ISFP\n" +
                    "ISFP มักจะเป็นคนที่สุภาพ และดูกลมกลืนไปกับผู้คน เขาเป็นคนที่เข้ากับคนอื่นได้ง่าย สบายๆ เป็นกันเอง แต่ลึกๆ แล้วเขาเป็นคนที่ค่อนข้างอ่อนไหวกับความรู้สึก และไม่ค่อยชอบเป็นจุดสนใจของคนหมู่มาก เราสามารถดูแล ISFP ได้โดย\n" +
                    "\n" +
                    "เข้าใจว่า ISFP ชอบที่จะใช้เวลาอยู่คนเดียว ไม่ควรบังคับให้เขาออกไปทำสิ่งต่างๆ ในที่สาธารณะหากเขาไม่ต้องการ\n" +
                    "\n" +
                    "ให้รายละเอียด ISFP มากเท่าที่จำเป็น และชัดเจนมากเท่าที่จะเป็นไปได้ นอกจากนั้นการเล่าประสบการณ์ส่วนตัวที่มีความเชื่อมโยงกับสิ่งที่พูดสามารถช่วยให้ ISFP เห็นภาพและเข้าใจสิ่งต่างๆ ได้ง่ายขึ้น\n" +
                    "\n" +
                    "ให้เวลาเขาในการตัดสินใจ",
            fontSize = 12.sp ,

            )
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                if (routeFrom == Screen.Result.route) {
                    navController.navigate(Screen.Home.route) // กลับไปยังหน้า Home ถ้าเป็นการเรียกจากหน้า Result
                } else {
                    navController.popBackStack() // ให้ pop stack ถ้าไม่ได้เรียกจากหน้า Result
                }
            },
        ) {
            Text(
                text = "Back",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ISFJ(navController: NavController) {
    val context = LocalContext.current
    val backStackEntry = navController.previousBackStackEntry
    val routeFrom = backStackEntry?.destination?.route
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "TSFJ TYPE",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            painter = painterResource(id= R.drawable.isfj),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            text = "ผู้พิทักษ์หรือ Defender (ISFJ)",
            fontSize = 18.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = "ผู้พิทักษ์หรือ Defender (ISFJ) ช่วยทำให้โลกหมุนไปด้วยความถ่อมตัว การไม่พูดเกินจริง การทำงานหนัก " +
                    "และการทุ่มเทตนเอง คนที่มีบุคลิกภาพประเภทนี้จะรู้สึกรับผิดชอบต่อคนรอบข้างอย่างลึกซึ้ง" +
                    " ผู้พิทักษ์มีความรับผิดชอบต่อกรอบเวลา จดจำวันเกิดและโอกาสพิเศษ ยึดปฏิบัติตามธรรมเนียมประเพณี" +
                    " แสดงท่าทางห่วงใยและสนับสนุนคนที่ตนรัก แต่พวกเขาไม่ค่อยเรียกร้องการยอมรับในทุกสิ่งที่พวกเขาทำ " +
                    "และเลือกที่จะทำงานเบื้องหลังแทน\n" +
                    "\n" +
                    "นี่เป็นบุคลิกภาพประเภทที่มีความสามารถและทำได้หลายอย่าง พวกเขามาพร้อมพรสวรรค์มากมาย " +
                    "แม้ว่าจะมีความละเอียดอ่อนและเอาใจใส่ แต่ผู้พิทักษ์ก็มีความสามารถในการวิเคราะห์ที่ยอดเยี่ยมและใส่ใจในรายละเอียด" +
                    " และถึงแม้จะเป็นคนที่ค่อนข้างสงวนท่าที แต่พวกเขาก็มักจะมีทักษะเกี่ยวกับคนที่พัฒนามาอย่างดีและ" +
                    "มีความสัมพันธ์ทางสังคมที่แข็งแกร่ง ผู้พิทักษ์เป็นมากกว่าการผสานรวมส่วนต่าง ๆ ไว้ด้วยกัน" +
                    " และความแข็งแกร่งที่มีหลากหลายของพวกเขาก็เปล่งประกายแม้ในแง่มุมที่ธรรมดาที่สุดในชีวิตประจำวันของพวกเขา",
            fontSize = 12.sp ,

            )
        Image(
            painter = painterResource(id= R.drawable.isfj_type),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(400.dp)
        )

        Text(
            text = "บุคลิกภาพและลักษณะเฉพาะตัวของ ISFJ\n" +
                    "ISFJ เป็นบุคลิกภาพที่ดูพึ่งพาได้ มักจะให้ความสำคัญกับเพื่อนและกลุ่มที่พวกเขาอยู่ด้วย เขามักจะมีท่าทีใจดีและให้ความสำคัญกับครอบครัวเป็นลำดับต้นๆ นอกจากนี้เขายังเป็นคนที่ให้ความสำคัญกับข้อเท็จจริง พวกเขามีความทรงจำที่ยอดเยี่ยมในเรื่องที่เกี่ยวข้องกับผู้คนเช่น น้ำเสียง สีหน้า การแสดงออก\n" +
                    "\n" +
                    "มองโลกตามความเป็นจริง ให้ความสำคัญกับรายละเอียด \n" +
                    "\n" +
                    "อยู่กับปัจจุบัน เรียนรู้จากประสบการณ์\n" +
                    "\n" +
                    "นอกจากนี้พวกเขายังเป็นคนที่ให้ความสำคัญเกี่ยวกับผู้คน โดยอาจแสดงออกผ่านทางคุณค่าของสังคม วัฒนธรรม หรือการเห็นพ้องต้องกัน เมื่อต้องตัดสินใจเขามักจะ\n" +
                    "\n" +
                    "ตัดสินใจโดยคำนึงถึงผลกระทบที่มีต่อคนอื่นๆ\n" +
                    "\n" +
                    "มองหาทางออกที่สร้างความสมานฉันท์ ปรองดอง และไม่สร้างความขัดแย้ง\n" +
                    "\n" +
                    "\n" +
                    "จุดแข็งของ ISFJ\n" +
                    "มีความสามารถในการจดจ่อกับรายละเอียด\n" +
                    "\n" +
                    "มีท่าทีที่เป็นมิตร เข้าใจผู้อื่น \n" +
                    "\n" +
                    "มองโลกตามความเป็นจริง ทำสิ่งต่างๆ ในเชิงปฏิบัติได้\n" +
                    "\n" +
                    "จุดอ่อนของ ISFJ\n" +
                    "บางครั้งอาจเก็บกด เพิกเฉยต่อความรู้สึก และความต้องการของตัวเอง\n" +
                    "\n" +
                    "ชอบหลีกเลี่ยงการเผชิญหน้า\n" +
                    "\n" +
                    "ไม่ชอบทฤษฎี สิ่งที่เป็นนามธรรม\n" +
                    "\n" +
                    "ISFJ ในที่ทำงาน\n" +
                    "ISFJ เป็นคนที่ชอบทำงานคนเดียวอย่างเงียบๆ พวกเขามักจะดูเนิบช้าและทำงานต่างๆ ตรงตามวิธีกระบวนการอย่างรัดกุม ซึ่งทำให้พวกเขาทำงานที่มีรายละเอียดได้ดีมาก นอกจากนั้นยังชอบช่วยเหลือและดูแลความสัมพันธ์ของเพื่อนๆ ในที่ทำงานอีกด้วย\n" +
                    "\n" +
                    "ISFJ เป็นคนที่เป็นมิตรและน่าไว้วางใจ เขามักจะชอบช่วยเหลือเพื่อนร่วมงานหากพวกเขาตกอยู่ในสถานการณ์ที่ลำบากหรือมีปัญหาเรื่องความสัมพันธ์ในที่ทำงาน ตรงจุดนี้เองที่ทำให้เพื่อนร่วมงานหลายคนที่มีเรื่องไม่สบายใจ เข้ามาพูดคุยปรึกษา ISFJ เป็นคนแรกๆ \n" +
                    "\n" +
                    "เมื่อคนที่มีบุคลิกภาพแบบ ISFJ ได้รับมอบหมายงานแล้ว เขาจะลงมือทำด้วยความตั้งใจ และอาจเป็นคนที่มีมาตรฐานสูงกับตัวเองและคนอื่นได้ เขาเป็นคนที่มีความอดทนสูงมากในการทำงานที่มีรายละเอียด และต้องอาศัยเวลาในการทำงาน\n" +
                    "\n" +
                    "ด้วยบุคลิกของ ISFJ เมื่อเป็นผู้นำ เขาจะเป็นผู้นำที่มีลักษณะของความเป็นพ่อแม่ที่พึ่งพาได้ในทีม เพราะ ISFJ ชอบดูแลลูกน้องในมิติต่างๆ ที่มากกว่าเรื่องงานเช่น การใช้ชีวิต ความสัมพันธ์ หรือสภาพจิตใจของลูกน้อง เขาพร้อมที่จะปกป้องลูกน้องจากคำตำหนิของคนอื่น และเป็นกำลังใจให้ลูกน้องในการทำงาน \n" +
                    "\n" +
                    "\n" +
                    "วิธีการปฏิสัมพันธ์และดูแลคนที่มีบุคลิกภาพ ISFJ\n" +
                    "คนที่มีบุคลิกภาพแบบ ISFJ เป็นคนที่ค่อนข้างเงียบ ทำตัวไม่โดดเด่น และชอบช่วยเหลือคนอื่น โดยมากพวกเขามักชอบพูดช้าๆ และนุ่มนวลด้วยภาษาที่ตรงไปตรงมาตามความคุ้นเคยของพวกเขา และยังเป็นคนที่เคารพกฎกติกาเป็นอย่างมาก\n" +
                    "\n" +
                    "เมื่อต้องพูดคุยกับ ISFJ คุณสามารถเพิ่มความสุภาพ และพูดให้ช้าลง โดยหลีกเลี่ยงท่าทีที่รีบร้อน และการใช้เสียงดังกับ ISFJ\n" +
                    "\n" +
                    "เข้าใจว่า ISFJ จำเป็นต้องใช้เวลาในการเรียบเรียง และสื่อสารสิ่งต่างๆ ออกมา โดยเฉพาะอย่างยิ่งหากเป็นแนวความคิดใหม่ๆ คุณควรให้เวลากับ ISFJ ในการค่อยๆ คิดและพูดสิ่งเหล่านั้นออกมา \n" +
                    "\n" +
                    "คุณควรให้รายละเอียดกับ ISFJ เพื่อให้เขาได้ทำความเข้าใจ นอกจากนี้คุณสามารถบอกสิ่งที่คุณคาดหวังและจุดประสงค์ในการทำสิ่งต่างๆ ได้",
            fontSize = 12.sp ,

            )
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                if (routeFrom == Screen.Result.route) {
                    navController.navigate(Screen.Home.route) // กลับไปยังหน้า Home ถ้าเป็นการเรียกจากหน้า Result
                } else {
                    navController.popBackStack() // ให้ pop stack ถ้าไม่ได้เรียกจากหน้า Result
                }
            },
        ) {
            Text(
                text = "Back",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun INTP(navController: NavController) {
    val context = LocalContext.current
    val backStackEntry = navController.previousBackStackEntry
    val routeFrom = backStackEntry?.destination?.route
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "TNTP TYPE",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            painter = painterResource(id= R.drawable.intp),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            text = "นักตรรกะ (Logician) (INTP)",
            fontSize = 18.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = "นักตรรกะ (Logician) (INTP) ภูมิใจในมุมมองที่เป็นเอกลักษณ์และสติปัญญาที่แข็งแกร่งของตน " +
                    "พวกเขาอดไม่ได้ที่จะไขปริศนาความลึกลับของจักรวาล ซึ่งอาจอธิบายได้ว่าทำไมนักปรัชญาและนักวิทยาศาสตร์" +
                    "ที่มีอิทธิพลมากที่สุดตลอดกาลบางคนจึงเป็นนักตรรกะ ด้วยความคิดสร้างสรรค์และความเป็นนักประดิษฐ์ทำให้" +
                    "บุคลิกภาพประเภทนี้ค่อนข้างหายาก และนักตรรกะไม่กลัวที่จะโดดเด่นในฝูงชน",
            fontSize = 12.sp ,

            )
        Image(
            painter = painterResource(id= R.drawable.intp_type),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(400.dp)
        )

        Text(
            text = "บุคลิกภาพและลักษณะเฉพาะตัวของ INTP\n" +
                    "INTP เป็นบุคลิกภาพที่เก่งในด้านของการวิเคราะห์ปัญหา ความคิด หรือสถานการณ์ด้วยการใช้ตรรกะ เขาใช้กระบวนการคิดอย่างเป็นระบบในการหาคำตอบสิ่งต่างๆ เขามักจะมีคำถามกับสิ่งต่างๆ จากมุมมองของตัวเอง ระบบตรรกะของตัวเอง  \n" +
                    "\n" +
                    "ใช้การวิเคราะห์ การคิดเชิงเหตุผล \n" +
                    "\n" +
                    "มองสิ่งต่างๆ อย่างเป็นกลาง\n" +
                    "\n" +
                    "INTP ยังเห็นความเป็นไปได้ใหม่ๆ มองสิ่งต่างๆ เป็นทฤษฎี ภาพรวม และมองหาหลักการที่อยู่เบื้องหลังของสิ่งที่ปรากฏออกมา เขามักใช้ตรรกะ สิ่งที่เคยเห็น และทฤษฎีต่างๆ หลอมรวมขึ้นมาเพื่อหาความเป็นไปได้ใหม่ๆ ที่ดีกว่าเดิม\n" +
                    "\n" +
                    "ให้ความสนใจกับแนวความคิด ทฤษฎี หลักการที่ทำให้สิ่งต่างๆ มีประสิทธิภาพ\n" +
                    "\n" +
                    "มีความคิดสร้างสรรค์ และมองเห็นความเป็นไปได้ใหม่ๆ\n" +
                    "\n" +
                    "\n" +
                    "จุดแข็งของ INTP\n" +
                    "การวิเคราะห์ มองสิ่งรอบตัวอย่างเป็นเหตุเป็นผล ด้วยตรรกะ\n" +
                    "\n" +
                    "ความคิดสร้างสรรค์\n" +
                    "\n" +
                    "การมองสิ่งต่างๆ ในเชิงนามธรรม \n" +
                    "\n" +
                    "จุดอ่อนของ INTP\n" +
                    "อาจมีความท้าทายในการเข้าใจหรือแสดงความรู้สึก\n" +
                    "\n" +
                    "มักไม่ชอบทำตามกฎ ระเบียบ\n" +
                    "\n" +
                    "อาจให้ความสำคัญเกี่ยวกับตรรกะมากเกินไปจนเพิกเฉย คุณค่าในเรื่องอื่น\n" +
                    "\n" +
                    "INTP ในที่ทำงาน\n" +
                    "INTP เป็นคนที่ค่อนข้างเก็บตัว และเป็นอิสระ ในที่ทำงานเขามักจะเป็นคนที่มีไอเดียใหม่ๆ อยู่เสมอ   และเขามักจะทำได้ดีเมื่อได้มีโอกาสคิดหรือสร้างสรรค์ผลงานอย่างอิสระ เขามักจะทุ่มเทพลังทั้งหมดไปกับสิ่งที่เขาสนใจ\n" +
                    "\n" +
                    "INTP รู้สึกลำบากใจเมื่อต้องเข้าร่วมงานเลี้ยงสังสรรค์ที่ต้องพบคนที่ไม่รู้จักเป็นจำนวนมาก \n" +
                    "\n" +
                    "พวกเขาอาจมีไอเดียที่ดีมากมาย แต่หลายครั้งที่ INTP ไม่สามารถทำให้ไอเดียเหล่านั้นกลายเป็นสิ่งที่ปฏิบัติได้จริง \n" +
                    "\n" +
                    "เมื่อต้องเป็นผู้นำ INTP จะอนุญาตให้แต่ละคนสามารถทำงานตามแนวทางที่ตัวเองถนัด เพื่อให้สอดคล้องกัวิสัยทัศน์ หรือสิ่งใหม่ๆ ที่ดีกว่า\n" +
                    "\n" +
                    "\n" +
                    "วิธีการปฏิสัมพันธ์และดูแลคนที่มีบุคลิกภาพ INTP\n" +
                    "คนที่มีบุคลิกภาพแบบ INTP มักจะค่อนข้างเก็บตัว พวกเขาเลือกที่จะพูดคุยและมีปฏิสัมพันธ์กับกลุ่มคนที่เขายอมรับซึ่งโดยมากมักจะเกี่ยวข้องกับเรื่องที่เขาสนใจ\n" +
                    "\n" +
                    "ให้เวลา INTP ในการวิเคราะห์ และแก้ไขปัญหาสิ่งต่างๆ\n" +
                    "\n" +
                    "เข้าใจว่า INTP ต้องการใช้เวลาส่วนตัวอยู่เพียงลำพัง  \n" +
                    "\n" +
                    "เข้าใจว่าบางครั้ง INTP อาจไม่รู้วิธีรับมือสถานการณ์ทางสังคม ไม่รู้วิธีการแสดงออกทางอารมณ์อย่างเหมาะสม โดยเฉพาะเมื่อต้องอยู่กับกลุ่มคนที่พวกเขาไม่รู้จัก",
            fontSize = 12.sp ,

            )
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                if (routeFrom == Screen.Result.route) {
                    navController.navigate(Screen.Home.route) // กลับไปยังหน้า Home ถ้าเป็นการเรียกจากหน้า Result
                } else {
                    navController.popBackStack() // ให้ pop stack ถ้าไม่ได้เรียกจากหน้า Result
                }
            },
        ) {
            Text(
                text = "Back",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun INFP(navController: NavController) {
    val context = LocalContext.current
    val backStackEntry = navController.previousBackStackEntry
    val routeFrom = backStackEntry?.destination?.route
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "TNFP TYPE",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            painter = painterResource(id= R.drawable.infp),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            text = "ผู้ไกล่เกลี่ย (Mediator) (INFP)",
            fontSize = 18.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = "แม้ว่าพวกเขาจะดูเงียบขรึมหรือไม่ประจบประแจง ผู้ไกล่เกลี่ย (Mediator) (INFP) มีชีวิตภายในที่สดใส" +
                    " มีความรักความหลงใหล ความคิดสร้างสรรค์ และจินตนาการ พวกเขามีความสุขไปกับฝันกลางวัน " +
                    "ประดิษฐ์เรื่องราวและบทสนทนาทุกประเภท ในใจ บุคลิกภาพเหล่านี้มักมีความอ่อนไหว " +
                    "ผู้ไกล่เกลี่ยสามารถมีการตอบสนองทางอารมณ์อย่างลึกซึ้งต่อดนตรี ศิลปะ ธรรมชาติ และผู้คนรอบข้างได้\n" +
                    "\n" +
                    "ผู้ไกล่เกลี่ยมีอุดมการณ์และเข้าอกเข้าใจ ปรารถนาความสัมพันธ์ที่ลึกซึ้งและเต็มไปด้วยจิตวิญญาณ" +
                    " และพวกเขารู้สึกว่ามีหน้าที่ต้องช่วยเหลือผู้อื่น แต่เนื่องจากมีประชากรจำนวนน้อยที่มีบุคลิกภาพประเภทนี้" +
                    " บางครั้งผู้ไกล่เกลี่ยจึงอาจรู้สึกโดดเดี่ยวหรือไม่มีใครมองเห็นหรือเข้าอกเข้าใจ " +
                    "พวกเขารู้สึกเคว้งคว้างอยู่ในโลกที่ดูเหมือนจะไม่ได้ยกย่องชื่นชมเอกลักษณ์เฉพาะตัวของพวกเขามากนัก",
            fontSize = 12.sp ,

            )
        Image(
            painter = painterResource(id= R.drawable.infp_type),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(400.dp)
        )

        Text(
            text = "บุคลิกภาพและลักษณะเฉพาะตัวของ INFP\n" +
                    "คนที่มีบุคลิกภาพแบบ INFP เป็นคนที่ขับเคลื่อนโดยคุณค่า หรือความรู้สึกภายใน พวกเขาต้องการทำงานและมีส่วนเกี่ยวข้องกับสิ่งที่มีคุณค่าต่อโลก INFP เป็นคนที่เข้าใจสภาวะอารมณ์และจิตใจของคนอื่น คุณค่า และสิ่งต่างๆ ที่เกิดขึ้นกับคนอื่น พวกเขาเป็นคนที่\n" +
                    "\n" +
                    "เร็วต่อความรู้สึก และเข้าใจผู้คน\n" +
                    "\n" +
                    "ซื่อสัตย์ต่อความรู้สึก คุณค่า ของตัวเอง \n" +
                    "\n" +
                    "INFP เป็นคนที่ให้ความสำคัญเกี่ยวกับอุดมคติ อุดมการณ์ พวกเขามักชอบพูดคุยสิ่งที่เป็นไปได้ในอนาคต สิ่งที่จะทำให้ชีวิตของคนอื่นดีขึ้น แม้ว่าเขาจะเข้าใจความรู้สึกของแต่ละคนเป็นอย่างดี แต่เขาก็ชอบมองภาพรวม และมองหาความเป็นไปได้ใหม่ๆ อยู่เสมอ\n" +
                    "\n" +
                    "มองการณ์ไกล มองสิ่งต่างๆ ในภาพรวม\n" +
                    "\n" +
                    "สร้างสรรค์ เปิดรับต่อความเป็นไปได้ใหม่ๆ \n" +
                    "\n" +
                    "\n" +
                    "จุดแข็งของ INFP\n" +
                    "รับรู้และเข้าใจความรู้สึก สภาวะอารมณ์ได้อย่างรวดเร็ว \n" +
                    "\n" +
                    "มีอุดมการณ์ และมุ่งมั่นที่จะเดินตามอุดมการณ์\n" +
                    "\n" +
                    "มีความคิดสร้างสรรค์ มองการณ์ไกล\n" +
                    "\n" +
                    "จุดอ่อนของ INFP\n" +
                    "ยึดติดในอุดมคติ\n" +
                    "\n" +
                    "อ่อนไหวต่อคำวิจารณ์\n" +
                    "\n" +
                    "มักชอบมองข้ามรายละเอียดหรือความมีประสิทธิภาพ\n" +
                    "\n" +
                    "INFP ในที่ทำงาน\n" +
                    "INFP เป็นคนที่ทำงานได้อย่างสร้างสรรค์และยอดเยี่ยมในองค์กรที่ได้ช่วยเหลือผู้คน หรือให้เขาได้ทำในสิ่งที่เขาให้คุณค่าได้ เขาสามารถรับมือกับการเปลี่ยนแปลงอย่างกะทันหันได้อย่างยอดเยี่ยมและทำงานได้ดีในสภาวะที่กดดัน\n" +
                    "\n" +
                    "สภาพอารมณ์และแรงบันดาลใจ ส่งผลต่อการทำงานของ INFP เป็นอย่างมาก  \n" +
                    "\n" +
                    "INFP รู้สึกลำบากใจที่จะต้องอยู่ในสถานการณ์ที่มีความขัดแย้ง มีการเมือง ไม่มีปฏิสัมพันธ์กันอย่างสร้างสรรค์ หรือมีการวิพากษ์วิจารณ์อย่างรุนแรงได้\n" +
                    "\n" +
                    "เมื่อ INFP ได้เป็นผู้นำ เขามักจะเป็นผู้นำที่ให้ความสำคัญกับคุณค่าและความสัมพันธ์ของคนในทีม เขามักจะเป็นคนที่สร้างแรงบันดาลใจให้กับคนอื่นได้มาก และผู้คนมักจะได้ฟังเรื่องราวความอ่อนโยน ความข่มขื่น หรือวิสัยทัศน์ เพื่อมาเป็นแรงบันดาลใจที่ยอดเยี่ยมได้\n" +
                    "\n" +
                    "\n" +
                    "วิธีการปฏิสัมพันธ์และดูแลคนที่มีบุคลิกภาพ INFP\n" +
                    "INFP เป็นคนที่มีบุคลิกภาพที่มีความอ่อนไหวกับความรู้สึกค่อนข้างมาก ซึ่ง INFP หลายคนมักไม่แสดงออกมา พวกเขาเป็นคนที่ระมัดระวังเกี่ยวกับคำพูดและการแสดงออก แม้ว่าเขาจะใส่ใจและชอบช่วยเหลือผู้คนรอบตัว แต่ INFP มักไม่ค่อยจะแสดงตัวตน และคุณค่าที่แท้จริงภายในออกมาให้ผู้อื่นรับรู้ เพราะพวกเขามักจะเปิดเผยสิ่งต่างๆ ให้กับคนบางคนและคนที่พิเศษเท่านั้น\n" +
                    "\n" +
                    "เข้าใจว่า INFP มีความอ่อนไหวมากกับการวิจารณ์ที่เกี่ยวข้องกับตัวตน บุคลิกภาพ หรือเรื่องส่วนตัวของเขา\n" +
                    "\n" +
                    "ให้ความเคารพวิธีการตัดสินใจ การลงมือทำ และพื้นที่ส่วนตัว โดยตระหนักว่าแต่ละคนมีวิธีการเข้าถึงคำตอบและบทสรุปที่แตกต่างกัน\n" +
                    "\n" +
                    "ทำความเข้าใจว่าคุณค่าส่วนตัว ความรู้สึก เป็นสิ่งที่สำคัญมากสำหรับเขา\n" +
                    "\n",
            fontSize = 12.sp ,

            )
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                if (routeFrom == Screen.Result.route) {
                    navController.navigate(Screen.Home.route) // กลับไปยังหน้า Home ถ้าเป็นการเรียกจากหน้า Result
                } else {
                    navController.popBackStack() // ให้ pop stack ถ้าไม่ได้เรียกจากหน้า Result
                }
            },
        ) {
            Text(
                text = "Back",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun INFJ(navController: NavController) {
    val context = LocalContext.current
    val backStackEntry = navController.previousBackStackEntry
    val routeFrom = backStackEntry?.destination?.route
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "TNFJ TYPE",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            painter = painterResource(id= R.drawable.infjnew),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            text = "ผู้สนับสนุน (Advocate ) (INFJ)",
            fontSize = 18.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = "ผู้สนับสนุน (Advocate ) (INFJ) อาจเป็นประเภทบุคลิกภาพที่หายากที่สุด" +
                    " แต่พวกเขาทิ้งร่องรอยไว้ให้เราเห็นอย่างแน่นอน พวกเขามีอุดมการณ์และมีหลักการ" +
                    " ผู้สนับสนุนไม่พอใจที่จะเพียงใช้ชีวิตไปวัน ๆ พวกเขาต้องการยืนหยัดและสร้างความแตกต่างให้เกิดขึ้นกับโลกใบนี้" +
                    " สำหรับบุคลิกแบบผู้สนับสนุนนี้ ความสำเร็จไม่ได้มาจากเงินหรือสถานะ แต่มาจากการแสวงหาการเติมเต็ม" +
                    " การช่วยเหลือผู้อื่น และการเป็นพลังแห่งความดีสู่โลก\n" +
                    "\n" +
                    "แม้ว่าพวกเขาจะมีเป้าหมายและความทะเยอทะยานสูงส่ง แต่ผู้สนับสนุนก็ไม่ควรถูกเข้าใจผิดว่าเป็นพวกเพ้อฝัน" +
                    " คนที่มีบุคลิกภาพแบบนี้จะให้ความสำคัญกับเรื่องความซื่อสัตย์ และพวกเขาจะไม่หยุดจนกว่าจะได้ทำในสิ่งที่รู้ว่าถูกต้อง" +
                    " พวกเขาดำเนินชีวิตด้วยจิตสำนึกที่ชัดเจนในคุณค่าของตนเอง และมีเป้าหมายที่จะไม่ลืมสิ่งที่สำคัญอย่างแท้จริง " +
                    "ไม่ใช่ตามคนอื่นหรือสังคมโดยรวม แต่ตามสติปัญญาและสัญชาตญาณของพวกเขาเอง",
            fontSize = 12.sp ,

            )
        Image(
            painter = painterResource(id= R.drawable.infj_type),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(400.dp)
        )

        Text(
            text = "บุคลิกภาพและลักษณะเฉพาะตัวของ INFJ\n" +
                    "คนที่มีบุคลิกภาพแบบ INFJ มักจะให้ความสำคัญกับวิสัยทัศน์ ความหมาย และความสัมพันธ์ระหว่างสิ่งต่างๆ กับผู้คน พวกเขามักใช้เวลาไปกับการพยายามทำความเข้าใจสิ่งที่มีความซับซ้อนที่อยู่ภายในหรือความหมายในชีวิต และพวกเขาชอบใช้การเปรียบเทียบ สัญลักษณ์ หรือคำศัพท์ที่มีความหมายเฉพาะตัว\n" +
                    "\n" +
                    "สร้างสรรค์ มีวิสัยทัศน์ มีจินตนาการ\n" +
                    "\n" +
                    "ชอบสิ่งที่เป็นนามธรรม ซับซ้อน และเป็นอุดมคติ\n" +
                    "\n" +
                    "นอกจากนี้ INFJ ยังเป็นคนที่ให้ความสำคัญกับคุณค่าของผู้คน สังคม เขามักจะตัดสินใจสิ่งต่างๆ โดยใช้คุณค่าและผลกระทบที่มีต่อผู้คนเป็นหลัก \n" +
                    "\n" +
                    "เข้าใจผู้คน เร็วต่อความรู้สึก \n" +
                    "\n" +
                    "ให้คุณค่ากับความสัมพันธ์ ความต้องการของผู้คน\n" +
                    "\n" +
                    "\n" +
                    "จุดแข็งของ INFJ\n" +
                    "มีความคิดสร้างสรรค์ วิสัยทัศน์\n" +
                    "\n" +
                    "สามารถจัดระบบสิ่งต่างๆ ได้ดี\n" +
                    "\n" +
                    "เป็นผู้ฟังที่ดี มีความเข้าใจความรู้สึกและสิ่งที่ผู้คนต้องการ \n" +
                    "\n" +
                    "\n" +
                    "จุดอ่อนของ INFJ\n" +
                    "อาจจะอ่อนไหวเกินไป\n" +
                    "\n" +
                    "ไม่ได้ใช้เวลาอยู่กับโลกแห่งความเป็นจริง หรือสิ่งที่เกิดขึ้นปัจจุบัน\n" +
                    "\n" +
                    "อาจเพิกเฉยต่อความเป็นจริงหรือรายละเอียด ที่ไม่ตรงกับความคิด ทฤษฎีของตัวเอง\n" +
                    "\n" +
                    "INFJ ในที่ทำงาน\n" +
                    "INFJ ชอบที่ทำงานที่ทำให้เงียบ ทำให้เขาสามารถมีสมาธิ เพื่อทำงานได้อย่างจริงจัง โดยที่เขามักชอบใช้เวลาทั้งวันไปกับการจินตนาการในสิ่งที่เป็นอุดมคติ เขาทำสิ่งต่างๆ อย่างเป็นระบบ และมักชอบที่ทำงานที่ได้ช่วยเหลือผู้คน หรือส่งผลต่อคนหมู่มากไม่ทางใดก็ทางหนึ่ง\n" +
                    "\n" +
                    "INFJ จะรู้สึกแย่หรือเสียใจเมื่อเขาได้รับคำตำหนิในผลงาน เพราะเขาเป็นคนที่ทุ่มเทในผลงานของตัวเอง แต่เมื่อมีประสบการณ์ พวกเขาก็สามารถทำความเข้าใจและเดินหน้าต่อไปได้อย่างรวดเร็ว\n" +
                    "\n" +
                    "เพราะความคาดหวังและจินตนาการที่สูงมากทำให้ INFJ ต้องใช้เวลาในการทำความเข้าใจเมื่อต้องรู้ว่าอุดมคติที่เขาวาดไว้ต่างกับความเป็นจริง\n" +
                    "\n" +
                    "เมื่อได้เป็นผู้นำ INFJ เป็นผู้นำที่ให้แรงบันดาลใจ วิสัยทัศน์กับคนอื่นได้เป็นอย่างดี ซึ่งเขามักจะทุ่มเทให้การเปลี่ยนแปลงและการพัฒนาสิ่งต่างๆ ให้เป็นไปตามวิสัยทัศน์นั้น\n" +
                    "\n" +
                    "\n" +
                    "วิธีการปฏิสัมพันธ์และดูแลคนที่มีบุคลิกภาพ INFJ\n" +
                    "คนที่มีบุคลิกภาพแบบ INFJ มักชอบใช้เวลาอยู่เพียงลำพัง ซึ่งมักจะเป็นคนที่ดูค่อนข้างมีความลึกลับ ซับซ้อน นอกจากนั้นพวกเขายังชอบใช้เวลาในการพูดคุยกับผู้คนแบบตัวต่อตัวมากกว่าการคุยในกลุ่มหรือวงกว้าง เขาเป็นผู้ฟังที่ดีและเข้าใจผู้คน\n" +
                    "\n" +
                    "ให้เวลา INFJ ในการคิดสิ่งต่างๆ และมองสิ่งต่างๆ ในเชิงลึกก่อนที่จะมีการพูดคุย ถกเถียง\n" +
                    "\n" +
                    "พยายามอดทน และทำความเข้าใจว่า INFJ ต้องใช้ระยะเวลานานในการอธิบายสิ่งต่างๆ และบางครั้งก็มักใช้คำศัพท์ที่แปลกหรือซับซ้อน\n" +
                    "\n" +
                    "อนุญาตให้ INFJ สามารถใช้เวลาอยู่เพียงลำพังได้เมื่อเขาต้องการ",
            fontSize = 12.sp ,

            )
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                if (routeFrom == Screen.Result.route) {
                    navController.navigate(Screen.Home.route) // กลับไปยังหน้า Home ถ้าเป็นการเรียกจากหน้า Result
                } else {
                    navController.popBackStack() // ให้ pop stack ถ้าไม่ได้เรียกจากหน้า Result
                }
            },
        ) {
            Text(
                text = "Back",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ESTP(navController: NavController) {
    val context = LocalContext.current
    val backStackEntry = navController.previousBackStackEntry
    val routeFrom = backStackEntry?.destination?.route
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ESTP TYPE",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            painter = painterResource(id= R.drawable.estp),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            text = "ผู้ประกอบการ (Entrepreneur) (ESTP)",
            fontSize = 18.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = "ผู้ประกอบการ (Entrepreneur) (ESTP) มักจะสร้างความแตกต่างให้กับสิ่งที่อยู่รอบตัวพวกเขาเสมอ " +
                    "วิธีที่ดีที่สุดในการมองหาพวกเขาในงานปาร์ตี้คือ การมองหาผู้คนที่เดินไปรอบ ๆ" +
                    " ขณะที่พวกเขาย้ายจากกลุ่มหนึ่งไปอีกกลุ่มหนึ่ง บุคลิกแบบผู้ประกอบการชอบที่จะเป็นศูนย์กลางของความสนใจ" +
                    " หัวเราะและสนุกสนานด้วยอารมณ์ขันที่ตรงไปตรงมาและเปิดเผย หากมีการขอให้ผู้ชมขึ้นมาบนเวที" +
                    " ผู้ประกอบการจะเป็นคนอาสาหรืออาสาส่งเพื่อนขี้อายขึ้นไป\n" +
                    "\n" +
                    "ทฤษฎี แนวคิดเชิงนามธรรม และการพูดคุยอย่างกระตือรือร้นเกี่ยวกับประเด็นระดับโลกและผลกระทบของสิ่งเหล่านี้" +
                    "ไม่ได้ทำให้ผู้ประกอบการสนใจเป็นเวลานานนัก ผู้ประกอบการชอบทำให้การสนทนาเป็นไปอย่างมีพลังและ" +
                    "มีความฉลาดพอสมควร พวกเขาชอบพูดคุยเกี่ยวกับสิ่งที่เป็นอยู่ หรือดีกว่านั้นคือ การได้ออกไปและลงมือทำ " +
                    "ผู้ประกอบการชอบกระโดดก่อนที่จะตรวจตราบริเวณโดยรอบ หรืออีกนัยหนึ่งคือ ชอบเสี่ยงก่อนที่จะพิจารณาให้รอบด้าน" +
                    " พวกเขาแก้ไขข้อผิดพลาดของตนไปพร้อมกับขณะที่ดำเนินการ แทนที่จะนั่งเฉย ๆ " +
                    "เตรียมสำหรับเหตุฉุกเฉินและหลบหนีข้อกำหนดใด ๆ",
            fontSize = 12.sp ,

            )
        Image(
            painter = painterResource(id= R.drawable.estp_type),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(400.dp)
        )

        Text(
            text = "บุคลิกภาพและลักษณะเฉพาะตัวของ ESTP\n" +
                    "คนที่มีบุคลิกภาพแบบ ESTP เป็นคนที่มีพลังงานมาก เขาเป็นนักแก้ไขปัญหา ชอบความสนุกสนาน เขาเป็นคนที่ปรับตัวเข้ากับสภาพแวดล้อม ได้อย่างยอดเยี่ยม รวมทั้งยังสามารถแก้ปัญหาเฉพาะหน้าได้ดีด้วย ESTP มักให้ความสำคัญเกี่ยวกับรายละเอียดเล็กๆ น้อยๆ และเป็นคนที่\n" +
                    "\n" +
                    "สังเกตสิ่งที่เกิดขึ้นรอบตัว มองเห็นรายละเอียดของสิ่งต่างๆ \n" +
                    "\n" +
                    "ใช้ชีวิตอยู่กับปัจจุบัน\n" +
                    "\n" +
                    "นอกจากนั้น ESTP เป็นคนที่ใช้ตรรกะในการตัดสินใจมากกว่าอารมณ์ความรู้สึก เมื่อต้องตัดสินใจเขามักจะเป็นคนที่\n" +
                    "\n" +
                    "วิเคราะห์สถานการณ์ โดยใช้เหตุผล\n" +
                    "\n" +
                    "ใช้ตรรกะ แก้ปัญหาด้วยกระบวนการที่เรียบง่าย\n" +
                    "\n" +
                    "ESTP เป็นคนที่เก่งในเรื่องของการอยู่กับความเป็นจริง เขาชอบสิ่งที่ลงมือปฏิบัติได้จริงมากกว่าไอเดีย ทฤษฎีต่างๆ  แต่เขาก็ให้ความสนใจเหตุผลที่อยู่เบื้องหลังสิ่งเหล่านั้นด้วย \n" +
                    "\n" +
                    "\n" +
                    "จุดแข็งของ ESTP\n" +
                    "มีพลังงานเหลือล้น\n" +
                    "\n" +
                    "มองเห็นรายละเอียดในสิ่งต่างๆ\n" +
                    "\n" +
                    "กระบวนการสังเกตและวิเคราะห์สิ่งที่เกิดขึ้น\n" +
                    "\n" +
                    "จุดอ่อนของ ESTP\n" +
                    "เบื่อง่าย\n" +
                    "\n" +
                    "ไม่ถนัดในการทำสิ่งที่เกี่ยวข้องกับทฤษฎี\n" +
                    "\n" +
                    "อาจไม่ค่อยได้วางแผนก่อนลงมือทำ\n" +
                    "\n" +
                    "\n" +
                    "ESTP ในที่ทำงาน\n" +
                    "ESTP เป็นคนที่ให้ความสำคัญเกี่ยวกับสิ่งรอบข้าง เขามักจะสังเกตสิ่งรอบข้างได้อย่างรวดเร็วไม่ว่าสิ่งเหล่านั้นจะเป็นสิ่งของหรือผู้คน เขามักชอบพูดคุยเรื่องสนุกสนานท่ามกลางเพื่อนฝูง และเก่งในการลงมือทำ นำไอเดียมาใช้ในเชิงปฏิบัติ จดจ่อในรายละเอียด และเป็นนักแก้ปัญหาเฉพาะหน้า\n" +
                    "\n" +
                    "ESTP รู้สึกเครียดหากต้องทำงานที่ต้องยุ่งเกี่ยวกับนามธรรม ทฤษฎี การมองภาพรวม  \n" +
                    "\n" +
                    "ESTP อาจไม่ค่อยถนัดในการมองไปยังอนาคต กำหนดวิสัยทัศน์ วางแผนระยะยาว\n" +
                    "\n" +
                    "เมื่อ ESTP ได้เป็นผู้นำ มักเป็นผู้นำที่เน้นการลงมือทำ ให้ความสำคัญเกี่ยวกับกฎ กติกา และธรรมเนียมปฏิบัติที่เคยมี ซึ่งมักจะเป็นวิธีที่เขาใช้ในการดูแลลูกน้องด้วย \n" +
                    "\n" +
                    "\n" +
                    "วิธีการปฏิสัมพันธ์และดูแลคนที่มีบุคลิกภาพ ESTP\n" +
                    "คนที่มีบุคลิกภาพแบบ ESTP เป็นคนที่ปรับตัวเก่ง พวกเขาชอบเข้าสังคม ออกไปทำกิจกรรมข้างนอก และมีพลังงานเหลือล้น เขาชอบตัดสินใจในเรื่องต่างๆ ทันที และพูดอะไรตรงไปตรงมา ในการมีปฏิสัมพันธ์กับ ESTP เราควร\n" +
                    "\n" +
                    "ตอบโต้ ESTP ในบทสนทนาเพื่อแสดงถึงความใส่ใจ แทนที่จะฟังเงียบๆ\n" +
                    "\n" +
                    "ใช้ภาษาที่ตรงไปตรงมา ไม่อ้อมค้อม\n" +
                    "\n" +
                    "พูดคุยในสิ่งที่เขาเคยผ่านมา มีประสบการณ์ หรือเชี่ยวชาญ",
            fontSize = 12.sp ,

            )
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                if (routeFrom == Screen.Result.route) {
                    navController.navigate(Screen.Home.route) // กลับไปยังหน้า Home ถ้าเป็นการเรียกจากหน้า Result
                } else {
                    navController.popBackStack() // ให้ pop stack ถ้าไม่ได้เรียกจากหน้า Result
                }
            },
        ) {
            Text(
                text = "Back",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ESTJ(navController: NavController) {
    val context = LocalContext.current
    val backStackEntry = navController.previousBackStackEntry
    val routeFrom = backStackEntry?.destination?.route
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ESTJ TYPE",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            painter = painterResource(id= R.drawable.estjnew),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            text = "ผู้บริหาร (Executive) (ESTJ)",
            fontSize = 18.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = "ผู้บริหาร (Executive) (ESTJ) เป็นตัวแทนของจารีตประเพณี ธรรมเนียมปฏิบัติ และระเบียบ " +
                    "โดยใช้ความเข้าใจของพวกเขาในสิ่งที่ถูก ผิด และเป็นที่ยอมรับของสังคมในการทำให้ครอบครัวและชุมชนอยู่ร่วมกัน" +
                    " บุคคลที่มีบุคลิกภาพแบบผู้บริหารนั้นยอมรับคุณค่าของความซื่อสัตย์ การอุทิศตน และศักดิ์ศรี " +
                    "พวกเขาขึ้นชื่อในเรื่องการให้คำแนะนำที่ชัดเจน และพวกเขาจะนำผู้อื่นอย่างมีความสุขแม้เส้นทางนั้นจะยากลำบากก็ตาม" +
                    " ด้วยความภูมิใจในการนำผู้คนมารวมกัน ผู้บริหารมักสวมบทบาทเป็นผู้จัดงานชุมชน " +
                    "ทำงานอย่างหนักเพื่อให้ทุกคนมารวมตัวกันในการเฉลิมฉลองกิจกรรมท้องถิ่นอันเป็นที่รัก " +
                    "หรือปกป้องค่านิยมดั้งเดิมที่ยึดครอบครัวและชุมชนไว้ด้วยกัน\n" +
                    "\n",
            fontSize = 12.sp ,

            )
        Image(
            painter = painterResource(id= R.drawable.estj_type),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(400.dp)
        )

        Text(
            text = "บุคลิกภาพและลักษณะเฉพาะตัวของ ESTJ\n" +
                    "คนที่มีบุคลิกภาพแบบ ESTJ เป็นคนที่มีระบบตรรกะและกระบวนการคิดค่อนข้างมาก เขามักจะใช้กระบวนการคิดและวิเคราะห์ในชีวิตประจำวันและทำงานได้อย่างยอดเยี่ยม เมื่อต้องตัดสินใจ เขามักจะ\n" +
                    "\n" +
                    "วิเคราะห์สิ่งต่างๆ อย่างเป็นกลาง\n" +
                    "\n" +
                    "ต้องการความชัดเจน เป็นไปตามตรรกะหรือเกณฑ์\n" +
                    "\n" +
                    "นอกจากนั้น ESTJ ให้ความสำคัญกับสิ่งที่เกิดขึ้นในปัจจุบันและจับต้องได้มากกว่าจินตนาการ แนวความคิด หรือทฤษฎี เขามักเป็นคนที่มีความมั่นคง ในสถานการณ์ต่างๆ เขามักจะให้คุณค่ากับ\n" +
                    "\n" +
                    "สิ่งที่เป็นไปได้ในเชิงปฏิบัติ ปัจจุบัน\n" +
                    "\n" +
                    "ประสบการณ์\n" +
                    "\n" +
                    "ESTJ มักจะเป็นคนที่สามารถจัดการะบบของสิ่งต่างๆ ได้ยอดเยี่ยม รวมทั้งการติดต่อพูดคุยกับผู้คน เพราะพวกเขามักจะคิดวิเคราะห์สถานการณ์และทางเลือกต่างๆ ไปพร้อมกับการเปรียบเทียบกับประสบการณ์ในอดีต\n" +
                    "\n" +
                    "\n" +
                    "จุดแข็งของ ESTJ\n" +
                    "การวิเคราะห์ เชิงตรรกะ\n" +
                    "\n" +
                    "เป็นระบบ มีการจัดการที่ดี\n" +
                    "\n" +
                    "ลงมือปฏิบัติและทำสิ่งต่างๆ ได้เก่ง \n" +
                    "\n" +
                    "จุดอ่อนของ ESTJ\n" +
                    "ไม่ค่อยเข้าใจเรื่องความรู้สึก คุณค่า อารมณ์\n" +
                    "\n" +
                    "บางครั้งอาจเป็นคนที่ดูชอบสั่งการ\n" +
                    "\n" +
                    "อาจมีลักษณะท่าทีที่แข็งกร้าว หรือชอบโต้เถียง\n" +
                    "\n" +
                    "\n" +
                    "ESTJ ในที่ทำงาน\n" +
                    "ESTJ เป็นคนที่มีเหตุผล วางแผนจัดการสิ่งต่างๆ และชอบพูดคุยกับผู้คน เขาเป็นเป็นคนที่มุ่งเน้นด้านความมีประสิทธิภาพ ตัดสินใจและลงมือทำสิ่งต่างๆ อย่างรวดเร็ว แต่อาจไม่สามารถรับมือกับปัญหาเฉพาะหน้าหรือความเปลี่ยนแปลงได้ดีมากนัก \n" +
                    "\n" +
                    "ESTJ อาจมีท่าทีแข็งกร้าว และไม่สนใจ ห่วงใยเพื่อนร่วมงาน เพราะเขาคิดถึงประสิทธิภาพ และการทำงานให้เสร็จ\n" +
                    "\n" +
                    "ESTJ อาจไม่ค่อยฟังลูกน้อง ผู้ใต้บังคับบัญชา และรับมือกับปัญหาเฉพาะหน้าได้ไม่ค่อยดี\n" +
                    "\n" +
                    "ESTJ เป็นหัวหน้าที่เข้าไปดูแลทุกส่วน และมักจะท้าทายลูกน้องให้ไปทำสิ่งต่างๆ ที่ดียิ่งขึ้น เขาให้ความสำคัญเกี่ยวกับการลงมือทำค่อนข้างมาก และต้องการให้ทุกสิ่งมีประสิทธิภาพ\n" +
                    "\n" +
                    "\n" +
                    "วิธีการปฏิสัมพันธ์และดูแลคนที่มีบุคลิกภาพ ESTJ\n" +
                    "ESTJ เป็นคนที่พูดเก่ง และอาจชอบแสดงออกด้วยท่าทางในการพูด แต่พวกเขามักจะไม่ค่อยแสดงออกทางด้านความรู้สึกมากเท่าที่ควร ในบทสนทนาพวกเขามักจะใช้เวลาไปกับตรรกะ เหตุผล หรือบอกเล่าสิ่งต่างๆ มากกว่าการพูดเรื่องความรู้สึก พวกเขาเป็นคนที่ตัดสินใจได้เก่ง และมีท่าทีตรงไปตรงมา เราสามารถมีปฏิสัมพันธ์กับเขาได้โดย\n" +
                    "\n" +
                    "มีบทสนทนาเกี่ยวกับสิ่งที่จับต้องได้ มีการวางแผนลงมือทำสิ่งต่างๆ \n" +
                    "\n" +
                    "บอกความต้องการของคุณออกไปตรงๆ ไม่อ้อมค้อม เพราะเขาอาจไม่เข้าใจและไม่ได้คิดถึงการตีความมากนัก\n" +
                    "\n" +
                    "เข้าใจว่าท่าทีและการพูดตรงๆ เป็นธรรมชาติของเขา",
            fontSize = 12.sp ,

            )
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                if (routeFrom == Screen.Result.route) {
                    navController.navigate(Screen.Home.route) // กลับไปยังหน้า Home ถ้าเป็นการเรียกจากหน้า Result
                } else {
                    navController.popBackStack() // ให้ pop stack ถ้าไม่ได้เรียกจากหน้า Result
                }
            },
        ) {
            Text(
                text = "Back",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ESFP(navController: NavController) {
    val context = LocalContext.current
    val backStackEntry = navController.previousBackStackEntry
    val routeFrom = backStackEntry?.destination?.route
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ESFP TYPE",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            painter = painterResource(id= R.drawable.esfpnew),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            text = "ผู้มอบความบันเทิง (Entertainer) (ESFP)",
            fontSize = 18.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = "หากจะพบว่าใครก็ตามที่ร้องเพลงและเต้นรำอย่างเป็นธรรมชาติ นั่นล่ะคือบุคลิกภาพประเภท" +
                    "ผู้มอบความบันเทิง (Entertainer) (ESFP) ผู้มอบความบันเทิงจมอยู่กับความตื่นเต้นในขณะนั้น " +
                    "และต้องการให้คนอื่น ๆ รู้สึกแบบนั้นเช่นกัน เมื่อพูดถึงการให้กำลังใจผู้อื่น " +
                    "ไม่มีบุคลิกภาพอื่นใดให้เวลาและพลังงานของพวกเขาได้มากเท่ากับผู้มอบความบันเทิง " +
                    "และไม่มีบุคลิกภาพอื่นใดที่ทำได้ด้วยรูปแบบที่ไม่อาจต้านทานได้เช่นนั้น",
            fontSize = 12.sp ,

            )
        Image(
            painter = painterResource(id= R.drawable.esfp_type),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(400.dp)
        )

        Text(
            text = "บุคลิกภาพและลักษณะเฉพาะตัวของ ESFP\n" +
                    "คนที่มีบุคลิกภาพแบบ ESFP เป็นชอบใช้เวลาอยู่กับปัจจุบัน เขาชอบหาอะไรทำ มีพลังงานมากมายเหลือล้น และชอบประสบการณ์ใหม่ๆ พวกเขามักมองเห็นรายละเอียดที่เกี่ยวข้องกับผู้คน แต่มักจะไม่ชอบทำกิจกรรมที่มีความจำเจ\n" +
                    "\n" +
                    "เรียนรู้ผ่านการลงมือทำ\n" +
                    "\n" +
                    "มองโลกตามความป็นจริง ทำในสิ่งที่ปฏิบัติได้\n" +
                    "\n" +
                    "นอกจากนั้น ESFP เป็นคนที่อ่อนโยน รับรู้ความรู้สึกของคนอื่นๆ ได้เร็ว เขาตัดสินใจด้วยการใช้คุณค่าส่วนตัวเป็นหลัก และให้ความสำคัญกับความรู้สึกของคนอื่น \n" +
                    "\n" +
                    "เข้าใจความรู้สึกของผู้คน\n" +
                    "\n" +
                    "เป็นมิตร มีทักษะทางสังคมที่ดี\n" +
                    "\n" +
                    "ESFP เป็นคนที่รู้จักสังเกตสิ่งต่างๆ รอบตัวโดยเฉพาะสิ่งที่เกี่ยวข้องกับผู้คน เขาจะรับรู้ถึงการเปลียนแปลงอย่างรวดเร็ว  \n" +
                    "\n" +
                    "\n" +
                    "จุดแข็งของ ESFP\n" +
                    "มีพลังงานมากในการทำสิ่งต่างๆ \n" +
                    "\n" +
                    "ตอบสนองต่อการเปลี่ยนแปลงได้อย่างรวดเร็ว\n" +
                    "\n" +
                    "เป็นมิตร เข้ากันคนอื่นได้ง่าย\n" +
                    "\n" +
                    "จุดอ่อนของ ESFP\n" +
                    "ไม่ถนัดในการทำสิ่งที่เกี่ยวข้องกับทฤษฎี\n" +
                    "\n" +
                    "อาจไม่ค่อยได้วางแผนก่อนลงมือทำ\n" +
                    "\n" +
                    "ไม่ค่อยนึกถึงผลระยะยาว\n" +
                    "\n" +
                    "\n" +
                    "ESFP ในที่ทำงาน\n" +
                    "ESFP เป็นคนที่ร่าเริงและเป็นมิตรมากในที่ทำงาน พวกเขามักจะชอบอยู่กันเป็นกลุ่ม และใช้เวลาปฏิสัมพันธ์กับเพื่อนร่วมงาน เขาสามารถรับมือกับปัญหาเฉพาะหน้าได้ดี และช่วยทำให้เพื่อนร่วมงานรู้สึกเป็นมิตร สามารถทำงานร่วมกันเป็นทีมได้ นอกจากนั้นเขายังเป็นคนที่จดจ่อกับรายละเอียดได้ดี และชอบลงมือทำ อยู่กับปัจจุบัน\n" +
                    "\n" +
                    "ESFP อาจรู้สึกว่าสามารถทำหลายอย่างพร้อมกันได้ ดังนั้นเขาอาจมีงานมากเกินไป จนเกินที่พวกเขาจะสามารถทำได้  \n" +
                    "\n" +
                    "ESFP ไม่ค่อยถนัดในการคิดสิ่งที่เป็นทฤษฎี ยุ่งเกี่ยวกับสิ่งที่จับต้องไม่ได้ หรือนามธรรม\n" +
                    "\n" +
                    "เมื่อ ESFP ได้เป็นผู้นำ เขามักจะเป็นหัวหน้าที่ให้ความสำคัญกับความสัมพันธ์กับลูกน้อง เขามักจะสนับสนุนให้ลูกน้องแต่ละคนสามารถทำงานได้เต็มที่ สนิทสนมกับลูกน้อง และไม่ชอบทำให้บรรยากาศการทำงานมันเครียดเกินไป\n" +
                    "\n" +
                    "\n" +
                    "วิธีการปฏิสัมพันธ์และดูแลคนที่มีบุคลิกภาพ ESFP\n" +
                    "คนที่มีบุคลิกภาพแบบ ESFP เป็นคนที่มีท่าทางเป็นมิตร และเข้าถึงได้ง่าย พวกเขามักจะชอบไปไหนมาไหนกับคนอื่น และเป็นคนที่มีพลังงานค่อนข้างมาก ESFP เป็นคนที่ชอบสังเกตสิ่งต่างๆ ที่เกิดขึ้นรอบตัว โดยเฉพาะสิ่งที่เกี่ยวข้องกับผู้คน เราสามารถดูแล ESFP ได้โดย\n" +
                    "\n" +
                    "พูดตรงๆ และใช้การยกตัวอย่างกับเขา ไม่พูดคุยกับ ESFP ด้วยทฤษฎีที่ซับซ้อน เข้าใจยาก หรือห่างไกลความเป็นจริง\n" +
                    "\n" +
                    "ไม่เป็นทางการมากเกินไปเมื่ออยู่ร่วมกับ ESFP \n" +
                    "\n" +
                    "หาโอกาสสร้างความประหลาดใจให้กับ ESFP เพราะพวกเขาชอบถูกเซอไพรส์มาก",
            fontSize = 12.sp ,

            )
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                if (routeFrom == Screen.Result.route) {
                    navController.navigate(Screen.Home.route) // กลับไปยังหน้า Home ถ้าเป็นการเรียกจากหน้า Result
                } else {
                    navController.popBackStack() // ให้ pop stack ถ้าไม่ได้เรียกจากหน้า Result
                }
            },
        ) {
            Text(
                text = "Back",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ESFJ(navController: NavController) {
    val context = LocalContext.current
    val backStackEntry = navController.previousBackStackEntry
    val routeFrom = backStackEntry?.destination?.route
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ESFJ TYPE",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            painter = painterResource(id= R.drawable.esfj),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            text = "ผู้บริหาร (Executive) (ESTJ)",
            fontSize = 18.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = "ผู้บริหาร (Executive) (ESTJ) เป็นตัวแทนของจารีตประเพณี ธรรมเนียมปฏิบัติ และระเบียบ " +
                    "โดยใช้ความเข้าใจของพวกเขาในสิ่งที่ถูก ผิด และเป็นที่ยอมรับของสังคมในการทำให้ครอบครัวและชุมชนอยู่ร่วมกัน" +
                    " บุคคลที่มีบุคลิกภาพแบบผู้บริหารนั้นยอมรับคุณค่าของความซื่อสัตย์ การอุทิศตน และศักดิ์ศรี " +
                    "พวกเขาขึ้นชื่อในเรื่องการให้คำแนะนำที่ชัดเจน และพวกเขาจะนำผู้อื่นอย่างมีความสุขแม้เส้นทางนั้นจะยากลำบากก็ตาม" +
                    " ด้วยความภูมิใจในการนำผู้คนมารวมกัน ผู้บริหารมักสวมบทบาทเป็นผู้จัดงานชุมชน " +
                    "ทำงานอย่างหนักเพื่อให้ทุกคนมารวมตัวกันในการเฉลิมฉลองกิจกรรมท้องถิ่นอันเป็นที่รัก" +
                    " หรือปกป้องค่านิยมดั้งเดิมที่ยึดครอบครัวและชุมชนไว้ด้วยกัน",
            fontSize = 12.sp ,

            )
        Image(
            painter = painterResource(id= R.drawable.esfj_type),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(400.dp)
        )

        Text(
            text = "บุคลิกภาพและลักษณะเฉพาะตัวของ ESFJ\n" +
                    "คนที่มีบุคลิกภาพแบบ ESFJ เป็นคนที่ชอบช่วยเหลือคนอื่น ให้ความสำคัญในสิ่งที่เกี่ยวข้องกับผู้คน เขามักจะชอบอยู่ในสถานที่ที่แวดล้อมไปด้วยผู้คน และชอบงานเลี้ยงสังสรรค์ ESFJ เป็นคนที่ให้ความสำคัญเกี่ยวกับระบบประเพณี วัฒนธรรม และคุณค่าส่วนรวมด้วย เขามักเป็นคนที\n" +
                    "\n" +
                    "เห็นใจคนอื่น ชอบช่วยเหลือคนอื่น\n" +
                    "\n" +
                    "เป็นกันเอง ชอบการมีปฏิสัมพันธ์ และการร่วมแรงร่วมใจ\n" +
                    "\n" +
                    "นอกจากนั้น ESFJ ยังให้ความสำคัญกับสิ่งที่เป็นไปได้จริงมากกว่าสิ่งที่อาจเกิดขึ้นในอนาคตได้ โดยพวกเขาอาจเปรียบเทียบสิ่งที่เกิดขึ้นกับประสบการณ์ที่ผ่านมา เขาเป็นคนที่ทำงานที่มีระบบหรือมีรายละเอียดได้ดี โดยเฉพาะรายละเอียดที่มีความเกี่ยวข้องกับผู้คน\n" +
                    "\n" +
                    "อยู่กับความเป็นจริงและปัจจุบัน\n" +
                    "\n" +
                    "จดจ่อกับรายละเอียดได้\n" +
                    "\n" +
                    "ESFJ มักจะจดจำสิ่งต่างๆ ของผู้คนได้ดี และเขาให้ความสำคัญกับเรื่องเหล่านี้ด้วย\n" +
                    "\n" +
                    "\n" +
                    "จุดแข็งของ ESFJ\n" +
                    "เป็นมิตร เข้ากับผู้อื่นได้ดี \n" +
                    "\n" +
                    "มีระบบ จัดการสิ่งต่างๆ ได้ดี \n" +
                    "\n" +
                    "อยู่กับความเป็นจริง ลงมือปฏิบัติเก่ง\n" +
                    "\n" +
                    "จุดอ่อนของ ESFJ\n" +
                    "อ่อนไหวต่อคำวิจารณ์ค่อนข้างมาก\n" +
                    "\n" +
                    "ละเลยความต้องการของตัวเอง เมื่อต้องตัดสินใจ\n" +
                    "\n" +
                    "อาจไม่ค่อยชอบออกจากความคุ้นเคยเดิมๆ หรือ safe zone\n" +
                    "\n" +
                    "\n" +
                    "ESFJ ในที่ทำงาน\n" +
                    "ESFJ เป็นคนที่ชอบการปฏิสัมพันธ์ พูดคุยกับคนอื่น ในที่ทำงานเขาเป็นคนที่ทำงานเก่งและชอบช่วยเหลือเพื่อนร่วมงาน เขาถนัดในการทำงานที่จับต้องได้มากกว่างานที่เป็นทฤษฎี โดยที่เขาจะโดดเด่นมากเมื่องานเหล่านั้นทำให้เขาได้เจอกับผู้คนไปพร้อมๆ กัน \n" +
                    "\n" +
                    "ESFJ ไม่ชอบความขัดแย้ง แม้ว่าจะเป็นเรื่องเล็กน้อยแต่เขาก็รู้สึกไม่สบายใจเมื่อเกิดความขัดแย้ง\n" +
                    "\n" +
                    "ESFJ เสียใจได้ง่ายเมื่อเจอคำตำหนิ หรือปฏิกิริยาเชิงลบจากเพื่อนร่วมงานได้ หากสิ่งเหล่านั้นเป็นสิ่งที่เขารัก ทุ่มเท หรือให้คุณค่ามาก\n" +
                    "\n" +
                    "ESFJ เป็นหัวหน้าที่สร้างเครือข่ายได้อย่างยอดเยี่ยม เขามักจะรู้จักผู้คนในวงกว้าง และมักใช้จุดนี้เป็นจุดแข็งในการสร้างความร่วมมือในการทำงาน เขาให้ความสำคัญกับระเบียบ คุณค่า วัฒนธรรมในองค์กรค่อนข้างมาก\n" +
                    "\n" +
                    "\n" +
                    "วิธีการปฏิสัมพันธ์และดูแลคนที่มีบุคลิกภาพ ESFJ\n" +
                    "ESFJ เป็นคนที่มีท่าทีเป็นมิตร ชอบปฏิสัมพันธืกับผู้คน และชอบช่วยเหลือคนอื่นมาก เขาชอบการแสดงออกด้วยภาษากายเช่นทำท่าทางประกอบการพูด และแสดงออกทางสีหน้าได้อย่างยอดเยี่ยม เขาให้ความสำคัญกับความกลมเกลียวและความรู้สึกของคนอื่นค่อนข้างมาก เราสามารถดูแล ESFJ ได้โดย\n" +
                    "\n" +
                    "ให้พื้นที่สำหรับเขาในการแสดงออกทางความรู้สึก และให้ความสำคัญกับความรู้สึกของเขา\n" +
                    "\n" +
                    "เป็นคู่สนทนาที่ดีให้กับเขา โดยการตั้งใจฟังสิ่งที่เขาพูด\n" +
                    "\n" +
                    "พยายามทำความหรือให้ความสำคัญเข้าใจคุณค่าที่เขายึดถือ",
            fontSize = 12.sp ,

            )
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                if (routeFrom == Screen.Result.route) {
                    navController.navigate(Screen.Home.route) // กลับไปยังหน้า Home ถ้าเป็นการเรียกจากหน้า Result
                } else {
                    navController.popBackStack() // ให้ pop stack ถ้าไม่ได้เรียกจากหน้า Result
                }
            },
        ) {
            Text(
                text = "Back",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ENTP(navController: NavController) {
    val context = LocalContext.current
    val backStackEntry = navController.previousBackStackEntry
    val routeFrom = backStackEntry?.destination?.route
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ENTP TYPE",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            painter = painterResource(id= R.drawable.entp),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            text = "นักโต้วาที (Debater) (ENTP)",
            fontSize = 18.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = "นักโต้วาที (Debater) (ENTP) เป็นคนที่มีไหวพริบและกล้าหาญ ไม่กลัวที่จะไม่เห็นด้วยกับสภาพปัจจุบันที่เป็นอยู่" +
                    " ในความเป็นจริงพวกเขาไม่กลัวที่จะไม่เห็นด้วยกับสิ่งใดหรือใครก็ตาม คนที่มีบุคลิกลักษณะนี้จะเฉิดฉายได้มากเมื่อ" +
                    "อยู่ในการโต้เถียงกันด้วยวาจา และหากบทสนทนาเปลี่ยนไปเป็นประเด็นที่ขัดแย้ง ก็จะยิ่งดีเข้าไปใหญ่\n" +
                    "\n" +
                    "มันคงเป็นเรื่องผิดที่จะคิดว่านักโต้วาทีเป็นคนที่ไม่เห็นด้วยกับสิ่งใดเลยหรือเป็นคนใจร้าย " +
                    "คนที่มีบุคลิกภาพประเภทนี้จะมีความรู้และอยากรู้อยากเห็น มีอารมณ์ขันขี้เล่น และพวกเขาก็สามารถสร้างความสนุกสนาน" +
                    "ได้อย่างไม่น่าเชื่อ พวกเขามีแนวคิดเรื่องความสนุกที่ผิดแผกและแตกต่างไปจากคนประเภทอื่น " +
                    "ซึ่งหนึ่งในนั้นคือการโต้วาทีที่มีสีสันและมีชีวิตชีวา",
            fontSize = 12.sp ,

            )
        Image(
            painter = painterResource(id= R.drawable.entp_type),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(400.dp)
        )

        Text(
            text = "บุคลิกภาพและลักษณะเฉพาะตัวของ ENTP\n" +
                    "คนที่มีบุคลิกภาพแบบ ENTP เป็นคนที่เห็นความเป็นไปได้ของสิ่งต่างที่อยู่รอบตัวอย่างรวดเร็ว เขาสนใจแนวความคิดเบื้องหลังของสิ่งเหล่านั้น เพื่อที่จะคาดเดาอนาคต และมักชอบความท้าทาย ชอบที่จะเปลี่ยนแปลงและรับมือกับสิ่งต่างๆ แบบฉับพลัน ENTP เป็นบุคลิกภาพที่\n" +
                    "\n" +
                    "- มีความคิดสร้างสรรค์ \n" +
                    "\n" +
                    "- สนใจระบบ ภาพรวม ทฤษฎี และความเป็นไปได้\n" +
                    "\n" +
                    "นอกจากนั้น ENTP เป็นคนที่เก่งในเรื่องกระบวนการคิดวิเคราะห์ เขามักจะนำความเป็นไปได้ใหม่ๆ มาวิเคราะห์ และเมื่อต้องตัดสินใจ เขามักจะเป็นคนที่\n" +
                    "\n" +
                    "- ใช้ตรรกะ เหตุผล\n" +
                    "\n" +
                    "- ตั้งคำถามเกี่ยวกับสิ่งเหล่านั้นเพื่อหามุมมองใหม่ๆ มีมุมมองที่เป็นกลาง\n" +
                    "\n" +
                    "ENTP เป็นคนที่ชอบแก้ปัญหาในมุมมองที่เป็นภาพรวมมากกว่าแก้ปัญหาเฉพาะหน้าเป็นเรื่องๆ นอกจากนั้น ENTP หลายคนชอบวิเคราะห์ผู้คน อ่านคน ประกอบกับการทำสิ่งต่างๆอีกด้วย\n" +
                    "\n" +
                    "\n" +
                    "จุดแข็งของ ENTP\n" +
                    "- ความคิดสร้างสรรค์\n" +
                    "\n" +
                    "- ความมีเสน่ห์ดึงดูด \n" +
                    "\n" +
                    "- สามารถปรับตัว เตรียมพร้อมรับมือสถานการณ์ต่างๆ ได้ยอดเยี่ยม\n" +
                    "\n" +
                    "จุดอ่อนของ ENTP\n" +
                    "- มองข้ามรายละเอียด\n" +
                    "\n" +
                    "- อาจเป็นคนที่ชอบโต้เถียงมากเกินไป โดยขาดความเข้าใจจากมุมมองของคนอื่น\n" +
                    "\n" +
                    "- ไม่ค่อยเข้าใจความรู้สึกของคนอื่น\n" +
                    "\n" +
                    "\n" +
                    "ENTP ในที่ทำงาน\n" +
                    "- ENTP เป็นคนที่ชอบพบปะ พูดคุยและปฏิสัมพันธ์กับเพื่อนร่วมงาน พวกเขาเป็นคนที่ดูมีพลังงานเหลือล้น และกระตือรือร้น เขามักจะมีไอเดียใหม่ๆ อยู่เสมอและมักจะชอบพูด แลกเปลี่ยนความคิดเห็นกับเพื่อนร่วมงาน นอกจากนั้นเขายังเป็นคนที่ให้ความสำคัญกับประสิทธิภาพในการทำงานอีกด้วย\n" +
                    "\n" +
                    "แม้ว่า ENTP จะมีไอเดียอยู่มากมาย แต่พวกเขากลับไม่ค่อยสามารถทำให้ไอเดียเหล่านั้นเป็นจริงได้หากไม่มีเพื่อนร่วมงานที่เข้าใจและพร้อมที่จะสนับสนุนเขา  \n" +
                    "\n" +
                    "- ENTP จะเกิดความเครียดอย่างหนักเมื่อต้องรับมือกับข้อมูลและรายละเอียดจำนวนมาก จนทำให้เขาเกิดสภาวะหมดไฟได้\n" +
                    "\n" +
                    "เมื่อ ENTP ได้เป็นผู้นำ เขามักจะเป็นผู้นำที่มีวิสัยทัศน์ เขาชอบการเรียนรู้สิ่งใหม่ๆ และพยายามจะให้ลูกน้องได้เรียนรู้สิ่งใหม่ๆ เหล่านั้นด้วย นอกจากนั้นเขาชอบที่ให้ทีมได้สร้างสรรค์ สิ่งใหม่ๆ ร่วมกัน\n" +
                    "\n" +
                    "\n" +
                    "วิธีการปฏิสัมพันธ์และดูแลคนที่มีบุคลิกภาพ ENTP\n" +
                    "คนที่มีบุคลิกภาพแบบ ENTP มักเป็นคนที่มีเสน่ห์ น่าดึงดูด พวกเขามักจะเป็นคนที่มีพลังงานสูงและดูกระตือรือร้นกับสิ่งต่างๆ นอกจากนี้พวกเขายังดูเป็นคนที่หลักแหลม และมีความคิดสร้างสรรค์มากอีกด้วย ในการปฏิสัมพันธ์กับ ENTP คุณควร \n" +
                    "\n" +
                    "- เตรียมพร้อมที่จะพูดถึงความเป็นไปได้ ไอเดียต่างๆ ที่คุณมี ความแปลกใหม่สร้างสรรค์ที่คุณมองเห็นในสิ่งต่างๆ \n" +
                    "\n" +
                    "- ไม่จู้จี้เรื่องรายละเอียดมากกับ ENTP \n" +
                    "\n" +
                    "- ในการตัดสินใจเรื่องต่างๆ ควรให้ ENTP ได้มีทางเลือกที่หลากหลายมากที่สุดเท่าที่จะเป็นไปได้ และไม่ควรเร่งรัดให้ ENTP ตัดสินใจโดยที่เขายังไม่พร้อม",
            fontSize = 12.sp ,

            )
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                if (routeFrom == Screen.Result.route) {
                    navController.navigate(Screen.Home.route) // กลับไปยังหน้า Home ถ้าเป็นการเรียกจากหน้า Result
                } else {
                    navController.popBackStack() // ให้ pop stack ถ้าไม่ได้เรียกจากหน้า Result
                }
            },
        ) {
            Text(
                text = "Back",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ENTJ(navController: NavController) {
    val context = LocalContext.current
    val backStackEntry = navController.previousBackStackEntry
    val routeFrom = backStackEntry?.destination?.route
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ENTJ TYPE",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            painter = painterResource(id= R.drawable.entj),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            text = "ผู้บัญชาการ (Commander) (ENTJ)",
            fontSize = 20.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = "\tผู้บัญชาการ (Commander) (ENTJ) เป็นผู้นำโดยกำเนิด บุคคลที่มีบุคลิกภาพประเภทนี้มาพร้อมของขวัญ" +
                    "ด้านความสามารถพิเศษและความมั่นใจ และมีความสามารถในการแสดงออกถึงอำนาจในแบบที่ดึงดูดฝูงชน" +
                    "ให้มารวมกันเพื่อทำให้บรรลุเป้าหมายเดียวกัน อย่างไรก็ตาม ผู้บัญชาการยังมีลักษณะที่มักมีเหตุผลในระดับที่ไร้ความปราณี" +
                    " โดยใช้แรงผลักดัน ความมุ่งมั่น และจิตใจที่เด็ดเดี่ยวของพวกเขาเพื่อบรรลุเป้าหมายที่พวกเขาตั้งไว้สำหรับตนเอง" +
                    " บางทีอาจเป็นการดีที่บุคลิกประเภทนี้มีสัดส่วนเพียงสามเปอร์เซ็นต์ของประชากรโลก ไม่เช่นนั้นพวกเขาอาจจะ" +
                    "ครอบงำบุคลิกภาพประเภทที่ขี้อายและอ่อนไหวกว่าซึ่งเป็นบุคลิกส่วนใหญ่ของโลกได้ แต่อย่างไรก็ตาม " +
                    "เราต้องขอบคุณบุคลิกประเภทผู้บัญชาการที่ทำให้มีธุรกิจและสถาบันต่าง ๆ ในโลกของเรา"
            ,fontSize = 16.sp

            )
        Image(
            painter = painterResource(id= R.drawable.entj_type),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(400.dp)
        )
        Text(
            text = "บุคลิกภาพและลักษณะเฉพาะตัวของ ENTJ",
            fontSize = 20.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text =
                    "\tคนที่มีบุคลิกภาพแบบ ENTJ เป็นคนที่ชอบหาเหตุผลและวิเคราะห์สิ่งต่างๆ พวกเขาสามารถเห็นข้อผิดพลาดของระบบได้อย่างง่ายดายและมักจะวิจารณ์สิ่งที่มองเห็นเพื่อให้เกิดการพัฒนาปรับปรุงสิ่งรอบตัวอยู่เสมอ ENTJ ให้ความสำคัญกับประสิทธิภาพและความรู้ ซึ่งพวกเขามักมีความโดดเด่นในเรื่อง\n" +
                    "\n" +
                    "• การวิเคราะห์ การใช้เหตุผล มองสิ่งต่างๆ อย่างเป็นกลาง\n" +
                    "\n" +
                    "• การตัดสินใจที่อยู่บนพื้นฐานของตรรกะ ความชัดเจน\n" +
                    "\n" +
                    "นอกจากนั้น ENTJ ยังเป็นคนที่ชอบมองสิ่งต่างๆ ในภาพรวมและในระยะยาว เขามักจะชอบการแก้ไขปัญหาที่ท้าทาย และค้นหาความเป็นไปได้ใหม่ในการแก้ปัญหา\n" +
                    "\n" +
                    "• มองสิ่งต่างๆ เป็นระบบ ภาพรวม \n" +
                    "\n" +
                    "• มีการวางแผน และคิดค้นสิ่งใหม่ๆ อย่างสร้างสรรค์\n" +
                    "\n" +
                    "• พวกเขามักจะชอบแก้ปัญหาและการจัดการเชิงโครงสร้าง\n" ,fontSize = 16.sp )
        Text(
            text = "จุดแข็งของ ENTJ",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp) // เพิ่มระยะห่างด้านล่าง
        )
        Text(
            text = "• มีบุคลิกภาพและทักษะของความเป็นผู้นำ\n" + "\n" +
                    "• การวิเคราะห์ ใช้ตรรกะ ด้วยมุมมองที่เป็นกลาง\n" + "\n" +
                    "• มีการตัดสินใจด้วยตรรกะที่ดี กล้าเสี่ยง",
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.Start) // จัดวางให้ชิดซ้ายของหน้าจอ
        )
        Text(
            text =   "จุดอ่อนของ ENTJ",
            fontSize = 20.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(text =
                    "• มีความอดทนต่ำกับสิ่งที่ต้องใช้เวลา อาจเปลี่ยนแปลงไปสู่สิ่งที่มีท่าทีว่าจะดีกว่าซึ่งเกิดจากกระบวนการวิเคราะห์หรือเชื่อมโยงที่รวดเร็วจนเกินไป \n" +
                    "\n" +
                    "• ขาดความเข้าใจ หรือไม่อ่อนไหวกับเรื่องของคุณค่าส่วนตัว อารมณ์ความรู้สึก\n" +
                    "\n" +
                    "• อาจถูกมองว่าเป็นคนที่ดื้อ ดึงดันทำในสิ่งที่ตัวเองต้องการ\n" ,fontSize = 16.sp )
        Text(
            text =  "ENTJ ในที่ทำงาน",
            fontSize = 20.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(text =

                    "• ENTJ เป็นคนที่รวดเร็ว ตรงไปตรงมา และมีความสามารถในการวางแผนเป็นอย่างดี พวกเขาสามารถเห็นความเป็นไปได้ในเกือบทุกสิ่งทุกอย่าง พร้อมลงมือวางแผน และปฏิบัติตามแผนต่างๆ โดยทันที ในที่ทำงาน ENTJ มักจะแสดงออกและพูดความคิดเห็นของเขาอย่างตรงไปตรงมา พวกเขามองสิ่งต่างๆ ที่เกิดขึ้นในชีวิตราวกับว่าเป็นเกมส์บนกระดานหมากรุก ที่มีผู้คน เหตุการณ์ และสิ่งต่างๆ อยู่ในนั้น \n" +
                    "\n" +
                    "• ENTJ มีบุคลิกภาพของความเป็นผู้นำสูง เพราะเขาสื่อสารทุกอย่างด้วยความชัดเจน วางแผนระยะยาว และกล้าเผชิญกับความเสี่ยง แต่หากอยู่ในบริบทที่ไม่เหมาะสมจะทำให้เขาดูเป็นคนเย่อหยิ่ง ชอบบงการ สั่งการคนอื่น \n" +
                    "\n" +
                    "• ENTJ มักจะเข้าไปสัมผัสกับเนื้องานเพียงเพื่อให้เขาสามารถเห็นภาพรวม ซึ่งอาจทำให้เพื่อนร่วมงานบางคนมองว่าเขาไม่รู้ปัญหาที่เกิดขึ้นจริงๆ ในงานและมีความผิวเผิน\n" +
                    "\n" +
                    "• ENTJ ชอบงานที่ให้พวกเขาสามารถออกแบบองค์กร ปรับโครงสร้าง สร้างมาตรฐาน เขียนโปรแกรม กำหนดนโยบาย วางแผนกลยุทธ์ และบริหารองค์กร เพราะงานเหล่านี้ช่วยทำให้เขาทำในสิ่งที่ตัวเองถนัดได้\n" ,fontSize = 16.sp )
        Text(
            text =  "วิธีการปฏิสัมพันธ์และดูแลคนที่มีบุคลิกภาพ ENTJ",
            fontSize = 20.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(text =

                    "\tโดยปกติแล้วคนที่มีบุคลิกภาพแบบ ENTJ เป็นคนที่เป็นมิตรและชอบออกไปข้างนอก พวกเขามีพลังในการพูดคุย แลกเปลี่ยนความคิดเห็น คิด และเปลี่ยนแปลงอย่างรวดเร็ว พวกเขาชอบบทสนทนาที่มีความหมาย และการโต้เถียงประเด็นในมิติต่างๆ ที่เกิดขึ้นในบทสนทนา ในหลายครั้ง \n" +
                    "\n" +
                    "• เข้าใจว่าการสร้างข้อโต้แย้งที่เกิดขึ้นในบทสนทนากับ ENTJ เป็นรูปแบบหนึ่งของการสนทนาที่เขาใช้และคุ้นเคยกับมันเท่านั้น ไม่ควรคิดว่าข้อโต้แย้งต่างๆ ทีเ่กิดขึ้นเกิดจากความไม่ลงรอยกัน หรือปัญหาเชิงความสัมพันธ์\n" +
                    "\n" +
                    "• เข้าใจว่าเมื่อ ENTJ มีท่าทีเย็นชากับคนที่อยู่รอบข้าง ไม่ได้หมายความว่า ENTJ ไม่มีความรู้สึก แต่พวกเขาต้องการความปลอดภัยเป็นอย่างมากในการแสดงความรู้สึกออกมา \n" +
                    "\n" +
                    "• ในการพูดคุยกับ ENTJ คุณควรเตรียมพร้อมที่จะแสดงจุดยืนของตัวเอง และพร้อมที่จะโต้เถียงโดยมีแนวความคิดหรือหลักฐานที่สมเหตุสมผลมากเพียงพอ นอกจากนั้นแนวความคิดต่างๆ ที่โต้เถียงกับ ENTJ จะต้องสอดคล้องกับภาพรวมหรือแผนการระยะยาว ด้วย\n" +
                    "\n",
            fontSize = 16.sp ,

            )
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                if (routeFrom == Screen.Result.route) {
                    navController.navigate(Screen.Home.route) // กลับไปยังหน้า Home ถ้าเป็นการเรียกจากหน้า Result
                } else {
                    navController.popBackStack() // ให้ pop stack ถ้าไม่ได้เรียกจากหน้า Result
                }
            },
        ) {
            Text(
                text = "Back",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ENFP(navController: NavController) {
    val context = LocalContext.current
    val backStackEntry = navController.previousBackStackEntry
    val routeFrom = backStackEntry?.destination?.route
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ENFP TYPE",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Image(
            painter = painterResource(id= R.drawable.enfp),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            text = "นักรณรงค์ (Campaigner) (ENFP)",
            fontSize = 18.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = "นักรณรงค์ (Campaigner) (ENFP) เป็นจิตวิญญาณแห่งอิสระอย่างแท้จริง พวกเขาเป็นคนเข้าสังคม ใจกว้าง" +
                    " และเปิดใจ ด้วยแนวทางการใช้ชีวิตที่มีชีวิตชีวาและสนุกสนาน พวกเขาจึงโดดเด่น ไม่ว่าจะอยู่ในกลุ่มไหนก็ตาม" +
                    " แม้ว่าพวกเขาจะชอบการปาร์ตี้ แต่นักรณรงค์ไม่เพียงแค่สนใจที่จะมีช่วงเวลาดี ๆ เท่านั้น ประเภทบุคลิกภาพเหล่านี้ลึกล้ำ" +
                    " พวกเขาปรารถนาที่จะมีความสัมพันธ์ทางอารมณ์ที่มีความหมายกับผู้อื่นด้วย"
            ,
            fontSize = 12.sp ,

            )
        Image(
            painter = painterResource(id= R.drawable.enfp_2969873558),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(400.dp)
        )

        Text(
            text = "บุคลิกภาพและลักษณะเฉพาะตัวของ ENFP\n" +
                    "ENFP เป็นคนที่มองว่าชีวิตคือการผจญภัย ที่มีแต่ความเป็นไปได้ เขาเป็นคนที่มีเสนห์ กระตือรือร้น และมีพลังที่จะทำสิ่งต่างๆ อย่างไม่จำกัด เขามักให้ความสนใจในสิ่งที่จะเกิดขึ้นในอนาคตและชอบที่จะพูดคุยแลกเปลี่ยนสิ่งเหล่านั้นกับคนอื่นๆ  \n" +
                    "\n" +
                    "- สร้างสรรค์ จินตนาการ\n" +
                    "\n" +
                    "- มองเห็นโอกาสในทุกๆ ความเปลี่ยนแปลงและปัญหา\n" +
                    "\n" +
                    "นอกจากนั้น ENFP เป็นคนที่มักจะมีผู้คนอยู่รอบข้างเสมอ เป็นคนที่มีความดึงดูด และเชิญชวนให้ผู้คนเข้าหา พวกเขาให้คุณค่ากับความเป็นกลุ่ม ความกลมเกลียว และใส่ใจผู้คน\n" +
                    "\n" +
                    "- มีเสน่ห์ เป็นมิตร และอ่อนโยนกับผู้คน\n" +
                    "\n" +
                    "- เป็นผู้ให้การสนับสนุน และทำงานร่วมกับคนอื่นได้อย่างยอดเยี่ยม\n" +
                    "\n" +
                    "\n" +
                    "ENFP เป็นคนที่มักจะเห็นสิ่งต่างๆ เป็นไปในทางที่ดีและเห็นความเป็นไปได้ในการเติบโตของผู้คนที่อยู่กับเขา เขาทำให้ผู้คนเหล่านั้นมีแรงบันดาลใจ ซึ่งทำให้คนที่อยู่รอบข้างมีความร่าเริง มีความสุขไปกับเขาได้\n" +
                    "\n" +
                    "\n" +
                    "จุดแข็งของ ENFP\n" +
                    "- มีความมีเสน่ห์ อ่อนโยน และมีทักษะการปฏิสัมพันธ์กับผู้คน\n" +
                    "\n" +
                    "- มีความสร้างสรรค์ มีจินตนาการ\n" +
                    "\n" +
                    "- ปรับตัวเก่ง สามารถรับมือกับความเปลี่ยนแปลงได้ดี\n" +
                    "\n" +
                    "จุดอ่อนของ ENFP\n" +
                    "- ความเบื่อหน่ายในสิ่งที่จำเจ\n" +
                    "\n" +
                    "- เปลี่ยนแปลงอารมณ์ง่าย และอาจท่วมท้นไปด้วยความรู้สึกได้ง่าย\n" +
                    "\n" +
                    "- ไม่ค่อยชอบทำตามกฏกติกา\n" +
                    "\n" +
                    "\n" +
                    "ENFP ในที่ทำงาน\n" +
                    "- ENFP เป็นคนที่มีความสุขเมื่อได้แลกเปลี่ยนความคิดเห็นและอยู่ท่ามกลางผู้คน เมื่อต้องการระดมความคิดในที่ทำงาน เขาเป็นคนที่มีไอเดียต่างๆ มากมาย ENFP ให้ความสำคัญเกี่ยวกับเพื่อนร่วมงานค่อนข้างมาก และเป็นคนที่เตรียมพร้อมรับมือแก้ปัญหาต่างๆ ได้อย่างดี โดยเฉพาะปัญหาที่เกี่ยวข้องกับการบริการ และการสื่อสาร\n" +
                    "\n" +
                    "- ENFP จะเบื่อหน่าย หากต้องจดจ่อกับงานที่ไม่ได้ปฏิสัมพันธ์กับเพื่อนร่วมงาน หรือทำงานที่ต้องทำคนเดียวเป็นระยะเวลานาน   \n" +
                    "\n" +
                    "เมื่อ ENFP ต้องทำงานที่มีรายละเอียดเป็นจำนวนมากอาจเกิดสภาวะหมดไฟได้เร็ว \n" +
                    "\n" +
                    "หาก ENFP ได้เป็นผู้นำ เขาจะเป็นผู้นำที่ให้แรงบันดาลใจคนอื่นได้อย่างยอดเยี่ยม มีวิสัยทัศน์กว้างไกล และยังช่วยสนับสนุนให้ลูกน้องได้พัฒนาและเข้าสู่ศักยภาพที่มีได้อย่างเต็มที่  \n" +
                    "\n" +
                    "\n" +
                    "วิธีการปฏิสัมพันธ์และดูแลคนที่มีบุคลิกภาพ ENFP\n" +
                    "ENFP เป็นคนที่ค่อนข้างเปิดกว้าง พวกเขามักจะชอบพูดคุยแลกเปลี่ยนความคิดเห็นกับคนอื่นๆ และชอบอยู่ท่ามกลางผู้คน เพื่อนฝูง นอกจากนั้นยังมีเพื่อนเป็นวงกว้าง พวกเขามีความสามารถในการปรับตัวและเรียนรู้วิธีการเข้ากับผู้คนได้เป็นอย่างดีแม้กระทั่งกับคนแปลกหน้า   เราสามารถดูแล ENFP ได้ด้วยการ \n" +
                    "\n" +
                    "- เตรียมพร้อมที่จะพูดคุยและปฏิสัมพันธ์กับ ENFP เป็นระยะเวลานาน\n" +
                    "\n" +
                    "- ไม่ทำให้บรรยากาศตอนพบกันดูเคร่งเครียดมากเกินไป\n" +
                    "\n" +
                    "- ไม่ควรให้ ENFP รับผิดชอบงานที่มีข้อมูลและรายละเอียดมากเกินไป",
            fontSize = 12.sp ,

            )
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                if (routeFrom == Screen.Result.route) {
                    navController.navigate(Screen.Home.route) // กลับไปยังหน้า Home ถ้าเป็นการเรียกจากหน้า Result
                } else {
                    navController.popBackStack() // ให้ pop stack ถ้าไม่ได้เรียกจากหน้า Result
                }
            },
        ) {
            Text(
                text = "Back",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ENFJ(navController: NavController) {
    val context = LocalContext.current
    val backStackEntry = navController.previousBackStackEntry
    val routeFrom = backStackEntry?.destination?.route
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ENFJ TYPE",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Image(
            painter = painterResource(id= R.drawable.enfj),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
                .padding(10.dp)
        )
        Text(
            text = "ผู้เป็นตัวเอก (Protagonist) (ENFJ)",
            fontSize = 20.sp ,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Text(
            text = "ผู้เป็นตัวเอก (Protagonist) (ENFJ) รู้สึกว่าตัวเองเกิดมาเพื่อทำตามจุดประสงค์ที่ยิ่งใหญ่กว่าในชีวิต " +
                    "บุคลิกภาพเหล่านี้มีความรอบคอบและยึดมั่นในอุดมการณ์ มุ่งมั่นที่จะสร้างให้เกิดสิ่งดี ๆ ต่อผู้อื่นและโลกรอบตัวพวกเขา" +
                    " พวกเขาไม่ค่อยอายที่จะทำในสิ่งที่ถูกต้อง แม้ว่าการทำเช่นนั้นจะไม่ใช่เรื่องง่ายก็ตาม" +
                    "ผู้เป็นตัวเอกเกิดมาเพื่อเป็นผู้นำ ซึ่งนั่นอธิบายได้ว่าทำไมบุคลิกเหล่านี้สามารถพบได้ในนักการเมือง โค้ช" +
                    " และครูผู้สอนที่มีชื่อเสียงหลายคน ความหลงใหลและความสามารถพิเศษของพวกเขาช่วยให้พวกเขาสร้างแรงบันดาลใจ" +
                    "ให้ผู้อื่นได้ ไม่ใช่แค่ในอาชีพการงานเท่านั้น แต่ในทุกด้านของชีวิต รวมถึงความสัมพันธ์ของพวกเขาด้วย ดังนั้น " +
                    "ผู้เป็นตัวเอกจะรู้สึกมีความสุขและสมหวังมากเมื่อพวกเขาได้ชี้นำเพื่อนและคนที่รักให้เติบโตเป็นตัวของตัวเองได้ดีที่สุด",
            fontSize = 16.sp ,

            )
        Image(
            painter = painterResource(id= R.drawable.diplomats_protagonist_enfj_introduction),
            contentDescription = "Friend",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(400.dp)
                .padding(10.dp)
        )
        Text(
            text = "บุคลิกภาพและลักษณะเฉพาะตัวของ ENFJ",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text =
                    "คนที่มีบุคลิกภาพแบบ ENFJ เป็นคนที่ให้ความสำคัญเกี่ยวกับผู้คนและมิตรภาพ พวกเขามักจะชอบอยู่ท่ามกลางผู้คนและเข้าใจความต้องการ คุณค่า สิ่งที่แต่ละคนต้องการ พวกเขาชอบอุทิศตัวเองไปกับการช่วยเหลือคนอื่น\n" +
                    "\n" +
                    "• เข้าใจผู้คน ชอบช่วยเหลือผู้คน\n" +
                    "\n" +
                    "• ให้ความสำคัญกับความกลมเกลียว ความสมานฉันท์ และข้อตกลงร่วมกัน\n" +
                    "\n" +
                    "นอกจากนั้น ENFJ ยังเป็นคนที่มักจะเห็นความเป็นไปได้ใหม่ๆ มองเห็นความเชื่อมโยง และความหมายที่อยู่เบื้องหลังสิ่งต่างๆ เขามักจะเป็นคนที่\n" +
                    "\n" +
                    "• มีความสร้างสรรค์ \n" +
                    "\n" +
                    "• มองเห็นความเป็นไปได้ และความเชื่อมโยง\n" +
                    "\n" +
                    "ENFJ มักจะเห็นความเป็นไปได้และศักยภาพในตัวผู้คนอยู่เสมอ และพยายามช่วยเหลือผู้คนรอบตัวเขาให้บรรลุศักยภาพในแบบที่พวกเขาสามารถเป็นได้\n" +
                    "\n" +
                    "\n" , fontSize = 16.sp )
        Text(
            text = "จุดแข็งของ ENFJ",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(text =
                    "• เข้าใจคนอื่น ชอบช่วยเหลือคนอื่น \n"+
                    "• มีทักษะการสื่อสารและปฏิสัมพันธ์กับผู้คนอย่างยอดเยี่ยม\n"+
                    "• มีความคิดสร้างสรรค์ และจินตนาการ\n" , fontSize = 16.sp )
        Text(
            text ="จุดอ่อนของ ENFJ\n",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(text =
                    "• หลงลืมความต้องการของตัวเอง ให้ความสำคัญกับคนอื่นมากเกินไปในการตัดสินใจ \n"+
                    "• อาจมีปัญหาเรื่องการโต้แย้งด้วยตรรกะ\n"+
                    "• อ่อนไหวต่อคำวิจารณ์ หรือการปฏิเสธ\n", fontSize = 16.sp )
        Text(
            text ="ENFJ ในที่ทำงาน",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(text =
                    
                    "• ENFJ เป็นนักพูดชั้นยอดในที่ทำงาน และเขาเป็นคนที่สามารถโน้มน้าวคนอื่นได้อย่างน่าประหลาดใจ พวกเขามักชอบพูดและปฏิสัมพันธ์กับเพื่อนร่วมงาน ชอบทำงานที่ได้ใช้ทักษะการสื่อสารและปฏิสัมพันธ์กับผู้คนมากกว่าการทำงานที่ต้องทำคนเดียว เขาเป็นคนที่ให้แรงบันดาลใจคนอื่นได้อย่างยอดเยี่ยม \n" +

                    "• ENFJ ไม่ชอบที่ทำงานที่มีความขัดแย้ง ไม่ลงรอยกัน และสิ่งนี้ทำให้ ENFJ เครียดได้ง่าย \n" +

                    "• ENFJ เสียใจได้ง่ายเมื่อเจอคำตำหนิ หรือปฏิกิริยาเชิงลบจากเพื่อนร่วมงานได้ หากสิ่งเหล่านั้นเป็นสิ่งที่เขารัก ทุ่มเท หรือให้คุณค่ามาก\n" +

                    "• ENFJ เป็นหัวหน้าที่ให้แรงบันดาลใจลูกน้อง เขามักจะให้ความสำคัญกับความสัมพันธ์และดูแลความสัมพันธ์ระหว่างทีมได้อย่างยอดเยี่ยม\n", fontSize = 16.sp )
        Text(
            text = "วิธีการปฏิสัมพันธ์และดูแลคนที่มีบุคลิกภาพ ENFJ",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
        Text(text =

                    "ENFJ เป็นคนที่มีพลัง พูดเก่ง และมีทักษะการสื่อสารที่ดี เขามักจะให้ความสำคัญเกี่ยวกับการปฏิสัมพันธ์และการสื่อสารกับผู้คนมากที่สุดในบุคลิกภาพทั้ง 16 แบบ เขาเป็นนักสื่อสารที่ดีและเป็นนักพูดที่น่าหลงใหลมาก เขามักจะชอบพูดเกี่ยวกับสิ่งต่างๆ ที่เกี่ยวกับเรืองส่วนตัวและความสัมพันธ์ การดูแลคนที่มีบุคลิกภาพแบบ ENFJ สามารถทำได้โดย\n" +
                    "\n" +
                    "• ให้ความสนใจกับความคิดเห็นของ ENFJ โดยตั้งใจฟังและพร้อมโต้ตอบ ขณะที่เขากำลังพูด\n" +
                    "\n" +
                    "• ลองทำความเข้าใจ ENFJ เมื่อพวกเขาให้คุณค่า หรือเห็นความสำคัญเกี่ยวกับเรื่องอะไร"
            , fontSize = 16.sp

            )
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                if (routeFrom == Screen.Result.route) {
                    navController.navigate(Screen.Home.route) // กลับไปยังหน้า Home ถ้าเป็นการเรียกจากหน้า Result
                } else {
                    navController.popBackStack() // ให้ pop stack ถ้าไม่ได้เรียกจากหน้า Result
                }
            },
        ) {
            Text(
                text = "Back",
                fontSize = 20.sp
            )
        }
    }
}

@Preview
@Composable
fun PreviewMBTI() {
    val navController = rememberNavController()
    ENTJ(navController = navController)

}