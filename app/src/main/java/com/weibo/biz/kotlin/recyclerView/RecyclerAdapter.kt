package com.weibo.biz.kotlin.recyclerView

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.weibo.biz.kotlin.R
import kotlinx.android.synthetic.main.recycler_item.view.*

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHoler>, View.OnClickListener {

    private var context: Context? = null
    private var list: ArrayList<String>? = null

    public var listener: OnChildClickListener? = null
    private var recyclerView: RecyclerView? = null

    constructor(context: Context?, list: ArrayList<String>?) : super() {
        this.context = context
        this.list = list
    }

    constructor() : super()


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerViewHoler {
        val view: View = LayoutInflater.from(context).inflate(R.layout.recycler_item, p0, false)
        view.setOnClickListener(this)
        return RecyclerViewHoler(view)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        this.recyclerView = null
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(p0: RecyclerViewHoler, p1: Int) {
        val textView = p0.textView
        if (textView != null) {
            println("${list!![p1]}")
            textView.text = list!![p1]
        }
    }

    override fun onClick(v: View?) {
        if (recyclerView != null && listener != null) {
            val position: Int? = recyclerView?.getChildAdapterPosition(v!!)
            listener!!.onChildClick(recyclerView!!, v!!, position!!, list!![position])
        }
    }

    public fun remove(position: Int) {
        list?.removeAt(position)
        //notifyDataSetChanged()
        notifyItemRemoved(position)
    }

    inner class RecyclerViewHoler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        public var textView: TextView? = itemView.findViewById(R.id.item_text)
    }

    public interface OnChildClickListener {
        fun onChildClick(parent: RecyclerView, view: View, position: Int, data: String);
    }
}
