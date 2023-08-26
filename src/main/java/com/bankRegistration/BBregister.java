package com.bankRegistration;

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

//import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class BBregister
 */
@WebServlet("/BBregister")
public class BBregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBregister() {
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

        String BloodBankName = request.getParameter("bloodBankName");
        String Address = request.getParameter("address");
        String ContactNumber = request.getParameter("contactNumber");
        String EmailAddress = request.getParameter("email");
        String WebsiteUrl = request.getParameter("website");
        String ContactPersonName = request.getParameter("contactName");
        String LicenseNumber = request.getParameter("licenseNumber");
        String LValidity = request.getParameter("licenseValidityFrom");
        String LValidityEnd = request.getParameter("licenseValidityTo");
        String LicenseAuthority = request.getParameter("issuingAuthority");
        String State = request.getParameter("state");
        String District = request.getParameter("district");
        String City = request.getParameter("city");
        String PostalAddress = request.getParameter("postalAddress");
        String NoBed = request.getParameter("bedsAvailable");
        String ApheresisFa = request.getParameter("apheresisFacility");
        String helplineNu = request.getParameter("helplineNumber");
        String AdditionalInf = request.getParameter("additionalInfo");
        String DonorType = request.getParameter("donorType");
        String DonationType = request.getParameter("donationType");
        String BagType = request.getParameter("bagType");
        String Remarks = request.getParameter("remarks");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date validityDate=null;
        java.util.Date validityEndDate=null;
		try {
			validityDate = dateFormat.parse(LValidity);
			validityEndDate = dateFormat.parse(LValidityEnd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       

        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().write("Database driver not found.");
            return; // Exit the method if driver is not found
        }


try {
	
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodmanagement", "root", "student");
    String query = "INSERT INTO bloodbankregistration (BloodBankName, Address,ContactNumber,EmailAddress, WebsiteUrl, ContactPersonName, LicenseNumber, LValidity, LValidityEnd,LicenseAuthority,"
    		+ "State,District,City,PostalAddress,NoBed,ApheresisFa,helplineNu,AdditionalInf,DonorType,DonationType,BagType,Remarks) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    PreparedStatement pstmt = conn.prepareStatement(query);
    pstmt.setString(1, BloodBankName);
    pstmt.setString(2, Address);
    pstmt.setString(3, ContactNumber);
    pstmt.setString(4, EmailAddress);
    pstmt.setString(5, WebsiteUrl);
    pstmt.setString(6, ContactPersonName);
    pstmt.setString(7, LicenseNumber);
    pstmt.setDate(9, new java.sql.Date(validityDate.getTime()));
    pstmt.setDate(10, new java.sql.Date(validityEndDate.getTime()));
    pstmt.setString(8, LValidity);
    pstmt.setString(9, LValidityEnd);
    pstmt.setString(10, LicenseAuthority);
    pstmt.setString(11, State);
    pstmt.setString(12, District);
    pstmt.setString(13, City);
    pstmt.setString(14, PostalAddress);
    pstmt.setString(15, NoBed);
    pstmt.setString(16, ApheresisFa);
    pstmt.setString(17, helplineNu);
    pstmt.setString(18, AdditionalInf);
    pstmt.setString(19, DonorType);
    pstmt.setString(20, DonationType);
    pstmt.setString(21, BagType);
    pstmt.setString(22, Remarks);
  
   
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
