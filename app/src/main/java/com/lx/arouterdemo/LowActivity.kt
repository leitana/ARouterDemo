package com.lx.arouterdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.lx.commonlib.ConstantArouter
import kotlinx.android.synthetic.main.normal_activity.*

/**
 * @title：LowActivity
 * @projectName ARouterDemo
 * @description: 降级后的测试界面
 * @author linxiao
 * @data Created in 2020/07/29
 */
@Route(path = ConstantArouter.MAIN_APP_LOW_ACTIVITY)
class LowActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.normal_activity)
        tvNormal.text = "降级策略跳转界面"
    }
}