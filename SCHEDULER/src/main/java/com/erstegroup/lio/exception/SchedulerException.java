package com.erstegroup.lio.exception;

import com.erstegroup.lio.enums.ErrorCodes;
import com.erstegroup.lio.utils.ErrorMessagesReader;

@SuppressWarnings("serial")
public class SchedulerException extends RuntimeException {

	public SchedulerException() {
		super();
	}
	
	public SchedulerException(ErrorCodes errorCodes) {
		super(ErrorMessagesReader.getErrorMessage(errorCodes.getErrorCode()));
	}
	
	public SchedulerException(ErrorCodes errorCodes,Throwable cause) {
		super(ErrorMessagesReader.getErrorMessage(errorCodes.getErrorCode()),cause);
	}
}
