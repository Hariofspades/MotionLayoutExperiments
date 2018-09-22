package com.hariofspades.platter.data

object Cart {

    var cartList = mutableListOf<String>()
    var currentDish: String = FactoryOutlet.makeRecipeList()[0].url

    fun addItem(url: String) {
        cartList.add(url)
    }
}