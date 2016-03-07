package _06_Seller.model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
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
//	private static final String URL = "jdbc:sqlserver://raab1str2m.database.windows.net:1433;database=DB02";
//	private static final String USERNAME = "eeit83team05@raab1str2m";
//	private static final String PASSWORD = "Sa123456";
	
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

		// select   OK
//		 SellerVisitorBean bean =
//		 dao.select("8A42F1DE-6562-48F1-B746-43808076A466");
//		 System.out.println(bean);

		// select all OK
//		 List<SellerVisitorBean> beans = dao.select();
//		 System.out.println(beans);

		// update OK
//		 SellerVisitorBean beanupdate = dao.update("9999911","玖壹壹",null,"0222227911","A","200","1001","69號52樓","CCC2@hotmail.com","上原亞依","0912345678","1",false,false,10000,10000, "4DDF4A66-2618-4A89-BB32-01BB25E36E2B");
//		 System.out.println(beanupdate);           

		// insert OK
//		SellerVisitorBean beanIns = new SellerVisitorBean(RD,"99999999","玖壹壹",null,"02227890","A","200","1001","69號52樓","CCC2@hotmail.com","上原亞依","0998987987","3",false,false,10000,10000,"2016/1/1");
//		dao.insert(beanIns);                              

		// delete  OK
//		 int beanDel = dao.delete("3BF52DE7-C806-45ED-B606-FD106175CE9F");
//		 System.out.println(beanDel);
	}

	private static final String SELECT = "select * from Seller_visitor where Account_UID=?";

	public SellerVisitorBean select(String Account_UID) {
		SellerVisitorBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
		  //conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		    conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT);

			stmt.setString(1, Account_UID);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new SellerVisitorBean();
				result.setAccount_UID(rset.getString("Account_UID"));
				result.setFEIN(rset.getString("FEIN"));
				result.setName(rset.getString("name"));
//				result.setAcc_email(rset.getString("acc_email"));
//				result.setPsd(rset.getString("psd"));
				result.setSeller_photo(rset.getBlob("Seller_photo"));
				result.setTel(rset.getString("tel"));
				result.setGUAR_CT(rset.getString("GUAR_CT"));
				result.setGUAR_AR(rset.getString("GUAR_AR"));
				result.setGUAR_ROAD(rset.getString("GUAR_ROAD"));
				result.setGUAR_NO(rset.getString("GUAR_NO"));				
				result.setEmail2(rset.getString("email2"));
				result.setCon_name(rset.getString("Con_name"));					
				result.setCon_cel(rset.getString("Con_cel"));
				result.setReceipts_metho(rset.getString("receipts_metho"));				
				result.setIS_check(rset.getBoolean("IS_check"));
//				result.setIS_cooperation(rset.getBoolean("IS_cooperation"));
				result.setSeller_status(rset.getBoolean("Seller_status"));
				result.setShip_price(rset.getInt("ship_price"));					
				result.setLowest_price(rset.getInt("lowest_price"));
				result.setInsdate(rset.getString("insdate"));
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

	private static final String SELECT_ALL = "select * from Seller_visitor";

	public List<SellerVisitorBean> select() {
		List<SellerVisitorBean> items = new ArrayList<SellerVisitorBean>();
		SellerVisitorBean result = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();

			while (rset.next()) {
				result = new SellerVisitorBean();
				result.setAccount_UID(rset.getString("Account_UID"));
				result.setFEIN(rset.getString("FEIN"));
				result.setName(rset.getString("name"));
//				result.setAcc_email(rset.getString("acc_email"));
//				result.setPsd(rset.getString("psd"));
				result.setSeller_photo(rset.getBlob("Seller_photo"));
				result.setTel(rset.getString("tel"));
				result.setGUAR_CT(rset.getString("GUAR_CT"));
				result.setGUAR_AR(rset.getString("GUAR_AR"));
				result.setGUAR_ROAD(rset.getString("GUAR_ROAD"));
				result.setGUAR_NO(rset.getString("GUAR_NO"));				
				result.setEmail2(rset.getString("email2"));
				result.setCon_name(rset.getString("Con_name"));					
				result.setCon_cel(rset.getString("Con_cel"));
				result.setReceipts_metho(rset.getString("receipts_metho"));				
				result.setIS_check(rset.getBoolean("IS_check"));
//				result.setIS_cooperation(rset.getBoolean("IS_cooperation"));
				result.setSeller_status(rset.getBoolean("Seller_status"));
				result.setShip_price(rset.getInt("Ship_price"));					
				result.setLowest_price(rset.getInt("Lowest_price"));
				result.setInsdate(rset.getString("insdate"));
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

	private static final String INSERT = "insert into Seller_visitor (Account_UID,FEIN, name, Seller_photo, tel, GUAR_CT, GUAR_AR, GUAR_ROAD, GUAR_NO, email2, Con_name, Con_cel, receipts_metho, IS_check,Seller_status,ship_price,lowest_price,insdate ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , 0, 0,?,?,getdate())";

	public SellerVisitorBean insert(SellerVisitorBean bean) {
		SellerVisitorBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, bean.getAccount_UID());
			stmt.setString(2, bean.getFEIN());
			stmt.setString(3, bean.getName());
//			stmt.setString(4, bean.getAcc_email());
//			stmt.setString(5, bean.getPsd());
			stmt.setBlob(4, bean.getSeller_photo());
			stmt.setString(5, bean.getTel());
			stmt.setString(6, bean.getGUAR_CT());
			stmt.setString(7, bean.getGUAR_AR());
			stmt.setString(8, bean.getGUAR_ROAD());
			stmt.setString(9, bean.getGUAR_NO());			
			stmt.setString(10, bean.getEmail2());			
			stmt.setString(11, bean.getCon_name());
			stmt.setString(12, bean.getCon_cel());			
			stmt.setString(13, bean.getReceipts_metho());			
//			stmt.setBoolean(14, bean.isIS_check());
////		stmt.setBoolean(15, bean.isIS_cooperation());
//			stmt.setBoolean(15, bean.isSeller_status());
			stmt.setInt(14, bean.getShip_price());
			stmt.setInt(15, bean.getLowest_price());
			//stmt.setString(18, bean.getInsdate());
			int i = stmt.executeUpdate();

			if (i == 1) {
				System.out.println("INSERT Success!");
				result = bean;
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

	private static final String UPDATE = "update Seller_visitor set  FEIN=?, name=?, Seller_photo=?, tel=?, GUAR_CT=?, GUAR_AR=?, GUAR_ROAD=?, GUAR_NO=?, email2=?, Con_name=?, Con_cel=?, Seller_status=? , receipts_metho=?, IS_check=?,Ship_price=?, Lowest_price=? where Account_UID=?";

	public SellerVisitorBean update(String FEIN, String name, Blob Seller_photo,String tel, String GUAR_CT, String GUAR_AR, String GUAR_ROAD, String GUAR_NO,String email2, 
			String Con_name, String Con_cel,String receipts_metho, boolean IS_check, boolean Seller_status, int Ship_price, int Lowest_price, String Account_UID) {
		Connection conn = null;
		PreparedStatement psStrUpd = null;
		SellerVisitorBean result = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			psStrUpd = conn.prepareStatement(UPDATE);			
			psStrUpd.setString(1, FEIN);
			psStrUpd.setString(2, name);
			psStrUpd.setBlob  (3, Seller_photo);
			psStrUpd.setString(4, tel);
			psStrUpd.setString(5, GUAR_CT);
			psStrUpd.setString(6, GUAR_AR);
			psStrUpd.setString(7, GUAR_ROAD);
			psStrUpd.setString(8, GUAR_NO);
			psStrUpd.setString(9, email2);
			psStrUpd.setString(10, Con_name);
			psStrUpd.setString(11, Con_cel);
			psStrUpd.setString(12, receipts_metho);
			psStrUpd.setBoolean(13, IS_check);
//			psStrUpd.setBoolean(14, IS_cooperation);	
//			psStrUpd.setString(15, insdate);
			psStrUpd.setBoolean(14,Seller_status);
			psStrUpd.setInt(15, Ship_price);
			psStrUpd.setInt(16, Lowest_price);
//			if (insdate != null) {
//				long time = insdate.getTime();
//				psStrUpd.setDate(15, new java.sql.Date(time));
//			} else {
//				psStrUpd.setDate(15, null);
//			}			
			psStrUpd.setString(17, Account_UID);
			
			
			int i = psStrUpd.executeUpdate();
			if (i == 1) {
				System.out.println("UPDATE Success!");
				result = this.select(Account_UID);
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

	private static final String DELETE = "delete from Seller_visitor where Account_UID=?";

	public int delete(String Account_UID) {
		try(
//				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {
				stmt.setString(1, Account_UID);
				return stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
}
