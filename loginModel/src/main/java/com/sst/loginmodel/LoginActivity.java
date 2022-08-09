package com.sst.loginmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sst.aroutlib.ActivityType;
import com.sst.aroutlib.BaseActivity;
import com.sst.aroutlib.RouteImpl;
import com.sst.aroutlib.RouterUtil;

import java.util.HashMap;
import java.util.Map;

@Route(path =ActivityType.login)
public class LoginActivity extends BaseActivity {
    @Override
    public String getType() {
        return ActivityType.login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void getUserName(View view) {
        UserIProvider impl = (UserIProvider) ARouter.getInstance().build(RouteImpl.UserImpl).navigation();
        Toast.makeText(this, impl.getName(), Toast.LENGTH_SHORT).show();
    }

    public void routeMain(View view) {
        RouterUtil.route(ActivityType.main);
    }

    public void routeMain2(View view) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "传递了命名为key的参数");
        RouterUtil.route(ActivityType.main, map);
    }
}
