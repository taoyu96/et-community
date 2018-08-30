package com.bluemyth.iface.controller;

import com.bluemyth.community.entity.Article;
import com.bluemyth.framework.controller.SuperController;
import com.bluemyth.framework.rest.RestStatus;
import com.bluemyth.framework.rest.RestStatusUtil;
import com.bluemyth.iface.dto.*;
import com.bluemyth.iface.service.IfaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 帖信息 前端控制器
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */
@Api(tags = {"Iface接口"})
@RestController
@RequestMapping("/iface")
public class IfaceController extends SuperController {

    private static final Logger logger = LoggerFactory.getLogger(IfaceController.class);

    @Autowired
    private IfaceService ifaceService;

    @ApiOperation("获取帖子列表->帖子类型type")
    @ApiImplicitParams( {
            @ApiImplicitParam(name = "type", value = "帖子类型type", required = true, paramType = "query"),
            @ApiImplicitParam(name = "status", value = "帖子状态", required = true, paramType = "query")
    })
    @GetMapping("articlelist")
    public RestStatus articlelist(String type,String status) {
        List<ActicleDto> list = ifaceService.findActiclelist(type,status);
        return RestStatusUtil.success(list);
    }

    @ApiOperation("获取热帖列表->热帖类型type")
    @ApiImplicitParam(name = "type", value = "热帖类型type", required = true, paramType = "query")
    @GetMapping("articlehot")
    public RestStatus articlehot(String type) {
        List<ActicleDto> list = ifaceService.findActiclehot(type);
        return RestStatusUtil.success(list);
    }

    @ApiOperation("获取用户最近发布的帖子->用户主键userid")
    @ApiImplicitParam(name = "type", value = "热帖类型type", required = true, paramType = "query")
    @GetMapping("articlerecently")
    public RestStatus articlerecently(String userid) {
        List<ActicleDto> list = ifaceService.findArticlerecently(userid);
        return RestStatusUtil.success(list);
    }

    @ApiOperation("获取用户最近回答->用户主键userid")
    @ApiImplicitParam(name = "type", value = "热帖类型type", required = true, paramType = "query")
    @GetMapping("commoentsrecently")
    public RestStatus commoentsrecently(String userid) {
        List<UserCommontDto> list = ifaceService.findCommoentsrecently(userid);
        return RestStatusUtil.success(list);
    }

    @ApiOperation("获取活跃回答的用户")
    @GetMapping("/activelist")
    public RestStatus activelist() {
        List<UserActiveDto> userActiveDtos = ifaceService.findActivelist();
        return RestStatusUtil.success(userActiveDtos);
    }

    @ApiOperation("获取帖子信息->帖子主键id")
    @ApiImplicitParam(name = "id", value = "帖子主键id", required = true, paramType = "query")
    @GetMapping("/articleone")
    public RestStatus findArticleById(String id) {
        ActicleDto acticleDto = ifaceService.findArticleById(id);
        return RestStatusUtil.success(acticleDto);
    }

    @ApiOperation("获取帖子的评论信息->帖子主键id")
    @ApiImplicitParam(name = "id", value = "帖子主键id", required = true, paramType = "query")
    @GetMapping("/comments")
    public RestStatus findCommentsById(String id) {
        List<CommentDto> commentDtos = ifaceService.findCommentsById(id);
        return RestStatusUtil.success(commentDtos);
    }

    @ApiOperation("消息数->用户主键id")
    @ApiImplicitParam(name = "userid", value = "用户主键id", required = true, paramType = "query")
    @GetMapping("/messagenum")
    public RestStatus messagenum(String userid) {
        Integer num = ifaceService.findMessagenum(userid);
        return RestStatusUtil.success(num);
    }

    @ApiOperation("消息列表->用户主键id")
    @ApiImplicitParam(name = "userid", value = "用户主键id", required = true, paramType = "query")
    @GetMapping("/messagelist")
    public RestStatus messagelist(String userid) {
        List<MessagesDto> list = ifaceService.findMessagelist(userid);
        return RestStatusUtil.success(list);
    }

    @ApiOperation("收藏列表->用户主键id")
    @ApiImplicitParam(name = "userid", value = "用户主键id", required = true, paramType = "query")
    @GetMapping("/collectlist")
    public RestStatus collectlist(String userid) {
        List<CollectDto> list = ifaceService.findCollectlist(userid);
        return RestStatusUtil.success(list);
    }

}
