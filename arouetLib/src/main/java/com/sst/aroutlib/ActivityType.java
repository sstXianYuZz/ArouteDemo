package com.sst.aroutlib;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({ActivityType.main, ActivityType.login})
@Retention(RetentionPolicy.SOURCE)
public @interface ActivityType {
    String base = "/activity/";
    String main = base + "main";
    String login = base + "login";

}
