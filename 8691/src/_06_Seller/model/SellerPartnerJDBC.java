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
import _06_Seller.model.SellerPartnerBean;


public class SellerPartnerJDBC {
//		private static final String URL = "jdbc:sqlserver://raab1str2m.database.windows.net:1433;database=DB02";
//		private static final String USERNAME = "eeit83team05@raab1str2m";
//		private static final String PASSWORD = "Sa123456";
		
		private DataSource dataSource = null;
		public SellerPartnerJDBC() {
			try {
				Context ctx = new InitialContext();
				dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}

		public static void main(String[] args) {
//			String RD = UUID.randomUUID().toString();
//			SellerPartnerJDBC dao = new SellerPartnerJDBC();

			// select
//			 SellerPartnerBean bean =
//			 dao.select("919329A4-38F9-4041-AD11-8E2C68320DEF");
//			 System.out.println(bean);

			// select all OK
//			 List<SellerPartnerBean> beans = dao.select();
//			 System.out.println(beans);

			// update OK
//			 SellerPartnerBean beanupdate = dao.update("玖壹壹","00000000",null,"0204227890","A","200","100","69號52樓","上原亞依","0912345678","3",true,50000,50000, new java.util.Date(), "CD14F61B-9046-4C1D-8E1C-3A83D4880FD4");
//			 System.out.println(beanupdate);

			// insert OK
//			SellerPartnerBean beanIns = new SellerPartnerBean(RD,"玖壹壹","00000000",null,"0222227890","A","200","100","1002","波多野結依","0912345678","3",true,10000,10000, new java.util.Date());
//			dao.insert(beanIns);

			// delete  OK
//			 int beanDel = dao.delete("CD14F61B-9046-4C1D-8E1C-3A83D4880FD4");
//			 System.out.println(beanDel);
		}

		private static final String SELECT = "select * from Seller_partner where Account_UID=?";

		public SellerPartnerBean select(String Account_UID) {
			SellerPartnerBean result = null;
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
					result = new SellerPartnerBean();
					result.setAccount_UID(rset.getString("Account_UID"));
//					result.setSeller_ID(rset.getString("Seller_ID"));
					result.setName(rset.getString("name"));
					result.setFEIN(rset.getString("FEIN"));
//					result.setAcc_email(rset.getString("acc_email"));
//					result.setPsd(rset.getString("psd"));
					result.setSeller_photo(rset.getBlob("Seller_photo"));
					result.setTel(rset.getString("tel"));
					result.setGUAR_CT(rset.getString("GUAR_CT"));
					result.setGUAR_AR(rset.getString("GUAR_AR"));
					result.setGUAR_ROAD(rset.getString("GUAR_ROAD"));
					result.setGUAR_NO(rset.getString("GUAR_NO"));
					result.setCon_name(rset.getString("Con_name"));					
					result.setCon_cel(rset.getString("Con_cel"));
					result.setReceipts_metho(rset.getString("receipts_metho"));
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

		private static final String SELECT_ALL = "select * from Seller_partner";

		public List<SellerPartnerBean> select() {
			List<SellerPartnerBean> items = new ArrayList<SellerPartnerBean>();
			SellerPartnerBean result = null;

			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rset = null;

			try {
				//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				conn = dataSource.getConnection();
				stmt = conn.prepareStatement(SELECT_ALL);
				rset = stmt.executeQuery();

				while (rset.next()) {
					result = new SellerPartnerBean();
					result.setAccount_UID(rset.getString("Account_UID"));
//					result.setSeller_ID(rset.getString("Seller_ID"));
					result.setName(rset.getString("name"));
					result.setFEIN(rset.getString("FEIN"));
//					result.setAcc_email(rset.getString("acc_email"));
//					result.setPsd(rset.getString("psd"));
					result.setSeller_photo(rset.getBlob("Seller_photo"));
					result.setTel(rset.getString("tel"));
					result.setGUAR_CT(rset.getString("GUAR_CT"));
					result.setGUAR_AR(rset.getString("GUAR_AR"));
					result.setGUAR_ROAD(rset.getString("GUAR_ROAD"));
					result.setGUAR_NO(rset.getString("GUAR_NO"));
					result.setCon_name(rset.getString("Con_name"));					
					result.setCon_cel(rset.getString("Con_cel"));
					result.setReceipts_metho(rset.getString("receipts_metho"));
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

		private static final String INSERT = "insert into Seller_partner (Account_UID, name, FEIN, Seller_photo, tel, GUAR_CT, GUAR_AR, GUAR_ROAD, GUAR_NO, Con_name, Con_cel, receipts_metho, Seller_status, Ship_price, Lowest_price, insdate) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		public SellerPartnerBean insert(SellerPartnerBean bean) {
			SellerPartnerBean result = null;
			Connection conn = null;
			PreparedStatement stmt = null;

			try {
				//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				conn = dataSource.getConnection();
				stmt = conn.prepareStatement(INSERT);
				stmt.setString(1, bean.getAccount_UID());
//				stmt.setString(2, bean.getSeller_ID());
				stmt.setString(2, bean.getName());
				stmt.setString(3, bean.getFEIN());
//				stmt.setString(5, bean.getAcc_email());
//				stmt.setString(6, bean.getPsd());
				stmt.setBlob  (4, bean.getSeller_photo());
				stmt.setString(5, bean.getTel());
				stmt.setString(6, bean.getGUAR_CT());
				stmt.setString(7, bean.getGUAR_AR());
				stmt.setString(8, bean.getGUAR_ROAD());
				stmt.setString(9, bean.getGUAR_NO());
				stmt.setString(10, bean.getCon_name());
				stmt.setString(11, bean.getCon_cel());
				stmt.setString(12, bean.getReceipts_metho());
				stmt.setBoolean(13, bean.isSeller_status());
				stmt.setInt(14, bean.getShip_price());
				stmt.setInt(15, bean.getLowest_price());
				stmt.setString(16, bean.getInsdate());
				
//				java.util.Date insdate = bean.getInsdate();
//				if (insdate != null) {
//					long time = insdate.getTime();
//					stmt.setDate(16, new java.sql.Date(time));
//				} else {
//					stmt.setDate(16, null);
//				}

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

		private static final String UPDATE = "update Seller_partner set name=?, FEIN=?, Seller_photo=?, tel=?, GUAR_CT=?, GUAR_AR=?, GUAR_ROAD=?, GUAR_NO=?, Con_name=?, Con_cel=?, receipts_metho=?, Seller_status=?, Ship_price=?, Lowest_price=?, insdate=? where Account_UID=?";

		public SellerPartnerBean update(String name, String FEIN, Blob Seller_photo, String tel, String GUAR_CT, String GUAR_AR, String GUAR_ROAD,
				String GUAR_NO, String Con_name, String Con_cel, String receipts_metho, boolean Seller_status,
				int Ship_price, int Lowest_price, String insdate, String Account_UID) {
			Connection conn = null;
			PreparedStatement psStrUpd = null;
			SellerPartnerBean result = null;
			try {
				//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				conn = dataSource.getConnection();
				psStrUpd = conn.prepareStatement(UPDATE);
//				psStrUpd.setString(1, Seller_ID);
				psStrUpd.setString(1, name);
				psStrUpd.setString(2, FEIN);
//				psStrUpd.setString(4, acc_email);
//				psStrUpd.setString(5, psd);
				psStrUpd.setBlob  (3, Seller_photo);
				psStrUpd.setString(4, tel);
				psStrUpd.setString(5, GUAR_CT);
				psStrUpd.setString(6, GUAR_AR);
				psStrUpd.setString(7, GUAR_ROAD);
				psStrUpd.setString(8, GUAR_NO);
				psStrUpd.setString(9, Con_name);
				psStrUpd.setString(10, Con_cel);
				psStrUpd.setString(11, receipts_metho);
				psStrUpd.setBoolean(12, Seller_status);
				psStrUpd.setInt(13, Ship_price);
				psStrUpd.setInt(14, Lowest_price);
				psStrUpd.setString(15, insdate);
				
//				if (insdate != null) {
//					long time = insdate.getTime();
//					psStrUpd.setDate(15, new java.sql.Date(time));
//				} else {
//					psStrUpd.setDate(15, null);
//				}
				psStrUpd.setString(16, Account_UID);	

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

		private static final String DELETE = "delete from Seller_partner where Account_UID=?";

		public int delete(String Account_UID) {
			try(//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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
