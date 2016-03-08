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

public class _11_GroupClass3jdbc {	
	private _11_FoodClassjdbc foodClassjdbc = new _11_FoodClassjdbc();
	private DataSource dataSource;
	
	public _11_GroupClass3jdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private final String SELECT_BY_UID = "select * from Group_class3 where Account_UID=?";
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
				obj.put("GroupClass3ID", rset.getString("Group_class3_ID"));
				obj.put("ProdStatusClass1ID", rset.getString("Prod_status_class1_ID"));
				obj.put("GroupClass3Name", rset.getString("Group_class3_name"));
				List FoodStatusList = foodClassjdbc.select(rset.getString("Group_class3_ID"));
				if (FoodStatusList != null) {
					obj.put("FoodStatus", FoodStatusList);
				}else{
					obj.put("FoodStatus", "");
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
