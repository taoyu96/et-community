package com.bluemyth.framework.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * 拦截器
 * Create by xiaot on 2018/6/13
 */
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        HttpSession session = request.getSession();
        System.out.println(">>>preHandle>>>>>>>在请求处理之前进行调用（Controller方法调用之前）"+ url);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println(">>>postHandle>>>>>>>请求处理之后进行调用，但是在DispatcherServlet视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println(">>>afterCompletion>>>>>>>在整个请求完成之后，也就是DispatcherServlet渲染了视图之后执行，主要用于清理资源的");
    }
}
