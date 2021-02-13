package com.lx.arouterdemo

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.SerializationService
import com.google.gson.Gson
import java.lang.reflect.Type

/**
 * @author linxiao
 * @title：BaseData
 * @projectName RouterDemo
 * @description: 如果需要传递自定义对象，新建一个类（并非自定义对象类），
 * 然后实现 SerializationService,并使用@Route注解标注
 *
 * withObject需要
 * @data Created in 2020/07/21
 */
@Route(path = "/custom/json")
class JsonSerializationService1 : SerializationService {
    var gson: Gson? = null
    override fun <T> json2Object(input: String, clazz: Class<T>): T {
        return gson!!.fromJson(input, clazz)
    }

    override fun object2Json(instance: Any): String {
        Log.d("------------", "3333333JsonSerializationService")
        return gson!!.toJson(instance)
    }

    override fun <T> parseObject(input: String, clazz: Type): T {
        return gson!!.fromJson(input, clazz)
    }

    override fun init(context: Context) {
        gson = Gson()
    }
}