package com.sysdelphia.workq.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import junit.framework.TestCase;

public class HelloSpringTest extends TestCase {
	private BeanFactory factory;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		factory = new XmlBeanFactory(new ClassPathResource("/test-beans.xml"));
	}

	public void testSayHello() {
		HelloSpring hello = (HelloSpring) factory.getBean("hello");
		String response = hello.sayHello("Bob");
		assertEquals("Hello Bob", response);
	}
}
