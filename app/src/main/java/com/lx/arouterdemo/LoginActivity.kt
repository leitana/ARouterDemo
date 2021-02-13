package com.lx.arouterdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.lx.commonlib.ConstantArouter
import kotlinx.android.synthetic.main.normal_activity.*

/**
 * @title：LoginActivity
 * @projectName ARouterDemo
 * @description: <Description>
 * @author linxiao
 * @data Created in 2020/07/28
 */
@Route(path = ConstantArouter.MAIN_APP_LOGIN_ACTIVITY)
class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.normal_activity)
        tvNormal.text = "登录界面"
    }
}