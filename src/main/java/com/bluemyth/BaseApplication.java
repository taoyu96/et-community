package com.bluemyth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 1.jar包中的打包方式根据自己的需要进行修改
 * <p>
 * 2.若打包成war包,则需要继承 org.springframework.boot.context.web.SpringBootServletInitializer类,
 * 覆盖其config(SpringApplicationBuilder)方法
 * <p>
 * 3.打包成war的话,如果打包之后的文件中没有web.xml文件的话自己可以加进去一个最简单的web.xml(只有根节点的定义,而没有子元素)，
 * 防止因缺乏web.xml文件而部署失败
 * <p>
 * 4.Spring Boot 使用事务，首先使用注解 @EnableTransactionManagement
 * 开启事务支持后，然后在访问数据库的Service方法上添加注解 @Transactional 便可。
 */
@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan
@MapperScan(basePackages = {"com.bluemyth.*.mapper"})
public class BaseApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BaseApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

}

