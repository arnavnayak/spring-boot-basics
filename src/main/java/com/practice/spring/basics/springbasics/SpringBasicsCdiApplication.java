package com.practice.spring.basics.springbasics;

import com.practice.spring.basics.springbasics.basic.BinarySearchImprovedAgainSetterInjection;
import com.practice.spring.basics.springbasics.cdi.SomeCdiBusiness;
import com.practice.spring.basics.springbasics.scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBasicsCdiApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringBasicsCdiApplication.class);
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext springApplicationContext = SpringApplication.run(SpringBasicsCdiApplication.class, args);

		SomeCdiBusiness someCdiBusiness = springApplicationContext.getBean(SomeCdiBusiness.class);

		LOGGER.info("{} -DAO {}",someCdiBusiness,someCdiBusiness.getSomeCdiDao());
	}

}
