package _01_Register.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.simple.JSONValue;

@WebServlet("/GetEmail")
public class GetEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int M1 = 1;
	int M2 = 2;
	
	DataSource datasource = null;
	public GetEmail() {
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;		

		String query = "select * from Account where acc_email = ?";
		String acc_email = request.getParameter("acc_email");
		
		try{
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1,acc_email);
			rs = stmt.executeQuery();
			
			 if (rs.next()) {
				 String jsonString = JSONValue.toJSONString(M1);                    
				 out.println(jsonString);      
			 }else{
				 String jsonString = JSONValue.toJSONString(M2);                    
				 out.println(jsonString);
			 }
			 
		}
		catch(SQLException e){
			out.println("Error:" + e.getMessage());
		}
		finally{
			if(rs != null){
			   try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(stmt != null){
			 try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(conn != null){
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
