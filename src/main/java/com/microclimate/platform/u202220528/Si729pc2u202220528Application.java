package com.microclimate.platform.u202220528;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Si729pc2u202220528Application {

    public static void main(String[] args) {
        SpringApplication.run(Si729pc2u202220528Application.class, args);
    }

    @Configuration
    public static class MyConfiguration {
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**").allowedOrigins("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH" );
                }
            };
        }
    }
}
