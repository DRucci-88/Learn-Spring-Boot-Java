package com.lerucco.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lerucco.springcore.common.Couch;
import com.lerucco.springcore.common.SwimCoach;

@Configuration
public class SportConfig {
    
    // Custom Id, by default using the name of method
    @Bean("aquatic")
    public Couch swimCoach() {
        return new SwimCoach();
    }
}
