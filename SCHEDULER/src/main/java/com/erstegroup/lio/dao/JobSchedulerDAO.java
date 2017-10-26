package com.erstegroup.lio.dao;

import com.erstegroup.lio.db.model.SchedulerJobGroup;

public interface JobSchedulerDAO {

	public SchedulerJobGroup getSchedulerJobGroup(String jobGroupName);

	public Long saveSchedulerJobGroup(SchedulerJobGroup schedulerJobGroup);

}
