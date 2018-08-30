package com.bluemyth.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import com.bluemyth.framework.controller.SuperController;

import com.bluemyth.community.entity.Comments;
import com.bluemyth.community.service.CommentsService;
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
 * 评论表 前端控制器
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */
@Api(tags = {"Comments接口"})
@RestController
@RequestMapping("/community/comments")
public class CommentsController extends SuperController {

    private static final Logger logger = LoggerFactory.getLogger(CommentsController.class);

    @Autowired
    private CommentsService thisService;

    @ApiOperation("获取信息->主键")
    @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "path")
    @GetMapping("{id}")
    public RestStatus findById(@PathVariable String id) {
        Comments entity = thisService.selectById(id);
        return RestStatusUtil.success(entity);
    }

    @ApiOperation(value = "获取信息->依条件", notes = "查询条件,所有条件均以and连接(非必填)")
    @GetMapping("/find")
    public RestStatus find(Comments entity) {
        List<Comments> list = thisService.selectList(new EntityWrapper<Comments>(entity));
        return RestStatusUtil.success(list);
    }

    @ApiOperation(value = "新增信息", notes = "不传主键id")
    @PostMapping
    public RestStatus add(Comments entity) {
        thisService.insert(entity);
        return RestStatusUtil.success(entity);
    }

    @ApiOperation(value = "修改信息", notes = "需传主键id")
    @PutMapping
    public RestStatus update(Comments entity) {
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
