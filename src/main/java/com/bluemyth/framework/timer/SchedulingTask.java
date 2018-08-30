package com.bluemyth.framework.timer;

import com.bluemyth.framework.websocket.ServerMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

/**
 * 定时任务
 *
 * Create by xiaot on 2018/6/13
 */
@Configuration
@EnableScheduling
public class SchedulingTask {

    private static final Logger log = LoggerFactory.getLogger(SchedulingTask.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * 通过@Scheduled声明该方法是计划任务
     * 1、@Scheduled(fixedRate = 5000)，使用fixedRate属性每隔固定时间5秒执行一次
     * 2、@Scheduled(cron = “0 0/10 * * * ?”)，使用cron属性可按照指定时间执行，指的是每10分钟执行一次；
     */
    @Scheduled(fixedRate = 60 * 1000)
    public void excute() {
        log.info("触发定时webSocket发送...");
        try {
            messagingTemplate.convertAndSend("/topic/subscribeTest", new ServerMessage("服务器主动推的数据"));
        } catch (Exception e) {
            log.error("触发定时webSocket群发异常:" + e.getMessage());
        }
    }

    //@Scheduled(cron = "0 0 9,11,13,15,18 * * ?")
    public void doTask() {
        try {
            log.info("执行效能监察监控更新...");
        } catch (Exception e) {
            log.error("执行效能监察监控更新异常:" + e.getMessage());
        }
    }

}
