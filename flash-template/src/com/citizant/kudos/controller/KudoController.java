package com.citizant.kudos.controller;

import java.util.List;

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
	public ModelAndView kudoPage() {
		ModelAndView mav = new ModelAndView("tile.kudoPage");
		List<UserBean> users = kudoService.getUsers();
		mav.addObject("users", users);
		return mav;
	}
}
