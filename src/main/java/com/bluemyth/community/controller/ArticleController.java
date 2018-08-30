package com.bluemyth.community.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import com.bluemyth.framework.controller.SuperController;

import com.bluemyth.community.entity.Article;
import com.bluemyth.community.service.ArticleService;
import com.bluemyth.framework.rest.RestStatus;
import com.bluemyth.framework.rest.RestStatusUtil;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.swagger.annotations.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 帖信息 前端控制器
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */
@Api(tags = {"Article接口"})
@RestController
@RequestMapping("/community/article")
public class ArticleController extends SuperController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService thisService;

    @ApiOperation("获取信息->主键")
    @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "path")
    @GetMapping("{id}")
    public RestStatus findById(@PathVariable String id) {
        Article entity = thisService.selectById(id);
        return RestStatusUtil.success(entity);
    }

    @ApiOperation(value = "获取信息->依条件", notes = "查询条件,所有条件均以and连接(非必填)")
    @GetMapping("/find")
    public RestStatus find(Article entity) {
        List<Article> list = thisService.selectList(new EntityWrapper<Article>(entity));
        return RestStatusUtil.success(list);
    }

    @ApiOperation(value = "新增信息", notes = "不传主键id")
    @PostMapping
    public RestStatus add(Article entity) {
        String userid = (String) this.getCurrentUserId();
        if(StringUtils.isBlank(userid)) throw  new RuntimeException("非法参数！");
        entity.setUserid(userid);
        entity.setCreatetime(new Date());
        thisService.insert(entity);
        return RestStatusUtil.success(entity);
    }

    @ApiOperation(value = "修改信息", notes = "需传主键id")
    @PutMapping
    public RestStatus update(Article entity) {
        String userid = (String) this.getCurrentUserId();
        if(StringUtils.isBlank(userid)) throw  new RuntimeException("非法参数！");
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
