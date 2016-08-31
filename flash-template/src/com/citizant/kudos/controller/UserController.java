package com.citizant.kudos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.citizant.kudos.bean.UserBean;
import com.citizant.kudos.common.AppConstants;
import com.citizant.kudos.service.KudoService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	
	@Autowired
	private KudoService kudoService;

	@RequestMapping("/startCreate")
	public ModelAndView startCreateUser() {
		ModelAndView mav = new ModelAndView("tile.createUserPage");
		UserBean userBean = new UserBean();
		mav.addObject("user", userBean);
		return mav;
	}

	@RequestMapping("/doCreate")
	public ModelAndView doCreateUser(HttpServletRequest request) {
		UserBean userBean = (UserBean)request.getSession().getAttribute(AppConstants.LOGIN_USER);
		kudoService.saveUser(makeUserBeanFromRequest(request));
		ModelAndView mav = new ModelAndView("tile.startPage");

		mav.addObject("users", kudoService.getHomeUsers(userBean));
		return mav;
	}
	
	@RequestMapping("/deactivate")
	public String deactivateUser(HttpServletRequest request) {
		String email = request.getParameter("email");
		UserBean user = kudoService.getUserByEmail(email);
		user.setActive(false);
		kudoService.saveUser(user);
		return "redirect: /servlet/home/start";
	}
	
	@RequestMapping("/activate")
	public String activateUser(HttpServletRequest request) {
		String email = request.getParameter("email");
		UserBean user = kudoService.getUserByEmail(email);
		user.setActive(true);
		kudoService.saveUser(user);
		return "redirect: /servlet/home/start";
	}
	
	@RequestMapping("/list")
	public ModelAndView userListPage() {
		ModelAndView mav = new ModelAndView("tile.listUserPage");
		List<UserBean> users = kudoService.getUsers();
		mav.addObject("users", users);
		return mav;
	}
	
	@RequestMapping("/edit")
	public ModelAndView userEditPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("tile.createUserPage");
		UserBean userBean = kudoService.getUserByEmail(request.getParameter("email"));		
		mav.addObject("user", userBean);
		return mav;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteUser(HttpServletRequest request) {
		kudoService.deleteUserByEmail(request.getParameter("email"));	
		ModelAndView mav = new ModelAndView("tile.listUserPage");
		List<UserBean> users = kudoService.getUsers();
		mav.addObject("users", users);
		return mav;
	}
	

	public UserBean makeUserBeanFromRequest(HttpServletRequest request) {
		UserBean userBean = new UserBean();
		userBean.setEmail(request.getParameter("email"));
		userBean.setFirstName(request.getParameter("firstName"));
		userBean.setLastName(request.getParameter("lastName"));
		userBean.setPassword("12345");
		userBean.setRole(request.getParameter("role"));
		userBean.setActive(true);
		/**
		 * 
		*if (request.getParameter("active") != null) {
		*	userBean.setActive(true);
		*} else {
			userBean.setActive(false);
		}
		*/
		return userBean;
	}

}
