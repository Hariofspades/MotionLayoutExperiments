package com.hariofspades.platter.model

data class Recipes(
        val url: String,
        val name: String,
        val price: String,
        val isVeg: Boolean,
        val calories: String,
        val ingredients: String
)