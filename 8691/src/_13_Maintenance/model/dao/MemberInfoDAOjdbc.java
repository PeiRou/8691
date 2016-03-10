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

public class MemberInfoDAOjdbc {	
	private DataSource dataSource;
	
	public MemberInfoDAOjdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private final String SELECT_BY_UID = "select a.name,a.tel,a.cel,a.gender,CT.GUAR_CT_name,AR.GUAR_AR_name,ROAD.GUAR_ROAD_name,a.GUAR_NO,a.email2 from member a join Address_CT CT on a.GUAR_CT = CT.GUAR_CT join Address_AR AR on a.GUAR_AR = AR.GUAR_AR join Address_ROAD ROAD on a.GUAR_ROAD = ROAD.GUAR_ROAD where account_UID = ?";
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
				obj.put("name", rset.getString("name"));
				obj.put("tel", rset.getString("tel"));
				obj.put("cel", rset.getString("cel"));
				obj.put("guarCT", rset.getString("GUAR_CT_name"));
				obj.put("guarAR", rset.getString("GUAR_AR_name"));
				obj.put("guarROAD", rset.getString("GUAR_ROAD_name"));
				obj.put("guarNO", rset.getString("GUAR_NO"));
				obj.put("email2", rset.getString("email2"));

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
