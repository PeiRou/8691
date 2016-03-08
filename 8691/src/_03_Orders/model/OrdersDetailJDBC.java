package _03_Orders.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import _03_Orders.model.OrdersDetailBean;


public class OrdersDetailJDBC {
//	private static final String URL = "jdbc:sqlserver://raab1str2m.database.windows.net:1433;database=DB02";
//	private static final String USERNAME = "eeit83team05@raab1str2m";
//	private static final String PASSWORD = "Sa123456";
	
	private DataSource dataSource = null;
	public OrdersDetailJDBC() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String RD = UUID.randomUUID().toString();
		OrdersDetailJDBC dao = new OrdersDetailJDBC();
		
		//select  OK
//		OrdersDetailBean bean = dao.select("1A01E09E-EDBB-4740-8A40-2996A98F4237");
//		System.out.println(bean);
		
		//select all  OK
//		List<OrdersDetailBean> beans = dao.select();
//		System.out.println(beans);
//		
		//update  OK
//		boolean beanupdate = dao.update("2016010003", 303, "珍珠綠茶(大)", 2, 40, "少糖少冰", "2B770F24-A751-485C-A1E1-9116BBA92D85");
//		System.out.println(beanupdate);
		
		// insert    
//		OrdersDetailBean beanIns = new OrdersDetailBean(RD,"2016010004", 304, "綠茶(小)", 1, 20, "半糖少冰");
//		dao.insert(beanIns);

		
		// delete    
//		int beanDel = dao.delete("7DB39C4E-711B-49D9-8852-7A5BACE18A4E");
//		System.out.println(beanDel);
	}

private static final String SELECT = "select * from Orders_detail where ordersID=?";

	
	public List<OrdersDetailBean> select(int ordersID) {
		List<OrdersDetailBean> items = new ArrayList<OrdersDetailBean>();
		OrdersDetailBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT);

			stmt.setInt(1, ordersID);
			rset = stmt.executeQuery();
			while (rset.next()) {
				result = new OrdersDetailBean();
				result.setOrders_detail_UID(rset.getString("Orders_detail_UID"));
				result.setOrdersID(rset.getInt("ordersID"));
				result.setFood_ID(rset.getInt("Food_ID"));
				result.setDrink_name(rset.getString("Drink_name"));
				result.setQuantity(rset.getInt("quantity"));
				result.setOriginalPrice(rset.getInt("originalPrice"));
				result.setNote(rset.getString("Note"));
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


//	private static final String INSERT = "insert into Orders_detail (Orders_detail_UID, Orders_ID, Food_ID, Drink_name, quantity, Food_original_price, Note) values (?, ?, ?, ?, ?, ?, ?)";
//
//	
//	public OrdersDetailBean insert(OrdersDetailBean bean) {
//		OrdersDetailBean result = null;
//		Connection conn = null;
//		PreparedStatement stmt = null;
//
//		try {
//			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			conn = dataSource.getConnection();
//			stmt = conn.prepareStatement(INSERT);
//			stmt.setString(1, bean.getOrders_detail_UID());
//			stmt.setString(2, bean.getOrdersID());			
//			stmt.setInt(3, bean.getFood_ID());
//			stmt.setString(4, bean.getDrink_name());
//			stmt.setInt(5, bean.getQuantity());
//			stmt.setInt(6, bean.getOriginalPrice());
//			stmt.setString(7, bean.getNote());			
//
//			int i = stmt.executeUpdate();
//
//			if (i == 1) {
//				System.out.println("INSERT Success!");				
//				result = bean;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return result;
//	}
//
//	private static final String UPDATE = "update Orders_detail set Orders_ID=?, Food_ID=?, Drink_name=?, quantity=?, Food_original_price=?, Note=? where orders_detail_UID=?";
//
//	
//	public OrdersDetailBean update(String orders_ID, int food_ID, String drink_name, int quantity,
//			int food_original_price, String note, String orders_detail_UID) {
//		Connection conn = null;
//		PreparedStatement psStrUpd = null;
//		OrdersDetailBean result = null;
//		try {
//			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			conn = dataSource.getConnection();
//			psStrUpd = conn.prepareStatement(UPDATE);
//			psStrUpd.setString(1, orders_ID);
//			psStrUpd.setInt(2, food_ID);
//			psStrUpd.setString(3, drink_name);
//			psStrUpd.setInt(4, quantity);
//			psStrUpd.setInt(5, food_original_price);
//			psStrUpd.setString(6, note);
//			psStrUpd.setString(7, orders_detail_UID);
//			
//
//			int i = psStrUpd.executeUpdate();
//			if (i == 1) {
//				System.out.println("UPDATE Success!");		
//				result = this.select(orders_detail_UID);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (psStrUpd != null) {
//				try {
//					psStrUpd.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return result;
//	}
//	
//	
//	
//	private static final String DELETE = "delete from Orders_detail where Orders_detail_UID=?";
//	
//	public int delete(String Orders_detail_UID) {
//		try(//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//				Connection conn = dataSource.getConnection();
//				PreparedStatement stmt = conn.prepareStatement(DELETE);) {
//				stmt.setString(1, Orders_detail_UID);
//				return stmt.executeUpdate();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return 0;
//		}
	
	
	
}
