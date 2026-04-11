package com.tandilrec.TandilRec.config;

// imports
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;

@Configuration
public class CORSConfiguration{

@Bean
public UrlBasedCorsConfigurationSource CorsConfigurationSource() {
    CorsConfiguration corsConfig = new CorsConfiguration();

    corsConfig.setAllowedMethods(Arrays.asList("GET" , "POST" , "PUT" , "PATCH" , "DELETE"));
    corsConfig.setAllowedOrigins(Arrays.asList("*"));

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig);

    return source;

}
}