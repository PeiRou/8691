package _07_Address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AddressJDBC {	
	private DataSource dataSource = null;
	public AddressJDBC() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}	
	
	public Address_CT_Bean findGUAR_CT_nameByAddress_CT(String GUAR_CT) {
		Address_CT_Bean address_CT_Bean = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("select * from Address_CT where GUAR_CT=?");

			stmt.setString(1, GUAR_CT);
			rset = stmt.executeQuery();
			while (rset.next()) {
				address_CT_Bean = new Address_CT_Bean();
				address_CT_Bean.setGUAR_CT(rset.getString("GUAR_CT"));
				address_CT_Bean.setGUAR_CT_name(rset.getString("GUAR_CT_name"));
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
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return address_CT_Bean;
	}
	
	
	public Address_AR_Bean findGUAR_AR_nameByAddress_AR(String GUAR_AR) {
		Address_AR_Bean address_AR_Bean = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("select * from Address_AR where GUAR_AR=?");

			stmt.setString(1, GUAR_AR);
			rset = stmt.executeQuery();
			while (rset.next()) {
				address_AR_Bean = new Address_AR_Bean();
				address_AR_Bean.setGUAR_AR(rset.getString("GUAR_AR"));
				address_AR_Bean.setGUAR_CT(rset.getString("GUAR_CT"));
				address_AR_Bean.setGUAR_AR_name(rset.getString("GUAR_AR_name"));
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
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return address_AR_Bean;
	}
	
	
	public Address_ROAD_Bean findGUAR_ROAD_nameByAddress_ROAD(String GUAR_ROAD) {
		Address_ROAD_Bean address_ROAD_Bean = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("select * from Address_ROAD where GUAR_ROAD=?");

			stmt.setString(1, GUAR_ROAD);
			rset = stmt.executeQuery();
			while (rset.next()) {
				address_ROAD_Bean = new Address_ROAD_Bean();
				address_ROAD_Bean.setGUAR_ROAD(rset.getString("GUAR_ROAD"));
				address_ROAD_Bean.setGUAR_AR(rset.getString("GUAR_AR"));
				address_ROAD_Bean.setGUAR_ROAD_name(rset.getString("GUAR_ROAD_name"));
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
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return address_ROAD_Bean;
	}
}
