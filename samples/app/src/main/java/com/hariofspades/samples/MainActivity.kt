package com.hariofspades.samples

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.GenericDeclaration

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickListeners()
    }

    private fun clickListeners() {

        simple.setOnClickListener {
            startActivity(Intent(this, ExampleOne::class.java))
        }
    }


}
