package com.User.Registration;

import java.io.IOException;
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
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
        String fullname = request.getParameter("fullName");
        String mobileNumber = request.getParameter("mobileNumber");
        String state = request.getParameter("state");
        String district = request.getParameter("district");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
	               
	                try {
	                    Class.forName("com.mysql.jdbc.Driver");
	                } catch (ClassNotFoundException e) {
	                    e.printStackTrace();
	                    response.getWriter().write("Database driver not found.");
	                    return; // Exit the method if driver is not found
	                }
	        

	        try {
	        	
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodmanagement", "root", "student");
	            String query = "INSERT INTO userregistration (fullname, mobileNumber, state, district, email, username, password) " +
	                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

	            PreparedStatement pstmt = conn.prepareStatement(query);
	            pstmt.setString(1, fullname);
	            pstmt.setString(2, mobileNumber);
	            pstmt.setString(3, state);
	            pstmt.setString(4, district);
	            pstmt.setString(5, email);
	            pstmt.setString(6, username);
	            pstmt.setString(7, password);
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
