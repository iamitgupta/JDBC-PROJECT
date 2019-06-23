package com.dev.services;

import com.dec.beans.User;
import com.dev.dao.UserInfoDao;
import com.dev.dao.UserInfoJDBCImpl;

public class UserServicesImpl implements UserServices{

	UserInfoDao dao=new UserInfoJDBCImpl();
	@Override
	public boolean createProfile(User user) {

		return dao.createProfile(user);
	}
	@Override
	public User retriveProfile() {
		return dao.retriveProfile();
	}
	@Override
	public boolean updateProfile(int userid,String password) {
		return dao.updateProfile(userid,password);
	}
	@Override
	public boolean deleteProfile(int userid, String password) {
		return dao.deleteProfile(userid, password);
			}

}
