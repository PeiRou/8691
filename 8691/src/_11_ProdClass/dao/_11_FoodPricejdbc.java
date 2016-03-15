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

public class _11_FoodPricejdbc {
	private _11_SizeStatusjdbc sizeStatusjdbc = new _11_SizeStatusjdbc();
	private DataSource dataSource;

	public _11_FoodPricejdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private final String SELECT_BY_ID = "select * from Food_size_price where Food_ID=?";

	public List select(String FoodID) {
		List JSONObjectList = null;
		ResultSet rset = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {
			stmt.setString(1, FoodID);
			rset = stmt.executeQuery();

			JSONObjectList = new LinkedList();
			while (rset.next()) {
				JSONObject obj = new JSONObject();
				obj.put("FoodSizePriceID", rset.getString("Food_size_price_ID"));
				obj.put("FoodID", rset.getString("Food_ID"));
				obj.put("SizeStatusID", rset.getString("Size_status_ID"));
				obj.put("FoodStatusPrice", rset.getString("Food_status_price"));
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

	private final String SELECT_BY_SZPZ_ID = "select Food_status_price from Food_size_price where Food_size_price_ID=?";

	public String select_SZPZ(String FoodSizePriceID) {
		String result = null;
		ResultSet rset = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_SZPZ_ID);) {
			stmt.setString(1, FoodSizePriceID);
			rset = stmt.executeQuery();

			while (rset.next()) {
				result = rset.getString("Food_status_price");
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
		return result;
	}

	private final String UPDATE = "update Food_size_price set Size_status_ID=?,Food_status_price=? where Food_size_price_ID=?";

	public int update(JSONObject JsonData) {
		try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			if (JsonData.getString("FoodSizePriceID") != "") {
				stmt.setString(1, JsonData.getString("SizeStatusID"));
				stmt.setString(2, JsonData.getString("FoodStatusPrice"));
				stmt.setString(3, JsonData.getString("FoodSizePriceID"));
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

	private final String INSERT = "insert into Food_size_price(Food_ID,Size_status_ID,Food_status_price) values(?,?,?)";

	public int insert(JSONObject JsonData) {
		ResultSet rs = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);) {
			if (JsonData.getString("FoodID") != "") {
				stmt.setString(1, JsonData.getString("FoodID"));
				stmt.setString(2, JsonData.getString("SizeStatusID"));
				stmt.setString(3, JsonData.getString("FoodStatusPrice"));
				stmt.executeUpdate();
				rs = stmt.getGeneratedKeys();
				if (rs.next()) {
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
}
