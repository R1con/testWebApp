package com.reliab.TestWebApp.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "bot")
@Data
public class BotProperties {
    @Value("${bot.name}")
    private String name;
    @Value("${bot.token}")
    private String token;
    @Value("${bot.url}")
    private String url;

}
