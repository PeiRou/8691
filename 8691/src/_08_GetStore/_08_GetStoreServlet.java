package _08_GetStore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.simple.JSONObject;
@WebServlet(
		urlPatterns={"/_08_GetStore/Store.controller"}
		)
public class _08_GetStoreServlet extends HttpServlet {

	private final String SELECT_ALL = "select * from Seller_visitor";
	private DataSource dataSource;
	public _08_GetStoreServlet() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public List select() {
		List JSONObjectList = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = stmt.executeQuery();) {

			JSONObjectList = new LinkedList();
			while(rset.next()) {
				JSONObject obj = new JSONObject();
				obj.put("Name", rset.getString("name"));
				obj.put("SellerPhoto", rset.getBytes("Seller_photo"));
				obj.put("ShipPrice", rset.getInt("ship_price"));
				obj.put("LowestPrice", rset.getInt("lowest_price"));
				obj.put("AccountUID", rset.getString("Account_UID"));
				JSONObjectList.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSONObjectList;
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List result = select();
		request.setAttribute("select", result);
		request.setAttribute("StoresCount", result.size());
		request.getRequestDispatcher(
				"/_08_Products/Products.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}
	

}
