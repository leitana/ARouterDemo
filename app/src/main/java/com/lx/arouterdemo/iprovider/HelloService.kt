package com.lx.arouterdemo.iprovider

import com.alibaba.android.arouter.facade.template.IProvider

/**
 * @title：HelloService
 * @projectName ARouterDemo
 * @description: <Description>
 * @author linxiao
 * @data Created in 2020/07/29
 */
interface HelloService: IProvider {
    fun sayHello(name: String)
}