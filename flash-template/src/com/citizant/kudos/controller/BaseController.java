package com.citizant.kudos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.citizant.kudos.common.SystemConfig;


public class BaseController  extends AbstractController {
	
	public static final String LOGIN_URL = "/servlet/home/login";
	public static final String LOGIN_PAGE = "tile.loginPage";
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
	
		return null;
	}
	

	public String getLoginRedirect() {
		return "redirect:" + SystemConfig.getInstance().getLoadBalancerAddress() + "/login.jsp";
	}
	

	
	public static String getURLWithContextPath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	}
}
