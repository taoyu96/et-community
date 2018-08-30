package com.bluemyth.demo.controller;

import com.bluemyth.framework.websocket.ClientMessage;
import com.bluemyth.framework.websocket.ServerMessage;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;


/**
 * Create by xiaot on 2018/6/13
 */
@Controller
public class WebSocketController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @MessageMapping("/sendTest")
    @SendTo("/topic/subscribeTest")
    public ServerMessage sendTest(ClientMessage message) {
        logger.info("sendTest：接收信息 >>" + message.getName());
        return new ServerMessage("你发送的消息为:" + message.getName());
    }

    @SubscribeMapping("/subscribeTest")
    public ServerMessage subscribeTest() {
        logger.info("subscribeTest：感谢你订阅了我！");
        return new ServerMessage("感谢你订阅了我！");
    }
}
