package com.bluemyth.sys.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户与角色对应关系
 * </p>
 *
 * @author xiaot
 * @since 2018-06-14
 */
@TableName("t_roleuser")
public class Roleuser extends Model<Roleuser> {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String id;
    /**
     * 用户ID
     */
    private String userid;
    /**
     * 角色ID
     */
    private String roleid;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Roleuser{" +
        ", id=" + id +
        ", userid=" + userid +
        ", roleid=" + roleid +
        "}";
    }
}
