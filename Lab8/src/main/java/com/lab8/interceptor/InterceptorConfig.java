package com.lab8.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    AuthInterceptor authInterceptor;

    @Autowired
    LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Ghi log mọi request
        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/**");

        // Áp dụng bảo mật
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/admin/**", "/account/edit-profile", "/account/change-password", "/order/**")
                .excludePathPatterns("/admin/home/index");
    }
}
