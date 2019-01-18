package com.weibo.biz.kotlin.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.weibo.biz.kotlin.R

class AFragment: Fragment() {

    private var textView: TextView? = null

    var bFragment: BFragment? = null

    var listener: IOnMessageClick? = null

    /** 静态方法 */
    companion object {
        fun getInstanceFragment(title: String): Fragment? {
            val aFragment: Fragment = AFragment()
            val bundle: Bundle = Bundle()
            bundle.putString("title", title)
            aFragment.arguments = bundle
            return aFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_a, container, false)
        return view
        //return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.wb_fragment_a)

        if (this.arguments != null) {
            textView?.text = this.arguments!!.getString("title")
        }

        val btn_change: Button  = view.findViewById(R.id.btn_change_fragment)
        val btn_reset: Button   = view.findViewById(R.id.btn_reset)
        val btn_message: Button = view.findViewById(R.id.btn_message)

        btn_change.setOnClickListener {
            changeFragment()
        }

        btn_reset.setOnClickListener {
            textView?.text = "被替换了~"
        }

        btn_message.setOnClickListener {
            //val mActivity: ContainerActivity = this.activity as ContainerActivity
            //mActivity.setData("路飞")
            listener?.onClick("路飞")
        }
    }

    fun changeFragment() {
        if (bFragment == null) bFragment = BFragment()
        val fragment: Fragment = fragmentManager!!.findFragmentByTag("a")!!
        if (fragment != null) {
            fragmentManager!!.beginTransaction().hide(fragment).add(R.id.wb_container, bFragment!!).addToBackStack(null).commitAllowingStateLoss()
        }
        else {
            fragmentManager!!.beginTransaction().replace(R.id.wb_container, bFragment!!).addToBackStack(null)
                .commitAllowingStateLoss()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as ContainerActivity?
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}