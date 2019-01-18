package com.weibo.biz.kotlin.event

import android.app.Activity
import android.view.View
import android.widget.Toast

class MyClickListener(eventActivity: EventActivity) : View.OnClickListener {
    private var activity: Activity ? = null

    init {
        this.activity = eventActivity
    }

    override fun onClick(v: View?) {
        Toast.makeText(this.activity, "点击我", Toast.LENGTH_SHORT).show()
    }
}