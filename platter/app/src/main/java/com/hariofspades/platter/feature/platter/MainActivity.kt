package com.hariofspades.platter.feature.platter

import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.hariofspades.platter.R
import com.hariofspades.platter.data.Cart
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private var mainFragment = MainFragment.newInstance()

    var listAdapter = CartAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.plant(Timber.DebugTree())

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, mainFragment)
                    .commitNow()
        }

        setupCart()
        clickListeners()
    }

    private fun setupCart() {
        cart_list.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, true)
            adapter = listAdapter
        }
    }

    private fun clickListeners() {
        add_to_cart.setOnClickListener {
            addToCart()
            if (Cart.cartList.size == 1) {
                motionContainer.transitionToEnd()
            }
        }
    }

    private fun addToCart() {
        Cart.addItem(Cart.currentDish)
        listAdapter.submitList(Cart.cartList)
        listAdapter.notifyDataSetChanged()
    }

}
