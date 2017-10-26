package com.erstegroup.lio.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.erstegroup.lio.enums.ErrorCodes;
import com.erstegroup.lio.exception.SchedulerException;

public class MessagesReader {

private static final Logger log = LoggerFactory.getLogger(MessagesReader.class);
	
	private static final String BUNDLE_NAME = "config/properties/messages";

	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	public static String getMessage(String key) {
		try {
			return BUNDLE.getString(key);
		} catch(MissingResourceException e) {
			log.error("Property or resource not found for key {}" , key , e);
			throw new SchedulerException(ErrorCodes.MISSING_RESOURCE_EXCEPTION);
		}
	}
	
}
