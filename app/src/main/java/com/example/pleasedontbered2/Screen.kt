package com.example.pleasedontbered2

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Score
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector


sealed class Screen (val route: String, val name:String, val icon: ImageVector){

    object Login: Screen(route = "login_screen", name="Login", icon = Icons.Default.Login)
    object Register: Screen(route = "register_screen", name="Register", icon = Icons.Default.Login)


    object Home : Screen(route = "home_screen", name = "Home", icon = Icons.Default.Home)
    object Setting : Screen(route = "Setting", name = "Setting", icon = Icons.Default.Settings)
    object History : Screen(route = "History", name = "History", icon = Icons.Default.History)
    object Type : Screen(route = "AllType", name = "AllType", icon = Icons.Default.Person)
    object ComunityScreen : Screen(route = "ComunityScreen", name = "ComunityScreen", icon = Icons.Default.Newspaper)
    object EditProfileScreen : Screen(route = "EditProfileScreen", name = "EditProfileScreen", icon = Icons.Default.Newspaper)

    object PostScreen : Screen(route = "Post", name = "Post", icon = Icons.Default.Newspaper)
    object EditPost : Screen(route = "EditPost", name = "EditPost", icon = Icons.Default.Newspaper)

    //Quiz route
    object AreYouReady : Screen(route = "AreYouReady", name = "AreYouReady", icon = Icons.Default.Article)
    object QuizTest : Screen(route = "quiz_screen_test", name = "quiz_test", icon = Icons.Default.Article)
    object QuizTest12 : Screen(route = "quiz_screen_test12", name = "quiz_test12", icon = Icons.Default.Article)
    object QuizTest13 : Screen(route = "quiz_screen_test13", name = "quiz_test13", icon = Icons.Default.Article)

    object QuizTest2 : Screen(route = "quiz_screen_test2", name = "quiz_test2", icon = Icons.Default.Article)
    object QuizTest22 : Screen(route = "quiz_screen_test22", name = "quiz_test22", icon = Icons.Default.Article)
    object QuizTest23 : Screen(route = "quiz_screen_test23", name = "quiz_test23", icon = Icons.Default.Article)

    object QuizTest3 : Screen(route = "quiz_screen_test3", name = "quiz_test3", icon = Icons.Default.Article)
    object QuizTest32 : Screen(route = "quiz_screen_test32", name = "quiz_test32", icon = Icons.Default.Article)
    object QuizTest33 : Screen(route = "quiz_screen_test33", name = "quiz_test33", icon = Icons.Default.Article)

    object QuizTest4 : Screen(route = "quiz_screen_test4", name = "quiz_test4", icon = Icons.Default.Article)
    object QuizTest42 : Screen(route = "quiz_screen_test42", name = "quiz_test42", icon = Icons.Default.Article)
    object QuizTest43 : Screen(route = "quiz_screen_test43", name = "quiz_test43", icon = Icons.Default.Article)

    object Result : Screen(route = "Result", name = "Result", icon = Icons.Default.Score)

    //mbti
    object ENFJ : Screen(route = "ENFJ", name = "ENFJ", icon = Icons.Default.Person)
    object ENTJ : Screen(route = "ENTJ", name = "ENTJ", icon = Icons.Default.Person)
    object ENTP : Screen(route = "ENTP", name = "ENTP", icon = Icons.Default.Person)
    object ENFP : Screen(route = "ENFP", name = "ENFP", icon = Icons.Default.Person)
    object ESFP : Screen(route = "ESFP", name = "ESFP", icon = Icons.Default.Person)
    object ESFJ : Screen(route = "ESFJ", name = "ESFJ", icon = Icons.Default.Person)
    object ESTP : Screen(route = "ESTP", name = "ESTP", icon = Icons.Default.Person)
    object ESTJ : Screen(route = "ESTJ", name = "ESTJ", icon = Icons.Default.Person)
    object INFJ : Screen(route = "INFJ", name = "INFJ", icon = Icons.Default.Person)
    object INTJ : Screen(route = "INTJ", name = "INTJ", icon = Icons.Default.Person)
    object INTP : Screen(route = "INTP", name = "INTP", icon = Icons.Default.Person)
    object INFP : Screen(route = "INFP", name = "INFP", icon = Icons.Default.Person)
    object ISFP : Screen(route = "ISFP", name = "ISFP", icon = Icons.Default.Person)
    object ISFJ : Screen(route = "ISFJ", name = "ISFJ", icon = Icons.Default.Person)
    object ISTP : Screen(route = "ISTP", name = "ISTP", icon = Icons.Default.Person)
    object ISTJ : Screen(route = "ISTJ", name = "ISTJ", icon = Icons.Default.Person)

}