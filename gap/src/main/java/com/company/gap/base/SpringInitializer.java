package com.company.gap.base;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringInitializer implements BeanFactoryPostProcessor, ApplicationContextAware {

	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextHolder.setApplicationContext(applicationContext);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory factory)
			throws BeansException {
		
	}


}
