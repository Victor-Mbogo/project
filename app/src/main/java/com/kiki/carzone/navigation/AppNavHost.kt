package com.kiki.carzone.navigation


//import com.kiki.carZone.screens.addcars.ExploreScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kiki.carzone.screens.explore.ProductListScreen
import com.kiki.carzone.screens.addcars.AddProductScreen
import com.kiki.carzone.screens.favourite.FavouriteScreen
import com.kiki.carzone.screens.homepage.HomePage
//import com.kiki.carzone.screens.login.LoginScreen
//import com.kiki.carzone.screens.products.AddProductsScreen
//import com.kiki.carzone.screens.splashscreen.SplashScreen
import com.kiki.carzone.screens.start.StartScreen
import com.kiki.carzone.screens.users.ProfileScreen
import net.kiki.ui.SplashScreen

//import com.kiki.carzone.screens.products.ViewProductsScreen
//import com.kiki.carzone.screens.signup.SignUpScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = SPLASH_URL
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier){
//        composable(LOGIN_URL){
//            LoginScreen(navController = navController)
//        }
//        composable(SIGNUP_URL){
//            SignUpScreen(navController = navController)
//        }

        composable(ADD_PRODUCTS_URL){
            AddProductsScreen(navController = navController)
        }
        composable(ROUTE_VIEW_PROD){
            ViewProductsScreen(navController = navController)
        }
        composable(START_URL){
            StartScreen(navController = navController, )
        }
        composable(SPLASH_URL){
            SplashScreen(navController = navController, )
        }
        composable(ROUTE_HOME){
            HomePage(navController = navController, )
        }
        composable(ADDPRODUCTS_URL){
            AddProductScreen(navController = navController) {
            }
        }
        composable(ROUTE_VIEW_PROD){
            FavouriteScreen(navController = navController, )
        }
        composable(PROFILE_URL) {
            ProfileScreen(navController = navController,)
        }

        composable(EXPLORE_URL) {
            ProductListScreen(navController = navController, products = listOf())
        }




//        composable("productDetail/{productId}") { backStackEntry ->
//            val productId = backStackEntry.arguments?.getString("productId") ?: ""
//            ProductDetailScreen(navController, productId)
//            }





    }
}

@Composable
fun ViewProductsScreen(navController: NavHostController) {

}

@Composable
fun AddProductsScreen(navController: NavHostController) {

}
