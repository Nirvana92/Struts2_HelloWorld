package com.nirvana.dao.impl;

import com.nirvana.dao.UserDao;
import com.nirvana.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	@Override
	public User load(String username, String password) {
		String hql = "from User u where u.username=? and u.password=?";
		return load(hql, new Object[] { username, password });
	}
}
