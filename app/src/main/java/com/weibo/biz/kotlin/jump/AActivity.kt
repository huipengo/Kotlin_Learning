package com.weibo.biz.kotlin.jump

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.KeyEventDispatcher
import android.view.View
import android.widget.TextView
import com.weibo.biz.kotlin.R

class AActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        println("1.taskid:" + this.taskId + " , hash:" + hashCode())
        logtaskName()

        this.title = "AActivity"
    }

    fun jumpClicked(view: View?) {
        val intent = Intent(this@AActivity, BActivity::class.java)
        val bundle: Bundle = Bundle()
        bundle.putString("name" , "海贼王")
        bundle.putInt("age" , 25)
        intent.putExtras(bundle)
        // 获取class是使用::反射
//        startActivity(intent)
        startActivityForResult(intent, 110)

//        val intent = Intent()
//        //获取intent对象
//        intent.setClass(this@AActivity, BActivity::class.java)
//        // 获取class是使用::反射
//        startActivity(intent)

//        val intent = Intent()
//        //获取intent对象
//        intent.setClassName(this@AActivity, "com.weibo.biz.kotlin.jump.BActivity")
//        // 获取class是使用::反射
//        startActivity(intent)

//        val intent = Intent()
//        val componentName = ComponentName(this@AActivity, "com.weibo.biz.kotlin.jump.BActivity")
//        intent.setComponent(componentName)
//        // 获取class是使用::反射
//        startActivity(intent)

//        val intent = Intent()
//        intent.setAction("com.weibo.biz.BActivity")
//        // 获取class是使用::反射
//        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val textView: TextView = findViewById(R.id.wb_receive_text)
        val bundle: Bundle = data?.extras!!
        textView.text = "${requestCode} " + "${resultCode} " + "${bundle.getString("name")}"
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        println("2.taskid:" + this.taskId + " , hash:" + hashCode())
        logtaskName()
    }

    private fun logtaskName() {
        val info: ActivityInfo = this.packageManager.getActivityInfo(componentName, PackageManager.GET_META_DATA)
        println(info.taskAffinity)
    }
}
