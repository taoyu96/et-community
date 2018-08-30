package com.bluemyth.framework.aspect;


import com.bluemyth.framework.utils.SpringContextUtils;
import com.bluemyth.sys.service.impl.SyslogServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 *使用自定义切入点
 *
 * Create by xiaot on 2018/6/13
 */

@Configuration
public class AopConfigure {


    @Bean
    public LogAspect logAspect(){
        LogAspect logAspect = new LogAspect();
        logAspect.setLevel(0);
        logAspect.setLogPoint(SpringContextUtils.getBean(SyslogServiceImpl.class));
        return logAspect;
    }

}
