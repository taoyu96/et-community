package com.bluemyth.sys.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.bluemyth.iface.utils.RuleFormatUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 系统用户信息
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */
@TableName("t_userinfo")
public class Userinfo extends Model<Userinfo> {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String userid;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 姓名
     */
    private String realname;
    /**
     * 认证信息
     */
    private String authinfo;
    /**
     * 头像资源主键
     */
    private String headpicfileid;
    /**
     * 积分总额
     */
    private Integer acouttotal;
    /**
     * 所在城市
     */
    private String city;
    /**
     * 座右铭
     */
    private String motto;
    /**
     * 性别   0：其他   1：男  2：女
     */
    private Integer sex;
    /**
     * 等级积分
     */
    private Integer level;
    /**
     * VIP等级积分
     */
    private Integer viplevel;
    /**
     * VIP激活标志 0:未激活 1：激活
     */
    private Integer vipactive;
    /**
     * email 激活标志 0:未激活 1激活
     */
    private Integer emailtive;
    /**
     * mobile 激活标志 0:未激活 1激活
     */
    private Integer mobileactive;

    /**
     * 连续签到天数
     */
    private Integer signdays;
    /**
     * 签到时间
     */
    private Date signtime;

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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
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

    public Integer getAcouttotal() {
        return acouttotal;
    }

    public void setAcouttotal(Integer acouttotal) {
        this.acouttotal = acouttotal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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

    public Integer getVipactive() {
        return vipactive;
    }

    public void setVipactive(Integer vipactive) {
        this.vipactive = vipactive;
    }

    public Integer getEmailtive() {
        return emailtive;
    }

    public void setEmailtive(Integer emailtive) {
        this.emailtive = emailtive;
    }

    public Integer getMobileactive() {
        return mobileactive;
    }

    public void setMobileactive(Integer mobileactive) {
        this.mobileactive = mobileactive;
    }

    public Integer getSigndays() {
        return signdays;
    }

    public void setSigndays(Integer signdays) {
        this.signdays = signdays;
    }

    public Date getSigntime() {
        return signtime;
    }

    public void setSigntime(Date signtime) {
        this.signtime = signtime;
    }

    //转换
    public String getVip_string() {
        return RuleFormatUtil.ruleVip(this.viplevel);
    }

    public String getLevel_string() {
        return RuleFormatUtil.ruleLevel(this.level);
    }

    @Override
    protected Serializable pkVal() {
        return this.userid;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
        ", userid=" + userid +
        ", nickname=" + nickname +
        ", realname=" + realname +
        ", authinfo=" + authinfo +
        ", headpicfileid=" + headpicfileid +
        ", acouttotal=" + acouttotal +
        ", city=" + city +
        ", motto=" + motto +
        ", sex=" + sex +
        ", level=" + level +
        ", viplevel=" + viplevel +
        ", vipactive=" + vipactive +
        ", emailtive=" + emailtive +
        ", mobileactive=" + mobileactive +
        ", signdays=" + signdays +
        ", signtime=" + signtime +
        "}";
    }
}
