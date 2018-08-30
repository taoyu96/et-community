package com.bluemyth.iface.dto;

import com.bluemyth.iface.utils.RuleFormatUtil;
import com.bluemyth.sys.utils.DictUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 帖信息
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */

public class ActicleDto implements Serializable{


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
     * 角色编码
     */
    private Integer rolecode;

    /**
     * 角色
     */
    private String rolename;
    /**
     * 等级积分
     */
    private Integer level;
    /**
     * VIP等级积分
     */
    private Integer viplevel;


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


    /**数据转换显示*/
    //帖子类型
    public String getType_string() {
        return DictUtil.getCodeName("ET0001",String.valueOf(this.type));
    }

    public String getTop_string() {
        return this.top!=null&&this.top == 1?"置顶":"";
    }

    public String getWonder_string() {
        return this.wonder!=null&&this.wonder == 1?"加精":"";
    }

    public String getStatus_string() {
        return this.status!=null&&this.status == 1?"已结":"";
    }

    public String getVip_string() {
        return RuleFormatUtil.ruleVip(this.viplevel);
    }

    public String getLevel_string() {
        return RuleFormatUtil.ruleLevel(this.level);
    }

    //帖子时间描述
    public String getTime_string() {
        return RuleFormatUtil.ruleTime(this.createtime);
    }

}
