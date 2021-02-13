package com.lx.arouterdemo

import android.content.Context
import android.net.Uri
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.PathReplaceService

/**
 * @title：PathReplaceServiceImpl
 * @projectName ARouterDemo
 * @description: 重写跳转URL
 * @author linxiao
 * @data Created in 2020/07/29
 */
@Route(path = "/dddd/dddd")
class PathReplaceServiceImpl: PathReplaceService {

    private var context: Context? = null

    override fun forString(path: String?): String {
//        Toast.makeText(context, path, Toast.LENGTH_SHORT).show()
        return path.toString()
    }

    override fun forUri(uri: Uri?): Uri {
//        Toast.makeText(context, uri.toString(), Toast.LENGTH_SHORT).show()
        return uri!!
    }

    override fun init(context: Context?) {
        this.context = context
    }
}