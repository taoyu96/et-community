package com.bluemyth.iface.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 消息表
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */

public class MessagesDto implements Serializable {


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
     * 发送用户
     */
    private String senduser;

    /**
     * 接收用户id
     */
    private String acceptuserid;

    /**
     * 接收用户id
     */
    private String acceptuser;

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

    public String getSenduser() {
        return senduser;
    }

    public void setSenduser(String senduser) {
        this.senduser = senduser;
    }

    public String getAcceptuser() {
        return acceptuser;
    }

    public void setAcceptuser(String acceptuser) {
        this.acceptuser = acceptuser;
    }

}
