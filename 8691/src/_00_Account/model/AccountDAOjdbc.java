package _00_Account.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AccountDAOjdbc implements AccountDAO {
//	private static final String URL = "jdbc:sqlserver://raab1str2m.database.windows.net:1433;database=DB02";
//	private static final String USERNAME = "eeit83team05@raab1str2m";
//	private static final String PASSWORD = "Sa123456";
	
	DataSource ds=null;
	public AccountDAOjdbc(){
	try {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/8691");
	} catch (NamingException e) {
		e.printStackTrace();
	 }
	}
	
	
public static void main(String[] args) {
	
	//AccountDAOjdbc dao = new AccountDAOjdbc();
//		select
//   AccountBean beanSelect = dao.select("Marcuslo@Foodmail.com");
//   System.out.println(beanSelect);
//	
//		update
	//AccountBean update = dao.update("aaaa", "Marcuslo@Foodmail.com");
	//System.out.println(update);
//	
//		insert
//	    AccountBean beanIns = new AccountBean("Marcuslo@Foodmail.com", "111111", "201");
//	    dao.insert(beanIns);
//		System.out.println(beanIns);
	}

private static final String FindRoleID = "select account_UID ,role_ID from Account where acc_email=?";
	
	@Override
	public AccountBean selectRoleID(String acc_email) {
		Connection conn = null;
		AccountBean result = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		try {//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            conn = ds.getConnection();	
			pstmt = conn.prepareStatement(FindRoleID); {
			pstmt.setString(1, acc_email);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = new AccountBean();
				result.setAccount_UID(rset.getString("account_UID"));
				result.setRole_ID(rset.getString("role_ID"));
				return result;
				}
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
			if (pstmt != null) {
				try {
					pstmt.close();
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
		return null;
	}
	
private static final String SELECT_by_acc_email = "select account_UID ,psd ,role_ID from Account where acc_email=?";
	
	@Override
	public AccountBean select(String acc_email) {
		Connection conn = null;
		AccountBean result = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		try {//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            conn = ds.getConnection();	
			pstmt = conn.prepareStatement(SELECT_by_acc_email); {
			pstmt.setString(1, acc_email);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = new AccountBean();
				result.setAccount_UID(rset.getString("account_UID"));
				result.setPsd(rset.getString("psd"));
				result.setRole_ID(rset.getString("role_ID"));
				return result;
				}
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
			if (pstmt != null) {
				try {
					pstmt.close();
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
		return null;
	}
	
	
	private static final String UPDATE =
			"update Account set account_UID=?, psd=?, role_ID=? where acc_email=?";
@Override
public AccountBean update(
		String account_UID,
		String psd,
		String role_ID,
		String acc_email)
{
	AccountBean result = null;
		Connection conn = null;
		PreparedStatement psStrUpd = null;
		try {
			conn = ds.getConnection();
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			psStrUpd = conn.prepareStatement(UPDATE);
			psStrUpd.setString(1, account_UID);
			psStrUpd.setString(2, psd);
			psStrUpd.setString(3, role_ID);
//			if (insdate != null) {
//				long time = insdate.getTime();
//				psStrUpd.setDate(11, new java.sql.Date(time));
//			} else {
//				psStrUpd.setDate(11, null);
//			}
			psStrUpd.setString(4, acc_email);
			
			int i = psStrUpd.executeUpdate();
			if(i==1){
				System.out.println(result);
				return result;
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
	

	private static final String INSERT =
			"insert into Account (acc_email, psd, role_ID) values (?, ?, ?)";

@Override
	public AccountBean insert(AccountBean bean) {
	AccountBean result = null;
	Connection conn = null;
	PreparedStatement psStrUpd = null;
	try {
		//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		conn = ds.getConnection();
		psStrUpd = conn.prepareStatement(INSERT);
		psStrUpd.setString(1, bean.getAcc_email());
		psStrUpd.setString(2, bean.getPsd());
		psStrUpd.setString(3, bean.getRole_ID());
		//if (bean.getInsdate() != null) {
		//	long time = bean.getInsdate().getTime();
		//	psStrUpd.setDate(3, new java.sql.Date(time));
		//}

		int i = psStrUpd.executeUpdate();
		if(i==1){
	result = select(bean.getAcc_email());
	return result;
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

		}