package com.lx.arouterdemo

import android.content.Context
import android.widget.Toast
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.DegradeService
import com.alibaba.android.arouter.launcher.ARouter
import com.lx.commonlib.ConstantArouter

/**
 * @title：DegradeServiceImpl
 * @projectName ARouterDemo
 * @description: 全局降级策略
 * @author linxiao
 * @data Created in 2020/07/29
 */
//path里面的内容可以任意
@Route(path = "/xxx/xxx")
class DegradeServiceImpl: DegradeService {

    private var context: Context? = null

    override fun onLost(context: Context?, postcard: Postcard?) {
        val path = postcard?.path
        Toast.makeText(context, "找不到$path", Toast.LENGTH_SHORT).show()
        ARouter.getInstance().build(ConstantArouter.MAIN_APP_LOW_ACTIVITY).navigation()
    }

    override fun init(context: Context?) {
        this.context = context
    }
}