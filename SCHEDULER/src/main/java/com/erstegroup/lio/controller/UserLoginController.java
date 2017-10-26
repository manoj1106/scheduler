package com.erstegroup.lio.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.erstegroup.lio.constants.ControllerUrlConstants;
import com.erstegroup.lio.constants.JspNamesConstants;
import com.erstegroup.lio.service.UserService;

@Controller
public class UserLoginController {
	
	private static final Logger log = LoggerFactory.getLogger(UserLoginController.class);

	@Autowired
	private UserService userService;
	
	@GetMapping(ControllerUrlConstants.BASE_URL)
	public String getBasePage() {
		log.debug("base url called. opening the login page.");
		return JspNamesConstants.LOGIN_JSP;
	}
	
	@GetMapping(ControllerUrlConstants.LOGIN_URL)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			log.debug("error while logging in. invailid username and password.");
			model.addObject("error", "Invalid username and password!");
		}
		if (logout != null) {
			log.debug("user is logged out from the system.");
			request.getSession().invalidate();
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName(JspNamesConstants.LOGIN_JSP);
		return model;

	}
	
	@GetMapping(ControllerUrlConstants.INDEX_URL)
	public ModelAndView indexPage(HttpServletRequest request) {
		log.debug("login success. returning index page");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		userService.getResponseEntity(userDetails.getUsername(), request);
		ModelAndView model = new ModelAndView();
		model.setViewName(JspNamesConstants.INDEX_JSP);
		return model;

	}

	//for 403 access denied page
	@GetMapping(ControllerUrlConstants.ERROR_URL)
	public ModelAndView accesssDenied() {
		log.debug("invailid page");
		ModelAndView model = new ModelAndView();
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}
		model.setViewName(JspNamesConstants.ERROR_JSP);
		return model;

	}
	
}
