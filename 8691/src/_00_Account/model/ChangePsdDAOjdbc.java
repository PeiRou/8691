package _00_Account.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ChangePsdDAOjdbc{
//	private static final String URL = "jdbc:sqlserver://raab1str2m.database.windows.net:1433;database=DB02";
//	private static final String USERNAME = "eeit83team05@raab1str2m";
//	private static final String PASSWORD = "Sa123456";
	
	DataSource ds=null;
	public ChangePsdDAOjdbc(){
	try {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/8691");
	} catch (NamingException e) {
		e.printStackTrace();
	 }
	}
	
public static void main(String[] args) {
	
	ChangePsdDAOjdbc dao = new ChangePsdDAOjdbc();
//		select
//   AccountBean beanSelect = dao.select("Marcuslo@Foodmail.com");
//   System.out.println(beanSelect);
//	
//		update
//	dao.updatePsd("0000", "8219ED2A-C9FA-4F78-940A-2A8516E8BCD9");
//	System.out.println(dao);
//	
//		insert
//	    AccountBean beanIns = new AccountBean("Marcuslo@Foodmail.com", "111111", "201");
//	    dao.insert(beanIns);
//		System.out.println(beanIns);
	}


private static final String UPDATEPSD =
			"update Account set psd=? where account_UID=?";
public String updatePsd(
		String psd,
		String account_UID)
{
	String result = null;
		Connection conn = null;
		PreparedStatement psStrUpd = null;
		try {
			conn = ds.getConnection();
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			psStrUpd = conn.prepareStatement(UPDATEPSD);
			psStrUpd.setString(1, psd);
			psStrUpd.setString(2, account_UID);
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
}
	