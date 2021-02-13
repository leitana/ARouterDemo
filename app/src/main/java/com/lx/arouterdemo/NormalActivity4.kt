package com.lx.arouterdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lx.commonlib.ConstantArouter
import kotlinx.android.synthetic.main.normal_activity.*


/**
 * @title：NormalActivity4
 * @projectName ARouterDemo
 * @description: <Description>
 * @author linxiao
 * @data Created in 2020/07/28
 *
 * 需要注意的是，如果不使用自动注入，那么可以不写 ARouter.getInstance().inject(this)，
 * 但是需要取值的字段仍然需要标上 @Autowired 注解，
 * 因为 只有标上注解之后，ARouter才能知道以哪一种数据类型提取URL中的参数并放入Intent中，
 * 这样才能在intent中获取到对应的参数
 */
@Route(path = ConstantArouter.MAIN_APP_NORMAL4_ACTIVITY)
class NormalActivity4: AppCompatActivity() {
    @JvmField
    @Autowired(desc = "姓名")
    var name = "jack"

    @JvmField
    @Autowired
    var age = 10

    @JvmField
    @Autowired
    var height = 175

    @JvmField
    @Autowired(name = "boy", required = true)
    var girl = false

    @JvmField
    @Autowired
    var ch = 'A'

    @JvmField
    @Autowired
    var fl = 12.00f

    @JvmField
    @Autowired
    var dou = 12.01

    @JvmField
    @Autowired
    var ser: TestSerializable? = null

    @JvmField
    @Autowired
    var pac: TestParcelable? = null

    @JvmField
    @Autowired
    var obj: TestObj? = null

    // 使用 withObject 传递 List 和 Map 的实现了
    // Serializable 接口的实现类(ArrayList/HashMap)
    // 的时候，接收该对象的地方不能标注具体的实现类类型
    // 应仅标注为 List 或 Map，否则会影响序列化中类型
    // 的判断, 其他类似情况需要同样处理
    @JvmField
    @Autowired
    var objList: List<TestObj>? = null

    @JvmField
    @Autowired
    var map: Map<String, List<TestObj>>? = null


    private val high: Long = 0

    @JvmField
    @Autowired
    var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.normal_activity)
        ARouter.getInstance().inject(this)

        val uriStr = intent.getStringExtra(ARouter.RAW_URI)

//        val deurl: String = URLDecoder.decode(uriStr, "UTF-8")

//        val value = intent.getStringExtra("key1")
//        if (!TextUtils.isEmpty(value)) {
//            Toast.makeText(this, "exist param :$value", Toast.LENGTH_LONG).show()
//        }
        val params = java.lang.String.format(
            "name=%s,\n age=%s, \n height=%s,\n girl=%s,\n high=%s,\n url=%s,\n ser=%s,\n pac=%s,\n obj=%s \n ch=%s \n fl = %s, \n dou = %s, \n objList=%s, \n map=%s",
            name,
            age,
            height,
            girl,
            high,
            url,
            ser,
            pac,
            obj,
            ch,
            fl,
            dou,
            objList,
            map
        )
        tvNormal.apply {
            text = params
            textSize = 16f
        }
    }
}