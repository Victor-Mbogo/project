package com.kiki.carzone.screens.homepage



import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kiki.carzone.navigation.PRODUCTLIST_URL
import com.kiki.carzone.R
import com.kiki.carzone.navigation.ADD_PRODUCTS_URL
import com.kiki.carzone.ui.theme.CarZoneTheme
//import com.kiki.carzone.ui.theme.CarentTheme
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController:NavHostController) {
    val drawerItem = listOf(
        DrawerItems(Icons.Default.Face,"Profile",0 , false),
        DrawerItems(Icons.Default.Search,"Search",0 , false),
        DrawerItems(Icons.Default.Notifications,"Inbox",0 , false),
        DrawerItems(Icons.Default.Settings,"Settings",0 , false),
    )

    var selectedItem by remember{
        mutableStateOf(drawerItem[0])
    }


    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
//
//
    var selected by remember { mutableIntStateOf(0) }
    Scaffold(
        bottomBar = {
            NavigationBar {
                com.kiki.carzone.screens.homepage.bottomNavItems.forEachIndexed { index, bottomNavItem ->
                    NavigationBarItem(
                        selected = index == selected,
                        onClick = {
                            selected = index
                            navController.navigate(bottomNavItem.route)
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (bottomNavItem.badges != 0) {
                                        Badge {
                                            Text(text = bottomNavItem.badges.toString())
                                        }
                                    } else if (bottomNavItem.hasNews) {
                                        Badge()
                                    }
                                }
                            ) {
                                Icon(imageVector =
                                if (index == selected)
                                    bottomNavItem.selectedIcon
                                else
                                    bottomNavItem.unselectedIcon,
                                    contentDescription = bottomNavItem.title)
                            }

                        },
                        label = {
                            Text(text = bottomNavItem.title)
                        })
                }
            }
        },




        content =
        @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
        @Composable{
            Scaffold(modifier = Modifier.fillMaxSize(),


                ) {it ->


//                ModalNavigationDrawer(drawerContent = {
//                    ModalDrawerSheet {
//                        Column(modifier = Modifier.fillMaxSize(),
//                            verticalArrangement = Arrangement.spacedBy(12.dp)){
//
//
//                            drawerItem.forEach{
//                                NavigationDrawerItem(label = { Text(it.text) },
//                                    selected = it == selectedItem
//                                    , onClick = {
//                                        selectedItem = it
//                                        scope.launch { drawerState.close() }
//
//                                    },
//                                    modifier = Modifier.padding(horizontal = 16.dp),
//                                    icon = {
//                                        Icon(imageVector = it.icon, contentDescription = it.text)
//                                    },
//                                    badge = {
//                                        if (it.hasBadge)
//                                            BadgedBox(badge = {
//                                                Badge{
//                                                    Text(it.badgeCount.toString())
//                                                }
//                                            }) {
//
//                                            }
//                                    }
//
//
//                                )
//                            }
//
//
//
//
//                        }
//
//
//
//                    }
//
//                }) {
//
//
//
//


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(if (isSystemInDarkTheme()) Color.DarkGray else Color.White)
                ) {Card(modifier = Modifier
                    .fillMaxWidth()
//        .background(Color.Blue)
//        .padding(15.dp)
                    .clip(
                        RoundedCornerShape(0.dp, 0.dp, 20.dp, 20.dp)
                    ),
                    colors = CardDefaults.cardColors(Color.Cyan),
                    shape = RoundedCornerShape(0.dp,0.dp,20.dp,20.dp)
                )





                {









                    Spacer(modifier = Modifier.height(17.dp))

                    Box(modifier = Modifier
                        .fillMaxWidth()
//        .background(Color.Blue)
                        .padding(15.dp)
                        .clip(RoundedCornerShape(50.dp))
                    ) {



                        Icon(imageVector = Icons.Default.LocationOn, contentDescription = "",
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .clickable {
                                    navController.navigate(PRODUCTLIST_URL)
                                },
//            if (isSystemInDarkTheme())Color.White else Color.Black


                        )
                        Row(modifier = Modifier.fillMaxWidth()) {

                            Text(
                                text = "",

                                )
//            Spacer(modifier= Modifier.width(250.dp))
//            Icon(imageVector = Icons.Default.Notifications, contentDescription = "",
//                modifier = Modifier.align(Alignment.BottomStart)
//            )

                        }

                        Icon(
                            imageVector = Icons.Default.Notifications, contentDescription = "",
                            modifier = Modifier.align(Alignment.TopEnd)
//                 .background(if (isSystemInDarkTheme()) Color.White else Color.Black)
//            ,if (isSystemInDarkTheme())Color.White else Color.Black
                            , Color.Black

                        )
                    }

                    var text by remember{ mutableStateOf("") }
                    var active by remember{ mutableStateOf(false) }


                    SearchBar(

                        query = text,
                        onQueryChange = {text = it},
                        onSearch ={active = false} ,
                        active = active ,
                        onActiveChange = {active = it},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        placeholder = {
                            Text(text = "Nairobi,Kenya")
                        },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "")

                        },

                        trailingIcon = {
                            if (active)
                                Icon(
                                    modifier = Modifier.clickable {
                                        if (text.isNotEmpty()) {
                                            text = ""
                                        } else {
                                            active = false

                                        }

                                    },


                                    imageVector = Icons.Default.Close, contentDescription = ""
                                )


                        }

                    ) {

                    }



                    Card(modifier = Modifier
                        .align(Alignment.End)
                        .padding(0.dp, 5.dp, 8.dp, 8.dp)
                        .size(40.dp)


                        ,colors = CardDefaults.cardColors(Color.White),
                        shape = RoundedCornerShape(5.dp),

                        ){

                        Icon(imageVector = Icons.Default.Menu, contentDescription = "",
                            modifier = Modifier
                                .size(40.dp)
                                .clickable {
                                    navController.navigate(ADD_PRODUCTS_URL)


                                },
                            Color.Cyan
                        )
                    }


                }
                    LazyColumn {
                        item {

                            Row(modifier = Modifier.padding(15.dp)) {
                                Text(
                                    text = "Brands",
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 20.sp
                                )
                                Spacer(modifier = Modifier.width(260.dp))
                                Text(
                                    text = "see all",
                                    color = Color.Blue
                                )
                            }

















                            Row(modifier = Modifier.padding(15.dp)) {
                                Text(
                                    text = "Popular",
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 20.sp
                                )
                                Spacer(modifier = Modifier.width(253.dp))
                                Text(
                                    text = "see all",
                                    color = Color.Blue
                                )
                            }


                            Card (modifier= Modifier
                                .fillMaxWidth()
                                .padding(10.dp, 0.dp, 10.dp, 0.dp),
                                elevation = CardDefaults.cardElevation(10.dp),
                                colors = CardDefaults.cardColors(if (isSystemInDarkTheme())Color.LightGray else Color.White)) {
                                Card (modifier = Modifier
                                    .height(250.dp)

                                    .width(362.dp)
                                    .padding(10.dp, 10.dp, 0.dp, 0.dp)) {
                                    Image(
                                        painter = painterResource(id = R.drawable.wat),
                                        contentDescription = "",
                                        modifier = Modifier.fillMaxSize(),

                                        )
                                }


                                Row(modifier = Modifier.padding(15.dp)) {
                                    Text(
                                        text = "Hyundai verna",
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 20.sp
                                    )
//                           Spacer(modifier = Modifier.width(253.dp))
//                           Text(
//                               text = "see all",
//                               color = Color.Blue
//                           )
                                }

                                Row {
                                    Text("Manual")
                                    Spacer(modifier = Modifier.width(80.dp))
                                    Text("Petrol")
                                    Spacer(modifier = Modifier.width(80.dp))
                                    Text("5 Seater")
                                }

                            }

                            Spacer(modifier = Modifier.height(10.dp))



                            Card (modifier= Modifier
                                .fillMaxWidth()
                                .padding(10.dp, 0.dp, 10.dp, 0.dp),
                                elevation = CardDefaults.cardElevation(10.dp),
                                colors = CardDefaults.cardColors(if (isSystemInDarkTheme())Color.LightGray else Color.White)) {
                                Card (modifier = Modifier
                                    .height(250.dp)

                                    .width(362.dp)
                                    .padding(10.dp, 10.dp, 0.dp, 0.dp)) {
                                    Image(
                                        painter = painterResource(id =com.kiki.carzone.R.drawable.wat),
                                        contentDescription = "",
                                        modifier = Modifier.fillMaxSize(),

                                        )
                                }


                                Row(modifier = Modifier.padding(15.dp)) {
                                    Text(
                                        text = "Hyundai verna",
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 20.sp
                                    )
//                           Spacer(modifier = Modifier.width(253.dp))
//                           Text(
//                               text = "see all",
//                               color = Color.Blue
//                           )
                                }

                                Row {
                                    Text("Manual")
                                    Spacer(modifier = Modifier.width(80.dp))
                                    Text("Petrol")
                                    Spacer(modifier = Modifier.width(80.dp))
                                    Text("5 Seater")
                                }

                            }

                            Spacer(modifier = Modifier.height(10.dp))



                            Card (modifier= Modifier
                                .fillMaxWidth()
                                .padding(10.dp, 0.dp, 10.dp, 0.dp),
                                elevation = CardDefaults.cardElevation(10.dp),
                                colors = CardDefaults.cardColors(if (isSystemInDarkTheme())Color.LightGray else Color.White)) {
                                Card (modifier = Modifier
                                    .height(250.dp)

                                    .width(362.dp)
                                    .padding(10.dp, 10.dp, 0.dp, 0.dp)) {
                                    Image(
                                        painter = painterResource(id =com.kiki.carzone.R.drawable.wat),
                                        contentDescription = "",
                                        modifier = Modifier.fillMaxSize(),

                                        )
                                }


                                Row(modifier = Modifier.padding(15.dp)) {
                                    Text(
                                        text = "Hyundai verna",
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 20.sp
                                    )
//                           Spacer(modifier = Modifier.width(253.dp))
//                           Text(
//                               text = "see all",
//                               color = Color.Blue
//                           )
                                }

                                Row {
                                    Text("Manual")
                                    Spacer(modifier = Modifier.width(80.dp))
                                    Text("Petrol")
                                    Spacer(modifier = Modifier.width(80.dp))
                                    Text("5 Seater")
                                }

                            }

                            Spacer(modifier = Modifier.height(10.dp))



                            Card (modifier= Modifier
                                .fillMaxWidth()
                                .padding(10.dp, 0.dp, 10.dp, 0.dp),
                                colors = CardDefaults.cardColors(if (isSystemInDarkTheme())Color.LightGray else Color.White),
                                elevation = CardDefaults.cardElevation(10.dp)
                            ) {
                                Card (modifier = Modifier
                                    .height(250.dp)

                                    .width(362.dp)
                                    .padding(10.dp, 10.dp, 0.dp, 0.dp)) {
                                    Image(
                                        painter = painterResource(id =com.kiki.carzone.R.drawable.wat),
                                        contentDescription = "",
                                        modifier = Modifier.fillMaxSize(),

                                        )
                                }


                                Row(modifier = Modifier.padding(15.dp)) {
                                    Text(
                                        text = "Hyundai verna",
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 20.sp
                                    )
//                           Spacer(modifier = Modifier.width(253.dp))
//                           Text(
//                               text = "see all",
//                               color = Color.Blue
//                           )
                                }

                                Row {
                                    Text("Manual")
                                    Spacer(modifier = Modifier.width(80.dp))
                                    Text("Petrol")
                                    Spacer(modifier = Modifier.width(80.dp))
                                    Text("5 Seater")
                                }

                            }














                        }
                    }



                    Text(
                        "Home page", color = Color.Black
                    )
                }


            }

        } )


}


val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="homepage",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Explore",
        route="explore",
        selectedIcon=Icons.Filled.Search ,
        unselectedIcon=Icons.Outlined.Search,
        hasNews = true,
        badges=5
    ),


    BottomNavItem(
        title = "Favourite",
        route="favourite",
        selectedIcon=Icons.Filled.Favorite,
        unselectedIcon=Icons.Outlined.Favorite,
        hasNews = true,
        badges=5
    ),

    BottomNavItem(
        title = "Profile",
        route="profile",
        selectedIcon=Icons.Filled.Face,
        unselectedIcon=Icons.Outlined.Face,
        hasNews = true,
        badges=1
    ),


    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon :ImageVector,
    val hasNews :Boolean,
    val badges :Int
)



@Composable
@Preview(showBackground = true)
fun HomePagePreview(){
    CarZoneTheme {
        HomePage(navController = rememberNavController())
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavDrawer(){
    val drawerItem = listOf(
        DrawerItems(Icons.Default.Face,"Profile",0 , false),
        DrawerItems(Icons.Default.Search,"Search",0 , false),
        DrawerItems(Icons.Default.Notifications,"Inbox",0 , false),
        DrawerItems(Icons.Default.Settings,"Settings",0 , false),
    )

    var selectedItem by remember{
        mutableStateOf(drawerItem[0])
    }


    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()


    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)){


                drawerItem.forEach{
                    NavigationDrawerItem(label = { Text(it.text) },
                        selected = it == selectedItem
                        , onClick = {
                            selectedItem = it
                            scope.launch { drawerState.close() }

                        },
                        modifier = Modifier.padding(horizontal = 16.dp),
                        icon = {
                            Icon(imageVector = it.icon, contentDescription = it.text)
                        },
                        badge = {
                            if (it.hasBadge)
                                BadgedBox(badge = {
                                    Badge{
                                        Text(it.badgeCount.toString())
                                    }
                                }) {

                                }
                        }


                    )
                }




            }



        }

    }) {

    }
}









data class DrawerItems(

    val icon : ImageVector,
    val text : String,
    val badgeCount: Int,
    val hasBadge : Boolean,


    )