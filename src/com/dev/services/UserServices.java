package com.dev.services;

import com.dec.beans.User;

public interface UserServices {
	public boolean createProfile(User user);
	public User retriveProfile(); 
	public boolean updateProfile(int userid,String password);
	public boolean deleteProfile(int userid,String password);
	
	

}
