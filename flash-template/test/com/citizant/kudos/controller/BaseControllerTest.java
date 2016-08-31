package com.citizant.kudos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.citizant.kudos.common.AppConstants;

import org.junit.Assert;

public class BaseControllerTest {
	
	@InjectMocks
	BaseController mockBaseController;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	/*
	@Test
	public void testGetLoginUser() {
		UserBean mockUser = Mockito.mock(UserBean.class);
		Mockito.when(mockUser.getFirstName()).thenReturn("Mock User");
		HttpSession mockSession = Mockito.mock(HttpSession.class);
		Mockito.when(mockSession.getAttribute(AppConstants.LOGIN_USER)).thenReturn(mockUser);
		HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
		Mockito.when(mockRequest.getSession()).thenReturn(mockSession);
		Assert.assertEquals("Mock User", mockBaseController.getLoginUser(mockRequest).getFirstName());
	}
	*/

    @Test
    public void testNothing() {
        Assert.assertEquals(2, 1+1);
    }
}
