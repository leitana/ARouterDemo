package com.lx.arouterdemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.lx.commonlib.ConstantArouter

/**
 * @title：RouteService
 * @projectName ARouterDemo
 * @description: <Description>
 * @author linxiao
 * @data Created in 2020/07/29
 */
@Route(path = ConstantArouter.MAIN_APP_SERVICE)
class RouteService: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, "启动服务", Toast.LENGTH_SHORT).show()
    }
}