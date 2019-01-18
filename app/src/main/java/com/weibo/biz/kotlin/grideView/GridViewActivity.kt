package com.weibo.biz.kotlin.grideView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import com.weibo.biz.kotlin.R
import kotlinx.android.synthetic.main.activity_gride_view.view.*

class GridViewActivity : AppCompatActivity() {

    private var gv: GridView? = null
    var dataList = ArrayList<GridModel>()
    var mAdapter: MyGridViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gride_view)

        gv = findViewById<GridView>(R.id.gv)


        gv?.setOnItemClickListener { parent, view, position, id ->
            val item: GridModel = dataList!![position]
            val toast: Toast = Toast.makeText(this@GridViewActivity, "I am " + item.title, Toast.LENGTH_LONG)
            toast.show()
        }

        gv?.setOnItemLongClickListener { parent, view, position, id ->
            val item: GridModel = dataList!![position]
            val toast: Toast = Toast.makeText(this@GridViewActivity, "Long " + item.title, Toast.LENGTH_LONG)
            toast.show()
            true
        }

        initData()
    }

    fun initData() {
        val model0: GridModel = GridModel(
            "https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20419.jpg",
            "路飞",
            "成为海贼王的男人"
        )
        dataList.add(model0)

        val model1: GridModel = GridModel(
            "https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1545624925.39.jpg",
            "索隆",
            "剑士"
        )
        dataList.add(model1)

        val model2: GridModel = GridModel(
            "https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p23477.jpg",
            "山治",
            "厨师"
        )
        dataList.add(model2)

        val model3: GridModel = GridModel(
            "https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1471358307.31.jpg",
            "娜美",
            "航海家"
        )

        dataList.add(model3)

        val  model4 = GridModel(
            "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2541662397.jpg",
            "乔巴",
            "医生"
        );

        dataList.add(model4)

        mAdapter = MyGridViewAdapter(dataList, this.baseContext)
        gv?.adapter = mAdapter
    }
}
