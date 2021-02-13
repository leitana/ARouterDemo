package com.lx.arouterdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.lx.commonlib.ConstantArouter

/**
 * @title：Fragment1
 * @projectName ARouterDemo
 * @description: <Description>
 * @author linxiao
 * @data Created in 2020/07/30
 */
@Route(path = ConstantArouter.MIAN_APP_TEST_FRAGMENT)
class Fragment1: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.normal_activity, container, false)
    }
}