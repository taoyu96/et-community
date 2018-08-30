package com.bluemyth.community.entity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 文章/帖附件
 * </p>
 *
 * @author xiaot
 * @since 2018-06-16
 */
@TableName("t_articlepic")
public class Articlepic extends Model<Articlepic> {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String picid;
    /**
     * 文章/帖外键
     */
    private String articleid;
    /**
     * 访问路径
     */
    private String uploadid;
    /**
     * 创建时间
     */
    private Date createtime;


    public String getPicid() {
        return picid;
    }

    public void setPicid(String picid) {
        this.picid = picid;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public String getUploadid() {
        return uploadid;
    }

    public void getUploadid(String uploadid) {
        this.uploadid = uploadid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    protected Serializable pkVal() {
        return this.picid;
    }

    @Override
    public String toString() {
        return "Articlepic{" +
        ", picid=" + picid +
        ", articleid=" + articleid +
        ", uploadid=" + uploadid +
        ", createtime=" + createtime +
        "}";
    }
}
