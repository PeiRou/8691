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
	
	private final String SELECT_ALL = "select b.name ,b.IS_check,b.Seller_status,b.insdate,a.account_UID from Account a join Seller_visitor b on a.account_UID = b.account_UID where a.role_ID = '101'";
	public List select() {
		List JSONObjectList = null;
		ResultSet rset = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			) {
			rset = stmt.executeQuery();
		
			JSONObjectList = new LinkedList();
			while(rset.next()) {
				JSONObject obj = new JSONObject();
				obj.put("name", rset.getString("name"));
				obj.put("isCheck", rset.getString("IS_check"));
				obj.put("sellerSstatus", rset.getString("Seller_status"));
				obj.put("insdate", rset.getString("insdate"));
				obj.put("accountUID", rset.getString("account_UID"));
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
