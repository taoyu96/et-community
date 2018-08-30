package com.bluemyth.iface.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Create by xiaot on 2018/6/18
 */
public class RuleFormatUtil {

    public static String ruleTime(Date d){
        if(d==null ) return "";
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);

        long t =  System.currentTimeMillis() - d.getTime();

        if(t <= 0) return "";
        if(t < 60 * 60 * 1000l) return "刚刚";
        if(t < 24 * 60 * 60 * 1000l){
            return (int)Math.floor(t/(60 * 60 * 1000l)) + "小时前";
        }
        if(t < 7 * 24 * 60 * 60 * 1000l){
            return (int)Math.floor(t/(24 * 60 * 60 *1000l)) + "天前";
        }
        if(t < 30 * 24 * 60 * 60 * 1000l){
            return (int)Math.floor(t/(7 * 24 * 60 * 60 *1000l)) + "周前";
        }

        if(t < 365 * 24 * 60 * 60 * 1000l){
            return (int)Math.floor(t/(30 * 24 * 60 * 60 *1000l)) + "月前";
        }else  {
            return (int)Math.floor(t/(365 * 24 * 60 * 60 *1000l)) + "年前";

        }
    }

    public static String ruleVip(Integer val){
        if(val==null ) return "";
        if(val <=0) return "";
        if(val <100) return "VIP1";
        if(val <200) return "VIP2";
        if(val <400) return "VIP3";
        if(val <800) return "VIP4";
        if(val <1600) return "VIP5";
        if(val <3200) return "VIP6";
        if(val <6400) return "VIP7";
        if(val <12800) return "VIP8";
        if(val <21600) return "VIP9";
        return "终身VIP";
    }

    public static String ruleLevel(Integer val){
        if(val==null ) return "";
        if(val <=0) return "";
        if(val <100) return "1级";
        if(val <200) return "2级";
        if(val <400) return "3级";
        if(val <800) return "4级";
        if(val <1600) return "5级";
        if(val <3200) return "6级";
        if(val <6400) return "7级";
        if(val <12800) return "8级";
        if(val <21600) return "9级";
        return "10级";
    }

    public static void main(String[] args) {
        System.out.println(ruleLevel(21300));
    }
}
