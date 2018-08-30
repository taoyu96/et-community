package com.bluemyth.community.entity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 消息表
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */
@TableName("t_messages")
public class Messages extends Model<Messages> {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String messageid;
    /**
     * 信息内容
     */
    private String content;
    /**
     * 发送用户id
     */
    private String senduserid;
    /**
     * 接收用户id
     */
    private String acceptuserid;
    /**
     * 收藏状态  0：未阅 1：已阅
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createtime;


    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenduserid() {
        return senduserid;
    }

    public void setSenduserid(String senduserid) {
        this.senduserid = senduserid;
    }

    public String getAcceptuserid() {
        return acceptuserid;
    }

    public void setAcceptuserid(String acceptuserid) {
        this.acceptuserid = acceptuserid;
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
        return this.messageid;
    }

    @Override
    public String toString() {
        return "Messages{" +
        ", messageid=" + messageid +
        ", content=" + content +
        ", senduserid=" + senduserid +
        ", acceptuserid=" + acceptuserid +
        ", status=" + status +
        ", createtime=" + createtime +
        "}";
    }
}
