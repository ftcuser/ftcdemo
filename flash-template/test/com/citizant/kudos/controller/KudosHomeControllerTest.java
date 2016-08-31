package com.citizant.kudos.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;

import com.citizant.kudos.bean.UserBean;
import com.citizant.kudos.common.AppConstants;

import org.junit.Assert;

public class KudosHomeControllerTest {

	@InjectMocks
	KudosHomeController controller;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

    public String formatEmail(String fname, String lname, String email) {
        return fname + " " + lname + " <" + email + ">";
    }
	
	
	@Test
	public void test_logout() throws IOException {
		//nothing to do for now.
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpSession session = new MockHttpSession();
		UserBean ub = new UserBean();
		ub.setEmail("test@test.com");
		ub.setFirstName("Test");
		ub.setLastName("User");
		session.setAttribute(AppConstants.LOGIN_USER, ub);
		request.setSession(session);
		controller.logout(request);
		Assert.assertNull(session.getAttribute(AppConstants.LOGIN_USER));
	}

}
