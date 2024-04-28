package com.tuto.testdb;

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
 * Servlet implementation class TestdbServlet
 */
//http://localhost:8080/WebHibernateGestions/TestdbServlet
@WebServlet("/TestdbServlet")
public class TestdbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Configuration de la connexion
				String user = "root";
				String pass = "";
				
				//A partir de Mysql8
				String jdbcUrl = "jdbc:mysql://localhost:3306/gestion_client_hibernate?useSSL=false&serverTimezone=UTC";
				String driver = "com.mysql.cj.jdbc.Driver";
				
				//Version antérieur à mysql 8
				//String jdbcUrl = "jdbc:mysql://localhost:3306/gestion_client_hibernate?useSSL=false";
				//String driver = "com.mysql.jdbc.Driver";
				
				
				//connection BDD
				
				try {
					
					PrintWriter out = response.getWriter();
					Class.forName(driver);
					
					out.println("Connection à la BDD:" + jdbcUrl);
					
					Connection myconn = DriverManager.getConnection(jdbcUrl, user, pass);
					
					out.println("Bravo!!!");
					myconn.close();
					
						
					} catch (Exception exec) {
						exec.printStackTrace();
						throw new ServletException(exec);
					  }
	}

}
