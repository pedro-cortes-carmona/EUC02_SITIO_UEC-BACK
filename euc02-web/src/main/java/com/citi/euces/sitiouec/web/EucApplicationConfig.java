/**
 *
 */
package com.citi.euces.sitiouec.web;

import java.time.Duration;

import javax.annotation.PostConstruct;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author lbermejo
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.citi.*")
@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
public class EucApplicationConfig {

	private static final Logger LOGGER = LogManager.getLogger(EucApplicationConfig.class);
	private final ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(EucApplicationConfig.class, args);
	}

	@PostConstruct
	public void init() {
		LOGGER.debug("Iniciando App... " + applicationContext.getApplicationName());
	}

	/**
	 * @param applicationContext
	 */
	public EucApplicationConfig(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("Messages");
		return messageSource;
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {

		return builder.setConnectTimeout(Duration.ofMillis(3000)).setReadTimeout(Duration.ofMillis(3000)).build();
	}

}
