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

import org.json.JSONException;
import org.json.JSONObject;

public class _11_Foodjdbc {
	private _11_FoodClassjdbc foodClassjdbc = new _11_FoodClassjdbc();
	DataSource dataSource = null;
	public _11_Foodjdbc(){
	try {
		Context context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:comp/env/8691");
	} catch (NamingException e) {
		e.printStackTrace();
	 }
	}
	
	private final String SELECT_BY_UID = "select * from Food where Account_UID=?";
	public List select(String accountUID) throws JSONException {
		List JSONObjectList = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_UID);
			) {
			stmt.setString(1, accountUID);
			ResultSet rset = stmt.executeQuery();
		
			JSONObjectList = new LinkedList();
			while(rset.next()) {
				JSONObject obj = new JSONObject();
				obj.put("FoodID", rset.getString("Food_ID"));
				obj.put("AccountUID", rset.getString("Account_UID"));
				obj.put("ProdStatusClass1ID", rset.getInt("Prod_status_class1_ID"));
				obj.put("FoodName", rset.getString("Food_name"));
				if (rset.getString("Food_photo")!=null){
					obj.put("FoodPhoto", rset.getString("Food_photo"));
				}else
				{
					obj.put("FoodPhoto", "");
				}
				System.out.println("Food_photo:"+rset.getString("Food_photo"));
				List FoodStatusList = foodClassjdbc.select(rset.getString("Food_ID"));
				if (FoodStatusList!=null){
					obj.put("FoodStatus", FoodStatusList);
				}
					
				JSONObjectList.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSONObjectList;
	}
}
