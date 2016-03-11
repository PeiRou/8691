package _05_Forum.controller;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;




import org.jdom2.Attribute;
import org.jdom2.Comment;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.json.JSONObject;
import org.json.simple.JSONValue;


@WebServlet("/GetDataTable")
public class GetDataTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataSource ds = null;
	
	public GetDataTable() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("hahah");		
		response.setContentType("text/xml;charset=UTF-8");
				PrintWriter out = response.getWriter();
					
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;
				
				//String url = "jdbc:sqlserver://localhost:1433;DatabaseName=DB02";
				
				String query = "select Seller_visitor.name, comment, rating from Forum join Seller_visitor on Forum.seller_UID = Seller_visitor.Account_UID ";
				
				try{
					conn = ds.getConnection();
					stmt = conn.prepareStatement(query);
					Document document = new Document();
					rs = stmt.executeQuery();
					
					List  l1 = new LinkedList();
					 while (rs.next()) {
						 Map m1 = new HashMap();       
				 		 m1.put("name",rs.getString(1));
				 		 m1.put("comment", rs.getString(2));
				 		 m1.put("rating", rs.getString(3));
						 l1.add(m1);
					 }
					 JSONObject jsonObj = new JSONObject();
					 jsonObj.put("data", l1);
					 String jsonString = JSONValue.toJSONString(jsonObj);                    
					 response.setHeader("Cache-control", "no-cache, no-store");
					 response.setCharacterEncoding("UTF-8");
					 response.setContentType("text/html");
					 response.getWriter().write(jsonString);
					
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
