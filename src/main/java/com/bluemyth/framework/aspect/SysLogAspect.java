/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.bluemyth.framework.aspect;

import com.bluemyth.framework.annotation.Log;
import com.bluemyth.framework.utils.HttpHelper;
import com.bluemyth.framework.utils.IpHelper;
import com.bluemyth.sys.entity.Syslog;
import com.bluemyth.sys.service.SyslogService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Enumeration;

/**
 * 系统日志，切面处理类
 *
 * 不需要切点
 *
 * Create by xiaot on 2018/6/13
 *
 */
//@Aspect
//@Component
public class SysLogAspect {

	private static final String LOG_CONTENT = "[类名]:%s,[方法]:%s,[参数]:%s,[IP]:%s";

	@Autowired
	private SyslogService syslogService;
	
	@Pointcut("@annotation(com.bluemyth.framework.annotation.Log)")
	public void logPointCut() { 
		
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		Object result = point.proceed(); //执行方法
		long time = System.currentTimeMillis() - beginTime; //执行时长(毫秒)
		saveLog(point, time);//保存日志
		return result;
	}

	/**
	 *
	 * 日志入库
	 *
	 * @param joinPoint
	 * @param time 执行时间
	 */
	private void saveLog(ProceedingJoinPoint joinPoint, long time ) {
		HttpServletRequest request = HttpHelper.getHttpServletRequest();

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

		syslogService.insert(syslog);
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
