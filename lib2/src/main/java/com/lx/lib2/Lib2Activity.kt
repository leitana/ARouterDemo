package com.lx.lib2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lx.commonlib.ConstantArouter
import kotlinx.android.synthetic.main.activity_lib2.*

@Route(path = ConstantArouter.LIB2_ACITVITY1)
class Lib2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lib2)
        lib2bt1.setOnClickListener {
            ARouter.getInstance()
                .build(ConstantArouter.MAIN_APP_ACTIVITY)
                .withFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .navigation(this)
        }
    }
}
