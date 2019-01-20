package com.weibo.biz.kotlin.databind

import android.app.Activity
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import android.widget.Toast
import com.weibo.biz.kotlin.BR

data class User(@Bindable var name: String?,
                var nickName: String?,
                var email: String?,
                var vip: Boolean,
                var level: Int,
                var icon: String?): BaseObservable()  {

    fun clickName(view: View) {
        Toast.makeText(view.context, "点击 " + this.name, Toast.LENGTH_SHORT).show()
    }

    fun longClickNickName(view: View): Boolean {
        Toast.makeText(view.context, "长按 " + this.nickName, Toast.LENGTH_SHORT).show()
        return true
    }

    fun click(view: View) {
        val name = this.name + "已点击"
        this.name = name
        notifyPropertyChanged(BR.name)
    }
}