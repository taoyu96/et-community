package com.bluemyth.framework.rest;

/**
 * rest 反馈模型
 *
 * Create by xiaot on 2018/6/13
 */
public class RestStatus {

    private String status;
    private String message;
    private Object data;

    public RestStatus(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data = this.data == null ? "" : data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("{");
        sb.append("\"status\":" + status);
        sb.append(",\"message\":" + message);
        //sb.append(",\"data\":"+data==null?null:data.toString());
        sb.append("}");
        return sb.toString();
    }
}