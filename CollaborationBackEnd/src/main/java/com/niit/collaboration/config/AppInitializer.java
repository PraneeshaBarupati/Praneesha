package com.niit.collaboration.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

	@Override
	protected Class[] getRootConfigClasses() {
		logger.debug("Starting of the method getRootConfigClasses");
		return new Class[] { AppConfig.class };
	}
	
	@Autowired
	protected Class[] getServletConfigClasses() {
		logger.debug("Starting of the method getServletConfigClasses");
		return null;
	}
	
	@Autowired
	protected String[] getServletMappings() {
		logger.debug("Starting of the method getRootConfigClasses");
		return new String[] { "/" };
	}
}
