package com.lx.arouterdemo

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.PretreatmentService

/**
 * @title：PretreatmentServiceImpl
 * @projectName ARouterDemo
 * @description: <Description>
 * @author linxiao
 * @data Created in 2020/07/30
 */
@Route(path = "/xxx/pretreat")
class PretreatmentServiceImpl: PretreatmentService {

    private var context: Context? = null

    override fun onPretreatment(context: Context?, postcard: Postcard?): Boolean {
        // 跳转前预处理，如果需要自行处理跳转，该方法返回 false 即可
        Log.d("------------------","预处理")
        return true
    }

    override fun init(context: Context?) {
        this.context = context
    }
}