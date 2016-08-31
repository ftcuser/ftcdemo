package com.citizant.kudos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.citizant.kudos.bean.UserBean;
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
		ModelAndView mav = new ModelAndView("tile.kudoPage");
	//	UserBean fromUser = this.getL
		UserBean user = kudoService.getUserByEmail(request.getParameter("email"));
		mav.addObject("user", user);
		return mav;
	}
}
