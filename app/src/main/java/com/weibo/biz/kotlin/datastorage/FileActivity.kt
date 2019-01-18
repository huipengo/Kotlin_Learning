package com.weibo.biz.kotlin.datastorage

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.weibo.biz.kotlin.R
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.lang.StringBuilder

class FileActivity : AppCompatActivity() {

    private var edit_text: EditText? = null
    private var save_btn: Button? = null
    private var show_btn: Button? = null
    private var show_text: TextView? = null

    private val fileName: String = "test.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file)

        edit_text = findViewById(R.id.wb_et_name)
        save_btn = findViewById(R.id.wb_btn_save)
        show_btn = findViewById(R.id.wb_btn_show)
        show_text = findViewById(R.id.wb_show_text)

        save_btn?.setOnClickListener {
            save(edit_text?.text.toString())
        }

        show_btn?.setOnClickListener {
            show_text?.text = read()
        }
    }

    private fun save(content: String) {
        val fileOutputStream: FileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE)
        fileOutputStream.write(content.toByteArray())
        fileOutputStream.close()
    }

    private fun read() : String {
        val fileInputStream: FileInputStream = openFileInput(fileName)
        val byte: ByteArray = ByteArray(1024)
        val stringBuilder: StringBuilder = StringBuilder("")
        var length: Int = 0
//        while ((length = fileInputStream.read(byte!)) > 0) {
//            stringBuilder.append(String(byte, 0, length))
//        }

        fileInputStream.close()

        return stringBuilder.toString()
    }
}