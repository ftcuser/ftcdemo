package com.citizant.kudos.service.impl;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;


import com.citizant.kudos.bean.UserBean;
import com.citizant.kudos.dao.KudoDao;
import com.citizant.kudos.domain.User;



public class KudoServiceImplTest {

    @InjectMocks
	KudoServiceImpl ksi = new KudoServiceImpl();

    @Mock
    public KudoDao mockKudoDao;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

	
	@Test
	public void test_makeUserBeanFromUser() {
		User user = createTestUser("George", "Washington", "pres1@example.com", "Iactuallydidchopdownthecherrytree");

		UserBean ub = ksi.makeUserBeanFromUser(user);

		Assert.assertEquals("pres1@example.com", ub.getEmail());
		Assert.assertEquals("George", ub.getFirstName());
		Assert.assertEquals("Washington", ub.getLastName());
		Assert.assertEquals("Iactuallydidchopdownthecherrytree", ub.getPassword());
		Assert.assertEquals(false, ub.isAdmin());
	}

	@Test
	public void test_makeUserBeanFromUser_with_null_user() {
		Assert.assertEquals(null, ksi.makeUserBeanFromUser(null));
    }

	@Test
    public void test_makeUserFromUserBean() {
        UserBean bean = createTestUserBean("Ozzy", "Osbourne", "wizard@example.com", "nobats", "admin");

        User user = ksi.makeUserFromUserBean(bean);

        Assert.assertEquals("Ozzy Osbourne <wizard@example.com>", formatEmail(user.getFirstName(), user.getLastName(), user.getEmail()));
        Assert.assertEquals("nobats", user.getPassword());
        Assert.assertTrue(user.getRole().equals("admin"));
    }

	private User createTestUser(String firstName, String lastName) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return user;
	}

    private User createTestUser(String firstName, String lastName, String email, String password) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole("user");
		return user;
	}

    private UserBean createTestUserBean(String firstName, String lastName, String email, String password, String role) {
        UserBean bean = new UserBean();
        bean.setFirstName(firstName);
        bean.setLastName(lastName);
        bean.setEmail(email);
        bean.setPassword(password);
        bean.setRole(role);
        return bean;
    }

	

    public String formatEmail(String fn, String ln, String email) {
        return fn + " " + ln + " <" + email + ">";
    }


    @Test
    public void test_getUsers_none() {
        List<UserBean> users = ksi.getUsers();
        Assert.assertEquals(0, users.size());
    }

    @Test
    public void test_getUsers_one() {
        List<User> someUsers = new ArrayList<>();
        someUsers.add(createTestUser("Gene", "Hackman", "thehackster@example.com", "Fr3nchConnect!on"));
		Mockito.when(mockKudoDao.getUsers()).thenReturn(someUsers);

        List<UserBean> users = ksi.getUsers();
        Assert.assertEquals(1, users.size());
        UserBean bean = users.get(0);
        Assert.assertEquals("Gene", bean.getFirstName());
        Assert.assertEquals("Hackman", bean.getLastName());
        Assert.assertEquals("thehackster@example.com", bean.getEmail());
        Assert.assertEquals("Fr3nchConnect!on", bean.getPassword());
        Assert.assertEquals(false, bean.isAdmin());
    }

    @Test
    public void test_getUsers_many() {
        List<User> someUsers = new ArrayList<>();
        for (int i=0; i < 10; i++)
            someUsers.add(createTestUser("Gene", "Hackman", "thehackster" + i + "@example.com", "Fr3nchConnect!on"));
        someUsers.get(5).setDeleted(true);
		Mockito.when(mockKudoDao.getUsers()).thenReturn(someUsers);

        List<UserBean> users = ksi.getUsers();
        Assert.assertEquals(9, users.size()); // because one was deleted
        UserBean bean = users.get(0);
        Assert.assertEquals("Gene", bean.getFirstName());
        Assert.assertEquals("Hackman", bean.getLastName());
        Assert.assertEquals("thehackster0@example.com", bean.getEmail());
        Assert.assertEquals("Fr3nchConnect!on", bean.getPassword());
        Assert.assertEquals(false, bean.isAdmin());
        Assert.assertEquals("thehackster9@example.com", users.get(8).getEmail()); // shifted up one
    }

    @Test
    public void test_deleteUserByEmail_null() {
        String badEmail = "nosuchuseremail@.com";
		Mockito.when(mockKudoDao.getUserByEmail(badEmail)).thenReturn(null);

        ksi.deleteUserByEmail(badEmail);

        verify(mockKudoDao).save(null);
    }

    @Test
    public void test_deleteUserByEmail_nonnull() {
        String email = "somebody@example.com";
        User user = createTestUser("Some", "Body", "somebody@example.com", "nobody1");
        Mockito.when(mockKudoDao.getUserByEmail(email)).thenReturn(user);

        ksi.deleteUserByEmail(email);

        Assert.assertEquals(true, user.isDeleted());
        verify(mockKudoDao).save(user);
    }
}
