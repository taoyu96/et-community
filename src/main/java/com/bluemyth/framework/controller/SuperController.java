package com.bluemyth.framework.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.bluemyth.framework.utils.HttpUtil;
import com.bluemyth.framework.utils.JWTUtil;
import com.bluemyth.sys.entity.Userinfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.jsonwebtoken.JwtException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

/**
 * Controller 基础类
 *
 */
public class SuperController {

    protected Logger logger = LoggerFactory.getLogger(SuperController.class);

    @Autowired
    protected HttpServletRequest request;

    //@Autowired
    //protected HttpServletResponse response;

    @Autowired
    protected HttpSession session;

    @Autowired
    protected ServletContext servletContext;

    /**
     * 用户ID
     */
    protected Object getCurrentUserId() {
        Object u = this.getCurrentUser();
        LinkedHashMap userinfo = (LinkedHashMap)u;
        return  userinfo==null?null:userinfo.get("userid");
    }

    protected Object getCurrentUser() {
        String jwt = request.getParameter("jwt");
        if(StringUtils.isBlank(jwt)) return  null;

        try {
            String subject = JWTUtil.parseJWT(jwt).getSubject();
            ObjectMapper mapper = new ObjectMapper();
            Object u = mapper.readValue(subject, Object.class);
            return u;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("parseJWT解析异常！");
        }
        return  null;
    }

    /**
     * 是否为 post 请求
     */
    protected boolean isPost() {
        return HttpUtil.isPost(request);
    }

    /**
     * 是否为 get 请求
     */
    protected boolean isGet() {
        return HttpUtil.isGet(request);
    }

    /**
     * <p>
     * 获取分页对象
     * </p>
     */
    protected <T> Page<T> getPage() {
        return getPage(10);
    }

    /**
     * <p>
     * 获取分页对象
     * </p>
     *
     * @param size 每页显示数量
     * @return
     */
    protected <T> Page<T> getPage(int size) {
        //int page, int limit  //根据ui 制定
        int _size = size, _index = 1;

        if (request.getParameter("limit") != null) {
            _size = Integer.parseInt(request.getParameter("limit"));
        }

        if (request.getParameter("page") != null) {
            _index = Integer.parseInt(request.getParameter("page"));
        }
        return new Page<T>(_index, _size);
    }

    /**
     * 重定向至地址 url
     *
     * @param url 请求地址
     * @return
     */
    protected String redirectTo(String url) {
        StringBuffer rto = new StringBuffer("redirect:");
        rto.append(url);
        return rto.toString();
    }


}
