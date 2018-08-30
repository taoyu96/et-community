package com.bluemyth.iface.dto;

import com.bluemyth.iface.utils.RuleFormatUtil;
import com.bluemyth.sys.utils.DictUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Create by xiaot on 2018/6/18
 */
public class CommentDto implements Serializable {

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
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 认证信息
     */
    private String authinfo;
    /**
     * 头像资源主键
     */
    private String headpicfileid;
    /**
     * 等级积分
     */
    private Integer level;
    /**
     * VIP等级积分
     */
    private Integer viplevel;
    /**
     * 角色编码
     */
    private Integer rolecode;

    /**
     * 角色
     */
    private String rolename;


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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAuthinfo() {
        return authinfo;
    }

    public void setAuthinfo(String authinfo) {
        this.authinfo = authinfo;
    }

    public String getHeadpicfileid() {
        return headpicfileid;
    }

    public void setHeadpicfileid(String headpicfileid) {
        this.headpicfileid = headpicfileid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getViplevel() {
        return viplevel;
    }

    public void setViplevel(Integer viplevel) {
        this.viplevel = viplevel;
    }

    public Integer getRolecode() {
        return rolecode;
    }

    public void setRolecode(Integer rolecode) {
        this.rolecode = rolecode;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }


    //转换
    public String getVip_string() {
        return RuleFormatUtil.ruleVip(this.viplevel);
    }

    public String getLevel_string() {
        return RuleFormatUtil.ruleLevel(this.level);
    }

}
