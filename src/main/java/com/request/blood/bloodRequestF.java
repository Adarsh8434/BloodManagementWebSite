package com.request.blood;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bloodRequestF
 */
@WebServlet("/bloodRequestF")
public class bloodRequestF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bloodRequestF() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name = request.getParameter("name");
        String Email = request.getParameter("email");
        String MobileNo = request.getParameter("mobile");
        String NoOfUn = request.getParameter("units");
        String Date = request.getParameter("date");
        String State = request.getParameter("state");
        String District = request.getParameter("district");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date validityDate=null;
       
		try {
			validityDate = dateFormat.parse(Date);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       

        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().write("Database driver not found.");
            return;         }


try {
	
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodmanagement", "root", "student");
    String query = "INSERT INTO bloodrequest (Name, Email,MobileNo,NoOfUn,Date, State, District) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    PreparedStatement pstmt = conn.prepareStatement(query);
    pstmt.setString(1, Name);
    pstmt.setString(2, Email);
    pstmt.setString(3, MobileNo);
    pstmt.setString(4, NoOfUn);
    pstmt.setDate(5, new java.sql.Date(validityDate.getTime()));
    pstmt.setString(6, State);
    pstmt.setString(7, District);
  
   
    
  
  
   
    int rowsInserted = pstmt.executeUpdate();
    if (rowsInserted > 0) {
        System.out.println("Data inserted successfully.");

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
