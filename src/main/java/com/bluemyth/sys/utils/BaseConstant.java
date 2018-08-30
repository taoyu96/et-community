package com.bluemyth.sys.utils;

/**
 * 基础编码
 *
 * Create by xiaot on 2018/6/14
 */
public class BaseConstant {

    public static final String SUPER_ADMIN_KEY = "00000000-0000-0000-0000-000000000000";

    /**
     * 菜单类型
     */
    public enum MenuType {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
