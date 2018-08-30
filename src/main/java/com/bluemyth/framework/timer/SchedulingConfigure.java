package com.bluemyth.framework.timer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.annotation.SchedulingConfigurer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 并行任务配置
 *
 * Create by xiaot on 2018/6/13
 */
@Configuration
@EnableScheduling
//@EnableAsync
public class SchedulingConfigure implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(20);
    }
}