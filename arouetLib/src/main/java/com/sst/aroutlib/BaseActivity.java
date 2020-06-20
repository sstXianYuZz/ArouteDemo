package com.sst.aroutlib;

import androidx.fragment.app.FragmentActivity;

public abstract class BaseActivity extends FragmentActivity {
    //route跳转使用这个 ActivityType 枚举类定义
    public abstract ActivityType getType();
}
