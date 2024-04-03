package co.sophea.cambodiaaccessoryapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("/**") // specify your allowed origins
                .allowedMethods("GET", "POST", "PUT", "DELETE") // specify your allowed HTTP methods
                .allowedHeaders("*"); // specify your allowed headers
    }
}
