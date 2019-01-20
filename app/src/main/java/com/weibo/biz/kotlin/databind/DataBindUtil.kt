package com.weibo.biz.kotlin.databind

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.weibo.biz.kotlin.R

object DataBindUtil {

    @BindingAdapter("app:loadImage")
    @JvmStatic fun loadImage(view: ImageView, url: String) {
        if (url == null) {
            view.setImageResource(R.mipmap.ic_launcher)
        }
        else {
            Glide.with(view.context).load(url).into(view)
        }
    }
}