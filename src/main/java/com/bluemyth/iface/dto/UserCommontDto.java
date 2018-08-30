package com.bluemyth.iface.dto;

import com.bluemyth.iface.utils.RuleFormatUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Create by xiaot on 2018/6/18
 */
public class UserCommontDto implements Serializable {

    private String commentid;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 赞同数
     */
    private Integer agreenum;
    /**
     * 评论状态 0：正常 1：被采纳 2: 隐藏 3：删除
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 用户id
     */
    private String userid;
    /**
     * 文章/帖外键
     */
    private String articleid;
    /**
     * 标题
     */
    private String title;

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAgreenum() {
        return agreenum;
    }

    public void setAgreenum(Integer agreenum) {
        this.agreenum = agreenum;
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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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


    //帖子时间描述
    public String getTime_string() {
        return RuleFormatUtil.ruleTime(this.createtime);
    }

}
