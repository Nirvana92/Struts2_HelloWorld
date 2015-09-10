package com.nirvana.action;

import com.nirvana.dao.UserDao;
import com.nirvana.dao.impl.UserDaoImpl;
import com.nirvana.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private User user;

	public LoginAction() {
		// TODO Auto-generated constructor stub
		userDao = new UserDaoImpl();
	}

	@Override
	public String execute() throws Exception {
		User u = userDao.load(user.getUsername(), user.getPassword());
		if (u == null) {
			return ERROR;
		}
		
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
