package com.bluemyth.sys.entity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author xiaot
 * @since 2018-06-14
 */
@TableName("t_role")
public class Role extends Model<Role> {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String roleid;
    /**
     * 角色名称
     */
    private String rolename;

    /**
     * 角色代码
     */
    private Integer rolecode;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createtime;


    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Integer getRolecode() {
        return rolecode;
    }

    public void setRolecode(Integer rolecode) {
        this.rolecode = rolecode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    protected Serializable pkVal() {
        return this.roleid;
    }

    @Override
    public String toString() {
        return "Role{" +
        ", roleid=" + roleid +
        ", rolename=" + rolename +
        ", remark=" + remark +
        ", createtime=" + createtime +
        "}";
    }
}
