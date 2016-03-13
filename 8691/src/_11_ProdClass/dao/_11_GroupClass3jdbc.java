package _11_ProdClass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.json.simple.JSONObject;

public class _11_GroupClass3jdbc {	
	private _11_FoodStatusClassjdbc foodStatusClassjdbc = new _11_FoodStatusClassjdbc();
	private _11_ProdClass2jdbc prodClass2jdbc = new _11_ProdClass2jdbc();
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
	public List selectGpFoodStatus(String accountUID) {
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
				List FoodStatusList = foodStatusClassjdbc.select(rset.getString("Group_class3_ID"));
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
	
	private final String SELECT_ClASS1 = "select DISTINCT b.Prod_status_class1_name from Group_class3 a join Prod_status_class1 b on a.Prod_status_class1_ID = b.Prod_status_class1_ID where Account_UID =?";
	public List selectGp(String accountUID) {
		List JSONObjectList = null;
		ResultSet rset = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ClASS1);
			) {
			stmt.setString(1, accountUID);
			rset = stmt.executeQuery();
		
			JSONObjectList = new LinkedList();
			while(rset.next()) {
				JSONObject obj = new JSONObject();				
				obj.put("ProdStatusClass1Name", rset.getString("Prod_status_class1_name"));				
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
	
	private final String SELECT_ALL_ClASS1 = "select distinct Prod_status_class1_ID from Group_class3 where Account_UID =?";
	public List selectGpC1(String accountUID) {
		List JSONObjectList = null;
		ResultSet rset = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_ClASS1);
			) {
			stmt.setString(1, accountUID);
			rset = stmt.executeQuery();
		
			JSONObjectList = new LinkedList();
			while(rset.next()) {
				JSONObject obj = new JSONObject();				
				obj.put("ProdStatusClass1ID", rset.getString("Prod_status_class1_ID"));	
				List Class2statusList = prodClass2jdbc.selectC1(rset.getString("Prod_status_class1_ID"));
				if (Class2statusList != null) {
					obj.put("Class2Status", Class2statusList);
				}else{
					obj.put("Class2Status", "");
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
	
	private final String INSERT = "insert into Group_class3 values(?,?,?)";
	public int insert(String accountUID,String prodStatusClass1ID,String groupClass3Name) {
		List JSONObjectList = null;
		ResultSet rs = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			) {
			stmt.setString(1, accountUID);
			stmt.setString(2, prodStatusClass1ID);
			stmt.setString(3, groupClass3Name);
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
		    if(rs.next()){
		    	System.out.println(rs.getInt(1));
		    	return rs.getInt(1);
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
}
