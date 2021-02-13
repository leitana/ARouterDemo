package com.lx.app2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.webview_activity.*

/**
 * @title：WebViewActivity
 * @projectName ARouterDemo
 * @description: <Description>
 * @author linxiao
 * @data Created in 2020/07/29
 */
class WebViewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview_activity)
        webview.loadUrl(intent.getStringExtra("url"))
    }
}