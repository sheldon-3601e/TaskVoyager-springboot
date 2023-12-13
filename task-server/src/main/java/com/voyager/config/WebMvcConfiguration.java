package com.voyager.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @ClassName WebMvcConfiguration
 * @Author 26483
 * @Date 2023/12/13 16:08
 * @Version 1.0
 * @Description TODO
 */
@Component
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Bean
    public Docket docket_admin() {
        log.info("准备生成接口文档");
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("TaskVoyager")
                .version("2.0")
                .description("TaskVoyager接口文档")
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.voyager.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("开始设置静态资源映射");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
