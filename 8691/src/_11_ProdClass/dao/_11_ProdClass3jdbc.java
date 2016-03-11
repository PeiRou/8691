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

public class _11_ProdClass3jdbc {	
	private DataSource dataSource;
	
	public _11_ProdClass3jdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private final String SELECT_BY_ID = "select * from Prod_status_class3 where Prod_status_class3_ID=?";
	public List select(String ProdStatusClass3ID) {
		List JSONObjectList = null;
		ResultSet rset = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);
			) {
			stmt.setString(1, ProdStatusClass3ID);
			rset = stmt.executeQuery();
		
			JSONObjectList = new LinkedList();
			while(rset.next()) {
				JSONObject obj = new JSONObject();
				obj.put("ProdStatusClass3ID", rset.getString("Prod_status_class3_ID"));
				obj.put("ProdStatusClass2ID", rset.getString("Prod_status_class2_ID"));
				obj.put("ProdStatusClass3Name", rset.getString("Prod_status_class3_name"));
				obj.put("ProdStatusClass3Price", rset.getString("Prod_status_class3_price"));
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
	
	private final String SELECT_BY_C2_ID = "select * from Prod_status_class3 where Prod_status_class2_ID=?";
	public List selectC2(String ProdStatusClass2ID) {
		List JSONObjectList = null;
		ResultSet rset = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_C2_ID);
			) {
			stmt.setString(1, ProdStatusClass2ID);
			rset = stmt.executeQuery();
		
			JSONObjectList = new LinkedList();
			while(rset.next()) {
				JSONObject obj = new JSONObject();
				obj.put("ProdStatusClass3ID", rset.getString("Prod_status_class3_ID"));
				obj.put("ProdStatusClass3Name", rset.getString("Prod_status_class3_name"));
				obj.put("ProdStatusClass3Price", rset.getString("Prod_status_class3_price"));
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
