package com.bluemyth.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import com.bluemyth.framework.controller.SuperController;

import com.bluemyth.sys.entity.Roleuser;
import com.bluemyth.sys.service.RoleuserService;
import com.bluemyth.framework.rest.RestStatus;
import com.bluemyth.framework.rest.RestStatusUtil;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.swagger.annotations.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 用户与角色对应关系 前端控制器
 * </p>
 *
 * @author xiaot
 * @since 2018-06-14
 */
@Api(tags = {"Roleuser接口"})
@RestController
@RequestMapping("/sys/roleuser")
public class RoleuserController extends SuperController {

    private static final Logger logger = LoggerFactory.getLogger(RoleuserController.class);

    @Autowired
    private RoleuserService thisService;

    @ApiOperation("获取信息->主键")
    @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "path")
    @GetMapping("{id}")
    public RestStatus findById(@PathVariable String id) {
        Roleuser entity = thisService.selectById(id);
        return RestStatusUtil.success(entity);
    }

    @ApiOperation(value = "获取信息->依条件", notes = "查询条件,所有条件均以and连接(非必填)")
    @GetMapping("/find")
    public RestStatus find(Roleuser entity) {
        List<Roleuser> list = thisService.selectList(new EntityWrapper<Roleuser>(entity));
        return RestStatusUtil.success(list);
    }

    @ApiOperation(value = "新增信息", notes = "不传主键id")
    @PostMapping
    public RestStatus add(Roleuser entity) {
        thisService.insert(entity);
        return RestStatusUtil.success(entity);
    }

    @ApiOperation(value = "修改信息", notes = "需传主键id")
    @PutMapping
    public RestStatus update(Roleuser entity) {
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
