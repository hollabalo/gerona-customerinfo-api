package com.recruitit.customerinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
        application.addListeners(new ApplicationPidFileWriter("app.pid"));
        
        application.run(args);
	}
	
}
