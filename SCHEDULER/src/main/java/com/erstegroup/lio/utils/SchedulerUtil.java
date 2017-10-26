package com.erstegroup.lio.utils;

import org.apache.commons.lang3.StringUtils;

public class SchedulerUtil {

	private SchedulerUtil() {
		
	}
	
	public static boolean isBlank(final CharSequence cs) {
		return StringUtils.isBlank(cs);
	}
	
	public static boolean isNotBlank(final CharSequence cs) {
		return StringUtils.isNotBlank(cs);
	}
	
	public static String trim(final String str) {
		return StringUtils.trim(str);
	}
	
	@SafeVarargs
	public static <T> String join(final T ...elements) {
		return StringUtils.join(elements);
	}
	
}
