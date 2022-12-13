package com.reliab.TestWebApp;

import com.reliab.TestWebApp.properties.BotProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(BotProperties.class)
public class TestWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestWebAppApplication.class, args);
	}

}
