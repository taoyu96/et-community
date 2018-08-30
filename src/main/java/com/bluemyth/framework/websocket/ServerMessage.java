package com.bluemyth.framework.websocket;

/**
 * Create by xiaot on 2018/6/13
 */
public class ServerMessage {

    private String responseMessage;

    public ServerMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
