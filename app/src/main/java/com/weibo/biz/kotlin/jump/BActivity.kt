package com.weibo.biz.kotlin.jump

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.weibo.biz.kotlin.R

class BActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        this.title = "BActivity"

        val textview: TextView = findViewById(R.id.wb_textview)
        val bundle: Bundle = this.intent.extras
        textview.text = "name: " + bundle.getString("name") + "\n" + "age: " + bundle.getInt("age")

        val button: Button = findViewById(R.id.wb_done)
        button.setOnClickListener {
            val intent: Intent = Intent()
            val bundle: Bundle = Bundle()
            bundle.putString("name", "我回来了~")
            intent.putExtras(bundle)
            this.setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
