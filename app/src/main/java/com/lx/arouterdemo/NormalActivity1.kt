package com.lx.arouterdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lx.commonlib.ConstantArouter
import kotlinx.android.synthetic.main.normal_activity.*

/**
 * @title：NormalActivity1
 * @projectName ARouterDemo
 * @description: <Description>
 * @author linxiao
 * @data Created in 2020/07/27
 */

/**
 * String path();//路径URL字符串
 * String group() default "";//组名，默认为一级路径名；一旦被设置，跳转时必须赋值
 * String name() default "undefined";//该路径的名称，用于产生JavaDoc
 * int extras() default Integer.MIN_VALUE;//额外配置的开关信息；譬如某些页面是否需要网络校验、登录校验等
 * int priority() default -1;//该路径的优先级
 */
@Route(path = ConstantArouter.MAIN_APP_NORMAL_ACTIVITY)
class NormalActivity1: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.normal_activity)
        tvNormal.apply {
            text = "普通跳转"
        }
    }
}