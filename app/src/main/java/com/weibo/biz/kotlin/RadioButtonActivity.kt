package com.weibo.biz.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class RadioButtonActivity : AppCompatActivity() {

    private var mgr0: RadioGroup? = null
    private var mgr1: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)

        mgr0 = findViewById(R.id.wb_rg_0)
        mgr1 = findViewById(R.id.wb_rg_1)

        radioChecked(radioGroup = mgr0!!)
        radioChecked(radioGroup = mgr1!!)
    }

    private fun radioChecked(radioGroup: RadioGroup) {
        radioGroup?.setOnCheckedChangeListener { group, checkedId ->
            val radioButton: RadioButton = findViewById(checkedId)
            Toast.makeText(this@RadioButtonActivity, radioButton.text, Toast.LENGTH_SHORT).show()
        }
    }
}
