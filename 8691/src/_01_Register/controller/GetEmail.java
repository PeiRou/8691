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
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=DB02";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "sa123456";
	
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

		String query = "select acc_email from Account where acc_email = ?";
		String acc_email = request.getParameter("acc_email");
		
		try{
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1,acc_email);
			rs = stmt.executeQuery();
			
			 List  l1 = new LinkedList();
			 while (rs.next()) {
				 Map m1 = new HashMap();       
		 		 m1.put("comment",rs.getString(1));
		 		 m1.put("name", rs.getString(2));
		 		 m1.put("insdate",rs.getString(3));
				 l1.add(m1);
			 }
			 String jsonString = JSONValue.toJSONString(l1);                    
			 out.println(jsonString);
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
