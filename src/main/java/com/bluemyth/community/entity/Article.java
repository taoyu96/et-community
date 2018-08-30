package com.bluemyth.community.entity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 帖信息
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */
@TableName("t_article")
public class Article extends Model<Article> {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String articleid;

    /**
     * 发表用户id
     */
    private String userid;
    /**
     * 标题
     */
    private String title;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 正文
     */
    private String content;
    /**
     * 状态 0：未结 1：已结
     */
    private Integer status;
    /**
     * 级别 0：默认 1：置顶
     */
    private Integer top;

    /**
     * 级别 0：默认 1：加精
     */
    private Integer wonder;

    /**
     * 悬赏数额
     */
    private Integer rewardnum;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 赞同数
     */
    private Integer agreenum;
    /**
     * 踩数
     */
    private Integer disagreenum;
    /**
     * 阅读数
     */
    private Integer readnum;
    /**
     * 收藏数
     */
    private Integer collectnum;
    /**
     * 评论数
     */
    private Integer commentnum;
    /**
     * 转发数
     */
    private Integer transpondnum;


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getWonder() {
        return wonder;
    }

    public void setWonder(Integer wonder) {
        this.wonder = wonder;
    }

    public Integer getRewardnum() {
        return rewardnum;
    }

    public void setRewardnum(Integer rewardnum) {
        this.rewardnum = rewardnum;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    public Integer getReadnum() {
        return readnum;
    }

    public void setReadnum(Integer readnum) {
        this.readnum = readnum;
    }

    public Integer getCollectnum() {
        return collectnum;
    }

    public void setCollectnum(Integer collectnum) {
        this.collectnum = collectnum;
    }

    public Integer getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(Integer commentnum) {
        this.commentnum = commentnum;
    }

    public Integer getTranspondnum() {
        return transpondnum;
    }

    public void setTranspondnum(Integer transpondnum) {
        this.transpondnum = transpondnum;
    }

    @Override
    protected Serializable pkVal() {
        return this.articleid;
    }

    @Override
    public String toString() {
        return "Article{" +
        ", articleid=" + articleid +
        ", userid=" + userid +
        ", title=" + title +
        ", type=" + type +
        ", content=" + content +
        ", status=" + status +
        ", top=" + top +
        ", wonder=" + wonder +
        ", rewardnum=" + rewardnum +
        ", createtime=" + createtime +
        ", agreenum=" + agreenum +
        ", disagreenum=" + disagreenum +
        ", readnum=" + readnum +
        ", collectnum=" + collectnum +
        ", commentnum=" + commentnum +
        ", transpondnum=" + transpondnum +
        "}";
    }
}
