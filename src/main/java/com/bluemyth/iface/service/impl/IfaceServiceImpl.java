package com.bluemyth.iface.service.impl;

import com.bluemyth.iface.dto.*;
import com.bluemyth.iface.mapper.IfaceMapper;
import com.bluemyth.iface.service.IfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 文章/帖附件 服务实现类
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */
@Service
public class IfaceServiceImpl implements IfaceService {

    @Autowired
    private IfaceMapper ifaceMapper;

    @Override
    public List<ActicleDto> findActiclelist(String type,String status){
        return ifaceMapper.findActiclelist(type,status);
    }

    @Override
    public List<ActicleDto> findActiclehot(String type){
        return ifaceMapper.findActiclehot(type);
    }

    @Override
    public List<ActicleDto> findArticlerecently(String userid){
        return ifaceMapper.findArticlerecently(userid);
    }

    @Override
    public List<UserCommontDto>  findCommoentsrecently(String userid){
        return ifaceMapper.findCommoentsrecently(userid);
    }

    @Override
    public List<UserActiveDto>  findActivelist(){
        return ifaceMapper.findActivelist();
    }

    @Override
    public  ActicleDto  findArticleById(String articleid){
        return ifaceMapper.findArticleById(articleid);
    }

    @Override
    public  List<CommentDto> findCommentsById(String acticleid){
        return ifaceMapper.findCommentsById(acticleid);
    }


    @Override
    public  Integer findMessagenum(String userid){
        return ifaceMapper.findMessagenum(userid);
    }

    @Override
    public  List<MessagesDto> findMessagelist(String userid){
        return ifaceMapper.findMessagelist(userid);
    }

    @Override
    public List<CollectDto> findCollectlist(String userid){
        return ifaceMapper.findCollectlist(userid);
    }

}
