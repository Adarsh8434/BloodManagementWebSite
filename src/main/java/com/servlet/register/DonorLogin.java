package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankRegistration.HttpSession;

/**
 * Servlet implementation class DonorLogin
 */
@WebServlet("/DonorLogin")
public class DonorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorLogin() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		if (Donor_LoginPage.validate(username, password)) {
		    // Successful login, redirect to the donor dashboard or any other page
			//HttpSession session = request.getSession();
         //   session.setAttribute("username", username);
			response.sendRedirect("donor_dashboard.html");
		} else {
		    // Incorrect login, show an error message and stay on the same login page
		    out.print("Sorry username and password mismatch");
		   
		    RequestDispatcher rd = request.getRequestDispatcher("donor_login.html");
		    rd.include(request, response);
		}

	}

}
