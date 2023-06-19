package com.reliab.TestWebApp.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
@Getter
@ConfigurationProperties(prefix = "bot")
public class BotProperties {
    private String name;
    private String token;
    private String url;
}
