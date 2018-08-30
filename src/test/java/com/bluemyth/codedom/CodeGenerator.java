package com.bluemyth.codedom;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 *
 * Create by xiaot on 2018/6/13
 */
public class CodeGenerator{

    public static void main(String[] args) throws InterruptedException {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("F:/code_gen");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor("xiaot");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);

        /*dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                return super.processTypeConvert(fieldType);
            }
        });*/

        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/et_base?useUnicode=true&amp;characterEncoding=UTF-8&amp;generateSimpleParameterMetadata=true");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setTablePrefix(new String[] { "t_"});// 此处可以修改为您的表前缀
        //strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略 - 下划线转驼峰

        strategy.setInclude(new String[] { "t_uploadData"}); // 需要生成的表
        //strategy.setExclude(new String[]{"BASE_VIEW"}); // 排除生成的表

        strategy.setRestControllerStyle(true);//使用RestController注解
        strategy.setSuperControllerClass("com.bluemyth.framework.controller.SuperController");//继承父类
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.bluemyth");
        pc.setModuleName("sys");
        pc.setController("controller");
        mpg.setPackageInfo(pc);


        // 注入自定义配置，可以在 VM 中使用 cfg.xxxx 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("title", "这是个demoTitle");
                this.setMap(map);
            }
        };

        // 自定义 xxList.jsp 生成
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        focList.add(new FileOutConfig("/templates/menu.sql.vm") {
           @Override
           public String outputFile(TableInfo tableInfo) {
              return "F:/code_gen/" + tableInfo.getEntityName() + "_menu.sql";  // 自定义输入文件名称
           }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 执行生成
        mpg.execute();
    }

}
