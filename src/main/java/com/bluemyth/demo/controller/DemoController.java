package com.bluemyth.demo.controller;

import com.bluemyth.framework.controller.SuperController;
import com.bluemyth.framework.rest.RestStatus;
import com.bluemyth.framework.rest.RestStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaot on 2018/3/14.
 */
@RestController
public class DemoController extends SuperController{

    @Value("${jwt.stringKey}")
    private String hello;

    @RequestMapping("/demo")
    public RestStatus hello() {
        return RestStatusUtil.success(hello);
    }

    @RequestMapping("/demo/{id}")
    public RestStatus hello1(@PathVariable String id) {
        System.out.println(request.getRequestURI());
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("text", hello);
        return RestStatusUtil.success(map);
    }

    @RequestMapping("/exp")
    public RestStatus exp() throws SQLException {
        throw new SQLException("SQLException");
        //return RestStatusUtil.success();
    }

    @RequestMapping("/exp1")
    public RestStatus exp1() {
        throw new RuntimeException("RuntimeException");
    }


    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/uri")
    public RestStatus testGet() {
        System.out.println(request.getRequestURI());
        String url = "http://localhost:8080/et-api/demo/1";
        ResponseEntity<Map> entity = restTemplate.getForEntity(url, Map.class);
        Map body = entity.getBody();
        List data = (List) body.get("data");
        for (int i = 0; i < data.size(); i++) {
            Map map = (Map) data.get(i);
            System.out.println(map.get("text"));
        }
        return RestStatusUtil.success(data);
    }

    @RequestMapping("/uri/post")
    public RestStatus testPost() {
        String url = "http://www.bluemyth.club/homepage";
        Map postData = new HashMap();
        postData.put("descp", "request for post");
        ResponseEntity<String> entity = restTemplate.postForEntity(url, postData, String.class);
        HttpStatus body = entity.getStatusCode();
        return RestStatusUtil.success(body);
    }


}

