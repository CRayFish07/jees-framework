package com.iisquare.jees.framework.view;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.iisquare.jees.framework.FrameworkConfiguration;

import freemarker.template.Configuration;

/**
 * FreeMarker自定义函数管理器
 */
public class FreemarkerTemplateManager {
	
	private FrameworkConfiguration frameworkConfiguration;

	public FrameworkConfiguration getFrameworkConfiguration() {
		return frameworkConfiguration;
	}

	public void setFrameworkConfiguration(
			FrameworkConfiguration frameworkConfiguration) {
		this.frameworkConfiguration = frameworkConfiguration;
	}
	
	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		Configuration configuration = freeMarkerConfigurer.getConfiguration();
        configuration.setSharedVariable("millisToDateTime",
        		new FreemarkerMillisToDateTimeModel(frameworkConfiguration));
        configuration.setSharedVariable("empty", new FreemarkerEmptyModel());
        configuration.setSharedVariable("escapeHtml", new FreemarkerEscapeHtmlModel());
        configuration.setSharedVariable("unescapeHtml", new FreemarkerUnescapeHtmlModel());
	}
	
	public FreemarkerTemplateManager() {
		
	}
}
