package com.sst.aroutlib;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.core.LogisticsCenter;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.Map;

/**
 * 示例 arouter://zhenhun/activity/main?name=珍婚&age=1900&url=https://github.com
 * 1.所有路由跳转使用RouterUtil route 方法
 * 2.目标页面注解(path = "/main/activity") 第一个路径为'activity'，第二路径activityType
 * 3.目标页面需要注解声明，接受参数及类型(注解声明的参数通过bundle 获取的)
 * 4.uri会通过&符号进行参数分割。如果发现参数缺失可以通过 getIntent().getStringExtra(ARouter.RAW_URI) 获取原始uir
 */
public class RouterUtil {
    public static final String TAG = RouterUtil.class.getSimpleName();
    public static final String SCHEME = "arouter://";
    public static final String HOST = "hibobi";

    public static void route(@NonNull String type) {
        route(type, null);
    }

    public static void route(@NonNull String type, Map<String, Object> params) {
        startRoute(getRouterUrl(type, params));
    }

    public static void routeForResult(@NonNull String type, Map<String, Object> params, Activity mContext, Integer requestCode) {

        String url = getRouterUrl(type, params);
        Uri uri = Uri.parse(url);
        Log.e(TAG, uri.toString());
        ARouter.getInstance().build(uri).navigation(mContext, requestCode);
    }

    public static void routeForResult(@NonNull String type, Map<String, Object> params, Fragment mContext, int requestCode) {

        String url = getRouterUrl(type, params);
        Uri uri = Uri.parse(url);
        Log.e(TAG, uri.toString());
        Postcard postcard = ARouter.getInstance()
                .build(uri);
        LogisticsCenter.completion(postcard);
        Intent intent = new Intent(mContext.getContext(), postcard.getDestination());
        mContext.startActivityForResult(intent, requestCode);
    }

    private static void startRoute(String url) {
        if (TextUtils.isEmpty(url)) {
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

    public static String getRouterUrl(@NonNull String type, Map<String, Object> params) {
        if (null == type) {
            return null;
        }

        StringBuffer stringBuffer = new StringBuffer(SCHEME);
        stringBuffer.append(HOST);
        stringBuffer.append(type);
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

