package com.bluemyth.framework.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 *
 * Create by xiaot on 2018/6/13
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

	/**
	 * 操作描述
	 */
	String value() default "";

	/**
	 * 日志级别
	 * @return
	 */
	int level() default 0;

}
