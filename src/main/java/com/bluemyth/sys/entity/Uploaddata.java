package com.bluemyth.sys.entity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 上传资源
 * </p>
 *
 * @author xiaot
 * @since 2018-06-19
 */
@TableName("t_uploaddata")
public class Uploaddata extends Model<Uploaddata> {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String uploadid;
    /**
     * 文件名
     */
    private String filename;
    /**
     * 文件位置
     */
    private String filepath;
    /**
     * 文件扩展名
     */
    private String ext;
    /**
     * 创建时间
     */
    private Date createtime;


    public String getUploadid() {
        return uploadid;
    }

    public void setUploadid(String uploadid) {
        this.uploadid = uploadid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    protected Serializable pkVal() {
        return this.uploadid;
    }

    @Override
    public String toString() {
        return "Uploaddata{" +
        ", uploadid=" + uploadid +
        ", filename=" + filename +
        ", filepath=" + filepath +
        ", ext=" + ext +
        ", createtime=" + createtime +
        "}";
    }
}
