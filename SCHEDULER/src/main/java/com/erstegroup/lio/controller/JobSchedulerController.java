package com.erstegroup.lio.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.erstegroup.lio.constants.CommonConstants;
import com.erstegroup.lio.constants.ControllerUrlConstants;
import com.erstegroup.lio.constants.JspNamesConstants;
import com.erstegroup.lio.dto.JobSchedulerDTO;
import com.erstegroup.lio.service.JobSchedulerService;
import com.erstegroup.lio.utils.ObjectFactory;
import com.erstegroup.lio.utils.ResponseEntity;

@Controller
@RequestMapping(ControllerUrlConstants.JOB_SCHEDULER_URL)
public class JobSchedulerController {

	@Autowired
	private JobSchedulerService jobSchedulerService;
	
	@GetMapping(ControllerUrlConstants.JOB_GROUP_URL)
	public ModelAndView getJobGroup(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName(JspNamesConstants.JOB_SCHEDULE_JSP);
		model.addObject(ControllerUrlConstants.JOB_SCHEDULER_URL, ControllerUrlConstants.JOB_GROUP_URL);
		return model;
	}
	
	@GetMapping(ControllerUrlConstants.JOB_SCHEDULE_URL)
	public ModelAndView getJobSchedule(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.addObject(ControllerUrlConstants.JOB_SCHEDULER_URL, ControllerUrlConstants.JOB_SCHEDULE_URL);
		model.setViewName(JspNamesConstants.JOB_SCHEDULE_JSP);
		return model;
	}
	
	@PostMapping(ControllerUrlConstants.JOB_SCHEDULE_GROUP_NAME_CREATION_URL)
	@ResponseBody
	public ResponseEntity createJobGroupName(@RequestBody JobSchedulerDTO jobSchedulerDTO, HttpServletRequest request) {
		Map<String,Object> params = ObjectFactory.getMap();
		params.put(CommonConstants.HTTP_SERVLET_REQUEST, request);
		ResponseEntity responseEntity = jobSchedulerService.createJobGroupName(jobSchedulerDTO, params);
		return responseEntity;
	}
	
	@PostMapping(ControllerUrlConstants.GET_JOB_GROUP_NAMES)
	@ResponseBody
	public ResponseEntity getJobGroupNames(HttpServletRequest request) {
		Map<String,Object> params = ObjectFactory.getMap();
		ResponseEntity responseEntity = jobSchedulerService.getJobGroupNames(params);
		return responseEntity;
	}
	
	
	
}
