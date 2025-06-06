package com.example.demo.apply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<HiddenHttpMethodFilter>hiddenHttpMethodFilter() {
		FilterRegistrationBean<HiddenHttpMethodFilter> filterRegistrationBean = new FilterRegistrationBean<>(new HiddenHttpMethodFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
}


