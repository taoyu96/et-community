package com.bluemyth.sys.entity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */
@TableName("t_user")
public class User extends Model<User> {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String userid;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 状态  0：未激活 1：正常 2：封禁
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createtime;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
        return this.userid;
    }

    @Override
    public String toString() {
        return "User{" +
        ", userid=" + userid +
        ", account=" + account +
        ", password=" + password +
        ", email=" + email +
        ", mobile=" + mobile +
        ", status=" + status +
        ", createtime=" + createtime +
        "}";
    }
}
