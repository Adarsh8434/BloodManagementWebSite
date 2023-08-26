package com.servlet.register;
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class RegisterDoServlet
 */
@WebServlet("/register")
public class RegisterDoServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 doPost(request,response);
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		    PrintWriter pw=response.getWriter();
//	        response.setContentType("text/hmt1");
	      
	           String fullname = request.getParameter("fullName");
	           String bloodGroup = request.getParameter("bloodGroup");
	           String mobileNumber = request.getParameter("mobileNumber");
	           String state = request.getParameter("state");
	           String district = request.getParameter("district");
	           String email = request.getParameter("email");
	           String username = request.getParameter("username");
	           String password = request.getParameter("password");
	           
	           
//	           System.out.println("full Name :"+fullname);
//	           System.out.println("Blood group :"+bloodGroup);
//	           System.out.println("Mobile Number :"+mobileNumber);
//	           System.out.println("State :"+state);
//	           System.out.println("District :"+district);
//	           System.out.println("Email :"+email);
//	           System.out.println("Username :"+username);
//	           System.out.println("Password :"+password);   
//	           pw.close();
		               
		                try {
		                    Class.forName("com.mysql.jdbc.Driver");
		                } catch (ClassNotFoundException e) {
		                    e.printStackTrace();
		                    response.getWriter().write("Database driver not found.");
		                    return; // Exit the method if driver is not found
		                }
		        

		        try {
		        	
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodmanagement", "root", "student");
		            String query = "INSERT INTO donorregistration (fullname, bloodGroup, mobileNumber, state, district, email, username, password) " +
		                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		            PreparedStatement pstmt = conn.prepareStatement(query);
		            pstmt.setString(1, fullname);
		            pstmt.setString(2, bloodGroup);
		            pstmt.setString(3, mobileNumber);
		            pstmt.setString(4, state);
		            pstmt.setString(5, district);
		            pstmt.setString(6, email);
		            pstmt.setString(7, username);
		            pstmt.setString(8, password);
		            int rowsInserted = pstmt.executeUpdate();
		            if (rowsInserted > 0) {
		                System.out.println("Data inserted successfully.");
		                RequestDispatcher rd=request.getRequestDispatcher("confirmation.html");
		                rd.include(request, response);
		            } else {
		                System.out.println("Data insertion failed.");
		            }
		            pstmt.close();
		            conn.close();

		            response.getWriter().write("success");
		        } catch (SQLException e) {
		            e.printStackTrace();
		            response.getWriter().write("Database error: " + e.getMessage());

		        }
		    }

	}




