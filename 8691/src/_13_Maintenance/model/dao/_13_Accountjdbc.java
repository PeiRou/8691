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

public class _13_Accountjdbc {	
	private DataSource dataSource;
	
	public _13_Accountjdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private final String SELECT_ALL = "select * from seller_visitor s join account a on s.account_UID =  a.account_UID join Address_CT ct on s.GUAR_CT=ct.GUAR_CT join Address_AR ar on s.GUAR_AR = ar.GUAR_AR join Address_ROAD road on road.GUAR_ROAD= s.GUAR_ROAD";
	    public List select() {
		List JSONObjectList = null;
		ResultSet rset = null;
		Connection conn = null;
		PreparedStatement stmt =null;
		try{
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();
		
			JSONObjectList = new LinkedList();
			while(rset.next()) {
				JSONObject obj = new JSONObject();
				obj.put("accountUID", rset.getString("account_UID"));
				obj.put("fein", rset.getString("FEIN"));
				obj.put("name", rset.getString("name"));
				obj.put("sellerPhoto", rset.getString("Seller_photo"));
				obj.put("tel", rset.getString("tel"));
				obj.put("guarCT", rset.getString("GUAR_CT_name"));
				obj.put("guarAR", rset.getString("GUAR_AR_name"));
				obj.put("guarROAD", rset.getString("GUAR_ROAD_name"));
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
			if(stmt !=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn !=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return JSONObjectList;
	}
}
