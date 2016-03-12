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
		
		// insert    
//		OrdersDetailBean beanIns = new OrdersDetailBean(RD,"2016010004", 304, "綠茶(小)", 1, 20, "半糖少冰");
//		dao.insert(beanIns);

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


	private static final String INSERT = "insert into Orders_detail (Orders_detail_UID, ordersID, Food_ID, Drink_name, quantity, originalPrice, note) values (NEWID(), ?, ?, ?, ?, ?, ?)";

	
	public OrdersDetailBean insert(OrdersDetailBean bean) {
		OrdersDetailBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(INSERT);
			stmt.setInt(1, bean.getOrdersID());
			stmt.setInt(2, bean.getFood_ID());
			stmt.setString(3, bean.getDrink_name());
			stmt.setInt(4, bean.getQuantity());
			stmt.setInt(5, bean.getOriginalPrice());
			stmt.setString(6, bean.getNote());			
			int i = stmt.executeUpdate();
			if (i == 1) {
				System.out.println("Orders_detail INSERT Success!");				
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
}
