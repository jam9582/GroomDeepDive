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
                // ingress 적용 후 cors 설정은 필요 없어지게 된다. 클러스터 ip로 통신
                .allowedOrigins()
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
