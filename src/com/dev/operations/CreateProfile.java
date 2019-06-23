package com.dev.operations;

import java.util.Scanner;

import com.dec.beans.User;
import com.dev.services.UserServices;
import com.dev.services.UserServicesImpl;

public class CreateProfile {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		UserServices us=new UserServicesImpl();
		User user=new User();
		
		System.out.println("Enter the userid");
		user.setUserid(Integer.parseInt(sc.nextLine()));
		System.out.println("Enter the Username");
		user.setUsername(sc.nextLine());
		System.out.println("Enter the email");
		user.setEmail(sc.nextLine());
		System.out.println("Enter the password");
		user.setPassword(sc.nextLine());
		
		
		boolean b=us.createProfile(user);
		if(b) {
			System.out.println("Profile Created");
		}else {
			System.out.println("Profile Creation failed");
		}
		sc.close();
		
		
		
	}
}
