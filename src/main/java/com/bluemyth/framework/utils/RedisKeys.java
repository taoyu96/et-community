package com.bluemyth.framework.utils;

/**
 *
 *
 * Redis所有Keys
 *
 * Create by xiaot on 2018/6/14
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }

    public static String getShiroSessionKey(String key){
        return "sessionid:" + key;
    }
}
