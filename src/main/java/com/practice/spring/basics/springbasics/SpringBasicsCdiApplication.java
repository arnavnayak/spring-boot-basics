package com.practice.spring.basics.springbasics;

import com.practice.spring.basics.springbasics.cdi.SomeCdiBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringBasicsCdiApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringBasicsCdiApplication.class);
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext springApplicationContext = new AnnotationConfigApplicationContext(SpringBasicsCdiApplication.class);

		SomeCdiBusiness someCdiBusiness = springApplicationContext.getBean(SomeCdiBusiness.class);

		LOGGER.info("{} -DAO {}",someCdiBusiness,someCdiBusiness.getSomeCdiDao());
	}

}
