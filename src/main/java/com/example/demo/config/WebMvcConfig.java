package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig {

    @Bean
    public WebMvcConfigurer forwardToIndex() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName(
                        "forward:/match3.html");
                registry.addViewController("/http").setViewName(
                        "forward:/http.html");
                registry.addViewController("/test").setViewName(
                        "forward:/test.html");
                registry.addViewController("/origin").setViewName(
                        "forward:/origin/match3.html");
                registry.addViewController("/final").setViewName(
                        "forward:/final/match3.html");
            }
        };
    }

}