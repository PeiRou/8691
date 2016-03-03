package _11_ProdClass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.json.simple.JSONObject;

public class _11_FoodClassjdbc {
	private DataSource dataSource;
	private _11_ProdClassjdbc prodClassjdbc = new _11_ProdClassjdbc();

	public _11_FoodClassjdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private final String SELECT_BY_UID = "select * from Food_status_class3 where Group_class3_ID=?";

	public List select(String GroupClass3ID) {
		System.out.println("haha123");
		List JSONObjectList = null;
		ResultSet rset = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_UID);) {
			stmt.setString(1, GroupClass3ID);
			rset = stmt.executeQuery();

			JSONObjectList = new LinkedList();
			while (rset.next()) {
				JSONObject obj = new JSONObject();
				obj.put("GroupClass3ID", rset.getString("Group_class3_ID"));
				obj.put("ProdStatusClass3ID",rset.getString("Prod_status_class3_ID"));

				List ProdStatusList = prodClassjdbc.select(rset.getString("Prod_status_class3_ID"));
				if (ProdStatusList != null) {
					System.out.println("ProdStatusList:" + ProdStatusList);
					obj.put("ProdStatus", ProdStatusList);
				}
				JSONObjectList.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return JSONObjectList;
	}
}
