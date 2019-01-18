package com.weibo.biz.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.weibo.biz.kotlin.R

class LifeCycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

        this.title = "LifeCycle"

        println("onCreate");
    }

    override fun onStart() {
        super.onStart()
        println("onStart");
    }

    override fun onResume() {
        super.onResume()
        println("onResume");
    }

    override fun onPause() {
        super.onPause()
        println("onPause");
    }

    override fun onStop() {
        super.onStop()
        println("onStop");
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart");
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy");
    }
}
