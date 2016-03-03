package _03_Orders.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _03_Orders.model.OrdersTotalBean;

public class OrdersTotalJDBC {
//	private static final String URL = "jdbc:sqlserver://raab1str2m.database.windows.net:1433;database=DB02";
//	private static final String USERNAME = "eeit83team05@raab1str2m";
//	private static final String PASSWORD = "Sa123456";
	
	private DataSource dataSource = null;
	public OrdersTotalJDBC() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String RD = UUID.randomUUID().toString();
		OrdersTotalJDBC dao = new OrdersTotalJDBC();

		// select
//		 OrdersTotalBean bean =
//		 dao.select("2016010003");
//		 System.out.println(bean);

		// select all OK
//		 List<OrdersTotalBean> beans = dao.select();
//		 System.out.println(beans);

		// update OK
//		 OrdersTotalBean beanupdate = dao.update("01657CF4-B140-4718-9C7E-0C8BAB1A4D76", "1", "炫窩鳴人", "0912345269", "A", "105", "2000",
//					"307號12樓", "0", new java.util.Date(), 300, 200, 500, "88433134-0610-4792-B5DD-3D0EB6B76097");
//		 System.out.println(beanupdate);

		// insert OK
//		OrdersTotalBean beanIns = new OrdersTotalBean(RD, RD, "1", "波多野", "0980888888", "A", "105", "2000",
//				"307號12樓", "0", new java.util.Date(), 100, 200, 300);
//		dao.insert(beanIns);

		// delete  OK
		// int beanDel = dao.delete("4183B13F-946C-4B49-A95A-F84F20FD4007");
		// System.out.println(beanDel);
	}

	//private static final String SELECT = "select * from Orders_total where account_UID=?";  //此處因登入後可抓到account_UID，故可以select自己的單(一般會員&店家皆是)
	private static final String SELECT = "select * from Orders_total join Address_AR on Orders_total.GUAR_AR=Address_AR.GUAR_AR join Address_CT on Orders_total.GUAR_CT=Address_CT.GUAR_CT join Address_ROAD on Orders_total.GUAR_ROAD=Address_ROAD.GUAR_ROAD where account_UID=?";  //此處因登入後可抓到account_UID，故可以select自己的單(一般會員&店家皆是)

	public OrdersTotalBean select(String account_UID) {
		OrdersTotalBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT);

			stmt.setString(1, account_UID);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new OrdersTotalBean();
				result.setOrders_total_UID(rset.getString("Orders_total_UID"));
				result.setAccount_UID(rset.getString("account_UID"));
				result.setOrdersID(rset.getInt("ordersID"));
				result.setStatus(rset.getString("status"));
				result.setName(rset.getString("name"));
				result.setCel(rset.getString("cel"));
				result.setGUAR_CT(rset.getString("GUAR_CT"));
				result.setGUAR_AR(rset.getString("GUAR_AR"));
				result.setGUAR_ROAD(rset.getString("GUAR_ROAD"));
				result.setGUAR_NO(rset.getString("GUAR_NO"));
				result.setPay_metho(rset.getString("pay_metho"));
				result.setInsdate(rset.getDate("insdate"));
				result.setShip_price(rset.getInt("ship_price"));
				result.setFood_price(rset.getInt("food_price"));
				result.setTotal_amount(rset.getInt("total_amount"));
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

	private static final String SELECT_ALL = "select * from Orders_total order by ordersID ASC";

	public List<OrdersTotalBean> select() {
		List<OrdersTotalBean> items = new ArrayList<OrdersTotalBean>();
		OrdersTotalBean result = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();

			while (rset.next()) {
				result = new OrdersTotalBean();
				result.setOrders_total_UID(rset.getString("Orders_total_UID"));
				result.setAccount_UID(rset.getString("account_UID"));
				result.setOrdersID(rset.getInt("ordersID"));
				result.setStatus(rset.getString("status"));
				result.setName(rset.getString("name"));
				result.setCel(rset.getString("cel"));
				result.setGUAR_CT(rset.getString("GUAR_CT"));
				result.setGUAR_AR(rset.getString("GUAR_AR"));
				result.setGUAR_ROAD(rset.getString("GUAR_ROAD"));
				result.setGUAR_NO(rset.getString("GUAR_NO"));
				result.setPay_metho(rset.getString("pay_metho"));
				result.setInsdate(rset.getDate("insdate"));
				result.setShip_price(rset.getInt("ship_price"));
				result.setFood_price(rset.getInt("food_price"));
				result.setTotal_amount(rset.getInt("total_amount"));
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

	private static final String INSERT = "insert into Orders_total (Orders_total_UID, account_UID, status, name, cel, GUAR_CT, GUAR_AR, GUAR_ROAD, GUAR_NO, pay_metho, insdate, ship_price, food_price, total_amount) OUTPUT INSERTED.ordersID values (NEWID(), ?, 0, ?, ?, ?, ?, ?, ?, ?, getdate(), ?, ?, ?)";

	public OrdersTotalBean insert(OrdersTotalBean bean) {
		OrdersTotalBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
//			stmt.setString(1, bean.getOrders_total_UID());   
//			stmt.setString(2, bean.getAccount_UID());
//			
//			stmt.setString(3, bean.getStatus());
//			stmt.setString(4, bean.getName());
//			stmt.setString(5, bean.getCel());
//			stmt.setString(6, bean.getGUAR_CT());
//			stmt.setString(7, bean.getGUAR_AR());
//			stmt.setString(8, bean.getGUAR_ROAD());
//			stmt.setString(9, bean.getGUAR_NO());
//			stmt.setString(10, bean.getPay_metho());
//			java.util.Date insdate = bean.getInsdate();
//			if (insdate != null) {
//				long time = insdate.getTime();
//				stmt.setDate(11, new java.sql.Date(time));
//			} else {
//				stmt.setDate(11, null);
//			}
//			stmt.setInt(12, bean.getShip_price());
//			stmt.setInt(13, bean.getFood_price());
//			stmt.setInt(14, bean.getTotal_amount());
//	----------------------------------------------------------------------------
			
//			stmt.setString(1, bean.getOrders_total_UID());    測試用先塞NEWID()
//			stmt.setString(2, bean.getAccount_UID());         測試用先塞NEWID()
//			stmt.setInt(3, bean.getOrdersID());               流水號不塞資料  
//			stmt.setString(4, bean.getStatus());		               預設狀態0
			stmt.setString(1, bean.getAccount_UID());
			stmt.setString(2, bean.getName());
			stmt.setString(3, bean.getCel());
			stmt.setString(4, bean.getGUAR_CT());
			stmt.setString(5, bean.getGUAR_AR());
			stmt.setString(6, bean.getGUAR_ROAD());
			stmt.setString(7, bean.getGUAR_NO());
			stmt.setString(8, bean.getPay_metho());
//			java.util.Date insdate = bean.getInsdate();
//			if (insdate != null) {
//				long time = insdate.getTime();
//				stmt.setDate(12, new java.sql.Date(time));
//			} else {
//				stmt.setDate(12, null);
//			}
			stmt.setInt(9, bean.getShip_price());
			stmt.setInt(10, bean.getFood_price());
			stmt.setInt(11, bean.getTotal_amount());

			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				System.out.println("INSERT Success!");				
				bean.setOrdersID(rs.getInt(1));
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

	private static final String UPDATE = "update Orders_total set status=?, name=?, cel=?, GUAR_CT=?, GUAR_AR=?, "
			+ "GUAR_ROAD=?, GUAR_NO=?, pay_metho=? ,insdate=?, "
			+ "ship_price=?, food_price=?, total_amount=? where ordersID=?";   //此處因ordersID為unique，故選為依據

	public OrdersTotalBean update(String status, String name, String cel,
			String gUAR_CT, String gUAR_AR, String gUAR_ROAD, String gUAR_NO, String pay_metho, Date insdate,
			int ship_price, int food_price, int total_amount, int ordersID) {
		Connection conn = null;
		PreparedStatement psStrUpd = null;
		OrdersTotalBean result = null;
		
		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			psStrUpd = conn.prepareStatement(UPDATE);						
			
			psStrUpd.setString(1, status);
			psStrUpd.setString(2, name);
			psStrUpd.setString(3, cel);
			psStrUpd.setString(4, gUAR_CT);
			psStrUpd.setString(5, gUAR_AR);
			psStrUpd.setString(6, gUAR_ROAD);
			psStrUpd.setString(7, gUAR_NO);
			psStrUpd.setString(8, pay_metho);
			if (insdate != null) {
				long time = insdate.getTime();
				psStrUpd.setDate(9, new java.sql.Date(time));
			} else {
				psStrUpd.setDate(9, null);
			}
			psStrUpd.setInt(10, ship_price);
			psStrUpd.setInt(11, food_price);
			psStrUpd.setInt(12, total_amount);
			psStrUpd.setInt(13, ordersID);

			int i = psStrUpd.executeUpdate();
			if (i == 1) {
				System.out.println("UPDATE Success!");
				return result;
				//result = this.select(account_UID);				
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

	private static final String DELETE = "delete from Orders_total where ordersID=?";

	public int delete(int ordersID) {
		try(//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {
				stmt.setInt(1, ordersID);
				return stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}

}
