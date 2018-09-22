package com.hariofspades.platter.feature.platter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.hariofspades.platter.R
import com.hariofspades.platter.data.FactoryOutlet


class RecipeAdapter(private val context: Context) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val recipes = FactoryOutlet.makeRecipeList()[position]
        val layout = LayoutInflater.from(context).inflate(R.layout.pager_view, container, false)

        layout.apply {
            findViewById<TextView>(R.id.dish_name).text = recipes.name
            findViewById<TextView>(R.id.ingredients).text = recipes.ingredients
            findViewById<TextView>(R.id.calories).text = recipes.calories
            findViewById<TextView>(R.id.price).text = recipes.price

            findViewById<ImageView>(R.id.dish_type).apply {
                if (recipes.isVeg) {
                    setColorFilter(ContextCompat.getColor(this.context,
                            android.R.color.holo_green_dark), android.graphics.PorterDuff.Mode.SRC_IN)
                } else {
                    setColorFilter(ContextCompat.getColor(this.context,
                            android.R.color.holo_red_dark), android.graphics.PorterDuff.Mode.SRC_IN)
                }
            }
        }

        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return FactoryOutlet.makeRecipeList().size
    }


}