package com.erstegroup.lio.service;

import java.util.Map;

import com.erstegroup.lio.db.model.SchedulerJobGroup;
import com.erstegroup.lio.dto.JobSchedulerDTO;

public interface DataPopulator {

	public SchedulerJobGroup getSchedulerJobGroup(JobSchedulerDTO jobSchedulerDTO , Map<String,Object> params);
	
}
