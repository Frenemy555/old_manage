package com.tianya.demos.config;

import com.tianya.demos.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web配置类：注册登录拦截器，配置拦截规则
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns(
                        "http://120.26.180.177:2020", // 开发环境
                        "http://localhost:5173"
                )
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders(
                        "Authorization",        // JWT令牌头
                        "Content-Disposition",  // 文件下载头
                        "X-Custom-Header"       // 自定义头
                )
                .allowCredentials(true)         // 允许凭证
                .maxAge(3600);                 // 预检缓存时间
    }

    // 注册拦截器，排除登录和注册接口
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .excludePathPatterns(
                        "/user/login",
                        "/user/register"
                );
    }
}
