package _03_Orders.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import _03_Orders.model.OrdersDetailBean;
import _03_Orders.model.OrdersTotalBean;

public class OrdersDetailJDBC {
	private static final String URL = "jdbc:sqlserver://l1r87zexza.database.windows.net:1433;database=DB02";
	private static final String USERNAME = "staebooksuser@l1r87zexza";
	private static final String PASSWORD = "Sa123456";

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

private static final String SELECT = "select * from Orders_detail where Orders_detail_UID=?";

	
	public OrdersDetailBean select(String Orders_detail_UID) {
		OrdersDetailBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(SELECT);

			stmt.setString(1, Orders_detail_UID);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new OrdersDetailBean();
				result.setOrders_detail_UID(rset.getString("Orders_detail_UID"));
				result.setOrders_ID(rset.getString("Orders_ID"));
				result.setFood_ID(rset.getInt("Food_ID"));
				result.setDrink_name(rset.getString("Drink_name"));
				result.setFood_count(rset.getInt("Food_count"));
				result.setFood_original_price(rset.getInt("Food_original_price"));
				result.setNote(rset.getString("Note"));
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

	private static final String SELECT_ALL = "select * from Orders_detail";

	
	public List<OrdersDetailBean> select() {
		List<OrdersDetailBean> items = new ArrayList<OrdersDetailBean>();
		OrdersDetailBean result = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();

			while (rset.next()) {
				result = new OrdersDetailBean();
				result.setOrders_detail_UID(rset.getString("Orders_detail_UID"));
				result.setOrders_ID(rset.getString("Orders_ID"));
				result.setFood_ID(rset.getInt("Food_ID"));
				result.setDrink_name(rset.getString("Drink_name"));
				result.setFood_count(rset.getInt("Food_count"));
				result.setFood_original_price(rset.getInt("Food_original_price"));
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

	private static final String INSERT = "insert into Orders_detail (Orders_detail_UID, Orders_ID, Food_ID, Drink_name, Food_count, Food_original_price, Note) values (?, ?, ?, ?, ?, ?, ?)";

	
	public OrdersDetailBean insert(OrdersDetailBean bean) {
		OrdersDetailBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, bean.getOrders_detail_UID());
			stmt.setString(2, bean.getOrders_ID());			
			stmt.setInt(3, bean.getFood_ID());
			stmt.setString(4, bean.getDrink_name());
			stmt.setInt(5, bean.getFood_count());
			stmt.setInt(6, bean.getFood_original_price());
			stmt.setString(7, bean.getNote());			

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

	private static final String UPDATE = "update Orders_detail set Orders_ID=?, Food_ID=?, Drink_name=?, Food_count=?, Food_original_price=?, Note=? where orders_detail_UID=?";

	
	public boolean update(String orders_ID, int food_ID, String drink_name, int food_count,
			int food_original_price, String note, String orders_detail_UID) {
		Connection conn = null;
		PreparedStatement psStrUpd = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			psStrUpd = conn.prepareStatement(UPDATE);
			psStrUpd.setString(1, orders_ID);
			psStrUpd.setInt(2, food_ID);
			psStrUpd.setString(3, drink_name);
			psStrUpd.setInt(4, food_count);
			psStrUpd.setInt(5, food_original_price);
			psStrUpd.setString(6, note);
			psStrUpd.setString(7, orders_detail_UID);
			

			int i = psStrUpd.executeUpdate();
			if (i == 1) {
				System.out.println("UPDATE Success!");
				// return true;
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
		return false;
	}
	
	
	
	private static final String DELETE = "delete from Orders_detail where Orders_detail_UID=?";
	
	public int delete(String Orders_detail_UID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			stmt = conn.prepareStatement(DELETE);			
			stmt.setString(1, Orders_detail_UID);
			int i = stmt.executeUpdate();
			if(i==1){
				System.out.println("DELETE Success!");
				//return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
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
