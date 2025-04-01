package drivingschoolsystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:3000", "http://192.168.1.102:3000") // Τα frontend origins
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Προσθέτουμε OPTIONS
                        .allowedHeaders("*")
                        .allowCredentials(true)
                        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");  // Εκθέτει τα CORS headers (όπως το Access-Control-Allow-Origin)
            }
        };
    }
}