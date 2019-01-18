package com.weibo.biz.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast

class CheckBoxActivity : AppCompatActivity() {

    private var checkBox: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box)

        checkBox = findViewById(R.id.wb_checkbox0)
        checkBox?.setOnCheckedChangeListener { buttonView, isChecked ->
            Toast.makeText(this@CheckBoxActivity, if (isChecked) (buttonView?.text) else "取消选中", Toast.LENGTH_SHORT).show()
        }
    }
}
