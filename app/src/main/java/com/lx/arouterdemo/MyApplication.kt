package com.lx.arouterdemo

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import kotlin.properties.Delegates

/**
 * @title：MyApplication
 * @projectName ARouterDemo
 * @description: <Description>
 * @author linxiao
 * @data Created in 2020/07/27
 */
class MyApplication : Application() {

    companion object {
        private val TAG = "App"

        var context: Context by Delegates.notNull()
            private set

        lateinit var instance: Application

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        context = applicationContext
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}