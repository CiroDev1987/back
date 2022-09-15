package com.back.config;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Data
@Configuration
@PropertySource("classpath:/application.properties")
public class ApplicationConfig {


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    private boolean publicSingUpUrlEnable;
    private String jwtSecret;
    private Long jwtExpirationMiliseg;
    private Long resetPasswordTokenExpirationMiliseg;
}
