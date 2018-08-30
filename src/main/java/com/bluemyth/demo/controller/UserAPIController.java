package com.bluemyth.demo.controller;

import com.bluemyth.framework.annotation.Log;
import com.bluemyth.framework.rest.RestStatus;
import com.bluemyth.framework.rest.RestStatusUtil;
import com.bluemyth.demo.dto.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 1.controller 返回类型必须为 RestStatus, 详情请看 RestStatusUtil 工具类
 * 2.api设计遵循rest规范; get,post,put,delete 分别对应 查询,新增,修改,删除
 * 3.mapping 命名 一般使用 名词复数
 */
@Api(tags = {"DEMO接口"})
@RestController
@RequestMapping("/rest/users")
public class UserAPIController {

    @ApiOperation("查询用户")
    @GetMapping
    public RestStatus get(User user) {
        return RestStatusUtil.success();
    }


    @ApiOperation("获取用户信息->用户主键")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path")
    @GetMapping("{id}")
    @Log("获取用户信息->用户主键")
    public RestStatus getUserById(@PathVariable("id") String id) {
        return RestStatusUtil.success();
    }

    @ApiOperation("获取所有用户信息")
    @GetMapping("/all")
    public RestStatus getUserAll(@ApiParam(value = "查询条件,所有条件均已and连接(非必填)") User user) {
        return RestStatusUtil.success();
    }

    @ApiOperation(value = "新增用户", notes = "新增不传userid")
    @PostMapping
    public RestStatus add(User user) {
        return RestStatusUtil.success();
    }

    @ApiOperation("修改用户")
    @PutMapping
    public RestStatus update(User user) {
        return RestStatusUtil.success();
    }

    @ApiOperation("删除用户")
    @DeleteMapping
    public RestStatus delete(User user) {
        return RestStatusUtil.success();
    }

    /**
     * 表明参数的传递方式 paramType可选值:
     * query   参数以 ? 拼接传参
     * path    路径参数
     * body    请求体传参
     * form    表单传参
     * header  请求头传参
     */
    @ApiOperation("跳转登录页面")
    @ApiIgnore
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query")
    })
    @GetMapping("/login")
    public ModelAndView test(ModelAndView mv, String username, String password) {
        mv.setViewName("login");
        return mv;
    }

}
