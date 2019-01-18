package com.weibo.biz.kotlin.handle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Button
import android.widget.Toast
import com.weibo.biz.kotlin.R

class HandleActivity : AppCompatActivity() {

    private lateinit var handler: Handler
    private lateinit var thread :Thread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handle)

//        handler = Handler()
//        handler?.postDelayed(Runnable {
//            Toast.makeText(this@HandleActivity, "延时执行", Toast.LENGTH_SHORT).show()
//        }, 3000)

        handler = object : Handler() {
            override fun handleMessage(msg: Message?) {
                super.handleMessage(msg)
                if (msg?.what == 0) {
                    Toast.makeText(applicationContext,"子线程消息",Toast.LENGTH_LONG).show()
                }
            }
        }

        myTherad()
        thread?.start()
    }

    private fun myTherad() {
        thread = Thread(Runnable {
            kotlin.run {
                var message = Message()
                message.what = 0
                handler.sendMessage(message)
            }
        })
    }
}

/**
主线程调用
myTherad()
thread?.start()
 */
