package com.bluemyth.iface.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 收藏表
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */

public class CollectDto implements Serializable {



    private String collectid;
    /**
     * 文章/帖外键
     */
    private String articleid;

    /**
     * 文章标题
     */
    private String title;
    /**
     * 收藏用户id
     */
    private String userid;
    /**
     * 收藏状态 0：正常 1：取消收藏
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createtime;


    public String getCollectid() {
        return collectid;
    }

    public void setCollectid(String collectid) {
        this.collectid = collectid;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }


}
