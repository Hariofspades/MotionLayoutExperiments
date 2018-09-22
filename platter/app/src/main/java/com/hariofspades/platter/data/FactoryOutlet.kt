package com.hariofspades.platter.data

import com.hariofspades.platter.model.Recipes

object FactoryOutlet {

    fun makeRecipeList(): List<Recipes> {
        return listOf(

                Recipes(
                        url = "https://image.ibb.co/n4JqCz/Featured_Food_2x_500x550_Taco_Salad.png",
                        name = "Taco Salad",
                        price = "₹120",
                        isVeg = true,
                        calories = "141 Kcal",
                        ingredients = "Tomatos, Cheese, Lettuce,\n Chips, Tacos, Dessing"
                ),

                Recipes(
                        url = "https://image.ibb.co/h5vsQK/pork.png",
                        name = "Pork Schnitzel",
                        price = "₹220",
                        isVeg = false,
                        calories = "287 Kcal",
                        ingredients = "Pork, Almonds, Eggs, Lemons,\n Garlic, Pepper, Rosemary"
                ),

                Recipes(
                        url = "https://image.ibb.co/hpie5K/chicken.png",
                        name = "Grilled Chicken",
                        price = "₹120",
                        isVeg = false,
                        calories = "226 Kcal",
                        ingredients = "Chicken Breast, Grill Sauce,\n Dressing"
                )
        )
    }

}