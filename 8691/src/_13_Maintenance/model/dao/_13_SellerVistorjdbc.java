package _13_Maintenance.model.dao;

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

public class _13_SellerVistorjdbc {	
	private DataSource dataSource;
	
	public _13_SellerVistorjdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private final String SELECT_BY_UID = "select * from Seller_visitor where account_UID =?";
	public List select(String accountUID) {
		List JSONObjectList = null;
		ResultSet rset = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_UID);
			) {
			stmt.setString(1, accountUID);
			rset = stmt.executeQuery();
		
			JSONObjectList = new LinkedList();
			while(rset.next()) {
				JSONObject obj = new JSONObject();
				obj.put("fein", rset.getString("FEIN"));
				obj.put("name", rset.getString("name"));
				obj.put("sellerPhoto", rset.getString("Seller_photo"));
				obj.put("tel", rset.getString("tel"));
				obj.put("guarCT", rset.getString("GUAR_CT"));
				obj.put("guarAR", rset.getString("GUAR_AR"));
				obj.put("guarROAD", rset.getString("GUAR_ROAD"));
				obj.put("guarNO", rset.getString("GUAR_NO"));
				obj.put("email2", rset.getString("email2"));
				obj.put("conName", rset.getString("Con_name"));
				obj.put("conCel", rset.getString("Con_cel"));
				obj.put("receiptsMetho", rset.getString("receipts_metho"));
				obj.put("sellerStatus", rset.getString("Seller_status"));
				obj.put("shipPrice", rset.getString("ship_price"));
				obj.put("lowestPrice", rset.getString("lowest_price"));
				obj.put("insdate", rset.getString("insdate"));
				JSONObjectList.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
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
