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
@TableName("t_relation")
public class Relation extends Model<Relation> {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String relationid;
    /**
     * 关系类型 0：关注 1：好友
     */
    private Integer relationtype;
    /**
     * 用户id
     */
    private String userid;
    /**
     * 被关注用户id
     */
    private String byuserid;
    /**
     * 创建时间
     */
    private Date createtime;


    public String getRelationid() {
        return relationid;
    }

    public void setRelationid(String relationid) {
        this.relationid = relationid;
    }

    public Integer getRelationtype() {
        return relationtype;
    }

    public void setRelationtype(Integer relationtype) {
        this.relationtype = relationtype;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getByuserid() {
        return byuserid;
    }

    public void setByuserid(String byuserid) {
        this.byuserid = byuserid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    protected Serializable pkVal() {
        return this.relationid;
    }

    @Override
    public String toString() {
        return "Relation{" +
        ", relationid=" + relationid +
        ", relationtype=" + relationtype +
        ", userid=" + userid +
        ", byuserid=" + byuserid +
        ", createtime=" + createtime +
        "}";
    }
}
