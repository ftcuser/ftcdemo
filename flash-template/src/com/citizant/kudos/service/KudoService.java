package com.citizant.kudos.service;

import java.util.List;

import com.citizant.kudos.bean.KudoBean;
import com.citizant.kudos.bean.UserBean;

public interface KudoService {
	public UserBean getUserByEmail(String email);
	public void deleteUserByEmail(String email);
	public List<UserBean> getUsers();
	public void removeAllRecord();
	public void saveUser(UserBean userBean);
	
	public List<KudoBean> getAllKudos();
	public void saveKudo(KudoBean kudoBean);
	public List<KudoBean> getKudosReceived(String email);
}
