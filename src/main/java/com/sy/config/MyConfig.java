package com.sy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //更改 默认页
        registry.addViewController("/").setViewName("page/login");
        registry.addViewController("/index").setViewName("index");

    }

    @Bean //自定义国际化
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
