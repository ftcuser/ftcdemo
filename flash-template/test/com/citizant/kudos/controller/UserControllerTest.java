package com.citizant.kudos.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;

import com.citizant.kudos.bean.UserBean;
import com.citizant.kudos.common.AppConstants;

public class UserControllerTest {
	@InjectMocks
	UserController controller;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

    public String formatEmail(String fname, String lname, String email) {
        return fname + " " + lname + " <" + email + ">";
    }

	@Test
	public void test_makeUserBeanFromRequest() {
		HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
        String data[] = {
            "email", "billy.joel@example.com",
            "firstName", "William",
            "lastName", "Joel",
            "password", "4theLongesttime" };
        for (int i=0; i < data.length; i += 2) {
            Mockito.when(req.getParameter(data[i])).thenReturn(data[i+1]);
        }

        UserBean ub = controller.makeUserBeanFromRequest(req);

		Assert.assertEquals("William Joel <billy.joel@example.com>", formatEmail(ub.getFirstName(), ub.getLastName(), ub.getEmail()));
		Assert.assertEquals("4theLongesttime", ub.getPassword());
	}
	

}
