package com.onlinevoting.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Properties;
/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String host, port, email, password;
	
	public void init() {
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		email = context.getInitParameter("email");
		password = context.getInitParameter("password");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String recipientEmail = request.getParameter("email");
		String subject = "Your password has been reset";
		String randomPwd = RandomStringUtils.randomAlphanumeric(10);
		String mailBody = "Your password is" +" "+ randomPwd+" "+ "Please do not share your password.";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", port);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getInstance(prop, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
				
			}
		});
		
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(email));
			InternetAddress[] toAddress = {new InternetAddress(recipientEmail)};
			msg.setRecipients(Message.RecipientType.TO, toAddress);
			msg.setSubject(subject);
			msg.setText(mailBody);
			Transport.send(msg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.println("A new password has been sent to your email address");
	}

}
