package com.lx.arouterdemo

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.alibaba.android.arouter.launcher.ARouter
import com.lx.commonlib.ConstantArouter

/**
 * @title：LoginInterceptor
 * @projectName ARouterDemo
 * @description: <Description>
 * @author linxiao
 * @data Created in 2020/07/28
 */

/**
 * 自定义拦截器必须使用 @Interceptor 注解
 * priority声明优先级  数值越小，越先执行，优先级越高
 *
 * 优先级不能一样,否则会报错
 *
 * 拦截器会在跳转之间执行，多个拦截器会按优先级顺序依次执行
 *
 * 拦截器因为其特殊性，会被任何一次路由所触发，
 * 拦截器会在ARouter初始化的时候异步初始化，
 * 如果第一次路由的时候拦截器还没有初始化结束，路由会等待，直到初始化完成。
 */
@Interceptor(priority = 7, name = "登录拦截器")
class LoginInterceptor : IInterceptor{
    private var context: Context? = null
    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        val path = postcard?.path
        val extra = postcard?.extra
        val isLogin : Boolean by Preference(ConstantArouter.ISLOGIN, false)
        if (isLogin) {//登录则不拦截
            callback?.onContinue(postcard)
        } else {
//            when(path) {
//                ConstantArouter.MAIN_APP_INTERCEPTOR_ACTIVITY -> {
//                    callback?.onInterrupt(RuntimeException("需要登录"))
//                    ARouter.getInstance().build(ConstantArouter.MAIN_APP_LOGIN_ACTIVITY).navigation(context)
//                }
//                else -> {
//                    callback?.onContinue(postcard)
//                }
//
//            }
            when(extra) {
                1 -> {
                    callback?.onInterrupt(RuntimeException("需要登录"))
                    ARouter.getInstance().build(ConstantArouter.MAIN_APP_LOGIN_ACTIVITY).navigation(context)
                }
                else -> {
                    callback?.onContinue(postcard)
                }
            }
        }
    }

    override fun init(context: Context?) {
        this.context = context
    }
}