package com.kiki.carzone.screens.explore


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
//import coil.compose.rememberImagePainter
import com.kiki.carzone.navigation.ROUTE_HOME
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.kiki.carzone.R
import kotlinx.coroutines.tasks.await

data class Product(
    var id: String = "",
    val name: String = "",
    val description: String ="",
    val price: Double = 0.0,
    val mileage: Double =0.0,
    val year : Double = 0.0,
    val no : Int =0,
    var imageUrl: String = ""
)



@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(navController: NavController, products: List<Product>) {
    var isLoading by remember { mutableStateOf(true) }
    var productList by remember { mutableStateOf(emptyList<Product>()) }
    var displayedProductCount by remember { mutableStateOf(1) }
    var progress by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        fetchProducts { fetchedProducts ->
            productList = fetchedProducts
            isLoading = false
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Cars",fontSize = 30.sp, color = Color.White)
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(ROUTE_HOME)
                    }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            "backIcon",
                            tint = Color.White
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF92706),
                    titleContentColor = Color.White,

                    )

            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xffFFDACA))
            ) {
                if (isLoading) {
                    // Progress indicator
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(progress = progress / 100f)
                        Text(text = "Loading... $progress%", fontSize = 20.sp)
                    }
                } else {
                    if (productList.isEmpty()) {
                        // No products found
                        Text(text = "No products found")
                    } else {
                        // Products list
                        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                            items(productList.take(displayedProductCount)) { product ->
                                ProductListItem(product) {
                                    navController.navigate("productDetail/${product.id}")
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        // Load More Button
                        if (displayedProductCount < productList.size) {
                            Button(
                                colors = ButtonDefaults.buttonColors(Color.Green ),
                                onClick = { displayedProductCount += 1 },
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            ) {
                                Text(text = "Load More")
                            }
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun ProductListItem(product: Product, onItemClick: (String) -> Unit) {


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
                painter = rememberImagePainter(product.imageUrl),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),

                )

        }


        Column(modifier = Modifier.padding(15.dp))
        {
            Text(
                text = product.name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.description,
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp
            )

            Text("Mileage: ${product.mileage} km")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Price: $${product.price}")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Year: ${product.year}")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Phone: ${product.no}")
            Spacer(modifier = Modifier.height(8.dp))

        }

        Row {
//            Text("Price: ${product.price}")
//            Spacer(modifier = Modifier.width(80.dp))
//            Text("Seller phone: ${product.mileage}")
//            Spacer(modifier = Modifier.width(80.dp))
//            Text("Year of Production ${product.year}")
//            Spacer(modifier = Modifier.width(80.dp))
//            Text("Year of Production ${product.no}")
//            Spacer(modifier = Modifier.width(80.dp))

        }

    }

    Spacer(modifier = Modifier.height(10.dp))
}

private suspend fun fetchProducts(onSuccess: (List<Product>) -> Unit) {
    val firestore = Firebase.firestore
    val snapshot = firestore.collection("products").get().await()
    val productList = snapshot.documents.mapNotNull { doc ->
        val product = doc.toObject<Product>()
        product?.id = doc.id
        product
    }
    onSuccess(productList)
}

suspend fun fetchProduct(productId: String, onSuccess: (Product?) -> Unit) {
    val firestore = Firebase.firestore
    val docRef = firestore.collection("products").document(productId)
    val snapshot = docRef.get().await()
    val product = snapshot.toObject<Product>()
    onSuccess(product)
}