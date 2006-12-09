package com.sysdelphia.workq.test;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringTest extends TestCase {
	protected BeanFactory factory;

	protected void setUp() throws Exception {
		super.setUp();
		factory = new XmlBeanFactory(new ClassPathResource("/test-beans.xml"));
	}
}
