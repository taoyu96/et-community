package com.bluemyth.community.entity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 艾特信息表
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */
@TableName("t_atmsg")
public class Atmsg extends Model<Atmsg> {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String atmsgid;
    /**
     * 文章/帖外键
     */
    private String articleid;
    /**
     * 发起@的用户id
     */
    private String senduserid;
    /**
     * 被@的用户id
     */
    private String acceptuserid;
    /**
     * 创建时间
     */
    private Date createtime;


    public String getAtmsgid() {
        return atmsgid;
    }

    public void setAtmsgid(String atmsgid) {
        this.atmsgid = atmsgid;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    protected Serializable pkVal() {
        return this.atmsgid;
    }

    @Override
    public String toString() {
        return "Atmsg{" +
        ", atmsgid=" + atmsgid +
        ", articleid=" + articleid +
        ", senduserid=" + senduserid +
        ", acceptuserid=" + acceptuserid +
        ", createtime=" + createtime +
        "}";
    }
}
