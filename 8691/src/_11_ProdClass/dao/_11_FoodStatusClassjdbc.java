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

import org.json.JSONObject;

public class _11_FoodStatusClassjdbc {
	private _11_ProdClass3jdbc prodClassjdbc = new _11_ProdClass3jdbc();
	private DataSource dataSource;

	public _11_FoodStatusClassjdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private final String SELECT_BY_UID = "select * from Food_status_class3 where Group_class3_ID=?";

	public List select(String GroupClass3ID) {
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
					obj.put("ProdStatus", ProdStatusList);
				}
				else
				{
					obj.put("ProdStatus", "");
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
	
	private final String DELETE = "delete from Food_status_class3 where Group_class3_ID = ?";
	public int delete(String GroupClass3ID){
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {				
				if(GroupClass3ID != "") {
					stmt.setString(1,GroupClass3ID);
					int i = stmt.executeUpdate();
					if(i == 1) {
						return i;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}
	
	private final String INSERT = "insert into Food_status_class3(Group_class3_ID,Prod_status_class3_ID) values(?,?)";
	public int insert(JSONObject JsonData){
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);) {				
				if(JsonData.getString("GroupClass3ID") != ""&&JsonData.getString("ProdStatusClass3ID") != "") {
					stmt.setString(1,JsonData.getString("GroupClass3ID"));
					stmt.setString(2,JsonData.getString("ProdStatusClass3ID"));
					stmt.executeUpdate();
					ResultSet rs = stmt.getGeneratedKeys();
				    if(rs.next()){
				    	return rs.getInt(1);
				    }
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}
}
