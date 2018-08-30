package com.bluemyth.community.service.impl;

import com.bluemyth.community.entity.Messages;
import com.bluemyth.community.mapper.MessagesMapper;
import com.bluemyth.community.service.MessagesService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消息表 服务实现类
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */
@Service
public class MessagesServiceImpl extends ServiceImpl<MessagesMapper, Messages> implements MessagesService {

}
