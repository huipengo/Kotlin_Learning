package com.weibo.biz.kotlin.databind

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.weibo.biz.kotlin.BR.*
import com.weibo.biz.kotlin.R
import com.weibo.biz.kotlin.databinding.ActivityDataBindListViewBinding
import java.util.ArrayList

class DataBindListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_data_bind_list_view)

        val binding: ActivityDataBindListViewBinding = DataBindingUtil.setContentView(this@DataBindListViewActivity, R.layout.activity_data_bind_list_view)
        var users: ArrayList<User> = ArrayList()
        for (i in 1..100) {
            val user: User = User("jack", "杰克", "jack@163.com", true, 9, "https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20419.jpg")
            users.add(user)
        }
        val adapter: CommonAdapter<User> = CommonAdapter(this@DataBindListViewActivity, users, R.layout.layout_databinding_item, user)
        binding.adapter = adapter
    }
}
