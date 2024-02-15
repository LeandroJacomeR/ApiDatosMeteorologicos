package com.lj.api.datos.config;

import com.lj.api.datos.service.RateLimitService;
import com.lj.api.datos.web.LoggerInterceptor;
import com.lj.api.datos.web.RateLimitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    RateLimitInterceptor rateLimitInterceptor;
    @Autowired
    LoggerInterceptor loggerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(rateLimitInterceptor)
                .addPathPatterns("/**");

        registry.addInterceptor(loggerInterceptor)
                .addPathPatterns("/**");
    }
}
