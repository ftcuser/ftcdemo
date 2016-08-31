package com.citizant.kudos.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.citizant.kudos.bean.KudoBean;
import com.citizant.kudos.bean.UserBean;
import com.citizant.kudos.common.AppConstants;
import com.citizant.kudos.service.KudoService;

@Controller
@RequestMapping("/kudo")
public class KudoController extends BaseController {
	
	@Autowired
	private KudoService kudoService;

	
	@RequestMapping("/start")
	public ModelAndView kudoPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("tile.kudoPage");
		UserBean user = kudoService.getUserByEmail(request.getParameter("email"));
		mav.addObject("user", user);
		return mav;
	}
	
	@RequestMapping("/create")
	public ModelAndView create(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("tile.startPage");
		UserBean fromUser = (UserBean)request.getSession().getAttribute(AppConstants.LOGIN_USER);
		UserBean toUser = kudoService.getUserByEmail(request.getParameter("kudoto"));
		
		KudoBean kudoBean = new KudoBean();
		
		kudoBean.setFromEmail(fromUser.getEmail());
		kudoBean.setToEmail(toUser.getEmail());
		kudoBean.setFromFirstName(fromUser.getFirstName());
		kudoBean.setFromLastName(fromUser.getLastName());
		
		kudoBean.setToFirstName(toUser.getFirstName());
		kudoBean.setToLastName(toUser.getLastName());
		
		kudoBean.setKudoCategory(request.getParameter("category"));
		kudoBean.setComment(request.getParameter("comment"));
		kudoBean.setKudoDate(new Date());
		
		kudoService.saveKudo(kudoBean);
		mav.addObject("msg", "Kudo sent to " + toUser.getFirstName() + " " + toUser.getLastName());
		
		//to do :
	
		List<UserBean> users = kudoService.getUsers();
		mav.addObject("users", users);
		return mav;
	}
}
