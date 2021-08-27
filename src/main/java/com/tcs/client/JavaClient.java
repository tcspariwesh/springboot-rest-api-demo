package com.tcs.client;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.tcs.springbootdemo.entity.User;

@SpringBootApplication 
public class JavaClient {
	private static String URL = "http://localhost:8080/user/";

	@Bean // use @Bean when you donot have the source code
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		ApplicationContext context = new SpringApplicationBuilder(JavaClient.class).web(WebApplicationType.NONE)
				.run(args);
//		getUser(context);
	}

	private static void getUser(ApplicationContext context) {
		RestTemplate restTemplate = context.getBean(RestTemplate.class);
		User response = restTemplate.getForObject(URL + "1", (User.class));
		System.out.println(response.getFirstName());
	}
}
