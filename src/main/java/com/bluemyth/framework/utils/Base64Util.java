package com.bluemyth.framework.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

public class Base64Util {

    public static String encodeBase64(String str) {
        str = StringUtils.trimToEmpty(str);
        if (StringUtils.isBlank(str)) return "";
        return new String(Base64.encodeBase64(str.getBytes()));
    }

    public static String decodeBase64(String str) {
        str = StringUtils.trimToEmpty(str);
        if (StringUtils.isBlank(str)) return "";
        return new String(Base64.decodeBase64(str));
    }

    public static void main(String[] args) {
        System.out.println(decodeBase64("L2FyZWEvdHVyblRvQXJlYU9mTW9kaWZ5SlNQLmRv"));
        System.out.println(encodeBase64("/area/turnToAreaOfModifyJSP.do"));
    }
}
