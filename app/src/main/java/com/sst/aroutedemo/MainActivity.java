package com.sst.aroutedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sst.aroutlib.ActivityType;
import com.sst.aroutlib.BaseActivity;

@Route(path = "/activity/main")
public class MainActivity extends BaseActivity {


    //路由传递参数 自动赋值  可不传递为初始值  使用这个注解
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

    @Override
    public ActivityType getType() {
        return ActivityType.main;
    }
}
