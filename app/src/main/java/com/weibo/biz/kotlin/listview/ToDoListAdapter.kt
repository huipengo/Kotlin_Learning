package com.weibo.biz.kotlin.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.weibo.biz.kotlin.R
import android.widget.BaseAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

class ToDoListAdapter(dl: List<ListModel>, mContext: Context) : BaseAdapter() {
    var todoList: List<ListModel>? = null
    var mViewHolder: MyViewHoler? = null
    var mContext:Context

    init {
        todoList = dl
        this.mContext = mContext
    }

    override fun getItem(position: Int): Any {
        return todoList!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return todoList?.size ?: 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var mConvertView = convertView
        if (convertView == null) {
            mConvertView = LayoutInflater.from(mContext).inflate(R.layout.holder_list_item, null)
            mViewHolder = MyViewHoler()
            mViewHolder!!.mImageView = mConvertView?.findViewById(R.id.tv_imageView)
            mViewHolder!!.mTitle = mConvertView?.findViewById(R.id.tv_title)
            mViewHolder!!.mContentTv = mConvertView?.findViewById(R.id.tv_content)
            (if (mConvertView != null) mConvertView else {
                throw KotlinNullPointerException()
            }).tag = this.mViewHolder
        }
        else {
            mViewHolder = mConvertView?.getTag() as MyViewHoler
        }

        val model: ListModel = todoList!![position]

        mViewHolder?.mTitle?.text = model?.title

        mViewHolder?.mContentTv?.text = model?.content

        val imageView = mViewHolder?.mImageView as ImageView
        Glide.with(mContext).load(model.url).into(imageView)

        return mConvertView!!
    }

    inner class MyViewHoler() {
        public var mImageView:ImageView? = null
        public var mTitle:TextView? = null
        public var mContentTv:TextView? = null
    }

}