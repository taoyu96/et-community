
package com.bluemyth.framework.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 日志切面处理类
 *
 * Create by xiaot on 2018/6/13
 */
@Aspect
//@Component
public class LogAspect {

	/**
	 * 日志切入点
	 */
	private LogPoint logPoint;

	/**
	 * 默认 级别最高级0，数字越大级别越底
	 */
	private int level;

	public void setLogPoint(LogPoint logPoint) {
		this.logPoint = logPoint;
	}

	/**
	 * 设置日志保存级别
	 * @param level
	 */
	public void setLevel(int level){
		this.level = level;
	}


	/**
	 * 保存系统操作日志
	 *
	 * @param joinPoint  连接点
	 * @return 方法执行结果
	 * @throws Throwable 调用出错
	 */
	@Around(value = "@annotation(com.bluemyth.framework.annotation.Log)")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long beginTime = System.currentTimeMillis();
		Object result = joinPoint.proceed(); 	//执行方法
		long time = System.currentTimeMillis() - beginTime; //执行时长(毫秒)
		logPoint.saveLog(joinPoint,time);
		return result;
	}

}
