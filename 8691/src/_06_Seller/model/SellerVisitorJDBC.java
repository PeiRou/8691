package _06_Seller.model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import _06_Seller.model.SellerVisitorBean;

public class SellerVisitorJDBC {
	private static final String URL = "jdbc:sqlserver://raab1str2m.database.windows.net:1433;database=DB02";
	private static final String USERNAME = "eeit83team05@raab1str2m";
	private static final String PASSWORD = "Sa123456";
	
	private DataSource dataSource = null;
	public SellerVisitorJDBC() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String RD = UUID.randomUUID().toString();
		SellerVisitorJDBC dao = new SellerVisitorJDBC();

		// select
//		 SellerVisitorBean bean =
//		 dao.select("E73B3D1B-90DA-4688-8B53-708C7B8CC6F9");
//		 System.out.println(bean);

		// select all OK
//		 List<SellerVisitorBean> beans = dao.select();
//		 System.out.println(beans);

		// update OK
//		 SellerVisitorBean beanupdate = dao.update("456","玖壹壹","00000000","anal@fuxx.com","analanal",null,"0222227890","A","200","100","69號52樓","上原亞依","0912345678","2","1","1","1", new java.util.Date(), "7EE65F76-B9B4-429C-B4A2-E831BC7CDF1C");
//		 System.out.println(beanupdate);

		// insert OK
//		SellerVisitorBean beanIns = new SellerVisitorBean(RD, "456","玖壹壹","00000000","lib@911.com","911991",null,"0222227890","A","200","100","1002","波多野結依","0912345678","2","1","1","1", new java.util.Date());
//		dao.insert(beanIns);

		// delete  OK
//		 int beanDel = dao.delete("7EE65F76-B9B4-429C-B4A2-E831BC7CDF1C");
//		 System.out.println(beanDel);
	}

	private static final String SELECT = "select * from Seller_partner where Seller_partner_UID=?";

	public SellerVisitorBean select(String Seller_partner_UID) {
		SellerVisitorBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT);

			stmt.setString(1, Seller_partner_UID);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new SellerVisitorBean();
				result.setSeller_partner_UID(rset.getString("Seller_partner_UID"));
				result.setSeller_ID(rset.getString("Seller_ID"));
				result.setName(rset.getString("Name"));
				result.setFEIN(rset.getString("FEIN"));
				result.setName(rset.getString("name"));
				result.setAcc_email(rset.getString("acc_email"));
				result.setPsd(rset.getString("psd"));
				result.setSeller_photo(rset.getBlob("Seller_photo"));
				result.setTel(rset.getString("tel"));
				result.setGUAR_CT(rset.getString("GUAR_CT"));
				result.setGUAR_AR(rset.getString("GUAR_AR"));
				result.setGUAR_ROAD(rset.getString("GUAR_ROAD"));
				result.setGUAR_NO(rset.getString("GUAR_NO"));
				result.setCon_name(rset.getString("Con_name"));					
				result.setCon_cel(rset.getString("Con_cel"));
				result.setReceipts_metho(rset.getString("receipts_metho"));
				result.setSeller_status(rset.getString("Seller_status"));
				result.setIS_Food_Staple(rset.getString("IS_Food_Staple"));					
				result.setIS_Food_Drink(rset.getString("IS_Food_Drink"));
				result.setInsdate(rset.getDate("insdate"));
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
		return result;
	}

	private static final String SELECT_ALL = "select * from Seller_partner";

	public List<SellerVisitorBean> select() {
		List<SellerVisitorBean> items = new ArrayList<SellerVisitorBean>();
		SellerVisitorBean result = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();

			while (rset.next()) {
				result = new SellerVisitorBean();
				result = new SellerVisitorBean();
				result.setSeller_partner_UID(rset.getString("Seller_partner_UID"));
				result.setSeller_ID(rset.getString("Seller_ID"));
				result.setName(rset.getString("Name"));
				result.setFEIN(rset.getString("FEIN"));
				result.setName(rset.getString("name"));
				result.setAcc_email(rset.getString("acc_email"));
				result.setPsd(rset.getString("psd"));
				result.setSeller_photo(rset.getBlob("Seller_photo"));
				result.setTel(rset.getString("tel"));
				result.setGUAR_CT(rset.getString("GUAR_CT"));
				result.setGUAR_AR(rset.getString("GUAR_AR"));
				result.setGUAR_ROAD(rset.getString("GUAR_ROAD"));
				result.setGUAR_NO(rset.getString("GUAR_NO"));
				result.setCon_name(rset.getString("Con_name"));					
				result.setCon_cel(rset.getString("Con_cel"));
				result.setReceipts_metho(rset.getString("receipts_metho"));
				result.setSeller_status(rset.getString("Seller_status"));
				result.setIS_Food_Staple(rset.getString("IS_Food_Staple"));					
				result.setIS_Food_Drink(rset.getString("IS_Food_Drink"));
				result.setInsdate(rset.getDate("insdate"));
				items.add(result);
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
		return items;
	}

	private static final String INSERT = "insert into Seller_partner (Seller_partner_UID, Seller_ID, name, FEIN, acc_email, psd, Seller_photo, tel, GUAR_CT, GUAR_AR, GUAR_ROAD, GUAR_NO, Con_name, Con_cel, receipts_metho, Seller_status, IS_Food_Staple, IS_Food_Drink, insdate) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?)";

	public SellerVisitorBean insert(SellerVisitorBean bean) {
		SellerVisitorBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, bean.getSeller_partner_UID());
			stmt.setString(2, bean.getSeller_ID());
			stmt.setString(3, bean.getName());
			stmt.setString(4, bean.getFEIN());
			stmt.setString(5, bean.getAcc_email());
			stmt.setString(6, bean.getPsd());
			stmt.setBlob(7, bean.getSeller_photo());
			stmt.setString(8, bean.getTel());
			stmt.setString(9, bean.getGUAR_CT());
			stmt.setString(10, bean.getGUAR_AR());
			stmt.setString(11, bean.getGUAR_ROAD());
			stmt.setString(12, bean.getGUAR_NO());
			stmt.setString(13, bean.getCon_name());
			stmt.setString(14, bean.getCon_cel());
			stmt.setString(15, bean.getReceipts_metho());
			stmt.setString(16, bean.getSeller_status());
			stmt.setString(17, bean.getIS_Food_Staple());
			stmt.setString(18, bean.getIS_Food_Drink());
			java.util.Date insdate = bean.getInsdate();
			if (insdate != null) {
				long time = insdate.getTime();
				stmt.setDate(19, new java.sql.Date(time));
			} else {
				stmt.setDate(19, null);
			}

			int i = stmt.executeUpdate();

			if (i == 1) {
				System.out.println("INSERT Success!");
				// return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return result;
	}

	private static final String UPDATE = "update Seller_partner set Seller_ID=?, name=?, FEIN=?, acc_email=?, psd=?, Seller_photo=?, tel=?, GUAR_CT=?, GUAR_AR=?, GUAR_ROAD=?, GUAR_NO=?, Con_name=?, Con_cel=?, receipts_metho=?, Seller_status=?, IS_Food_Staple=?, IS_Food_Drink=?, insdate=? where Seller_partner_UID=?";

	public SellerVisitorBean update(String Seller_ID, String name, String FEIN, String acc_email,
			String psd, Blob Seller_photo, String tel, String GUAR_CT, String GUAR_AR, String GUAR_ROAD,
			String GUAR_NO, String Con_name, String Con_cel, String receipts_metho, String Seller_status,
			String IS_Food_Staple, String IS_Food_Drink, Date insdate, String Seller_partner_UID) {
		Connection conn = null;
		PreparedStatement psStrUpd = null;
		SellerVisitorBean result = null;
		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			psStrUpd = conn.prepareStatement(UPDATE);
			psStrUpd.setString(1, Seller_ID);
			psStrUpd.setString(2, name);
			psStrUpd.setString(3, FEIN);
			psStrUpd.setString(4, acc_email);
			psStrUpd.setString(5, psd);
			psStrUpd.setBlob(6, Seller_photo);
			psStrUpd.setString(7, tel);
			psStrUpd.setString(8, GUAR_CT);
			psStrUpd.setString(9, GUAR_AR);
			psStrUpd.setString(10, GUAR_ROAD);
			psStrUpd.setString(11, GUAR_NO);
			psStrUpd.setString(12, Con_name);
			psStrUpd.setString(13, Con_cel);
			psStrUpd.setString(14, receipts_metho);
			psStrUpd.setString(15, Seller_status);
			psStrUpd.setString(16, IS_Food_Staple);
			psStrUpd.setString(17, IS_Food_Drink);							
			if (insdate != null) {
				long time = insdate.getTime();
				psStrUpd.setDate(18, new java.sql.Date(time));
			} else {
				psStrUpd.setDate(18, null);
			}
			psStrUpd.setString(19, Seller_partner_UID);	

			int i = psStrUpd.executeUpdate();
			if (i == 1) {
				System.out.println("UPDATE Success!");				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (psStrUpd != null) {
				try {
					psStrUpd.close();
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
		return result;
	}

	private static final String DELETE = "delete from Seller_partner where Seller_partner_UID=?";

	public int delete(String Seller_partner_UID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(DELETE);
			stmt.setString(1, Seller_partner_UID);
			int i = stmt.executeUpdate();
			if (i == 1) {
				System.out.println("DELETE Success!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return 0;
	}
}
