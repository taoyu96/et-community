package com.bluemyth.sys.service.impl;

import com.bluemyth.framework.annotation.Log;
import com.bluemyth.framework.aspect.LogPoint;
import com.bluemyth.framework.utils.RequestHelper;
import com.bluemyth.framework.utils.IpHelper;
import com.bluemyth.sys.entity.Syslog;
import com.bluemyth.sys.mapper.SyslogMapper;
import com.bluemyth.sys.service.SyslogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Enumeration;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaot
 * @since 2018-06-13
 */
@Service
public class SyslogServiceImpl extends ServiceImpl<SyslogMapper, Syslog> implements SyslogService, LogPoint {


    private static final String LOG_CONTENT = "[类名]:%s,[方法]:%s,[参数]:%s,[IP]:%s";

    /**
     *
     * 日志入库
     *
     * @param joinPoint
     * @param time 执行时间
     */
    @Override
    public void saveLog(ProceedingJoinPoint joinPoint, long time ) {
        HttpServletRequest request = RequestHelper.getHttpServletRequest();

        //解析Log注解
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = signature.getName();
        Log log = method.getAnnotation(Log.class);

        //日志入库
        Syslog syslog = new Syslog();
        syslog.setUid("");
        syslog.setUname("");
        syslog.setContent(operateContent(joinPoint, methodName, request));
        syslog.setOperation(log.value());
        syslog.setLevel(log.level());
        syslog.setExcutetime(time);
        syslog.setCreatetime(new Timestamp(System.currentTimeMillis()));

        baseMapper.insert(syslog);
    }

    /**
     * 获取当前执行的方法
     *
     * @param joinPoint  连接点
     * @param methodName  方法名称
     * @return 操作内容
     */
    @SuppressWarnings("unchecked")
    private String operateContent(ProceedingJoinPoint joinPoint, String methodName, HttpServletRequest request) {
        String className = joinPoint.getTarget().getClass().getName();
        Object[] params = joinPoint.getArgs();
        StringBuffer bf = new StringBuffer();
        if (params != null && params.length > 0) {
            Enumeration<String> paraNames = request.getParameterNames();
            while (paraNames.hasMoreElements()) {
                String key = paraNames.nextElement();
                bf.append(key).append("=");
                bf.append(request.getParameter(key)).append("&");
            }
            if (StringUtils.isBlank(bf.toString())) {
                bf.append(request.getQueryString());
            }
        }
        return String.format(LOG_CONTENT, className, methodName, bf.toString(), IpHelper.getIpAddr(request));
    }

}
