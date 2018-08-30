package com.bluemyth.framework.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * 访问认证
 * Create by xiaot on 2018/6/13
 */
@WebFilter(filterName = "authFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private List<String> whiteList = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        whiteList.add("/users");
        logger.debug("初始化白名单");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();
        chain.doFilter(request, response);
        /*----------------------------------*/
       /* if (whiteList.contains(requestURI)) {
            List<String> collect = whiteList.stream().filter(s -> Pattern.matches(s, requestURI)).collect(Collectors.toList());
            chain.doFilter(request, response);
        } else {
            Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
            String authorization = null;
            while (headerNames.hasMoreElements()) {
                String s = headerNames.nextElement();
                if ("authorization".equals(s)) {
                    authorization = httpServletRequest.getHeader(s);
                    try {
                        Claims claims = JWTUtil.parseJWT(authorization);
                        request.setAttribute("info", claims);
                        chain.doFilter(request, response);
                    } catch (JwtException e) {

                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
            Cookie[] cookies = httpServletRequest.getCookies();
            if (cookies != null) {
                Arrays.asList(cookies).forEach((cookie) -> {
                    cookie.getName();
                    cookie.getValue();
                });
            }
        }*/
    }

    @Override
    public void destroy() {

    }
}
