package com.dev.operations;

import java.util.Scanner;

import com.dev.services.UserServices;
import com.dev.services.UserServicesImpl;

public class UpdateProfile {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		UserServices us=new UserServicesImpl();
		System.out.println("Enter the userid");
		int userid=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the password");
		String password=sc.nextLine();

		boolean b=us.updateProfile(userid, password);

		if(b) {
			System.out.println("Profile Updated");
		}else {
			System.out.println("Profile updation failed");
		}
		sc.close();
		
	}

}
