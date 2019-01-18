package com.weibo.biz.kotlin.event

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.weibo.biz.kotlin.R
import com.weibo.biz.kotlin.handle.HandleActivity
import okhttp3.internal.Internal

class EventActivity : AppCompatActivity() /*, View.OnClickListener*/ {
    private var event_btn: Button? = null

    private var btn_handle: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        event_btn = findViewById(R.id.wb_event_btn)
//        event_btn.setOnClickListener {
//
//        }

        //event_btn.setOnClickListener(OnClick())

//        event_btn?.setOnClickListener(this@EventActivity)

        event_btn?.setOnClickListener(MyClickListener(this))

        btn_handle = findViewById(R.id.wb_btn_handle)
        btn_handle?.setOnClickListener {
            val intent: Intent = Intent()
            intent.setClass(this@EventActivity, HandleActivity::class.java)
            startActivity(intent)
        }
    }

//    override fun onClick(v: View?) {
//        Toast.makeText(this@EventActivity, "Clicked Me", Toast.LENGTH_SHORT).show()
//    }

//    inner class OnClick : View.OnClickListener {
//        override fun onClick(v: View?) {
//            when (v?.id) {
//                R.id.wb_event_btn -> {
//                    Toast.makeText(this@EventActivity, "Clicked Me", Toast.LENGTH_SHORT)
//                }
//            }
//        }
//    }
}
