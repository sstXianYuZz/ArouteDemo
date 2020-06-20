package com.sst.aroutlib;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.Map;
import java.util.logging.Logger;

/**
 * 示例 arouter://aroutedemo/activity/main?age=1900&url=https://github.com
 * 1.所有路由跳转使用RouterUtil route 方法
 * 2.目标页面注解(path = "/main/activity") 第一个路径为'activity'，第二路径activityType
 * 3.目标页面需要注解声明，接受参数及类型(注解声明的参数通过bundle 获取的)
 * 4.uri会通过&符号进行参数分割。如果发现参数缺失可以通过 getIntent().getStringExtra(ARouter.RAW_URI) 获取原始uir
 */
public class RouterUtil {
    public static final String TAG = RouterUtil.class.getSimpleName();
    public static final String SCHEME = "arouter://";
    public static final String HOST = "aroutedemo/";

    public static void route(@NonNull ActivityType type) {
        route(type, null);
    }

    public static void route(@NonNull ActivityType type, Map<String, Object> params) {
        route(getRouterUrl(type, params));
    }

    public static void routeForResult(@NonNull ActivityType type, Map<String, Object> params, Activity mContext, Integer requestCode) {
        String url = getRouterUrl(type, params);
        Uri uri = Uri.parse(url);
        ARouter.getInstance().build(uri).navigation(mContext, requestCode);
    }

    public static void route(String url) {
        if (null == url) {
            return;
        }
        Uri uri = Uri.parse(url);
        Log.e(TAG, uri.toString());
        try {
            ARouter.getInstance().build(uri).navigation();
        } catch (Exception e) {
            Log.e(TAG, "router exception");
        }
    }

    public static String getRouterUrl(@NonNull ActivityType type, Map<String, Object> params) {
        if (null == type) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(SCHEME);
        stringBuffer.append(HOST);
        stringBuffer.append("activity/");
        stringBuffer.append(type.name());
        if (null != params) {
            stringBuffer.append("?");
            for (String key : params.keySet()) {
                if (stringBuffer.toString().endsWith("?")) {
                    stringBuffer.append(key).append("=").append(params.get(key));
                } else {
                    stringBuffer.append("&").append(key).append("=").append(params.get(key));
                }
            }
        }
        return stringBuffer.toString();
    }

}

