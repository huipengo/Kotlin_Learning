package com.weibo.biz.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.weibo.biz.kotlin.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btn = findViewById<Button>(R.id.btn_button)
        btn.setOnClickListener{
            Toast.makeText(this@SecondActivity, "Hello Kotlin ~", Toast.LENGTH_SHORT).show()
        }
    }

    fun btnClicked(view: View?) {
        val toast = Toast.makeText(this@SecondActivity, "Hello Kotlin ~", Toast.LENGTH_SHORT)
        Toast.makeText(this@SecondActivity, "Hello Kotlin .", Toast.LENGTH_SHORT).show()
    }
}
