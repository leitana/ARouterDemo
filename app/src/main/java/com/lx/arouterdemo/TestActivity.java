package com.lx.arouterdemo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lx.commonlib.ConstantArouter;

/**
 * @author linxiao
 * @title：TestActivity
 * @projectName ARouterDemo
 * @description: <Description>
 * @data Created in 2020/07/30
 */
class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().build(ConstantArouter.MAIN_APP_NORMAL_ACTIVITY).navigation();
    }
}
