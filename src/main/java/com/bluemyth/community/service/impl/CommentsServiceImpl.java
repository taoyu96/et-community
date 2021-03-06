package com.bluemyth.community.service.impl;

import com.bluemyth.community.entity.Comments;
import com.bluemyth.community.mapper.CommentsMapper;
import com.bluemyth.community.service.CommentsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

}
