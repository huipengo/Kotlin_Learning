package com.weibo.biz.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast

class PopupWindowActivity : AppCompatActivity() {

    private var btn_pop: Button? = null
    private var popupWindow: PopupWindow? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_window)

        btn_pop = findViewById(R.id.wb_btn_pop)
        btn_pop?.setOnClickListener {
            val view: View = layoutInflater.inflate(R.layout.layout_pop, null)

            val textView: TextView = view.findViewById(R.id.tv_0)
            textView.setOnClickListener {
                popupWindow?.dismiss()
                Toast.makeText(this@PopupWindowActivity, textView.text, Toast.LENGTH_SHORT).show()
            }
            popupWindow = PopupWindow(view, btn_pop!!.width, ViewGroup.LayoutParams.WRAP_CONTENT)
            popupWindow?.isOutsideTouchable = true
            popupWindow?.isFocusable = true
            popupWindow?.showAsDropDown(btn_pop)
        }
    }
}
