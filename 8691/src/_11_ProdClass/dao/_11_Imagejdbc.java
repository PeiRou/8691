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

public class _11_Imagejdbc {	
	private DataSource dataSource;
	
	public _11_Imagejdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private final String SELECT_BY_ID = "select * from Image where Image_ID=?";
	public List select(String imageID) {
		List JSONObjectList = null;
		ResultSet rset = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);
			) {
			stmt.setString(1, imageID);
			rset = stmt.executeQuery();
		
			JSONObjectList = new LinkedList();
			while(rset.next()) {
				JSONObject obj = new JSONObject();
				obj.put("ImageName", rset.getString("Image_Name"));
				obj.put("ImageURL", rset.getString("Image_URL"));
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
	
	private final String SELECT_NOW_ID = "select max(Image_ID)+1 from Image";
	public String selectNowID() {
		String result = null;
		ResultSet rs = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_NOW_ID);
			) {			
			rs = stmt.executeQuery();
			if (rs.next()) {
				result = rs.getString(1);
				return result;
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
		return null;
	}
	
	private final String INSERT = "insert into Image values(?,?)";
	public int insert(String Image_Name,String Image_URL) {
		List JSONObjectList = null;
		ResultSet rs = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			) {
			stmt.setString(1, Image_Name);
			stmt.setString(2, Image_URL);
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
	
	private final String UPDATE = "update Image set Image_Name =?,Image_URL =? where Image_ID = ?";
	public int update(String ImageID,String ImageName,String ImageURL) {
		int rset = 0;
		ResultSet rs = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(UPDATE);
			) {
			stmt.setString(1, ImageName);
			stmt.setString(2, ImageURL);
			stmt.setString(3, ImageID);
			rset = stmt.executeUpdate();
		    if(rset!=0){
		    	return rset;
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
