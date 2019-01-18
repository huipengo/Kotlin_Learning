package com.weibo.biz.kotlin.webView

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.weibo.biz.kotlin.R
import kotlinx.android.synthetic.main.activity_web_view.view.*

class WebViewActivity : AppCompatActivity() {

    private var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView = findViewById<WebView>(R.id.wb_webview)

        /** 加载本地 html */
        //webView?.loadUrl("file:///android_asset/local.html")

        /** 加载网络 url */
        webView?.settings?.javaScriptEnabled = true
        webView?.webViewClient = MyWebViewClient()
        webView?.webChromeClient = MyWebChromeClient()
        webView?.loadUrl("https://m.baidu.com")
    }

    inner class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            view?.loadUrl(request?.url.toString())
            return super.shouldOverrideUrlLoading(view, request)
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            //webView?.loadUrl("javascript:alert('hello')")
            webView?.evaluateJavascript("javascript:alert('hello')", null)
        }
    }

    inner class MyWebChromeClient : WebChromeClient() {
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
        }

        override fun onReceivedTitle(view: WebView?, title: String?) {
            super.onReceivedTitle(view, title)
            setTitle(title)
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView?.canGoBack()!!) {
            webView?.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
