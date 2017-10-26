package com.erstegroup.lio.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erstegroup.lio.constants.CommonConstants;
import com.erstegroup.lio.constants.ServiceConstants;
import com.erstegroup.lio.dao.UserDAO;
import com.erstegroup.lio.db.model.UserLogin;
import com.erstegroup.lio.dto.UserDTO;
import com.erstegroup.lio.exception.SchedulerException;
import com.erstegroup.lio.service.UserService;
import com.erstegroup.lio.utils.MessagesReader;
import com.erstegroup.lio.utils.ResponseEntity;
import com.erstegroup.lio.utils.SessionUtil;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public ResponseEntity getResponseEntity(String userName,HttpServletRequest request) {
		log.debug("getting the user information for userName {}" , userName);
		ResponseEntity responseEntity = ResponseEntity.newInstance();
		try {
			UserLogin userLogin = userDAO.getUserLoginDetailsByUsername(userName);
			if(null == userLogin) {
				log.debug("user information not found in the system");
				responseEntity.getDataMap().put(CommonConstants.ERROR, MessagesReader.getMessage(ServiceConstants.USER_NOT_FOUND));
				return responseEntity;
			}
			UserDTO userDTO = new UserDTO();
			userDTO.setUserName(userName);
			userDTO.setUserFullName(userLogin.getUlUserFullName());
			responseEntity.getDataMap().put(CommonConstants.USER_INFO, userDTO);
			SessionUtil.setUserDetail(userDTO, request);
		} catch(SchedulerException e) {
			log.error("exception occurred while retrieving data " , e.getMessage());
			responseEntity.getDataMap().put(CommonConstants.ERROR, MessagesReader.getMessage(ServiceConstants.USER_RETRIEVAL_ERROR));
		}
		return responseEntity;
	}
}
