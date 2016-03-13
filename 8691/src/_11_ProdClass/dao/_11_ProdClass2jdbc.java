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

public class _11_ProdClass2jdbc {	
	private _11_ProdClass3jdbc prodClass3jdbc = new _11_ProdClass3jdbc();
	private DataSource dataSource;
	
	public _11_ProdClass2jdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private final String SELECT_ALL = "select * from Prod_status_class2";
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
				obj.put("ProdStatusClass2ID", rset.getString("Prod_status_class2_ID"));
				obj.put("ProdStatusClass1ID", rset.getString("Prod_status_class1_ID"));
				obj.put("ProdStatusClass2Name", rset.getString("Prod_status_class2_name"));
				JSONObjectList.add(obj);
			}
			return JSONObjectList;
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
		return null;
	}
	private final String SELECT_BY_C1_ID = "select * from Prod_status_class2 where Prod_status_class1_ID = ?";
	public List selectC1(String ProdStatusClass1ID) {
		List JSONObjectList = null;
		ResultSet rset = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_C1_ID);
			) {
			stmt.setString(1, ProdStatusClass1ID);
			rset = stmt.executeQuery();
		
			JSONObjectList = new LinkedList();
			while (rset.next()) {
					JSONObject obj = new JSONObject();
					obj.put("ProdStatusClass2ID", rset.getString("Prod_status_class2_ID"));
					obj.put("ProdStatusClass2Name", rset.getString("Prod_status_class2_name"));
					List Class3List = prodClass3jdbc.selectC2(rset.getString("Prod_status_class2_ID"));
					if (Class3List != null) {
						obj.put("Class3Status", Class3List);
					} else {
						obj.put("Class3Status", "");
					}
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
