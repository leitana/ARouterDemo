package com.lx.arouterdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.lx.commonlib.ConstantArouter
import kotlinx.android.synthetic.main.normal_activity.*

/**
 * @title：GroupActivity
 * @projectName ARouterDemo
 * @description: <Description>
 * @author linxiao
 * @data Created in 2020/07/30
 */
@Route(path = ConstantArouter.MAIN_APP_GROUP_ACTIVITY, group = "test")
class GroupActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.normal_activity)
        tvNormal.text = "指定分组"

    }
}