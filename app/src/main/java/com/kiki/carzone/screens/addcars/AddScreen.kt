package com.kiki.carzone.screens.addcars

import android.annotation.SuppressLint
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.kiki.carzone.navigation.ROUTE_HOME
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.util.UUID

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(navController: NavController, onProductAdded: () -> Unit) {
    var productName by remember { mutableStateOf("") }
    var productDescription by remember { mutableStateOf("") }
    var productMileage by remember { mutableStateOf("") }
    var productYear by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productNo by remember { mutableStateOf("") }
    var productImageUri by remember { mutableStateOf<Uri?>(null) }

    // Track if fields are empty
    var productNameError by remember { mutableStateOf(false) }
    var productDescriptionError by remember { mutableStateOf(false) }
    var productMileageError by remember { mutableStateOf(false) }
    var productYearError by remember { mutableStateOf(false) }
    var productPriceError by remember { mutableStateOf(false) }
    var productNoError by remember { mutableStateOf(false) }
    var productImageError by remember { mutableStateOf(false) }

    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            productImageUri = it
        }
    }

    androidx.compose.material.Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    androidx.compose.material.Text(
                        text = "Add Products",
                        fontSize = 30.sp,
                        color = Color.White
                    )
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
                    containerColor = Color(0xffF94806),
                    titleContentColor = Color.White,
                )
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xffFFDACA))
            ) {
                item {
                    if (productImageUri != null) {
                        // Display selected image
                        Image(
                            painter = rememberImagePainter(productImageUri), // Using rememberImagePainter with Uri
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                        )
                    } else {
                        // Display placeholder if no image selected
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            androidx.compose.material.Text(
                                "No Image Selected",
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    androidx.compose.material.Button(onClick = { launcher.launch("image/*") }) {
                        androidx.compose.material.Text("Select Image")
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    androidx.compose.material.TextField(
                        value = productName,
                        onValueChange = { productName = it },
                        label = { androidx.compose.material.Text("Make") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    androidx.compose.material.TextField(
                        value = productDescription,
                        onValueChange = { productDescription = it },
                        label = { androidx.compose.material.Text("Model & variant") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    androidx.compose.material.TextField(
                        value = productMileage,
                        onValueChange = { productMileage = it },
                        label = { androidx.compose.material.Text("mileage") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        keyboardActions = KeyboardActions(onDone = { /* Handle Done action */ }),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    androidx.compose.material.TextField(
                        value = productYear,
                        onValueChange = { productYear = it },
                        label = { androidx.compose.material.Text("Year") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        keyboardActions = KeyboardActions(onDone = { /* Handle Done action */ }),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    androidx.compose.material.TextField(
                        value = productPrice,
                        onValueChange = { productPrice = it },
                        label = { androidx.compose.material.Text("Price") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        keyboardActions = KeyboardActions(onDone = { /* Handle Done action */ }),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Spacer(modifier = Modifier.height(16.dp))
                    androidx.compose.material.TextField(
                        value = productNo,
                        onValueChange = { productNo = it },
                        label = { androidx.compose.material.Text("Phone number") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        keyboardActions = KeyboardActions(onDone = { /* Handle Done action */ }),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    if (productNameError) {
                        androidx.compose.material.Text(
                            "Make of the car is required",
                            color = Color.Red
                        )
                    }
                    if (productDescriptionError) {
                        androidx.compose.material.Text(
                            "Model & Variant is required",
                            color = Color.Red
                        )
                    }
                    if (productMileageError) {
                        androidx.compose.material.Text("Mileage is required", color = Color.Red)
                    }
                    if (productYearError) {
                        androidx.compose.material.Text("Year is required", color = Color.Red)
                    }
                    if (productPriceError) {
                        androidx.compose.material.Text("Price is required", color = Color.Red)
                    }
                    if (productNoError) {
                        androidx.compose.material.Text("Your phone Number is required", color = Color.Red)
                    }
                    if (productImageError) {
                        androidx.compose.material.Text(
                            "Product Image is required",
                            color = Color.Red
                        )
                    }

                    // Button to add product
                    androidx.compose.material.Button(
                        onClick = {
                            // Reset error flags
                            productNameError = productName.isBlank()
                            productDescriptionError = productDescription.isBlank()
                            productMileageError = productMileage.isBlank()
                            productNoError =productNo.isBlank()
                            productImageError = productImageUri == null

                            // Add product if all fields are filled
                            if (!productNameError && !productDescriptionError && !productMileageError && !productImageError) {
                                addProductToFirestore(
                                    navController,
                                    onProductAdded,
                                    productName,
                                    productDescription,
                                    productMileage.toDouble(),
                                    productNo.toDouble(),
                                    productImageUri
                                )
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        androidx.compose.material.Text("Add Product")
                    }
                }
            }
        }
    )
}

fun addProductToFirestore(navController: NavController, onProductAdded: () -> Unit,
                          productName: String,
                          productDescription: String,
                          productMileage: Double,
                          productPrice: Double,
                          productImageUri1: Uri?) {

}

private fun addProductToFirestore(
    navController: NavController,
    onProductAdded: () -> Unit,
    productName: String,
    productDescription: String,
    productMileage: Double,
    productPrice: Double,
    productYear: Int,
//    productImageUri1: Uri?,
    productImageUri: Uri?
) {
    if (productName.isEmpty() || productDescription.isEmpty() || productMileage.isNaN() || productImageUri == null) {
        // Validate input fields
        return
    }

    val productId = UUID.randomUUID().toString()

    val firestore = Firebase.firestore
    val productData = hashMapOf(
        "name" to productName,
        "description" to productDescription,
        "price" to productPrice,
        "mileage" to productMileage,
        "imageUrl" to ""
    )

    firestore.collection("products").document(productId)
        .set(productData)
        .addOnSuccessListener {
            uploadImageToStorage(productId, productImageUri) { imageUrl ->
                firestore.collection("products").document(productId)
                    .update("imageUrl", imageUrl)
                    .addOnSuccessListener {
                        // Display toast message
                        Toast.makeText(
                            navController.context,
                            "Product added successfully!",
                            Toast.LENGTH_SHORT
                        ).show()

                        // Navigate to another screen
                        navController.navigate(ROUTE_HOME)

                        // Invoke the onProductAdded callback
                        onProductAdded()
                    }
                    .addOnFailureListener { e ->
                        // Handle error updating product document
                    }
            }
        }
        .addOnFailureListener { e ->
            // Handle error adding product to Firestore
        }
}

private fun uploadImageToStorage(productId: String, imageUri: Uri?, onSuccess: (String) -> Unit) {
    if (imageUri == null) {
        onSuccess("")
        return
    }

    val storageRef = Firebase.storage.reference
    val imagesRef = storageRef.child("products/$productId.jpg")

    imagesRef.putFile(imageUri)
        .addOnSuccessListener { taskSnapshot ->
            imagesRef.downloadUrl
                .addOnSuccessListener { uri ->
                    onSuccess(uri.toString())
                }
                .addOnFailureListener {
                    // Handle failure to get download URL
                }
        }
        .addOnFailureListener {
            // Handle failure to upload image
        }
}
