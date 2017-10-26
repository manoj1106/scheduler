package com.erstegroup.lio.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erstegroup.lio.constants.CommonConstants;
import com.erstegroup.lio.constants.ServiceConstants;
import com.erstegroup.lio.dao.JobSchedulerDAO;
import com.erstegroup.lio.db.model.SchedulerJobGroup;
import com.erstegroup.lio.dto.JobSchedulerDTO;
import com.erstegroup.lio.exception.SchedulerException;
import com.erstegroup.lio.service.DataPopulator;
import com.erstegroup.lio.service.JobSchedulerService;
import com.erstegroup.lio.utils.MessagesReader;
import com.erstegroup.lio.utils.ObjectFactory;
import com.erstegroup.lio.utils.ResponseEntity;
import com.erstegroup.lio.utils.SchedulerUtil;

@Service
public class JobSchedulerServiceImpl implements JobSchedulerService {

	private static final Logger log = LoggerFactory.getLogger(JobSchedulerServiceImpl.class);
	
	@Autowired
	private JobSchedulerDAO jobSchedulerDAO;
	
	@Autowired
	private DataPopulator dataPopulator;
	
	@Override
	@Transactional
	public ResponseEntity createJobGroupName(JobSchedulerDTO jobSchedulerDTO,Map<String,Object> params) {
		log.debug("saving the");
		ResponseEntity responseEntity = ResponseEntity.newInstance();
		Map<String,Object> dataMap = ObjectFactory.getMap();
		try {
			SchedulerJobGroup schedulerJobGroup = jobSchedulerDAO.getSchedulerJobGroup(jobSchedulerDTO.getJobGroupName());
			if(null == schedulerJobGroup) {
				schedulerJobGroup = dataPopulator.getSchedulerJobGroup(jobSchedulerDTO, params);
				Long schJobGroupId = jobSchedulerDAO.saveSchedulerJobGroup(schedulerJobGroup);
				if(null == schJobGroupId || schJobGroupId.compareTo(ServiceConstants.ZERO) == 0) {
					dataMap.put(CommonConstants.ERROR, MessagesReader.getMessage(ServiceConstants.JOBGROUP_NAME_CREATION_ERROR));
				} else {
					dataMap.put(CommonConstants.SUCCESS, SchedulerUtil.join(MessagesReader.getMessage(
							ServiceConstants.JOBGROUP_NAME_CREATED)	, CommonConstants.SPACE, schJobGroupId));
				}
			} else {
				dataMap.put(CommonConstants.ERROR, MessagesReader.getMessage(ServiceConstants.JOBGROUP_NAME_EXISTS));
			}
		} catch(SchedulerException e) {
			log.error("exception occurred while saving job group in database..");
			dataMap.put(CommonConstants.ERROR, MessagesReader.getMessage(ServiceConstants.JOBGROUP_NAME_CREATION_ERROR));
		} catch(Exception e) {
			log.error("exception occurred while saving job group in database.." , e);
			dataMap.put(CommonConstants.ERROR, MessagesReader.getMessage(ServiceConstants.JOBGROUP_NAME_CREATION_ERROR));
		}
		responseEntity.setDataMap(dataMap);
		return responseEntity;
	}

	@Override
	@Transactional
	public ResponseEntity getJobGroupNames(Map<String, Object> params) {
		log.debug("getting the job group names");
		ResponseEntity responseEntity = ResponseEntity.newInstance();
		Map<String,Object> dataMap = ObjectFactory.getMap();
		List<String> jobGroupNames = null;
		try {
			jobGroupNames = jobSchedulerDAO.getJobGroupNames();
			dataMap.put(ServiceConstants.JOBGROUP_NAMES, jobGroupNames);
		} catch(SchedulerException e) {
			log.error("exception occurred while saving job group in database..");
			dataMap.put(CommonConstants.ERROR, MessagesReader.getMessage(ServiceConstants.JOBGROUP_NAME_CREATION_ERROR));
		} catch(Exception e) {
			log.error("exception occurred while saving job group in database.." , e);
			dataMap.put(CommonConstants.ERROR, MessagesReader.getMessage(ServiceConstants.JOBGROUP_NAME_CREATION_ERROR));
		}
		responseEntity.setDataMap(dataMap);
		return responseEntity;
	}
	
}
