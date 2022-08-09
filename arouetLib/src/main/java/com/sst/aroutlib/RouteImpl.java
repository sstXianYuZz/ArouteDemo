package com.sst.aroutlib;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Description TODO
 * @Author sst
 * @Date 2022/8/9 3:39 下午
 */
@StringDef({RouteImpl.UserImpl})
@Retention(RetentionPolicy.SOURCE)
public @interface RouteImpl {
    String base = "/app/";
    String UserImpl = base + "UserImpl";
}
