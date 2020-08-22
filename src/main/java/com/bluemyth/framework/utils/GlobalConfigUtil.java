package com.bluemyth.framework.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/**
 *  全局配置管理
 * Created by xiaot on 2018/4/8.
 */
@Configuration
public class GlobalConfigUtil {


    public static String uploadPath; //上传路径
    public static String tempPath;//temp路径
    public static String template;//模板路径

    @Value("${upload.path:}")
    public void setUploadPath(String uploadPath){
        GlobalConfigUtil.uploadPath = uploadPath;
    }

    @Value("${upload.temppath:}")
    public void setTemppath(String tempPath){
        GlobalConfigUtil.tempPath = tempPath;
    }

    @Value("${upload.template:}")
    public void setTemplate(String template){
        GlobalConfigUtil.template = template;
    }

}
