package com.bankRegistration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.servlet.register.Donor_LoginPage;

/**
 * Servlet implementation class BBLogin
 */
@WebServlet("/BBLogin")
public class BBLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String BloodBankName=request.getParameter("BloodBankName");
		String LicenseNumber=request.getParameter("LicenseNumber");
		
		
		if(BBLoginPage.validate(BloodBankName, LicenseNumber)) {
			//RequestDispatcher rd=request.getRequestDispatcher("blood bank dashboard.html");
			HttpSession session = request.getSession();
            session.setAttribute("BloodBankName", BloodBankName);
			response.sendRedirect("blood bank dashboard.html");
		}else {
			out.print("Sorry username and password mismatch");
			RequestDispatcher rd=request.getRequestDispatcher("blood_bank_login.html");
            rd.include(request, response);
		}
	}

}
