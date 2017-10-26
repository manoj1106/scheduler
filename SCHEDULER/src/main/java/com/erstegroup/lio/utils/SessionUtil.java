package com.erstegroup.lio.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.erstegroup.lio.constants.CommonConstants;
import com.erstegroup.lio.dto.UserDTO;

public class SessionUtil {

	private static final Map<String,Object> loggedInUserMap = ObjectFactory.getConcurrentMap();
	
	public static void setUserDetail(UserDTO userDTO, HttpServletRequest request) {
		if(null == SessionUtil.getLoggedInUserMap().get(userDTO.getUserName())) {
			SessionUtil.loggedInUserMap.put(userDTO.getUserName(), userDTO.getUserName());
		}
		request.getSession().setAttribute(CommonConstants.USER_INFO, userDTO);
	}
	
	public static UserDTO getUserDetail(HttpServletRequest request) {
		return (UserDTO)request.getSession().getAttribute(CommonConstants.USER_INFO);
	}
	
	public static Map<String,Object> getLoggedInUserMap() {
		return SessionUtil.loggedInUserMap;
	}
	
	public static void removeUserOnLogout(HttpServletRequest request) {
		UserDTO userDTO = (UserDTO)request.getSession().getAttribute(CommonConstants.USER_INFO);
		if(null != userDTO && null != SessionUtil.getLoggedInUserMap().get(userDTO.getUserName())) {
			SessionUtil.loggedInUserMap.remove(userDTO.getUserName());
		}
		
	}
	
}
