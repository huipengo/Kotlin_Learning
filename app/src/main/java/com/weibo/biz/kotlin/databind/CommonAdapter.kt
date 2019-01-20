package com.weibo.biz.kotlin.databind

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class CommonAdapter<T>: BaseAdapter {

    private var context: Context
    private var list: List<T>? = null
    private var layoutId: Int = 0
    private var variableId: Int = 0

    constructor(context: Context, list: List<T>, layoutId: Int, variableId: Int) : super() {
        this.context = context
        this.list = list
        this.layoutId = layoutId
        this.variableId = variableId
    }

    override fun getItem(position: Int): T {
        return list!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list?.size ?: 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var binding: ViewDataBinding? = null
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, parent, false)
        }
        else {
            binding = DataBindingUtil.getBinding(convertView)!!
        }
        binding?.setVariable(variableId, list!![position])
        return binding?.root!!
    }
}