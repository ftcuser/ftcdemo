package com.citizant.kudos.dao;

import java.util.List;

import com.citizant.kudos.domain.User;

public interface KudoDao extends BaseDao {
	
	public User getUserByEmail(String email);
	public List<User> getUsers();

}
