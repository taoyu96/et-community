package com.bluemyth.framework.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 允许跨域
 * Create by xiaot on 2018/6/13
 */
@WebFilter(filterName = "crossFilter", urlPatterns = "/*")
public class CrossFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(CrossFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest resq = (HttpServletRequest) request;

        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type,Authorization");
        resp.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
