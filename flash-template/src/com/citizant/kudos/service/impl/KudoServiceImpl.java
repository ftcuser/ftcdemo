package com.citizant.kudos.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.citizant.kudos.bean.KudoBean;
import com.citizant.kudos.bean.UserBean;
import com.citizant.kudos.dao.KudoDao;
import com.citizant.kudos.domain.Kudo;
import com.citizant.kudos.domain.User;
import com.citizant.kudos.service.KudoService;
import com.citizant.kudos.util.StringUtil;

public class KudoServiceImpl implements KudoService {

	@Autowired
	private KudoDao kudoDao;
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
	
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
	
	@Override
	public List<KudoBean> getAllKudos() {
		List<KudoBean> kudoBeans = new ArrayList<>();
		List<Kudo> kudos = kudoDao.getAllKudos();
		for(Kudo kudo : kudos){
			kudoBeans.add(makeKudoBean(kudo, kudoDao));
		}
		return kudoBeans;
	}
	
	public KudoBean makeKudoBean(Kudo kudo, KudoDao kudoDao) {
		KudoBean bean = new KudoBean();
		bean.setFromEmail(kudo.getFromEmail());
		bean.setToEmail(kudo.getToEmail());
		bean.setComment(kudo.getComment());
		bean.setKudoDate(kudo.getKudoDate());

		User user = kudoDao.getUserByEmail(kudo.getFromEmail());
		if (user != null) {
			bean.setFromFirstName(user.getFirstName());
			bean.setFromLastName(user.getLastName());
		} else {
			bean.setFromFirstName(StringUtil.EMPTY_STRING);
			bean.setFromLastName(StringUtil.EMPTY_STRING);
		}

		user = kudoDao.getUserByEmail(kudo.getToEmail());
		if (user != null) {
			bean.setToFirstName(user.getFirstName());
			bean.setToLastName(user.getLastName());
		} else {
			bean.setToFirstName(StringUtil.EMPTY_STRING);
			bean.setToLastName(StringUtil.EMPTY_STRING);
		}
		return bean;
	}

	@Override
	public void saveKudo(KudoBean kudoBean) {
		kudoDao.save(makeKudoFromKudoBean(kudoBean));
	}
	
	public Kudo makeKudoFromKudoBean(KudoBean bean) {
		Kudo kudo = new Kudo();
		kudo.setKudoDate(bean.getKudoDate());
		kudo.setFromEmail(bean.getFromEmail());
		kudo.setToEmail(bean.getToEmail());
		kudo.setComment(bean.getComment());
		kudo.setKudoCategory(bean.getKudoCategory());
        return kudo;
    }
	
	@Override
	public List<KudoBean> getKudosReceived(String email) {

		List<KudoBean> allKudos = getAllKudos();
		List<KudoBean> receivedKudos = filterKudos(email, allKudos);
		return receivedKudos;
	}
	
	public List<KudoBean> filterKudos(String email, List<KudoBean> allKudos) {
		List<KudoBean> receivedKudos = new ArrayList<>();
		for (KudoBean kb : allKudos) {
			if (kb.getToEmail().equalsIgnoreCase(email.trim())) {
				receivedKudos.add(kb);
			}
		}
		return receivedKudos;
	}
	
	public List<UserBean> getHomeUsers(UserBean formUser){
		List<UserBean> users = getUsers();
		List<UserBean> newList = new ArrayList<>();
		for (UserBean user : users) {
			if (user.getEmail().equals(formUser.getEmail())) {
				continue;
			}
			setUserKudoReceivedFlag(user, formUser.getEmail());
			newList.add(user);
		}
		return newList;
	}
	private void setUserKudoReceivedFlag(UserBean user, String email) {
		List<KudoBean> kudosReceived = getKudosReceived(user.getEmail());
		Date today = new Date();
		for (KudoBean kb : kudosReceived) {
			if (kb.getFromEmail().equals(email) &&
				dateFormatter.format(kb.getKudoDate()).equals(dateFormatter.format(today))) {
				user.setKudoReceived(true);
			}
		}
	}
}
