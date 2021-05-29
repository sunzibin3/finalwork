package com.sun.finalwork.config;

import com.sun.finalwork.component.LoginInterceptor;
import com.sun.finalwork.component.MylocalCompnent;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;
import java.util.Arrays;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("index.html").setViewName("login");
        registry.addViewController("/test.html").setViewName("test");
        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/course.html").setViewName("student/course");
        registry.addViewController("/batchTip").setViewName("tip/batchTip");
        registry.addViewController("/stuToTeaMsg").setViewName("student/stuToTeaMsg");
        registry.addViewController("/stumain").setViewName("student/stumain");
        registry.addViewController("/teamain").setViewName("teacher/teamain");
        registry.addViewController("/managermain").setViewName("manager/main");
        registry.addViewController("/stuMsgToTea").setViewName("teacher/stuMsg");
        registry.addViewController("/teacher/teaMsg").setViewName("teacher/teaMsg");
        registry.addViewController("/studata").setViewName("manager/studata");
        registry.addViewController("/teadata").setViewName("manager/teadata");
        registry.addViewController("/classManager").setViewName("manager/classMan");
        registry.addViewController("/evaManager").setViewName("manager/evaManager");
        registry.addViewController("/quotaMan").setViewName("manager/QuotaMan");
        registry.addViewController("/stuEvaMan").setViewName("manager/stuEvaMan");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html",
                        "/",
                        "/user/login",
                        "/getVerifyCode",
                        "/webjars/**",
                        "/asserts/**",
                        "/img/**",
                        "/kindeditor/**",
                        "/test.html");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MylocalCompnent();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:E:\\javaPro\\finalwork\\src\\main\\resources\\static\\img\\");
    }
}
