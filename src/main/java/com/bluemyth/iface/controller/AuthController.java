package com.bluemyth.iface.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.bluemyth.framework.controller.SuperController;
import com.bluemyth.framework.rest.RestStatus;
import com.bluemyth.framework.rest.RestStatusUtil;
import com.bluemyth.framework.utils.JWTUtil;
import com.bluemyth.sys.entity.User;
import com.bluemyth.sys.entity.Userinfo;
import com.bluemyth.sys.service.UserService;
import com.bluemyth.sys.service.UserinfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.JwtException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("auth")
public class AuthController extends SuperController {

    @Autowired
    private  UserService userService;
    @Autowired
    private UserinfoService  userinfoService;

    private static Map<String,String> CODE_MAP = new HashMap<>();//暂存


    @PostMapping("login")
    public RestStatus login(String account, String password, String verifyCode,String verifyCodeKey) {

        if(StringUtils.isBlank(account)||StringUtils.isBlank(password)
                ||StringUtils.isBlank(verifyCode)) {
            return RestStatusUtil.failure("非法参数");
        }

        //String code = (String) session.getAttribute("verifyCodeKey");

        String code = CODE_MAP.get(verifyCodeKey);
        CODE_MAP.remove(verifyCodeKey);//清除
        if(!StringUtils.equals(code,verifyCode)){
            return RestStatusUtil.failure("验证码错误");
        }

        User param = new User();
        param.setAccount(account);
        User user = userService.selectOne(new EntityWrapper<>(param));
        if (Optional.ofNullable(user).isPresent()) {
            if (user.getStatus() != 1) {
                return RestStatusUtil.failure("帐号已失效,请联系系统管理员");
            } else {

                if(!StringUtils.equals(password,user.getPassword())){
                    return RestStatusUtil.failure("密码错误");
                }

                Userinfo userInfo = userinfoService.selectById(user.getUserid());
                ObjectMapper objectMapper = new ObjectMapper();
                String subject = "";
                try {
                    subject = objectMapper.writeValueAsString(userInfo);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                String jwt = JWTUtil.createJWT(UUID.randomUUID().toString(), subject);
                return RestStatusUtil.success(new HashMap<String, Object>(2) {{
                    put("jwt", jwt);
                    put("info", userInfo);
                }});
            }
        } else {
            return RestStatusUtil.failure("请重新核对登录信息");
        }
    }


    @PostMapping("reg")
    public RestStatus reg( User user, Userinfo userinfo, String verifyCode,String verifyCodeKey) {

        if (StringUtils.isBlank(user.getEmail()) || StringUtils.isBlank(userinfo.getNickname()) || StringUtils.isBlank(user.getPassword())
                || StringUtils.isBlank(verifyCode) || StringUtils.isBlank(verifyCodeKey)) {
            return RestStatusUtil.failure("非法参数");
        }


        String code = CODE_MAP.get(verifyCodeKey);
        CODE_MAP.remove(verifyCodeKey);//清除
        if (!StringUtils.equals(code, verifyCode)) {
            return RestStatusUtil.failure("验证码错误");
        }

        user.setAccount(user.getEmail());
        user.setStatus(1);
        user.setCreatetime(new Date());
        userService.insert(user);

        userinfo.setUserid(user.getUserid());
        userinfoService.insert(userinfo);
        return RestStatusUtil.success();
    }

    @GetMapping("verifyCode")
    public RestStatus verifyCode() throws JwtException {
        long a = Math.round(Math.random() * 10 ), b= Math.round(Math.random() * 10 );
        String code  = a > b? (a-b)+"":(b-a)+"";
        String text  = a > b? (a + "-" + b +" =?"):(b + "-" + a +" =?");

        //session.setAttribute("verifyCodeKey",code);
        //return RestStatusUtil.success(text);

        String verifyCodeKey =  UUID.randomUUID().toString();
        CODE_MAP.put(verifyCodeKey,code);
        return RestStatusUtil.success(new HashMap<String, Object>(2) {{
            put("code", code);
            put("key", verifyCodeKey);
            put("text", text);
        }});
    }

    @GetMapping("pasre")
    public RestStatus pasreJWT(String jwt) throws JwtException {
        String subject = JWTUtil.parseJWT(jwt).getSubject();
        return RestStatusUtil.success(subject);
    }

}
