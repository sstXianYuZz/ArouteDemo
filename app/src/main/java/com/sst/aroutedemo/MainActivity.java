package com.sst.aroutedemo;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sst.aroutlib.ActivityType;
import com.sst.aroutlib.BaseActivity;

@Route(path = ActivityType.main)
public class MainActivity extends BaseActivity {


    //路由传递参数 自动赋值  可不传递为初始值  使用这个注解
    // 使用int long 时最好添加初始值 之前遇到过一个aroute自带的的bug内部解析时会去获取老的缓存
    @Autowired
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.tv);
        if (TextUtils.isEmpty(key)){

        }
        tv.setText(TextUtils.isEmpty(key)?"未传递参数":key);
    }

}
