package com.kiki.carzone.screens.start


import android.annotation.SuppressLint
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
//import com.airbnb.lottie.compose.LottieAnimation
//import com.airbnb.lottie.compose.LottieCompositionSpec
//import com.airbnb.lottie.compose.LottieConstants
//import com.airbnb.lottie.compose.rememberLottieComposition
import com.kiki.carzone.R
import com.kiki.carzone.ui.theme.CarZoneTheme
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StartScreen(navController: NavHostController ){

//    val animations = listOf(
//        R.raw.loading,
//        R.raw.splo
//    )
    val titles = listOf(
        "Need a car",
        "We got you covered"
    )
    val descriptions = listOf(
        "Discover unbeatable deals on buying car all around the country",
        "Experience the best car purchase prices right at your fingertips with our app"
    )

//    val pagerState = rememberPagerState(
//        pageCount = { animations.size })
    Column(modifier= Modifier.fillMaxSize()
        .background(if (isSystemInDarkTheme()) Color.DarkGray else Color.White),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        var pagerState = null
        pagerState?.let {
            HorizontalPager(state = it,
                Modifier.wrapContentSize())
            {currentPage->
                Column(modifier = Modifier
                    .wrapContentSize()
                    .padding(26.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center)
                {
    //                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animations[currentPage]))
    //                LottieAnimation(composition = composition,
    //                    iterations = LottieConstants.IterateForever,
    //                    modifier = Modifier.size(300.dp)

    //                    progress =
    //                )
                    Text(text = titles[currentPage],
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp,
                        color = if (isSystemInDarkTheme())Color.White else Color.White)

                    Text(text = descriptions[currentPage],
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top= 45.dp),
    //                    fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = if (isSystemInDarkTheme())Color.White else Color.White)


                }


            }
        }
//        PageIndicator(
//            pageCount =animations.size,
//            currentPage = pagerState.currentPage,
//            modifier = Modifier.padding(60.dp)
//        )


    }


    var pagerState = null
    pagerState?.let {
        ButtonSection(
        pagerState = it,
        navController = navController
    )
    }




}

@OptIn( ExperimentalFoundationApi::class)
@Composable
fun ButtonSection(pagerState: PagerState, navController: NavHostController) {
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp)){
        if(pagerState.currentPage!= 1){
            Text(text = "Next",
                color = if (isSystemInDarkTheme())Color.White else Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clickable {

                        scope.launch {
                            val nextPage = pagerState.currentPage +1
                            pagerState.scrollToPage(nextPage)
                        }

                    },
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold)
        }else{
            OutlinedButton(onClick = {
                navController.popBackStack()
                navController.navigate("homepage")
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                colors = ButtonDefaults.buttonColors(Color.LightGray)) {
                Text(text = "Get Started",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold)

            }
        }
    }

}

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier) {

    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
    ){
        repeat(pageCount){
            Indicator(isSelecte = it == currentPage)
        }

    }




}

@Composable
fun Indicator(isSelecte: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelecte) 35.dp else 15.dp, label = "")
    Box(
        modifier = Modifier
            .padding(2.dp)
            .height(15.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(if (isSelecte) Color.Blue else Color.Cyan)
    ){

    }

}


@Composable
@Preview(showBackground = true)
fun StartScreenPreview(){
    CarZoneTheme {
        StartScreen(navController = rememberNavController() )
    }
}