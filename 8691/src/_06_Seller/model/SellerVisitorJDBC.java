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
//		 dao.select("77887788");
//		 System.out.println(bean);

		// select all OK
//		 List<SellerVisitorBean> beans = dao.select();
//		 System.out.println(beans);

		// update OK
//		 SellerVisitorBean beanupdate = dao.update("玖壹壹","CCC@gmail.com","BBB22",null,"0222227890","A","200","1001","69號52樓","CCC2@hotmail.com","宇智波右助","0912345678","1",false,false, new java.util.Date(),"00000000");
//		 System.out.println(beanupdate);

		// insert OK
//		SellerVisitorBean beanIns = new SellerVisitorBean("99999999","玖壹壹","CCC@gmail.com","BBB22",null,"0222227890","A","200","1001","69號52樓","CCC2@hotmail.com","上原亞依","0912345678","1",false,false, new java.util.Date());
//		dao.insert(beanIns);

		// delete  OK
//		 int beanDel = dao.delete("99999999");
//		 System.out.println(beanDel);
	}

	private static final String SELECT = "select * from Seller_visitor where FEIN=?";

	public SellerVisitorBean select(String FEIN) {
		SellerVisitorBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT);

			stmt.setString(1, FEIN);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new SellerVisitorBean();
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
				result.setEmail2(rset.getString("email2"));
				result.setCon_name(rset.getString("Con_name"));					
				result.setCon_cel(rset.getString("Con_cel"));
				result.setReceipts_metho(rset.getString("receipts_metho"));				
				result.setIS_check(rset.getBoolean("IS_check"));
				result.setIS_cooperation(rset.getBoolean("IS_cooperation"));
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

	private static final String SELECT_ALL = "select * from Seller_visitor";

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
				result.setEmail2(rset.getString("email2"));
				result.setCon_name(rset.getString("Con_name"));					
				result.setCon_cel(rset.getString("Con_cel"));
				result.setReceipts_metho(rset.getString("receipts_metho"));				
				result.setIS_check(rset.getBoolean("IS_check"));
				result.setIS_cooperation(rset.getBoolean("IS_cooperation"));
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

	private static final String INSERT = "insert into Seller_visitor (FEIN, name, acc_email, psd, Seller_photo, tel, GUAR_CT, GUAR_AR, GUAR_ROAD, GUAR_NO, email2, Con_name, Con_cel, receipts_metho, IS_check, IS_cooperation, insdate) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?)";

	public SellerVisitorBean insert(SellerVisitorBean bean) {
		SellerVisitorBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, bean.getFEIN());
			stmt.setString(2, bean.getName());
			stmt.setString(3, bean.getAcc_email());
			stmt.setString(4, bean.getPsd());
			stmt.setBlob(5, bean.getSeller_photo());
			stmt.setString(6, bean.getTel());
			stmt.setString(7, bean.getGUAR_CT());
			stmt.setString(8, bean.getGUAR_AR());
			stmt.setString(9, bean.getGUAR_ROAD());
			stmt.setString(10, bean.getGUAR_NO());			
			stmt.setString(11, bean.getEmail2());			
			stmt.setString(12, bean.getCon_name());
			stmt.setString(13, bean.getCon_cel());			
			stmt.setString(14, bean.getReceipts_metho());			
			stmt.setBoolean(15, bean.isIS_check());
			stmt.setBoolean(16, bean.isIS_cooperation());			
			java.util.Date insdate = bean.getInsdate();
			if (insdate != null) {
				long time = insdate.getTime();
				stmt.setDate(17, new java.sql.Date(time));
			} else {
				stmt.setDate(17, null);
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

	private static final String UPDATE = "update Seller_visitor set name=?, acc_email=?, psd=?, Seller_photo=?, tel=?, GUAR_CT=?, GUAR_AR=?, GUAR_ROAD=?, GUAR_NO=?, email2=?, Con_name=?, Con_cel=?, receipts_metho=?, IS_check=?, IS_cooperation=?, insdate=? where FEIN=?";

	public SellerVisitorBean update(String name, String acc_email, String psd, Blob Seller_photo,
			String tel, String GUAR_CT, String GUAR_AR, String GUAR_ROAD, String GUAR_NO,String email2, 
			String Con_name, String Con_cel,String receipts_metho, boolean IS_check, boolean IS_cooperation, Date insdate, String FEIN) {
		Connection conn = null;
		PreparedStatement psStrUpd = null;
		SellerVisitorBean result = null;
		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			psStrUpd = conn.prepareStatement(UPDATE);			
			psStrUpd.setString(1, name);
			psStrUpd.setString(2, acc_email);
			psStrUpd.setString(3, psd);
			psStrUpd.setBlob(4, Seller_photo);
			psStrUpd.setString(5, tel);
			psStrUpd.setString(6, GUAR_CT);
			psStrUpd.setString(7, GUAR_AR);
			psStrUpd.setString(8, GUAR_ROAD);
			psStrUpd.setString(9, GUAR_NO);
			psStrUpd.setString(10, email2);
			psStrUpd.setString(11, Con_name);
			psStrUpd.setString(12, Con_cel);
			psStrUpd.setString(13, receipts_metho);
			psStrUpd.setBoolean(14, IS_check);
			psStrUpd.setBoolean(15, IS_cooperation);										
			if (insdate != null) {
				long time = insdate.getTime();
				psStrUpd.setDate(16, new java.sql.Date(time));
			} else {
				psStrUpd.setDate(16, null);
			}			
			psStrUpd.setString(17, FEIN);
			
			
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

	private static final String DELETE = "delete from Seller_visitor where FEIN=?";

	public int delete(String FEIN) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(DELETE);
			stmt.setString(1, FEIN);
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
