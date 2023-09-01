package com.bankRegistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BBLoginPage {
	public static boolean validate(String BloodBankName,String LicenseNumber) {
		boolean status =false;
		
		
		 try {
             Class.forName("com.mysql.cj.jdbc.Driver");
         } catch (ClassNotFoundException e) {
             
         }
		try {
        	
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodmanagement", "root", "student");
            PreparedStatement pstmt = conn.prepareStatement("select * from bloodbankregistration where BloodBankName=? AND LicenseNumber=? " );
            pstmt.setString(1,BloodBankName);
            pstmt.setString(2,LicenseNumber);
            ResultSet resultSet = pstmt.executeQuery();
            status =resultSet.next();          
 
		} catch (SQLException e) {


        }
		return status;
	}

}
