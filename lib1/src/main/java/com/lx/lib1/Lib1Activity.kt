package com.lx.lib1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lx.commonlib.ConstantArouter
import kotlinx.android.synthetic.main.activity_lib1.*

@Route(path = ConstantArouter.LIB1_ACITVITY1)
class Lib1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lib1)
        lib1bt1.setOnClickListener {
            ARouter.getInstance().build(ConstantArouter.LIB2_ACITVITY1).navigation()
        }
    }
}
