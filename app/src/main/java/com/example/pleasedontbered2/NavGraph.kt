package com.example.pleasedontbered2

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable



@Composable
fun NavGraph(navController: NavHostController) {
    val viewModel = viewModel<QuestionViewModel>()
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route) {

        composable(route = Screen.Login.route) { navBackStackEntry ->
            LoginScreen(navController)
        }
        composable(route = Screen.Register.route) { navBackStackEntry ->
            RegisterScreen(navController)
        }
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.Setting.route
        ) {
            SettingScreen(navController)
        }
        composable(
            route = Screen.History.route
        ) {
            HistoryScreen(navController)
        }
        composable(
            route = Screen.ComunityScreen.route
        ) {
            ComunityScreen(navController)
        }
        composable(
            route = Screen.PostScreen.route
        ) {
            PostScreen(navController)
        }
        composable(
            route = Screen.EditPost.route
        ) {
            EditPost(navController)
        }
        composable(
            route = Screen.Type.route
        ) {
            TypeScreen(navController)
        }
        composable(
            route = Screen.EditProfileScreen.route
        ) {
            EditProfileScreen(navController)
        }
        composable(
            route = Screen.AreYouReady.route) {
            AreYouReady(navController)
        }
        composable(
            route = Screen.QuizTest.route) {
            QuestionScreenTest(navController, viewModel)
        }
        composable(
            route = Screen.QuizTest12.route) {
            QuestionScreenTest12(navController, viewModel)
        }
        composable(
            route = Screen.QuizTest13.route) {
            QuestionScreenTest13(navController, viewModel)
        }

        composable(
            route = Screen.QuizTest2.route) {
            QuestionScreenTest2(navController, viewModel)
        }
        composable(
            route = Screen.QuizTest22.route) {
            QuestionScreenTest22(navController, viewModel)
        }
        composable(
            route = Screen.QuizTest23.route) {
            QuestionScreenTest23(navController, viewModel)
        }
        composable(
            route = Screen.QuizTest3.route) {
            QuestionScreenTest3(navController, viewModel)
        }
        composable(
            route = Screen.QuizTest32.route) {
            QuestionScreenTest32(navController, viewModel)
        }
        composable(
            route = Screen.QuizTest33.route) {
            QuestionScreenTest33(navController, viewModel)
        }
        composable(
            route = Screen.QuizTest4.route) {
            QuestionScreenTest4(navController, viewModel)
        }
        composable(
            route = Screen.QuizTest42.route) {
            QuestionScreenTest42(navController, viewModel)
        }
        composable(
            route = Screen.QuizTest43.route) {
            QuestionScreenTest43(navController, viewModel)
        }

        composable(
            route = Screen.Result.route) {
            Result(navController, viewModel)
        }

        composable(
            route = Screen.ENFJ.route) {
            ENFJ(navController)
        }
        composable(
            route = Screen.ENTJ.route) {
            ENTJ(navController)
        }
        composable(
            route = Screen.ENTP.route) {
            ENTP(navController)
        }
        composable(
            route = Screen.ENFP.route) {
            ENFP(navController)
        }
        composable(
            route = Screen.ESFP.route) {
            ESFP(navController)
        }
        composable(
            route = Screen.ESFJ.route) {
            ESFJ(navController)
        }
        composable(
            route = Screen.ESTP.route) {
            ESTP(navController)
        }
        composable(
            route = Screen.ESTJ.route) {
            ESTJ(navController)
        }
        composable(
            route = Screen.INFJ.route) {
            INFJ(navController)
        }
        composable(
            route = Screen.INTJ.route) {
            INTJ(navController)
        }
        composable(
            route = Screen.INTP.route) {
            INTP(navController)
        }
        composable(
            route = Screen.INFP.route) {
            INFP(navController)
        }
        composable(
            route = Screen.ISFP.route) {
            ISFP(navController)
        }
        composable(
            route = Screen.ISFJ.route) {
            ISFJ(navController)
        }
        composable(
            route = Screen.ISTP.route) {
            ISTP(navController)
        }
        composable(
            route = Screen.ISTJ.route) {
            ISTJ(navController)
        }

    }
}