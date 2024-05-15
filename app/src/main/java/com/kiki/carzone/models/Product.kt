package com.kiki.carzone.models

class Product {
    var name:String = ""
    var quantity:String = ""
    var price:String = ""
    var imageUrl:String = ""
    var mileage: String=""
    var id:String = ""

    constructor(name: String, quantity: String,mileage: String, price: String, imageUrl: String, id: String) {
        this.name = name
        this.quantity = quantity
        this.price = price
        this.mileage = mileage
        this.imageUrl = imageUrl
        this.id = id
    }



    constructor()
}