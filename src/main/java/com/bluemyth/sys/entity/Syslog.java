package com.bluemyth.sys.entity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaot
 * @since 2018-06-13
 */
@TableName("t_syslog")
public class Syslog extends Model<Syslog> {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String logid;
    private String uid;
    private String uname;
    private String content;
    private String operation;
    private Integer level;
    private Long excutetime;
    private Date createtime;


    public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getExcutetime() {
        return excutetime;
    }

    public void setExcutetime(Long excutetime) {
        this.excutetime = excutetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    protected Serializable pkVal() {
        return this.logid;
    }

    @Override
    public String toString() {
        return "Syslog{" +
        ", logid=" + logid +
        ", uid=" + uid +
        ", uname=" + uname +
        ", content=" + content +
        ", operation=" + operation +
        ", level=" + level +
        ", excutetime=" + excutetime +
        ", createtime=" + createtime +
        "}";
    }
}
