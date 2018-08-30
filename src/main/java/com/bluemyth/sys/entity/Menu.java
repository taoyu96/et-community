package com.bluemyth.sys.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 菜单管理
 * </p>
 *
 * @author xiaot
 * @since 2018-06-14
 */
@TableName("t_menu")
public class Menu extends Model<Menu> {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String menuid;
    /**
     * 父菜单ID，一级菜单为0
     */
    private String parentid;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单URL
     */
    private String url;
    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;
    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Integer type;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 排序
     */
    private Integer ordernum;
    /**
     * 备注
     */
    private String remark;


    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    protected Serializable pkVal() {
        return this.menuid;
    }

    @Override
    public String toString() {
        return "Menu{" +
        ", menuid=" + menuid +
        ", parentid=" + parentid +
        ", name=" + name +
        ", url=" + url +
        ", perms=" + perms +
        ", type=" + type +
        ", icon=" + icon +
        ", ordernum=" + ordernum +
        ", remark=" + remark +
        "}";
    }
}
