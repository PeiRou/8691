package _04_Member.model;

import java.sql.*;
import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import _04_Member.model.MemberBean;
import _04_Member.model.MemberDAO;

public class MemberDAOjdbc implements MemberDAO {
//	private static final String URL = "jdbc:sqlserver://raab1str2m.database.windows.net:1433;database=DB02";
//	private static final String USERNAME = "eeit83team05@raab1str2m";
//	private static final String PASSWORD = "Sa123456";
	
	DataSource ds=null;
	public MemberDAOjdbc(){
	try {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/8691");
	} catch (NamingException e) {
		e.printStackTrace();
	 }
	}
	
	public static void main(String[] args){
//		MemberDAOjdbc dao = new MemberDAOjdbc();
//		select
//	    MemberBean beanSelect = dao.select("87B6061E-4C34-4F1A-843F-032EC7D44125");
//		System.out.println(beanSelect);

		//select all
//		List<MemberBean> SelectAll = dao.select();
//		System.out.println(SelectAll);
		
//      insert
//	    MemberBean beanIns = new MemberBean("117EA040-ECA2-4B05-A70D-9EFEA6346796","Marcus wo", "男", "7782406836","A","106","110","1號1樓","Marcuswo@Foodmail.com","0910111111");
//	                                                      account_UID, member_ID, name, gender, tel, GUAR_CT, GUAR_AR, GUAR_ROAD, GUAR_NO, email2, cel, insdate
//	    dao.insert(beanIns);
//		System.out.println(beanIns);
		
//      update
//		MemberBean update = dao.update("Marcus Lo",null,"男","7782406836","A","106","110","1號1樓","Marcuslo@Foodmail.com","0910111111",null,"46886F5D-34AE-4F43-9CB5-79BF388535A6");
//		                                System.out.println(update);
//      delete	
//		int beanDel = dao.delete("11");
//		System.out.println(beanDel);
	}
	private static final String SELECT_BY_account_UID = "select * from member where account_UID=?";
	
	@Override
	public MemberBean select(String account_UID) {
		Connection conn = null;
		MemberBean result = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		try {
            conn = ds.getConnection();	
			pstmt = conn.prepareStatement(SELECT_BY_account_UID); {
			pstmt.setString(1, account_UID);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = new MemberBean();
				result.setAccount_UID(rset.getString("account_UID"));
				result.setName(rset.getString("name"));
				result.setMember_photo(rset.getString("member_photo"));
				result.setGender(rset.getString("gender"));
				result.setTel(rset.getString("tel"));
				result.setGUAR_CT(rset.getString("GUAR_CT"));
				result.setGUAR_AR(rset.getString("GUAR_AR"));
				result.setGUAR_ROAD(rset.getString("GUAR_ROAD"));
				result.setGUAR_NO(rset.getString("GUAR_NO"));
				result.setEmail2(rset.getString("email2"));
				result.setCel(rset.getString("Cel"));
				result.setInsdate(rset.getString("insdate"));}
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
		return result;
	}
	

	private static final String SELECT_ALL = "select * from Member";
	@Override
	public List<MemberBean> select() {		
		List<MemberBean> items = new ArrayList<MemberBean>();
		MemberBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		
		try {//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();

			while(rset.next()){
				result = new MemberBean();
				result.setName(rset.getString("name"));
				result.setMember_photo(rset.getString("member_photo"));
				result.setGender(rset.getString("gender"));
				result.setTel(rset.getString("tel"));
				result.setGUAR_CT(rset.getString("GUAR_CT"));
				result.setGUAR_AR(rset.getString("GUAR_AR"));
				result.setGUAR_ROAD(rset.getString("GUAR_ROAD"));
				result.setGUAR_NO(rset.getString("GUAR_NO"));
				result.setEmail2(rset.getString("email2"));
				result.setCel(rset.getString("cel"));
				result.setInsdate(rset.getString("insdate"));
				items.add(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
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
				
	private static final String UPDATE =
			"update Member set name=?, member_photo=?,gender=?, tel=?, GUAR_CT=?, GUAR_AR=?, GUAR_ROAD=?, GUAR_NO=?, email2=?, cel=? where account_UID=?";
// 
@Override
public MemberBean update(
		String name,
		String member_photo,
		String gender,
		String tel,
		String GUAR_CT,
		String GUAR_AR,
		String GUAR_ROAD,
		String GUAR_NO,
		String email2,
		String cel,
		//java.util.Date insdate,
		String account_UID)
{
	MemberBean result = null;
		Connection conn = null;
		PreparedStatement psStrUpd = null;
		try {
			conn = ds.getConnection();
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			psStrUpd = conn.prepareStatement(UPDATE);
			psStrUpd.setString(1, name);
			psStrUpd.setString(2, member_photo);
			psStrUpd.setString(3, gender);
			psStrUpd.setString(4, tel);
			psStrUpd.setString(5, GUAR_CT);
			psStrUpd.setString(6, GUAR_AR);
			psStrUpd.setString(7, GUAR_ROAD);
			psStrUpd.setString(8, GUAR_NO);
			psStrUpd.setString(9, email2);
			psStrUpd.setString(10, cel);
//			if (insdate != null) {
//				long time = insdate.getTime();
//				psStrUpd.setDate(11, new java.sql.Date(time));
//			} else {
//				psStrUpd.setDate(11, null);
//			}
			psStrUpd.setString(11, account_UID);
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
			"insert into member (account_UID, name, member_photo, gender, tel, GUAR_CT, GUAR_AR, GUAR_ROAD, GUAR_NO, email2, cel, insdate) values (?, ?, '', ?, ?, ?, ?, ?, ?, ?, ?, ?)";
// 
	@Override
	public MemberBean insert(MemberBean bean1) {
		MemberBean result = null;
		Connection conn = null;
		PreparedStatement psStrUpd = null;
		try {
			conn = ds.getConnection();
			psStrUpd = conn.prepareStatement(INSERT);
			psStrUpd.setString(1, bean1.getAccount_UID());
			psStrUpd.setString(2, bean1.getName());
			//psStrUpd.setString(4, bean1.getMember_photo());
			psStrUpd.setString(3, bean1.getGender());
			psStrUpd.setString(4, bean1.getTel());
			psStrUpd.setString(5, bean1.getGUAR_CT());
			psStrUpd.setString(6, bean1.getGUAR_AR());
			psStrUpd.setString(7, bean1.getGUAR_ROAD());
			psStrUpd.setString(8, bean1.getGUAR_NO());
			psStrUpd.setString(9, bean1.getEmail2());
		    psStrUpd.setString(10, bean1.getCel());
		    psStrUpd.setString(11, bean1.getInsdate());
		   
			int i = psStrUpd.executeUpdate();
			if(i==1){
				result = select(bean1.getAccount_UID());
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
	
	private static final String DELETE = "delete from member where Account_UID=?";

	@Override
	public int delete(String Account_UID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			//conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			conn = ds.getConnection();
			stmt = conn.prepareStatement(DELETE);
			stmt.setString(1, Account_UID);
			int i = stmt.executeUpdate();
			if(i==1){
				System.out.println("DELETE sucessfully!");
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