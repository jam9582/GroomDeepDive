package me.codetiny.bootproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // .allowedOrigins("http://localhost:5173") // 기존 프론트엔드 포트 주소
                .allowedOrigins("http://localhost:8011") // 프론트 컨테이너 포트 주소
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
