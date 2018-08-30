package com.bluemyth.sys.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据字典表
 * </p>
 *
 * @author xiaot
 * @since 2018-06-14
 */
@TableName("t_dict")
public class Dict extends Model<Dict> {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String id;
    /**
     * 字典名称
     */
    private String dictname;
    /**
     * 字典类型
     */
    private String dicttype;
    /**
     * 字典码
     */
    private String code;
    /**
     * 字典值
     */
    private String value;
    /**
     * 排序
     */
    private Integer ordernum;
    /**
     * 备注
     */
    private String remark;
    /**
     * 删除标记  -1：已删除  0：正常
     */
    private Integer flag;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDictname() {
        return dictname;
    }

    public void setDictname(String dictname) {
        this.dictname = dictname;
    }

    public String getDicttype() {
        return dicttype;
    }

    public void setDicttype(String dicttype) {
        this.dicttype = dicttype;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Dict{" +
        ", id=" + id +
        ", dictname=" + dictname +
        ", dicttype=" + dicttype +
        ", code=" + code +
        ", value=" + value +
        ", ordernum=" + ordernum +
        ", remark=" + remark +
        ", flag=" + flag +
        "}";
    }
}
