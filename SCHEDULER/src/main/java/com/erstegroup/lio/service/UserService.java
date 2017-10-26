package com.erstegroup.lio.service;

import javax.servlet.http.HttpServletRequest;

import com.erstegroup.lio.utils.ResponseEntity;

public interface UserService {
	
	public ResponseEntity getResponseEntity(String userName,HttpServletRequest request);
	
}
