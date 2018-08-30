package com.bluemyth.community.service.impl;

import com.bluemyth.community.entity.Article;
import com.bluemyth.community.mapper.ArticleMapper;
import com.bluemyth.community.service.ArticleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 帖信息 服务实现类
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
