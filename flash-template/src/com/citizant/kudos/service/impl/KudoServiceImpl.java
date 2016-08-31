package com.citizant.kudos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.citizant.kudos.bean.UserBean;
import com.citizant.kudos.dao.KudoDao;
import com.citizant.kudos.domain.User;
import com.citizant.kudos.service.KudoService;

public class KudoServiceImpl implements KudoService {

	@Autowired
	private KudoDao kudoDao;

	@Override
	public List<UserBean> getUsers() {
		List<UserBean> userBeans = new ArrayList<>();
		List<User> users = kudoDao.getUsers();
		for(User user : users) {
			UserBean userBean = makeUserBeanFromUser(user);
			if(!userBean.isDeleted()) {
				userBeans.add(makeUserBeanFromUser(user));
			}
		}
		return userBeans;
	}

	@Override
	public void removeAllRecord(){
		List<User> users = kudoDao.getUsers();
		for(User user : users) {
			kudoDao.delete(user);
		}
	}


    public User makeUserFromUserBean(UserBean userBean) {
    	User user = 
         new User(userBean.getFirstName(), userBean.getLastName(), userBean.getEmail(),
                        userBean.getPassword(), userBean.getRole());
    	user.setActive(userBean.isActive());
    	user.setDeleted(userBean.isDeleted());
    	return user;
    }

    public UserBean makeUserBeanFromUser(User user) {
        if (user == null)
            return null;
      
	        UserBean userBean = new UserBean();
	        userBean.setEmail(user.getEmail());
	        userBean.setPassword(user.getPassword());
	        userBean.setFirstName(user.getFirstName());
	        userBean.setLastName(user.getLastName());
	        userBean.setRole(user.getRole());
	        userBean.setActive(user.isActive());
	        userBean.setDeleted(user.isDeleted());
	        return userBean;
    
    }

	@Override
	public UserBean getUserByEmail(String email) {
		return makeUserBeanFromUser(kudoDao.getUserByEmail(email));
	}


	@Override
	public void saveUser(UserBean userBean) {
		kudoDao.save(makeUserFromUserBean(userBean));
	}
	
	@Override
	public void deleteUserByEmail(String email) {
		User user = kudoDao.getUserByEmail(email);
		if(user!=null) {
			user.setDeleted(true);
		}
		kudoDao.save(user);
	}

}
