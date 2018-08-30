package com.bluemyth.iface.dto;

import java.io.Serializable;

/**
 * Create by xiaot on 2018/6/19
 */
public class UserActiveDto implements Serializable {

    /**
     * 发表用户id
     */
    private String userid;
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
     * 活跃数/回答数
     */
    private Integer activenum;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public Integer getActivenum() {
        return activenum;
    }

    public void setActivenum(Integer activenum) {
        this.activenum = activenum;
    }

}
