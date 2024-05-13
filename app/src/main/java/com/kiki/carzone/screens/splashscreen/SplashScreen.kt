package com.kiki.carzone.screens.splashscreen

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
//import com.airbnb.lottie.compose.LottieAnimation
//import com.airbnb.lottie.compose.LottieCompositionSpec
//import com.airbnb.lottie.compose.LottieConstants
//import com.airbnb.lottie.compose.rememberLottieComposition
import com.kiki.carzone.R
import com.kiki.carzone.ui.theme.CarZoneTheme
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreen(navController: NavHostController ){

    val alpha = remember{
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        alpha.animateTo(1f,
            animationSpec = tween(3000))
        delay(3000L)



        navController.popBackStack()
        navController.navigate("Start")

    }


    Column(
        modifier = Modifier.fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.DarkGray else Color.White)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LoaderAnimation(
            modifier =Modifier.size(350.dp),
            anim = R.raw.sanimate
        )
        Spacer(modifier = Modifier.height(10.dp))


        Text(text = "Your number one car purchase station",
            modifier =Modifier.alpha(alpha.value),
            fontSize=28.sp,
            fontWeight = FontWeight.Bold,
            color = if (isSystemInDarkTheme())Color.White else Color.White)







    }}

@Composable
fun LoaderAnimation(modifier: Modifier, anim: Int) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(anim))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,

//        progress = { /*TODO*/ }
    )

}


@Composable
@Preview(showBackground = true)
fun SplashScreenPreview(){
    CarZoneTheme {
        SplashScreen(navController = rememberNavController())
    }
}
//
//private fun onBoardingIsFinished():Boolean {
//    val sharedPreferences = context
//}
