package _07_GetAddress;

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
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;




import org.jdom2.Attribute;
import org.jdom2.Comment;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


@WebServlet("/GetAddress")
public class GetAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataSource ds = null;
	
	public GetAddress() {
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
				
				String query = "select GUAR_AR, GUAR_AR_name from Address_AR";
				
				try{
					conn = ds.getConnection();
					stmt = conn.prepareStatement(query);
					Document document = new Document();
					rs = stmt.executeQuery();
					//table全部資料
		               Element root = new Element("Address_AR");
		               document.addContent(root);
		               while (rs.next())
						 {//另存一個新的table 內容只有前端需要的資料
		            	   Element e = new Element("Category");
		            	   root.addContent(e);
		            	   
		            	   e.addContent(new Element("GUAR_AR")
		                           .setText(rs.getString(1)));
		            	   e.addContent(new Element("GUAR_AR_name")
		            			   .setText(rs.getString(2)));
		            	   
						 }
		               
		            
		               Format format = Format.getPrettyFormat();		              
		               format.setIndent("    ");
		               
		               XMLOutputter xml = new XMLOutputter();
		               out.write(xml.outputString(document));
					
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
