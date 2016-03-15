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
import org.json.simple.JSONValue;

@WebServlet("/GetSeller")
public class GetSeller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataSource ds = null;

	public GetSeller() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("hahah");
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// String url = "jdbc:sqlserver://localhost:1433;DatabaseName=DB02";

		String query = "select Account_UID, name from Seller_visitor";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(query);
			Document document = new Document();
			rs = stmt.executeQuery();

			List l1 = new LinkedList();
			while (rs.next()) {
				Map m1 = new HashMap();
				m1.put("Account_UID", rs.getString(1));
				m1.put("name", rs.getString(2));
				l1.add(m1);
			}
			String jsonString = JSONValue.toJSONString(l1);
			out.println(jsonString);

		} catch (SQLException e) {
			out.println("Error:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
