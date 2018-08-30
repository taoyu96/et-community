package com.bluemyth.iface.service;

import com.bluemyth.iface.dto.*;

import java.util.List;

/**
 * <p>
 *   服务类
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */
public interface IfaceService {


    List<ActicleDto>  findActiclelist(String type,String status);

    List<ActicleDto>  findActiclehot(String type);

    List<ActicleDto>  findArticlerecently(String userid);

    List<UserCommontDto>  findCommoentsrecently(String userid);

    List<UserActiveDto>  findActivelist();

    ActicleDto  findArticleById(String articleid);

    List<CommentDto> findCommentsById(String acticleid);

    Integer findMessagenum(String userid);

    List<MessagesDto> findMessagelist(String userid);

    List<CollectDto> findCollectlist(String userid);
}
