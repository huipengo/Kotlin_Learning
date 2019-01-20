package com.weibo.biz.kotlin.databind

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.weibo.biz.kotlin.R
import com.weibo.biz.kotlin.databinding.ActivityDataBindingBinding
import java.util.ArrayList

class DataBindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_data_binding)
        val binding: ActivityDataBindingBinding = DataBindingUtil.setContentView(this@DataBindingActivity, R.layout.activity_data_binding)
        val user0 = User("Rose", "萝丝", "rose@163.com", false, 3 , "https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20419.jpg")
        val user1 = User("Jack", "杰克", "jack@163.com", true, 6, "https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1545624925.39.jpg")
        var users = ArrayList<User>()
        users.add(user0)
        users.add(user1)
        binding.users = users
    }
}
