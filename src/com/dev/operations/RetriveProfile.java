package com.dev.operations;

import com.dev.services.UserServices;
import com.dev.services.UserServicesImpl;

public class RetriveProfile {

	public static void main(String[] args) {
		UserServices us=new UserServicesImpl();
		us.retriveProfile();
	

	}

}
