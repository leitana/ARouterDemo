package com.lx.arouterdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.lx.commonlib.ConstantArouter
import kotlinx.android.synthetic.main.normal_activity.*

/**
 * @title：InterceptorActivity
 * @projectName ARouterDemo
 * @description: <Description>
 * @author linxiao
 * @data Created in 2020/07/28
 */
@Route(path = ConstantArouter.MAIN_APP_INTERCEPTOR_ACTIVITY, extras = ConstantArouter.NEED_LOGIN)
class InterceptorActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.normal_activity)
        tvNormal.text = "拦截器测试界面"
    }
}