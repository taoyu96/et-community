package com.bluemyth.sys.mapper;

import com.bluemyth.sys.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author xiaot
 * @since 2018-06-14
 */
public interface UserMapper extends BaseMapper<User> {


    /**
     * 查询用户的所有权限
     * @param userid  用户ID
     */
    List<String> queryAllPerms(String userid);

    /**
     * 查询用户的所有菜单ID
     */
    List<String> queryAllMenuId(String userid);

}
