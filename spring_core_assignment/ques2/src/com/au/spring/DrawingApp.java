package com.au.spring;

import java.io.IOException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) throws IOException {
		
		//Handle bean's after init/destroy activities
		AbstractApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml");
		factory.registerShutdownHook();
		Triangle triangle = (Triangle)factory.getBean("triangle");//bean id
		triangle.draw();

	}

}
