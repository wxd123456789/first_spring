package com.first_spring_demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 全局跨域配置
 */
@Configuration
@EnableWebMvc
public class GlobalCorsConfig extends WebMvcConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(GlobalCorsConfig.class);

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        logger.info("in addCorsMappings");
        //允许跨域访问资源的源地址
        String[] allowedOrigins = {"*"};
        //允许跨域访问资源的方法
        String[] allowedMethods = {"POST", "GET", "DELETE", "PUT", "OPTIONS"};
        //允许跨域访问资源的请求头
        String[] allowedHeaders = {"*"};
        //??
        String[] exposedHeaders = {"x-auth-token", "content-type", "X-Requested-With", "XMLHttpRequest"};
        registry.addMapping("/**")
                .allowedOrigins(allowedOrigins)
                .allowedMethods(allowedMethods)
                .allowedHeaders(allowedHeaders)
                //Set-Cookie??
                .exposedHeaders(HttpHeaders.SET_COOKIE)
                .allowCredentials(false).maxAge(3600);
    }
}