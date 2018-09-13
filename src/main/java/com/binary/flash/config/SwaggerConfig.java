package com.binary.flash.config;

import io.swagger.annotations.Api;
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
 * <p>项目名称: g7_shell</p>
 * <p>类名称: SwaggerConfig</p>
 * <p>类描述: swagger配置文件</p>
 * <p>创建人: <a href="mailto:chenyongtao@cdbinary.com"> chenyongtao </a></p>
 * <p>创建时间: 2018/3/29 15:13</p>
 * <p>修改人: </p>
 * <p>修改时间: </p>
 * <p>修改备注: </p>
 *
 * @author <a href="mailto:chenyongtao@cdbinary.com"> chenyongtao </a>
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("WMS接口文档")
                .contact(new Contact("陈永滔", "", "chenyongtao@cdbinary.com"))
                .version("1.0")
                .build();
    }
}
