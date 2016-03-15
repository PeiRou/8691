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

import org.json.JSONException;
import org.json.JSONObject;

public class _11_Foodjdbc {
	private _11_FoodPricejdbc foodPricejdbc = new _11_FoodPricejdbc();
	DataSource dataSource = null;

	public _11_Foodjdbc() {
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
		ResultSet rset = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_UID);) {
			stmt.setString(1, accountUID);
			rset = stmt.executeQuery();

			JSONObjectList = new LinkedList();
			while (rset.next()) {
				JSONObject obj = new JSONObject();
				obj.put("AccountUID", rset.getString("Account_UID"));
				obj.put("FoodID", rset.getString("Food_ID"));
				obj.put("FoodName", rset.getString("Food_name"));
				if (rset.getString("Food_photo") != null) {
					obj.put("FoodPhoto", rset.getString("Food_photo"));
				} else {
					obj.put("FoodPhoto", "");
				}
				obj.put("GroupClass3ID", rset.getString("Group_class3_ID"));
				List FoodPriceList = foodPricejdbc.select(rset.getString("Food_ID"));
				if (FoodPriceList != null) {
					obj.put("FoodPrice", FoodPriceList);
				} else {
					obj.put("FoodPrice", "");
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

	private final String UPDATE = "update Food set Food_name=? where Food_ID=?";

	public int update(JSONObject JsonData) throws JSONException {
		try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			if (JsonData.getString("FoodID") != "") {
				stmt.setString(1, JsonData.getString("FoodName"));
				stmt.setString(2, JsonData.getString("FoodID"));
				int i = stmt.executeUpdate();
				if (i == 1) {
					return i;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private final String INSERT = "insert into Food values (?,?,?,?)";

	public int insert(JSONObject JsonData) throws JSONException {
		ResultSet rs = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);) {
			if (JsonData.getString("AccountUID") != "" && JsonData.getString("GroupClass3ID") != "") {
				System.out.println("InsJsonData: " + JsonData);
				stmt.setString(1, JsonData.getString("AccountUID"));
				stmt.setString(2, JsonData.getString("FoodName"));
				stmt.setString(3, JsonData.getString("FoodPhoto"));
				stmt.setString(4, JsonData.getString("GroupClass3ID"));
				stmt.executeUpdate();
				rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					System.out.println(rs.getInt(1));
					return rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
