package com.weibo.biz.kotlin.datastorage

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.weibo.biz.kotlin.R

class DataStorageActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btn_sharedpreferences: Button
    private lateinit var btn_file: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_storage)

        btn_sharedpreferences = findViewById(R.id.wb_btn_sharedpreferences)
        btn_sharedpreferences.setOnClickListener(this@DataStorageActivity)

        btn_file = findViewById(R.id.wb_btn_file)
        btn_file.setOnClickListener {

        }
    }

    override fun onClick(v: View?) {
        var intent: Intent = Intent()
        when(v?.id) {
            R.id.wb_btn_sharedpreferences -> {
                intent.setClass(this@DataStorageActivity, SharedpreferencesActivity::class.java)
            }
            R.id.wb_btn_file -> {
                intent.setClass(this@DataStorageActivity, FileActivity::class.java)
            }
        }

        startActivity(intent)
    }
}
