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
import _07_Address.model.Address_CT_Bean;

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
//		 List<OrdersTotalBean> bean =
//		 dao.select("A5162397-9C58-4670-9684-427A2C020DB7");
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

	private static final String SELECT = "select * from Orders_total where account_UID=?";  //此處因登入後可抓到account_UID，故可以select自己的單(一般會員&店家皆是)
	//private static final String SELECT = "select * from Orders_total join Address_AR on Orders_total.GUAR_AR=Address_AR.GUAR_AR join Address_CT on Orders_total.GUAR_CT=Address_CT.GUAR_CT join Address_ROAD on Orders_total.GUAR_ROAD=Address_ROAD.GUAR_ROAD where account_UID=?";  //此處因登入後可抓到account_UID，故可以select自己的單(一般會員&店家皆是)

	public List<OrdersTotalBean> select(String account_UID) {
		List<OrdersTotalBean> items = new ArrayList<OrdersTotalBean>();
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
			while (rset.next()) {
				result = new OrdersTotalBean();
				result.setOrders_total_UID(rset.getString("Orders_total_UID"));
				result.setAccount_UID(rset.getString("account_UID"));
				result.setSeller_UID(rset.getString("seller_UID"));
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


	private static final String INSERT = "insert into Orders_total (Orders_total_UID, account_UID, seller_UID, ordersID(), status, name, cel, GUAR_CT, GUAR_AR, GUAR_ROAD, GUAR_NO, pay_metho, insdate, ship_price, food_price, total_amount) OUTPUT INSERTED.ordersID values (NEWID(), ?, ?, ?, '處理中', ?, ?, ?, ?, ?, ?, ?, getdate(), ?, ?, ?)";

	public OrdersTotalBean insert(OrdersTotalBean bean) {
		OrdersTotalBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, bean.getAccount_UID());
			stmt.setString(2, bean.getSeller_UID());   //要抓店家的Seller_UID(Account_UID)才能insert訂單
			stmt.setInt(3, bean.getOrdersID());
			stmt.setString(5, bean.getName());
			stmt.setString(5, bean.getCel());
			stmt.setString(6, bean.getGUAR_CT());
			stmt.setString(7, bean.getGUAR_AR());
			stmt.setString(8, bean.getGUAR_ROAD());
			stmt.setString(9, bean.getGUAR_NO());
			stmt.setString(10, bean.getPay_metho());
			stmt.setInt(11, bean.getShip_price());
			stmt.setInt(12, bean.getFood_price());
			stmt.setInt(13, bean.getTotal_amount());
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

	public OrdersTotalBean findNameBySellerPartner(String account_UID) {
		OrdersTotalBean ordersTotalBean = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("select * from Seller_visitor where account_UID=?");
			stmt.setString(1, account_UID);
			rset = stmt.executeQuery();
			while (rset.next()) {
				ordersTotalBean = new OrdersTotalBean();
				ordersTotalBean.setAccount_UID(rset.getString("account_UID"));
				ordersTotalBean.setName(rset.getString("name"));
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
		return ordersTotalBean;
	}
}
