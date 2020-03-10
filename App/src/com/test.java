package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public test() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// setup variables for connection
		String jdbcurl ="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		
		String user="springstudent";
		
		String pass ="springstudent";
		
		String driver="com.mysql.jdbc.Driver";
		
		
		// get a database connection
		
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to database:" +jdbcurl);
			
			Class.forName(driver);
			
			Connection con= DriverManager.getConnection(jdbcurl, user, pass);
			
			out.print("Sucess !!");
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
	}

}
