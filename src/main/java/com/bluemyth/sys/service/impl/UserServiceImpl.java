package com.bluemyth.sys.service.impl;

import com.bluemyth.sys.entity.User;
import com.bluemyth.sys.mapper.UserMapper;
import com.bluemyth.sys.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author xiaot
 * @since 2018-06-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
