package com.weibo.biz.kotlin.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.weibo.biz.kotlin.R

class ListViewActivity : AppCompatActivity() {

    private var listView:ListView? = null;

    var dataList = ArrayList<ListModel>()
    var mAdapter: ToDoListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        listView = findViewById<ListView>(R.id.wlistView)
        listView?.setOnItemClickListener { parent, view, position, id ->
            val item: ListModel = dataList!![position]
            val toast: Toast = Toast.makeText(this@ListViewActivity, "I am " + item.title, Toast.LENGTH_LONG)
            toast.show()
        }

        listView?.setOnItemLongClickListener { parent, view, position, id ->
            val item: ListModel = dataList!![position]
            val toast: Toast = Toast.makeText(this@ListViewActivity, "Long " + item.title, Toast.LENGTH_LONG)
            toast.show()
            true
        }

        initData()
    }

    fun initData() {
        val model0: ListModel = ListModel(
            "https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20419.jpg",
            "路飞",
            "成为海贼王的男人"
        )
        dataList.add(model0)

        val model1: ListModel = ListModel(
            "https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1545624925.39.jpg",
            "索隆",
            "剑士"
        )
        dataList.add(model1)

        val model2: ListModel = ListModel(
            "https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p23477.jpg",
            "山治",
            "厨师"
        )
        dataList.add(model2)

        val model3: ListModel = ListModel(
            "https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1471358307.31.jpg",
            "娜美",
            "航海家"
        )

        dataList.add(model3)

        val  model4 = ListModel(
            "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2541662397.jpg",
            "乔巴",
            "医生"
        );

        dataList.add(model4)

        mAdapter = ToDoListAdapter(dataList, this.baseContext)
        listView?.adapter = this.mAdapter
    }
}
