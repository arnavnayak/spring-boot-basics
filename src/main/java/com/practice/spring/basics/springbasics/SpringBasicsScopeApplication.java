package com.practice.spring.basics.springbasics;

import com.practice.spring.basics.springbasics.basic.BinarySearchImprovedAgainSetterInjection;
import com.practice.spring.basics.springbasics.scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringBasicsScopeApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringBasicsScopeApplication.class);
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext springApplicationContext = new AnnotationConfigApplicationContext(SpringBasicsScopeApplication.class);
		
		
		BinarySearchImprovedAgainSetterInjection bSearchSettInjected = springApplicationContext.getBean(BinarySearchImprovedAgainSetterInjection.class);
		BinarySearchImprovedAgainSetterInjection bSearchSettInjectedCopy = springApplicationContext.getBean(BinarySearchImprovedAgainSetterInjection.class);
		
		System.out.println(bSearchSettInjected); // o/p - com.practice.spring.basics.springbasics.BinarySearchImprovedAgainSetterInjection@142269f2
		System.out.println(bSearchSettInjectedCopy); //o/p - com.practice.spring.basics.springbasics.BinarySearchImprovedAgainSetterInjection@142269f2
		//observation above same object gets instantiated for the same bean always no matter how many times the getBean is done 
		//beacuse of singleton by default nature of beans
		
		/* if scope is defined as prototype then we can clearly observe the different instance created or new bean always gets created
		 o/p-	com.practice.spring.basics.springbasics.BinarySearchImprovedAgainSetterInjection@59b38691
				com.practice.spring.basics.springbasics.BinarySearchImprovedAgainSetterInjection@2e2ff723
		*/
		
		PersonDAO pDaoBean = springApplicationContext.getBean(PersonDAO.class);
		PersonDAO pDaoBean1 = springApplicationContext.getBean(PersonDAO.class);

		LOGGER.info("{}",pDaoBean);
		LOGGER.info("{}",pDaoBean.getJdbcConnection());
		LOGGER.info("{}",pDaoBean1);
		LOGGER.info("{}",pDaoBean1.getJdbcConnection());
		
		/** when we use prortype as ascope we in persdao we get the following output:--
		 *  com.practice.spring.basics.springbasics.scope.PersonDAO@55322aab
			com.practice.spring.basics.springbasics.scope.JdbcConnection@50468873
 			com.practice.spring.basics.springbasics.scope.PersonDAO@146587a2
			com.practice.spring.basics.springbasics.scope.JdbcConnection@50468873
		 * **/
		/*but when we used no scopes we got 
		 * com.practice.spring.basics.springbasics.scope.PersonDAO@55322aab
			com.practice.spring.basics.springbasics.scope.JdbcConnection@50468873
 			com.practice.spring.basics.springbasics.scope.PersonDAO@55322aab
			com.practice.spring.basics.springbasics.scope.JdbcConnection@50468873
		 * */
		/**but when we used scopes on JDBC connection tht is dependent bean but we didnt use any scope on personDAo we got  same beans like singleton why?
		 * its because although in main class above we are calling personDao class bean and personDAo doesnt really care what
		 * is the scope of the dependent class hence this issue
		 * to be able to have differnt dependent beans then we need to use proxy like @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)
		 * com.practice.spring.basics.springbasics.scope.PersonDAO@4ff4357f
			com.practice.spring.basics.springbasics.scope.JdbcConnection@2b4c1d96
 			com.practice.spring.basics.springbasics.scope.PersonDAO@4ff4357f
			com.practice.spring.basics.springbasics.scope.JdbcConnection@2b4c1d96
		 * **/
		/***After using proxy:---
		 *  com.practice.spring.basics.springbasics.scope.PersonDAO@52851b44
		com.practice.spring.basics.springbasics.scope.JdbcConnection@1b73be9f
			com.practice.spring.basics.springbasics.scope.PersonDAO@52851b44
		com.practice.spring.basics.springbasics.scope.JdbcConnection@628c4ac0
	 * **/
	}

}
