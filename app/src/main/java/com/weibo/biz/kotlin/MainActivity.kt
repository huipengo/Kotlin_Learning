package com.weibo.biz.kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.weibo.biz.kotlin.databind.DataBindListViewActivity
import com.weibo.biz.kotlin.databind.DataBindingActivity
import com.weibo.biz.kotlin.datastorage.DataStorageActivity
import com.weibo.biz.kotlin.event.EventActivity
import com.weibo.biz.kotlin.fragment.ContainerActivity
import com.weibo.biz.kotlin.grideView.GridViewActivity
import com.weibo.biz.kotlin.jump.AActivity
import com.weibo.biz.kotlin.listview.ListViewActivity
import com.weibo.biz.kotlin.recyclerView.RecyclerViewActivity
import com.weibo.biz.kotlin.webView.WebViewActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.title = "主页"

        val button = findViewById<Button>(R.id.btn_button)
        button.setOnClickListener {
            val intent = Intent()
            //获取intent对象
            intent.setClass(this, SecondActivity::class.java)
            // 获取class是使用::反射
            startActivity(intent)
        }

        setListeners()
    }

    fun listViewClicked(view: View?) {
        val intent = Intent()
        //获取intent对象
        intent.setClass(this@MainActivity, ListViewActivity::class.java)
        // 获取class是使用::反射
        startActivity(intent)
    }

    fun grideViewClicked(view: View?) {
        val intent = Intent()
        //获取intent对象
        intent.setClass(this@MainActivity, GridViewActivity::class.java)
        // 获取class是使用::反射
        startActivity(intent)
    }

    fun webViewClicked(view: View?) {
        val intent = Intent()
        //获取intent对象
        intent.setClass(this@MainActivity, WebViewActivity::class.java)
        // 获取class是使用::反射
        startActivity(intent)
    }

    fun lifeCycleClicked(view: View?) {
        val intent = Intent()
        //获取intent对象
        intent.setClass(this@MainActivity, LifeCycleActivity::class.java)
        // 获取class是使用::反射
        startActivity(intent)
    }

    fun jumpClicked(view: View?) {
        val intent = Intent()
        //获取intent对象
        intent.setClass(this@MainActivity, AActivity::class.java)
        // 获取class是使用::反射
        startActivity(intent)
    }

    private fun setListeners() {
        val onClick: MyOnClick = MyOnClick()

        val btn_dataBinding = findViewById<Button>(R.id.btn_dataBinding)
        btn_dataBinding.setOnClickListener(onClick)

        val btn_dataBinding_list = findViewById<Button>(R.id.btn_dataBinding_list)
        btn_dataBinding_list.setOnClickListener(onClick)

        val btn_recyclerView = findViewById<Button>(R.id.btn_recyclerView)
        btn_recyclerView.setOnClickListener(onClick)

        val btn_fragment = findViewById<Button>(R.id.btn_fragment)
        btn_fragment.setOnClickListener(onClick)

        val btn_event = findViewById<Button>(R.id.btn_event)
        btn_event.setOnClickListener(onClick)

        val btn_data = findViewById<Button>(R.id.btn_data)
        btn_data.setOnClickListener(onClick)

        val btn_radio = findViewById<Button>(R.id.btn_radio)
        btn_radio.setOnClickListener(onClick)

        val btn_checkbox = findViewById<Button>(R.id.btn_checkbox)
        btn_checkbox.setOnClickListener(onClick)

        val btn_popupwindow = findViewById<Button>(R.id.btn_popupwindow)
        btn_popupwindow.setOnClickListener(onClick)
    }

    inner class MyOnClick : View.OnClickListener {
        override fun onClick(v: View?) {
            val intent: Intent? = Intent()
            when (v?.id) {

                R.id.btn_dataBinding -> {
                    intent?.setClass(this@MainActivity, DataBindingActivity::class.java)
                }
                R.id.btn_dataBinding_list -> {
                    intent?.setClass(this@MainActivity, DataBindListViewActivity::class.java)
                }
                R.id.btn_recyclerView -> {
                    intent?.setClass(this@MainActivity, RecyclerViewActivity::class.java)
                }
                R.id.btn_fragment -> {
                    intent?.setClass(this@MainActivity, ContainerActivity::class.java)
                }
                R.id.btn_event -> {
                    intent?.setClass(this@MainActivity, EventActivity::class.java)
                }
                R.id.btn_data -> {
                    intent?.setClass(this@MainActivity, DataStorageActivity::class.java)
                }
                R.id.btn_radio -> {
                    intent?.setClass(this@MainActivity, RadioButtonActivity::class.java)
                }
                R.id.btn_checkbox -> {
                    intent?.setClass(this@MainActivity, CheckBoxActivity::class.java)
                }
                R.id.btn_popupwindow -> {
                    intent?.setClass(this@MainActivity, PopupWindowActivity::class.java)
                }
            }
            // 获取class是使用::反射
            startActivity(intent)
        }
    }
}
