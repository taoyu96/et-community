

package com.bluemyth.framework.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置
 *
 * Create by xiaot on 2018/6/13
 */
@Configuration
@EnableSwagger2
public class SwaggerConfigure {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))  //加了ApiOperation注解的类，生成接口文档
            //.apis(RequestHandlerSelectors.basePackage("io.renren.modules.job.controller")) //包下的类，生成接口文档
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("REST API")
            .description("507社区-API文档")
            .termsOfServiceUrl("https://www.bluemyth.club/507")
            .contact(new Contact("xiaot", "https://www.bluemyth.club", "taoyu96@c126.com"))
            .version("1.0")
            .build();
    }

}