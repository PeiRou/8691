package _05_Forum.model;

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

import _03_Orders.model.OrdersTotalBean;

public class ForumDAOJdbc {
	private static final String URL = "jdbc:sqlserver://raab1str2m.database.windows.net:1433;database=DB02";
	private static final String USERNAME = "eeit83team05@raab1str2m";
	private static final String PASSWORD = "Sa123456";
	
//	private DataSource dataSource = null;
//	public ForumDAO() {
//		try {
//			Context ctx = new InitialContext();
//			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) {
		String RD = UUID.randomUUID().toString();
		ForumDAOJdbc dao = new ForumDAOJdbc();
		
		//select  
//		ForumBean bean = dao.select("69C4D4DA-CA77-4468-BDA3-98B630EF84DD");
//		System.out.println(bean);
		
		//select all  
//		List<ForumBean> beans = dao.select();
//		System.out.println(beans);

		// insert    
//		ForumBean beanIns = new ForumBean(RD,"88433134-0610-4792-B5DD-3D0EB6B76097", "E8962DB1-8A44-4248-9BE1-2C7E08431D79", 1, "蘿蔔沒挑過，筋太多，失敗! 豬皮煮得太爛，沒咬頭，失敗!", new java.util.Date());
//		dao.insert(beanIns);
		
		//update  
//		ForumBean beanUpdate = dao.update(RD,"88433134-0610-4792-B5DD-3D0EB6B76097", 0, 
//				"蘿蔔沒挑過，筋太多，失敗! 豬皮煮得太爛，沒咬頭，失敗!最慘的就是大腸了，裏面根本沒洗乾淨，還有一坨屎", new java.util.Date(), "E8962DB1-8A44-4248-9BE1-2C7E08431D79");
//		System.out.println(beanUpdate);
		
		
		// delete    
//		int beanDel = dao.delete("");  //輸入Forum_UID
//		System.out.println(beanDel);
		
	}
	
private static final String SELECT = "select * from Forum where Forum_UID=?";
	public ForumBean select(String Forum_UID) {
		ForumBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT);

			stmt.setString(1, Forum_UID);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new ForumBean();
				result.setForum_UID(rset.getString("Forum_UID"));
				result.setOrders_total_UID(rset.getString("Orders_total_UID"));
				result.setMember_UID(rset.getString("Member_UID"));
				result.setRatting(rset.getInt("ratting"));
				result.setComment(rset.getString("comment"));
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
	
private static final String SELECT_ALL = "select * from Forum";
	public List<ForumBean> select() {
		List<ForumBean> items = new ArrayList<ForumBean>();
		ForumBean result = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();

			while (rset.next()) {
				result = new ForumBean();
				result.setForum_UID(rset.getString("Forum_UID"));
				result.setOrders_total_UID(rset.getString("Orders_total_UID"));
				result.setMember_UID(rset.getString("Member_UID"));
				result.setRatting(rset.getInt("ratting"));
				result.setComment(rset.getString("comment"));
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
	
private static final String INSERT = "insert into Forum (Forum_UID, Orders_total_UID, Member_UID, ratting, comment, insdate) values (?, ?, ?, ?, ?, ?)";
	public ForumBean insert(ForumBean bean) {
		ForumBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//conn = dataSource.getConnection();
			stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, bean.getForum_UID());
			stmt.setString(2, bean.getOrders_total_UID());			
			stmt.setString(3, bean.getMember_UID());
			stmt.setInt(4, bean.getRatting());
			stmt.setString(5, bean.getComment());
			java.util.Date insdate = bean.getInsdate();
			if (insdate != null) {
				long time = insdate.getTime();
				stmt.setDate(6, new java.sql.Date(time));
			} else {
				stmt.setDate(6, null);
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
	
private static final String UPDATE = "update Forum set Forum_UID=?, Orders_total_UID=?, ratting=?, comment=?, insdate=? where Member_UID=?";
	public ForumBean update(String Forum_UID, String Orders_total_UID, int ratting,
			String comment, Date insdate, String Member_UID) {
		Connection conn = null;
		PreparedStatement psStrUpd = null;
		ForumBean result = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//conn = dataSource.getConnection();
			psStrUpd = conn.prepareStatement(UPDATE);
			psStrUpd.setString(1, Forum_UID);
			psStrUpd.setString(2, Orders_total_UID);
			psStrUpd.setInt(3, ratting);
			psStrUpd.setString(4, comment);
			if (insdate != null) {
				long time = insdate.getTime();
				psStrUpd.setDate(5, new java.sql.Date(time));
			} else {
				psStrUpd.setDate(5, null);
			}
			psStrUpd.setString(6, Member_UID);

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
	
private static final String DELETE = "delete from Forum where Forum_UID=?";
	
	public int delete(String Forum_UID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			//conn = dataSource.getConnection();
			stmt = conn.prepareStatement(DELETE);			
			stmt.setString(1, Forum_UID);
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