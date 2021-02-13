package com.lx.arouterdemo.iprovider

import android.content.Context
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route

/**
 * @title：HelloServiceImpl
 * @projectName ARouterDemo
 * @description: <Description>
 * @author linxiao
 * @data Created in 2020/07/29
 */
@Route(path = "/service/hello",name = "测试服务")
class HelloServiceImpl: HelloService {
    private var context: Context? = null
    override fun sayHello(name: String) {
        Toast.makeText(context, "Hello$name", Toast.LENGTH_SHORT).show()
    }

    override fun init(context: Context?) {
        this.context = context
    }
}