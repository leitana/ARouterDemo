package com.lx.arouterdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.lx.commonlib.ConstantArouter

/**
 * @title：SchemeFilterActivity
 * @projectName ARouterDemo
 * @description:  直接通过ARouter处理外部Uri
 * @author linxiao
 * @data Created in 2020/07/28
 */
class SchemeFilterActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val uri = intent.data
        ARouter.getInstance().build(uri).navigation(this, object : NavCallback(){
            override fun onArrival(postcard: Postcard?) {
                finish()
            }

            override fun onFound(postcard: Postcard?) {
                super.onFound(postcard)
            }

            override fun onInterrupt(postcard: Postcard?) {
                super.onInterrupt(postcard)
            }

            //外部降级策略
            override fun onLost(postcard: Postcard?) {
                super.onLost(postcard)
                Toast.makeText(this@SchemeFilterActivity, "找不到$uri", Toast.LENGTH_SHORT).show()
                ARouter.getInstance().build(ConstantArouter.MAIN_APP_LOW_ACTIVITY).navigation()
            }
        })
    }
}