package com.erstegroup.lio.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.erstegroup.lio.constants.CommonConstants;
import com.erstegroup.lio.db.model.SchedulerJobGroup;
import com.erstegroup.lio.dto.JobSchedulerDTO;
import com.erstegroup.lio.dto.UserDTO;
import com.erstegroup.lio.service.DataPopulator;
import com.erstegroup.lio.utils.DateUtil;
import com.erstegroup.lio.utils.ObjectFactory;
import com.erstegroup.lio.utils.SchedulerUtil;
import com.erstegroup.lio.utils.SessionUtil;

@Component
public class DataPopulatorImpl implements DataPopulator {
	
	private static final Logger log = LoggerFactory.getLogger(DataPopulatorImpl.class);
	
	@Override
	public SchedulerJobGroup getSchedulerJobGroup(JobSchedulerDTO jobSchedulerDTO , Map<String,Object> params) {
		log.debug("populating SchedulerJobGroup for jobGroupName {}" , jobSchedulerDTO.getJobGroupName());
		SchedulerJobGroup schedulerJobGroup = ObjectFactory.getSchedulerJobGroup();
		schedulerJobGroup.setSchJobGroupName(SchedulerUtil.trim(jobSchedulerDTO.getJobGroupName()));
		UserDTO userDTO = SessionUtil.getUserDetail((HttpServletRequest)params.get(CommonConstants.HTTP_SERVLET_REQUEST));
		schedulerJobGroup.setCreatedBy(userDTO.getUserName());
		schedulerJobGroup.setCreatedOn(DateUtil.getCurrentSystemDateTime());
		return schedulerJobGroup;
	}
	
}
