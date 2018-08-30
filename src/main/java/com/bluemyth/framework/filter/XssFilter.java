package com.bluemyth.framework.filter;


import com.bluemyth.framework.filter.wrapper.XssHttpServletRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Xss过滤
 * Create by xiaot on 2018/6/13
 */
@WebFilter(filterName = "XssFilter", urlPatterns = "/*")
public class XssFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpResponse.addHeader("Set-Cookie", "name=value; HttpOnly");
        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(httpRequest);
        chain.doFilter(xssRequest, response);
    }

    @Override
    public void destroy() {

    }

}
