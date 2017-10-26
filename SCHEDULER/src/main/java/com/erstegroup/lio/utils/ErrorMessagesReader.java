package com.erstegroup.lio.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.erstegroup.lio.enums.ErrorCodes;
import com.erstegroup.lio.exception.SchedulerException;

public class ErrorMessagesReader {

	private static final Logger log = LoggerFactory.getLogger(ErrorMessagesReader.class);
	
	private static final String BUNDLE_NAME = "config/properties/errormessages";

	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	public static String getErrorMessage(int key) {
		String keyStr = String.valueOf(key);
		try {
			return BUNDLE.getString(keyStr);
		} catch(MissingResourceException e) {
			log.error("Property or resource not found for key {}" , keyStr , e);
			throw new SchedulerException(ErrorCodes.MISSING_RESOURCE_EXCEPTION);
		}
	}
}
