package com.bluemyth.framework.rest;

/**
 * REST API 统一反馈模型，必须使用
 *
 * Create by xiaot on 2018/6/13
 */
public class RestStatusUtil {

    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";

    public static final String REST_STATUS_SUCCESS_DES = "成功";
    public static final String REST_STATUS_FAIL_DES = "失败";


    /**
     * 自定义返回
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static RestStatus instance(String code, String msg, Object data) {
        return new RestStatus(code, msg, data);
    }

    /**
     * 默认成功状态以及状态说明
     *
     * @return
     */
    public static RestStatus success() {
        return success(null);
    }

    /**
     * 默认成功状态以及状态说明，并附带反馈数据
     *
     * @return
     */
    public static RestStatus success(Object data) {
        return instance(SUCCESS, REST_STATUS_SUCCESS_DES, data);
    }

    /**
     * 默认失败状态以及状态说明
     *
     * @return
     */
    public static RestStatus failure() {
        return failure(REST_STATUS_FAIL_DES);
    }

    /**
     * 默认失败状态以及状态说明，并附带反馈数据
     *
     * @return
     */
    public static RestStatus failure(Object data) {
        return failure(REST_STATUS_FAIL_DES, data);
    }

    /**
     * 默认失败状态，自定义失败状态说明
     *
     * @return
     */
    public static RestStatus failure(String msg) {
        return failure(msg, null);
    }

    /**
     * 默认失败状态，自定义失败状态说明以及反馈数据
     *
     * @param msg
     * @param data
     * @return
     */
    public static RestStatus failure(String msg, Object data) {
        return instance(FAILURE, msg, data);
    }

}
