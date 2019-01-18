package com.weibo.biz.kotlin.fragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.widget.Button
import android.widget.TextView
import com.weibo.biz.kotlin.R
import org.w3c.dom.Text

class ContainerActivity : AppCompatActivity(), IOnMessageClick {

    var aFragment: AFragment? = null
//    var bFragment: BFragment? = null
//    var is_Afragment: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        this.title = "Fragment"

        aFragment = AFragment.getInstanceFragment("海贼王") as AFragment?
        supportFragmentManager.beginTransaction().add(R.id.wb_container, aFragment!!, "a").commitAllowingStateLoss()

//        val btn: Button = findViewById(R.id.btn_change_fragment)
//        btn.setOnClickListener {
//            if (is_Afragment) {
//                is_Afragment = false
//                if (bFragment == null) {
//                    bFragment = BFragment()
//                }
//                supportFragmentManager.beginTransaction().replace(R.id.wb_container, bFragment!!).commitAllowingStateLoss()
//            }
//            else {
//                is_Afragment = true
//                supportFragmentManager.beginTransaction().replace(R.id.wb_container, aFragment!!).commitAllowingStateLoss()
//            }
//        }
    }

    public fun setData(text: String) {
        val textView: TextView = findViewById(R.id.text_change_fragment)
        textView?.text = text
    }

    override fun onClick(text: String) {
        val textView: TextView = findViewById(R.id.text_change_fragment)
        textView?.text = text
    }
}
