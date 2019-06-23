package com.dev.dao;

import com.dec.beans.User;

public interface UserInfoDao {
	public boolean createProfile(User user);
	public User retriveProfile();
	public boolean updateProfile(int userid,String password);
	public boolean deleteProfile(int userid,String password);
	
	
	
}
