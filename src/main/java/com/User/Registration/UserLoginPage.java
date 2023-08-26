package com.User.Registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginPage {
	public static boolean validate(String username,String password) {
		boolean status =false;
		
		
		 try {
             Class.forName("com.mysql.jdbc.Driver");
         } catch (ClassNotFoundException e) {
             
         }
		try {
        	
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodmanagement", "root", "student");
            PreparedStatement pstmt = conn.prepareStatement("select * from donorregistration where username=? AND password=? " );
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet resultSet = pstmt.executeQuery();
            status =resultSet.next();          
            
            
            
		} catch (SQLException e) {
       

        }
		return status;
	}
}
