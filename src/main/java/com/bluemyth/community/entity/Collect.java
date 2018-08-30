package com.bluemyth.community.entity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 收藏表
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */
@TableName("t_collect")
public class Collect extends Model<Collect> {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String collectid;
    /**
     * 文章/帖外键
     */
    private String articleid;
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

    @Override
    protected Serializable pkVal() {
        return this.collectid;
    }

    @Override
    public String toString() {
        return "Collect{" +
        ", collectid=" + collectid +
        ", articleid=" + articleid +
        ", userid=" + userid +
        ", status=" + status +
        ", createtime=" + createtime +
        "}";
    }
}
