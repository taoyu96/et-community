package com.bluemyth.sys.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色与菜单对应关系
 * </p>
 *
 * @author xiaot
 * @since 2018-06-14
 */
@TableName("t_rolemenu")
public class Rolemenu extends Model<Rolemenu> {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String id;
    /**
     * 角色ID
     */
    private String roleid;
    /**
     * 菜单ID
     */
    private String menuid;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Rolemenu{" +
        ", id=" + id +
        ", roleid=" + roleid +
        ", menuid=" + menuid +
        "}";
    }
}
