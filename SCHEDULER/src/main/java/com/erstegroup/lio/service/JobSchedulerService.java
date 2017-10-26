package com.erstegroup.lio.service;

import java.util.Map;

import com.erstegroup.lio.dto.JobSchedulerDTO;
import com.erstegroup.lio.utils.ResponseEntity;

public interface JobSchedulerService {

	public ResponseEntity createJobGroupName(JobSchedulerDTO jobSchedulerDTO,Map<String,Object> params);

	public ResponseEntity getJobGroupNames(Map<String, Object> params);

}
