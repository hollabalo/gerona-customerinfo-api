package com.recruitit.customerinfo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
@EnableAutoConfiguration(exclude = {
		FreeMarkerAutoConfiguration.class,
		DataSourceAutoConfiguration.class})
public class TestApplicationConfig {

	public static final String URL = "http://localhost:8039/";
	
}
