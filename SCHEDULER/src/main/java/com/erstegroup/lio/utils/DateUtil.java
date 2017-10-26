package com.erstegroup.lio.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class DateUtil {

	public static LocalDateTime getLocalDateTime() {
		LocalDateTime localDateTime = LocalDateTime.now();
		return localDateTime;
	}
	
	public static Date getCurrentSystemDateTime() {
		Instant now = Instant.now();
		Date systemDate = Date.from(now);
		return systemDate;
	}
	
}
