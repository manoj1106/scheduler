package com.erstegroup.lio.constants;

public class ServiceConstants {
	
	public static final Long ZERO = 0L;

	public static final String GENERIC_EXCEPTION = "GlobalControllerExceptionHandler.Exception";
	public static final String USER_NOT_FOUND = "UserServiceImpl.UserNotFound";
	public static final String USER_RETRIEVAL_ERROR = "UserServiceImpl.UserRetrievalError";
	
	public static final String JOBGROUP_NAME_CREATED = "JobSchedulerServiceImpl.JobGroupNameCreated";
	public static final String JOBGROUP_NAME_EXISTS = "JobSchedulerServiceImpl.JobGroupNameExists";
	public static final String JOBGROUP_NAME_CREATION_ERROR = "JobSchedulerServiceImpl.JobGroupNameCreationError";
	
	private ServiceConstants() {
		
	}
	
}
