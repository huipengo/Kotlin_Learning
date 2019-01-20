package com.weibo.biz.kotlin.recyclerView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.*
import android.view.View
import android.widget.Toast
import com.weibo.biz.kotlin.R
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity(), RecyclerAdapter.OnChildClickListener {

    private var recyclerView: RecyclerView? = null
    private var adapter: RecyclerAdapter? = null

    constructor() : super()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        var list: ArrayList<String> = ArrayList(100)
        for (i in 1..100) {
            list.add("第${i}条数据")
        }

        recyclerView = findViewById(R.id.recycler)
        recyclerView?.layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
//        recyclerView?.layoutManager = LinearLayoutManager(this@RecyclerViewActivity, LinearLayoutManager.HORIZONTAL, false)
//        recyclerView?.layoutManager = GridLayoutManager(this@RecyclerViewActivity, 3, LinearLayoutManager.HORIZONTAL, false)
//        val gridLayoutManager: GridLayoutManager = GridLayoutManager(this@RecyclerViewActivity, 3)
//        gridLayoutManager.spanSizeLookup =
//        val staggeredGridLayoutManager: StaggeredGridLayoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL)
//        recyclerView?.layoutManager = gridLayoutManager

        val animator: DefaultItemAnimator = DefaultItemAnimator()
        animator?.removeDuration = 100
        recyclerView?.itemAnimator = animator

//        recyclerView.addItemDecoration

        adapter = RecyclerAdapter(this@RecyclerViewActivity, list)
        recyclerView?.adapter = adapter
        adapter?.listener = this
    }

    override fun onChildClick(parent: RecyclerView, view: View, position: Int, data: String) {
        Toast.makeText(this@RecyclerViewActivity, data, Toast.LENGTH_SHORT).show()
        adapter?.remove(position)
    }
}
