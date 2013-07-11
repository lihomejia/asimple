package com.norming.ess.common.dao.utils;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.norming.ess.base.SpringContextHolder;

/**
 * 动态加载Spring配置文件.
 * @author lh.jia
 * @date 2013.02.05
 */
public class DynamicLoadBean {

	/**
	 * 加载.
	 * @param configLocationString
	 */
	public void loadBean(String configLocationString) {
		DefaultListableBeanFactory  beanFactory = 
			(DefaultListableBeanFactory ) SpringContextHolder.getApplicationContext().getAutowireCapableBeanFactory();
		
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
		reader.loadBeanDefinitions(configLocationString);
	}
}