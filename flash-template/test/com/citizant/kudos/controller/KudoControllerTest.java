package com.citizant.kudos.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.citizant.kudos.service.KudoService;
import com.citizant.kudos.bean.UserBean;
import com.citizant.kudos.common.AppConstants;

import org.junit.Assert;

public class KudoControllerTest {

	@InjectMocks
	KudoController controller;

    @Mock
	private KudoService kudoService;

    private HttpServletRequest mockRequest;
    private HttpSession mockSession;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
        mockRequest = mock(HttpServletRequest.class);
        mockSession = mock(HttpSession.class);
        when(mockRequest.getSession()).thenReturn(mockSession);
	}

    public String formatEmail(String fname, String lname, String email) {
        return fname + " " + lname + " <" + email + ">";
    }
	
	@Test
	public void test_create() throws IOException {
        when(mockRequest.getParameter("kudoto")).thenReturn("some@example.com");
        when(mockSession.getAttribute(AppConstants.LOGIN_USER)).thenReturn(new UserBean("From","Frummelson","","",""));
        when(kudoService.getUserByEmail("some@example.com")).thenReturn(new UserBean("Tootie","Tooer","","",""));
        List<UserBean> users = new ArrayList<>();
        users.add(new UserBean("Listed", "User", "", "", ""));
        when(kudoService.getUsers()).thenReturn(users);

        ModelAndView mav = controller.create(mockRequest);

        Map m = mav.getModel();//Object
        List<UserBean> returnedUsers = (List<UserBean>) m.get("users");
        Assert.assertEquals(1, users.size());
        Assert.assertEquals("Listed", users.get(0).getFirstName());
        Assert.assertEquals("1 kudo sent to Tootie Tooer", (String) m.get("msg"));
	}

}
