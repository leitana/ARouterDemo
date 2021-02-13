package com.lx.arouterdemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lx.commonlib.ConstantArouter
import com.lx.commonlib.TestData
import kotlinx.android.synthetic.main.normal_activity.*


/**
 * @title：NormalActivity2
 * @projectName ARouterDemo
 * @description: <Description>
 * @author linxiao
 * @data Created in 2020/07/27
 */
@Route(path = ConstantArouter.MAIN_APP_NORMAL2_ACTIVITY)
class NormalActivity2: AppCompatActivity() {

//    @JvmField
//    @Autowired
    var key2: String? = null

    @JvmField
    @Autowired(name = "key1")
    var testData : TestData? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.normal_activity)
        ARouter.getInstance().inject(this)
        key2 = intent.extras?.getString("key2")
        tvNormal.apply {
            text = key2 + testData
        }
    }
}