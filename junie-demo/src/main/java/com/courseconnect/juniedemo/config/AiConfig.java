package com.courseconnect.juniedemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

/**
 * Configuration class for AI-related beans.
 */
@Configuration
public class AiConfig {

    @Value("${spring.ai.openai.api-key:demo-key}")
    private String apiKey;

    @Value("${spring.ai.openai.model:gpt-3.5-turbo}")
    private String model;

    /**
     * Creates and configures a dummy AI client bean.
     * This is a placeholder for demo purposes.
     *
     * @return a string representing the API key and model
     */
    @Bean
    public String aiClientInfo() {
        return "API Key: " + apiKey + ", Model: " + model;
    }
}
