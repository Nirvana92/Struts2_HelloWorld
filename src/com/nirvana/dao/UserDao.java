package com.nirvana.dao;

import com.nirvana.entity.User;

public interface UserDao extends BaseDao<User> {
	public User load(String username, String password);
}
