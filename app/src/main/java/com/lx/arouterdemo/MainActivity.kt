package com.lx.arouterdemo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.lx.arouterdemo.iprovider.HelloService
import com.lx.commonlib.ConstantArouter
import com.lx.commonlib.TestData
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

@SuppressLint("LongLogTag")

@Route(path = ConstantArouter.MAIN_APP_ACTIVITY)
class MainActivity : AppCompatActivity() {
    val TAG: String = "------MainActivity--------"

    private var isLogin: Boolean by Preference(ConstantArouter.ISLOGIN, false)

    @SuppressLint("ObsoleteSdkInt")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 普通跳转
         */
        bt1.setOnClickListener {
            ARouter.getInstance()
                .build(ConstantArouter.MAIN_APP_NORMAL_ACTIVITY)
                .navigation()
        }

        /**
         * SDK中针对所有的路径(/test/1 /test/2)进行分组，
         * 分组只有在分组中的某一个路径第一次被访问的时候，该分组才会被初始化
         * 可以通过 @Route 注解主动指定分组，否则使用路径中第一段字符串(/xx/)作为分组
         *
         * 一旦主动指定分组之后，应用内路由需要使用 ARouter.getInstance().build(path, group) 进行跳转，
         * 手动指定分组，否则无法找到
         *
         * ARouter允许一个module中存在多个分组，但是不允许多个module中存在相同的分组，会导致映射文件冲突
         */
        bt101.setOnClickListener {
            ARouter.getInstance()
                .build(ConstantArouter.MAIN_APP_GROUP_ACTIVITY, "test")
                .navigation(this)
        }

        /**
         * 带参数跳转
         */
        bt2.setOnClickListener {
            ARouter.getInstance()
                .build(ConstantArouter.MAIN_APP_NORMAL2_ACTIVITY)
                .withObject("key1", TestData("jack", 12))
                .withString("key2", "字符串测试")
                .navigation()
        }

        bt21.setOnClickListener {
            val testSerializable = TestSerializable("Titanic", 555)
            val testParcelable = TestParcelable("jack", 666)
            val testObj = TestObj("Rose", 777)
            val objList: MutableList<TestObj> = ArrayList()
            objList.add(testObj)

            val map: MutableMap<String, List<TestObj>> =
                HashMap()
            map["testMap"] = objList

            ARouter.getInstance().build(ConstantArouter.MAIN_APP_NORMAL4_ACTIVITY)
                .withString("name", "老王")
                .withInt("age", 18)
                .withBoolean("boy", true)
                .withLong("high", 180)
                .withString("url", "https://a.b.c")
                .withSerializable("ser", testSerializable)
                .withParcelable("pac", testParcelable)
                .withObject("obj", testObj)
                .withObject("objList", objList)
                .withObject("map", map)
                .navigation()
        }

        /**
         * 转场动画
         * navigation必须传context
         */
        bt3.setOnClickListener {
            ARouter.getInstance()
                .build(ConstantArouter.MAIN_APP_NORMAL_ACTIVITY)
                .withTransition(R.anim.enter_activity, R.anim.exit_activity)
                .navigation(this)
        }


        /**
         * 新转场动画
         * navigation必须传context
         */
        bt32.apply {
            setOnClickListener {
                if (Build.VERSION.SDK_INT >= 16) {
                    val compat: ActivityOptionsCompat = ActivityOptionsCompat
                        .makeScaleUpAnimation(it, it.width /2, it.height / 2, 10, 10)
                    ARouter.getInstance()
                        .build(ConstantArouter.MAIN_APP_NORMAL_ACTIVITY)
                        .withOptionsCompat(compat)
                        .navigation(this@MainActivity)
                } else {
                    Toast.makeText(this@MainActivity, "API < 16,不支持新版本动画", Toast.LENGTH_SHORT).show()
                }
            }
        }

        /**
         * startActivityForResult
         */
        bt4.setOnClickListener {
            ARouter.getInstance()
                .build(ConstantArouter.MAIN_APP_NORMAL3_ACTIVITY)
                .withObject("key1", TestData("jack1", 12))
                .withString("key2", "字符串测试2")
                .navigation(this, 1)
        }

        /**
         * flag
         * withFlags 是直接赋值，addFlags 是 |=
         */
        bt5.setOnClickListener {
            ARouter.getInstance()
                .build(ConstantArouter.MAIN_APP_NORMAL_ACTIVITY)
                .withFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .navigation()
//            val intent = Intent(this, NormalActivity1::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            startActivity(intent)
        }


        /**
         * Interceptor
         */
        bt6.setOnClickListener {
            ARouter.getInstance()
                .build(ConstantArouter.MAIN_APP_INTERCEPTOR_ACTIVITY)
                .navigation(this, object : NavigationCallback {
                    override fun onFound(postcard: Postcard?) {
                        //路由目标被发现时调用
                        Log.d(TAG, "onFound:")
                    }

                    override fun onArrival(postcard: Postcard?) {
                        //路由到达之后调用
                        Log.d(TAG, "onArrival:")
                    }

                    override fun onLost(postcard: Postcard?) {
                        //路由丢失调用
                        Log.d(TAG, "onLost:")
                    }

                    override fun onInterrupt(postcard: Postcard?) {
                        //路由被拦截调用
                        Log.d(TAG, "onInterrupt:")
                        runOnUiThread {
                            Toast.makeText(this@MainActivity, "路由被拦截，请先登录", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
        }

        bt7.apply {
            setOnClickListener {
                isLogin = !isLogin
                text = isLogin.toString()
            }
            text = isLogin.toString()
        }

        /**
         * 其他module
         */
        bt8.setOnClickListener {
            ARouter.getInstance().build(ConstantArouter.LIB1_ACITVITY1).navigation()
        }

        bt9.setOnClickListener {
            ARouter.getInstance()
                .build(ConstantArouter.MAIN_APP_WEBVIEW_ACTIVITY)
                .withString("url", "file:///android_asset/scheme-test.html")
                .navigation()
        }


        /**
         * 使用全局降级策略需要传context
         */
        bt10.setOnClickListener {
            ARouter.getInstance()
                .build("/xx/xx")
                .navigation(this)
        }

        /**
         * 这里说的服务不是Android四大组件里面的服务，其实是根据path去获取对象。
         */
        bt11.setOnClickListener {
//            ARouter.getInstance().navigation(HelloService::class.java).sayHello("mike")
            (ARouter.getInstance().build("/service/hello").navigation() as HelloService).sayHello("mike")
        }

        bt12.setOnClickListener {
            ARouter.getInstance().build(ConstantArouter.MAIN_APP_SERVICE).navigation(this)
//            val intent = Intent(this, RouteService::class.java)
//            startService(intent)
        }

        bt13.setOnClickListener {
            val fragment = ARouter.getInstance().build(ConstantArouter.MIAN_APP_TEST_FRAGMENT).navigation() as Fragment
            Toast.makeText(this, "找到Fragment:$fragment", Toast.LENGTH_SHORT).show()
        }

        // 使用绿色通道(跳过所有的拦截器)
        bt14.setOnClickListener {
            ARouter.getInstance().build(ConstantArouter.MAIN_APP_INTERCEPTOR_ACTIVITY).greenChannel().navigation()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            bt4.text = data?.getStringExtra("age")
        }
    }
}