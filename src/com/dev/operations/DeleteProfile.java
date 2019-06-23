package com.dev.operations;

import java.util.Scanner;

import com.dev.services.UserServices;
import com.dev.services.UserServicesImpl;

public class DeleteProfile {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		UserServices us=new UserServicesImpl();

		System.out.println("Enter the userid");
		int userid=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the password");
		String password=sc.nextLine();

		boolean b=us.deleteProfile(userid, password);

		if(b) {
			System.out.println("Profile Deleted");
		}else {
			System.out.println("Profile deletion failed");
		}
		sc.close();
		
	}

}
