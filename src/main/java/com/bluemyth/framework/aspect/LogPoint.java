package com.bluemyth.framework.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 日志切入点接口类
 *
 * Create by xiaot on 2018/6/13
 */
public interface LogPoint {

	void saveLog(ProceedingJoinPoint joinPoint,long time);

}
