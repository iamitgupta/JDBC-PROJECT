package com.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.dec.beans.User;

public class UserInfoJDBCImpl implements UserInfoDao {
	public UserInfoJDBCImpl() {
		try {
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	String url="jdbc:mysql://127.0.0.1:3306/caps_mumbai?user=root&password=root";
	@Override
	public boolean createProfile(User user) {
		String query="INSERT INTO users_info VALUES (?,?,?,?)";
		try(Connection conn=DriverManager.getConnection(url);
				PreparedStatement pstmt=conn.prepareStatement(query)){

			pstmt.setInt(1, user.getUserid());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());

			int i=pstmt.executeUpdate();
			if(i>0) {
				System.out.println("Data inserted");
				return true;
			}
			else {
				System.out.println("Data Insertion Failed");
				return false;

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public User retriveProfile() {
		String query="SELECT  * FROM users_info";

		try(Connection conn=DriverManager.getConnection(url);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(query)){

			User user= new User();
			while(rs.next()) {
				user.setUserid(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setEmail((rs.getString("email")));

				System.out.println(user);

			}
			return user;

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	@Override
	public boolean updateProfile(int userid,String password) {
		String query="UPDATE users_info SET username=?,email=?,password=? WHERE user_id="+userid;
		String passQuery="SELECT * FROM users_info WHERE user_id="+userid;
		try(Connection conn=DriverManager.getConnection(url);
				PreparedStatement pstmt=conn.prepareStatement(query);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(passQuery)
				){
			rs.next();
			String tempPass=rs.getString("password");
			if(password.equals(tempPass)) {
				System.out.println("Enter the details to update profile");
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter username");
				String username=sc.nextLine();
				System.out.println("Enter email");
				String email=sc.nextLine();
				System.out.println("Enter password");
				String passwd=sc.nextLine();
				pstmt.setString(1, username);
				pstmt.setString(2, email);
				pstmt.setString(3, passwd);

				int i=pstmt.executeUpdate();
				sc.close();
				
				if(i>0) {
					return true;
				}
				else {
					return false;

				}
			}
			else {
				System.out.println("user_id or password is wrong");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	@Override
	public boolean deleteProfile(int userid, String password) {
		String query="DELETE FROM users_info WHERE user_id="+userid;
		String passQuery="SELECT * FROM users_info WHERE user_id="+userid;
		try(Connection conn=DriverManager.getConnection(url);
				PreparedStatement pstmt=conn.prepareStatement(query);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(passQuery);
				){
			rs.next();
			String tempPass=rs.getString("password");
			
			if(password.equals(tempPass)) {
				int i=pstmt.executeUpdate();
				if(i>0) {
					return true;
				}
				else {
					return false;

				}
			}
			else {
				System.out.println("user_id or password is wrong");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
