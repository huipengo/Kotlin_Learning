package com.weibo.biz.kotlin.datastorage

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.weibo.biz.kotlin.R
import kotlinx.android.synthetic.main.activity_sharedpreferences.*

class SharedpreferencesActivity : AppCompatActivity() {

    private var edit_text: EditText? = null
    private var save_btn: Button? = null
    private var show_btn: Button? = null
    private var show_text: TextView? = null

    private var wsharedPreferences: SharedPreferences? = null
    private var wEditor: SharedPreferences.Editor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharedpreferences)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        edit_text = findViewById(R.id.wb_et_name)
        save_btn = findViewById(R.id.wb_btn_save)
        show_btn = findViewById(R.id.wb_btn_show)
        show_text = findViewById(R.id.wb_show_text)

        save_btn?.setOnClickListener {
            wEditor?.putString("name", edit_text?.text.toString())
            wEditor?.apply()
        }

        show_btn?.setOnClickListener {
            show_text?.text = wsharedPreferences?.getString("name", "")
        }

        wsharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE)
        wEditor = wsharedPreferences?.edit()
    }

}
