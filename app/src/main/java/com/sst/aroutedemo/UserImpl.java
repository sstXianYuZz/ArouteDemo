package com.sst.aroutedemo;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sst.loginmodel.UserIProvider;
import com.sst.userlib.User;
@Route(path = "/app/UserImpl")
public class UserImpl implements UserIProvider {
    @Override
    public String getName() {
        return new User().getName();
    }

    @Override
    public void init(Context context) {

    }
}
