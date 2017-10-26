package com.erstegroup.lio.enums;

public enum ErrorCodes {

	MISSING_RESOURCE_EXCEPTION(101),
	HIBERNATE_EXCEPTION(102)
	;
	
	private final int errorCode;
	
	private ErrorCodes(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public int getErrorCode() {
		return this.errorCode;
	}
}
