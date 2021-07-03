package com.bangmaple.lms.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class LmsAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsAuthenticationApplication.class, args);
	}

}
