package com.practice.spring.basics.springbasics;

import com.practice.spring.basics.springbasics.basic.BinarySearchImprovedAgainSetterInjection;
import com.practice.spring.basics.springbasics.basic.BinarySearchImprovedWithoutSpringBoot;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@ComponentScan("com.practice.spring.basics.springbasics")
public class SpringBasicsApplicationWithoutSpringBoot {

	//What are the beans ?
	//What are the dependencies of the beans?
	//Where to search for the bean?
	//we need to answer these for the spring.
	
	public static void main(String[] args) {
		

		ConfigurableApplicationContext springApplicationContext = new AnnotationConfigApplicationContext(SpringBasicsApplicationWithoutSpringBoot.class);
//				SpringApplication.run(SpringBasicsApplicationWithoutSpringBoot.class, args);

		BinarySearchImprovedWithoutSpringBoot bSearch = springApplicationContext.getBean(BinarySearchImprovedWithoutSpringBoot.class);

		int result = bSearch.binarySearch(new int[] {2,1,4},2);
		 
		System.out.println("result with setter Injection : "+result);
		
	}

}
