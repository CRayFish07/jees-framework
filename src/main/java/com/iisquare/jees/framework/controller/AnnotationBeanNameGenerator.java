package com.iisquare.jees.framework.controller;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

public class AnnotationBeanNameGenerator extends
		org.springframework.context.annotation.AnnotationBeanNameGenerator {

	@Override
	protected String buildDefaultBeanName(BeanDefinition definition,
			BeanDefinitionRegistry registry) {
		return definition.getBeanClassName();
	}

}
