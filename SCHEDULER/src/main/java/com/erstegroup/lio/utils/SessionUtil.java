package com.erstegroup.lio.utils;

import javax.servlet.http.HttpServletRequest;

import com.erstegroup.lio.constants.CommonConstants;
import com.erstegroup.lio.dto.UserDTO;

public class SessionUtil {

	public static void setUserDetail(UserDTO userDTO, HttpServletRequest request) {
		request.getSession().setAttribute(CommonConstants.USER_INFO, userDTO);
	}
	
	public static UserDTO getUserDetail(HttpServletRequest request) {
		return (UserDTO)request.getSession().getAttribute(CommonConstants.USER_INFO);
	}
	
}
