package com.erstegroup.lio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.erstegroup.lio.constants.CommonConstants;
import com.erstegroup.lio.constants.JspNamesConstants;
import com.erstegroup.lio.constants.ServiceConstants;
import com.erstegroup.lio.utils.MessagesReader;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

	@ExceptionHandler(Throwable.class)
	public ModelAndView handleException() {
		log.debug("global excpetion occurred");
		ModelAndView model = new ModelAndView();
		model.addObject(CommonConstants.ERROR, MessagesReader.getMessage(ServiceConstants.GENERIC_EXCEPTION));
		model.setViewName(JspNamesConstants.ERROR_JSP);
		return model;
	}
	
}
