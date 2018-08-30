package com.bluemyth.community.entity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */
@TableName("t_comments")
public class Comments extends Model<Comments> {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String commentid;
    /**
     * 文章/帖外键
     */
    private String articleid;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 用户id
     */
    private String userid;
    /**
     * 赞同数
     */
    private Integer agreenum;
    /**
     * 踩数
     */
    private Integer disagreenum;
    /**
     * 评论状态 0：正常 1：被采纳 2: 隐藏 3：删除
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createtime;


    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getAgreenum() {
        return agreenum;
    }

    public void setAgreenum(Integer agreenum) {
        this.agreenum = agreenum;
    }

    public Integer getDisagreenum() {
        return disagreenum;
    }

    public void setDisagreenum(Integer disagreenum) {
        this.disagreenum = disagreenum;
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
        return this.commentid;
    }

    @Override
    public String toString() {
        return "Comments{" +
        ", commentid=" + commentid +
        ", articleid=" + articleid +
        ", content=" + content +
        ", userid=" + userid +
        ", agreenum=" + agreenum +
        ", disagreenum=" + disagreenum +
        ", status=" + status +
        ", createtime=" + createtime +
        "}";
    }
}
