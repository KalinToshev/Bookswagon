package com.softuni.bookswagon.config;

import com.softuni.bookswagon.web.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Add a new instance of the LoggerInterceptor to the interceptor registry
        registry.addInterceptor(new LoggerInterceptor());
    }
}
