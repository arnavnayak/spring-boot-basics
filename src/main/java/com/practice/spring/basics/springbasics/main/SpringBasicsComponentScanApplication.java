package com.practice.spring.basics.springbasics.main;

import com.practice.spring.basics.springbasics.componentscan.ComponentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.practice.spring.basics.springbasics.componentscan") // if not mentioned will not throw a compiler error
																		// but runtime when it searches for bean it wont find and hence need to mention the package
public class SpringBasicsComponentScanApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringBasicsComponentScanApplication.class);
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext springApplicationContext = new AnnotationConfigApplicationContext(SpringBasicsComponentScanApplication.class);

		ComponentDAO cDaoBean = springApplicationContext.getBean(ComponentDAO.class);

		LOGGER.info("{}",cDaoBean);

			}

}
