package com.sst.aroutlib;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.alibaba.android.arouter.launcher.ARouter;

public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ARouter.getInstance().inject(this);//注入路由参数
        super.onCreate(savedInstanceState);
    }
}
