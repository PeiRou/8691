package _08_GetStore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import _11_ProdClass.dao._11_GroupClass3jdbc;
import _11_ProdClass.dao._11_Imagejdbc;

@WebServlet(urlPatterns = { "/_08_GetStore/Store.controller" })
public class _08_GetStoreServlet extends HttpServlet {
	private _11_GroupClass3jdbc groupClass3jdbc = new _11_GroupClass3jdbc();
	private _11_Imagejdbc imagejdbc = new _11_Imagejdbc();

	private DataSource dataSource;

	public _08_GetStoreServlet() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private final String SELECT_ALL = "select DISTINCT a.Account_UID,a.name,a.Seller_photo,a.ship_price,a.lowest_price,a.Seller_photo,(CASE WHEN b.Group_class3_ID IS NULL THEN '' ELSE '1' END) as 'Group_class3_ID' from Seller_visitor a left join Group_class3 b on a.Account_UID = b.Account_UID join account c on a.Account_UID = c.Account_UID where c.role_ID <> '1111' order by Group_class3_ID desc";

	public List select() {
		List JSONObjectList = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();) {

			JSONObjectList = new LinkedList();
			while (rset.next()) {
				JSONObject obj = new JSONObject();
				obj.put("Name", rset.getString("name"));
				obj.put("SellerPhoto", rset.getBytes("Seller_photo"));
				obj.put("ShipPrice", rset.getInt("ship_price"));
				obj.put("LowestPrice", rset.getInt("lowest_price"));
				obj.put("AccountUID", rset.getString("Account_UID"));
				obj.put("sellerPhoto", rset.getString("Seller_photo"));

				List ImagejdbcList = imagejdbc.select(rset.getString("Seller_photo"));
				if (ImagejdbcList != null) {
					obj.put("imageStatus", ImagejdbcList);
				} else {
					obj.put("imageStatus", "");
				}

				List GroupClass3List = groupClass3jdbc.selectGp(rset.getString("Account_UID"));
				if (GroupClass3List != null) {
					obj.put("GroupClass3", GroupClass3List);
				} else {
					obj.put("GroupClass3", "");
				}
				JSONObjectList.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSONObjectList;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orderby = request.getParameter("orderby");

		System.out.println("orderby:" + orderby);

		List result = select();
		System.out.println("getstoreRs:" + result);
		request.setAttribute("select", result);
		request.getRequestDispatcher("/_08_Products/Products.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.doGet(req, resp);
	}

}
