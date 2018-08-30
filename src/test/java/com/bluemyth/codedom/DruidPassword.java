package com.bluemyth.codedom;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * Druid 加密/解密
 *
 * Create by xiaot on 2018/6/13
 */
public class DruidPassword {

    public static void main(String[] args) throws Exception {
        ConfigTools configTools = new ConfigTools();
        String password = "password";
        String[] arr = configTools.genKeyPair(512);
        System.out.println("privateKey:" + arr[0]);
        System.out.println("publicKey:" + arr[1]);

        System.out.println("password_encrypt:" + configTools.encrypt(arr[0], password));
        System.out.println("password:" + configTools.decrypt(arr[1],configTools.encrypt(arr[0], password)));
    }
}
