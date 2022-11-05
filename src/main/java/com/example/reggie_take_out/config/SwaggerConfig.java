package com.example.reggie_take_out.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ZEYANG
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket coreApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(adminApiInfo())
                .groupName("adminApi")
                .select()
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();
    }

    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("大食堂系统外卖--api文档")
                .description("大食堂系统外卖接口描述")
                .version("1.0")
                .contact(new Contact("嘤嘤", "https://baidu.com", "@qq.com"))
                .build();
    }
}
