package com.bluemyth.sys.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.bluemyth.framework.controller.SuperController;
import com.bluemyth.framework.rest.RestStatus;
import com.bluemyth.framework.rest.RestStatusUtil;
import com.bluemyth.sys.entity.Syslog;
import com.bluemyth.sys.service.SyslogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaot
 * @since 2018-06-14
 */
@Api(tags = {"Syslog接口"})
@RestController
@RequestMapping("/sys/syslog")
public class SyslogController extends SuperController {

    private static final Logger logger = LoggerFactory.getLogger(SyslogController.class);

    @Autowired
    private SyslogService thisService;

    @RequiresPermissions("sys:syslog:findById")
    @ApiOperation("获取信息->主键")
    @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "path")
    @GetMapping("{id}")
    public RestStatus findById(@PathVariable String id) {
        Syslog entity = thisService.selectById(id);
        return RestStatusUtil.success(entity);
    }

    @ApiOperation(value = "获取信息->依条件", notes = "查询条件,所有条件均以and连接(非必填)")
    @GetMapping("/find")
    public RestStatus find(Syslog entity) {
        List<Syslog> list = thisService.selectList(new EntityWrapper<Syslog>(entity));
        return RestStatusUtil.success(list);
    }

    @ApiOperation(value = "新增信息", notes = "不传主键id")
    @PostMapping
    public RestStatus add(Syslog entity) {
        thisService.insert(entity);
        return RestStatusUtil.success(entity);
    }

    @ApiOperation(value = "修改信息", notes = "需传主键id")
    @PutMapping
    public RestStatus update(Syslog entity) {
        thisService.updateById(entity);
        return RestStatusUtil.success(entity);
    }

    @ApiOperation(value = "删除信息",notes = "支持批量删除,以“,”分割")
    @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query", dataType = "array" )
    @DeleteMapping
    public RestStatus delete(String... id) {
        thisService.deleteBatchIds(Arrays.asList(id));
        return RestStatusUtil.success();
    }

}
