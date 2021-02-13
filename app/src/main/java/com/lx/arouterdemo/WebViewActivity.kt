package com.lx.arouterdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.lx.commonlib.ConstantArouter
import kotlinx.android.synthetic.main.webview_activity.*

/**
 * @title：WebViewActivity
 * @projectName ARouterDemo
 * @description: <Description>
 * @author linxiao
 * @data Created in 2020/07/29
 */
@Route(path = ConstantArouter.MAIN_APP_WEBVIEW_ACTIVITY)
class WebViewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview_activity)

        webview.loadUrl(intent.getStringExtra("url"))
    }
}