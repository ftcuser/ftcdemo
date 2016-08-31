package com.citizant.kudos.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.citizant.kudos.bean.UserBean;
import com.citizant.kudos.common.AppConstants;
import com.citizant.kudos.common.SystemConfig;
import com.citizant.kudos.service.KudoService;


@Controller
@RequestMapping("/home")
public class KudosHomeController extends BaseController {

	private static Log log = LogFactory.getLog(KudosHomeController.class.getCanonicalName());

    public static final String LOGIN_TILE = "tile.loginPage";
    public static final String START_TILE = "tile.startPage";


	@Autowired
	private KudoService kudoService;

	@Override
	protected void initServletContext(ServletContext servletContext) {
		super.initServletContext(servletContext);
		if (servletContext.getAttribute("nameSuffixes") == null) {
			// Load System config
			String configFile = servletContext
					.getRealPath("/WEB-INF/system-config.xml");
			try {
				SystemConfig.getInstance().loadConfig(configFile);
			} catch (DocumentException e) {
				log.error(e);
			}
		}
	}

	@RequestMapping("/login")
	public ModelAndView loginPage() {
		return new ModelAndView(LOGIN_TILE);
	}


	@RequestMapping("/doLogin")
	public ModelAndView doLogin(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		UserBean userBean = kudoService.getUserByEmail(request.getParameter("email"));

        if(requestHasCorrectPasswordForUser(request, userBean)) {
            mav.setViewName(START_TILE);
            request.getSession().setAttribute(AppConstants.LOGIN_USER, userBean);
            return mav;
        }

		//login  failed
		request.setAttribute("msg", "Invalid email or password");
		mav.addObject("msg", "Invalid email or password");
		mav.setViewName(LOGIN_TILE);
		return mav;
	}

    public boolean requestHasCorrectPasswordForUser(HttpServletRequest request, UserBean userBean) {
        if (userBean == null)
            return false;
        if(!userBean.isActive() || userBean.isDeleted()) {
        	return false;
        }
        String password = request.getParameter("password");
        return password != null && password.equals(userBean.getPassword());
    }


	@RequestMapping("/start")
	public ModelAndView startPage(HttpServletRequest request) {
		UserBean userBean = (UserBean)request.getSession().getAttribute(AppConstants.LOGIN_USER);
		if (userBean != null) {
			return new ModelAndView(START_TILE);
		}
		return new ModelAndView(LOGIN_TILE);
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute(AppConstants.LOGIN_USER);
		request.getSession().invalidate();
		return "redirect:" + LOGIN_URL;
	}
	
}
