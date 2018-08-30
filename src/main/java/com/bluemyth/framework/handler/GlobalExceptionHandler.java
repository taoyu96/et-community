package com.bluemyth.framework.handler;

import com.bluemyth.framework.rest.RestStatus;
import com.bluemyth.framework.rest.RestStatusUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * 全局异常处理
 * Create by xiaot on 2018/6/13
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 所有异常报错
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public RestStatus allExceptionHandler(HttpServletRequest request, Exception exception) {
        exception.printStackTrace();
        return RestStatusUtil.failure("Exception：" + exception.getMessage());
    }

    @ExceptionHandler(value = SQLException.class)
    public RestStatus sqlExceptionHandler(HttpServletRequest request, SQLException exception) {
        exception.printStackTrace();
        return RestStatusUtil.failure("SQLExceptio：" + exception.getMessage());
    }

}