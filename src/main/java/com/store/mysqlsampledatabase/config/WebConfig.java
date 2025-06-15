package com.store.mysqlsampledatabase.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

    public WebConfig() {
        log.info("✅ WebConfig class has been loaded.");
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.info("🌍 Configuring global CORS for frontend access...");

        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173/")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
