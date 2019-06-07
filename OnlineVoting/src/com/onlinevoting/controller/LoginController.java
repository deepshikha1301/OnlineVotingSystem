package com.onlinevoting.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String voterID = request.getParameter("voterID").toString(); 
		String password = request.getParameter("pass").toString();
		try {
		if(voterID.equals("deepshikha")&& password.equals("1234")) {
			RequestDispatcher rd = request.getRequestDispatcher("/Profile.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.include(request, response);
		}
		
	 }catch(ServletException e) {
		 System.out.println("blabla" + e);
	 }
	}

}
