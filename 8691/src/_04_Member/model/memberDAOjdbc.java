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

public class memberDAOjdbc implements MemberDAO {
//	private static final String URL = "jdbc:sqlserver://l1r87zexza.database.windows.net:1433;database=DB02";
//	private static final String USERNAME = "staebooksuser@l1r87zexza";
//	private static final String PASSWORD = "Sa123456";
	
	DataSource ds=null;
	public memberDAOjdbc(){
	try {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/8691");
	} catch (NamingException e) {
		e.printStackTrace();
	 }
	}
	public static void main(String[] args){
		MemberDAO dao = new memberDAOjdbc();
	//	select
	 //   MemberBean beanSelect = dao.select("0");
	//	System.out.println(beanSelect);}

		//select all
		List<MemberBean> SelectAll = dao.select();
		System.out.println(SelectAll);}
		
//      insert
//	    MemberBean beanIns = new MemberBean(
//      "7", "bc", "01@hotmail.com", "zzzzz","YYYYY",true,"0204388488","DFGDFSG","ESWFEWFEfe","EWFEWFFEWF","djdjhjd","fsafdasfa","afdsafsfas", new java.util.Date());
//	    dao.insert(beanIns);
//		System.out.println(beanIns);
		
//      update
//		MemberBean update = dao.update("name","acc_email","pwd",
//				"member_photo",true,"tel","GUAR_CT",
//				"GUAR_AR","NB_CODE","GUAR_NO",(""),
//				"cel", new java.util.Date(), "11");
//		         System.out.println(update);

//      delete	
//		int beanDel = dao.delete("11");
//		System.out.println(beanDel);
//	}
	private static final String SELECT_BY_ID = "select * from member where member_id=?";
	
	@Override
	public MemberBean select(String Member_ID) {
		Connection conn = null;
		MemberBean result = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		try {
            conn = ds.getConnection();	
			pstmt = conn.prepareStatement(SELECT_BY_ID); {
			pstmt.setString(1, Member_ID);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = new MemberBean();
				result.setMember_ID(rset.getString("Member_ID"));
				result.setName(rset.getString("name"));
				result.setAcc_email(rset.getString("acc_email"));
				result.setPsd(rset.getString("psd"));
				result.setMember_photo(rset.getBlob("member_photo"));
				result.setGender(rset.getString("gender"));
				result.setTel(rset.getString("tel"));
				result.setGUAR_CT(rset.getString("GUAR_CT"));
				result.setGUAR_AR(rset.getString("GUAR_AR"));
				result.setGUAR_ROAD(rset.getString("NB_CODE"));
				result.setGUAR_NO(rset.getString("GUAR_NO"));
				result.setEmail2(rset.getString("Email2"));
				result.setCel(rset.getString("Cel"));
				result.setInsdate(rset.getDate("insdate"));}
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
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();

			while(rset.next()){
				result = new MemberBean();
				result.setMember_ID(rset.getString("Member_ID"));
				result.setName(rset.getString("name"));
				result.setAcc_email(rset.getString("acc_email"));
				result.setPsd(rset.getString("psd"));
				result.setMember_photo(rset.getBlob("Member_photo"));
				result.setGender(rset.getString("gender"));
				result.setTel(rset.getString("tel"));
				result.setGUAR_CT(rset.getString("GUAR_CT"));
				result.setGUAR_AR(rset.getString("GUAR_AR"));
				result.setGUAR_ROAD(rset.getString("NB_CODE"));
				result.setGUAR_NO(rset.getString("GUAR_NO"));
				result.setEmail2(rset.getString("email2"));
				result.setCel(rset.getString("cel"));
				result.setInsdate(rset.getDate("insdate"));
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
			"update member set name=?, acc_email=?, psd=?, Member_photo=?, gender=?, tel=?, GUAR_CT=?, GUAR_AR=?, GUAR_ROAD=?, GUAR_NO=?, email2=?, cel=?, insdate=? where Member_ID=?";

@Override
public MemberBean update(
		String name,
		String acc_email,
		String psd,
		Blob Member_photo,
		String gender,
		String tel,
		String GUAR_CT,
		String GUAR_AR,
		String GUAR_ROAD,
		String GUAR_NO,
		String email2,
		String cel,
		java.util.Date insdate,
		String Member_ID)
{
	MemberBean result = null;
		Connection conn = null;
		PreparedStatement psStrUpd = null;
		try {
			conn = ds.getConnection();
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			psStrUpd = conn.prepareStatement(UPDATE);
			
			psStrUpd.setString(1, name);
			psStrUpd.setString(2, acc_email);
			psStrUpd.setString(3, psd);
			psStrUpd.setBlob(4, Member_photo);
			psStrUpd.setString(5, gender);
			psStrUpd.setString(6, tel);
			psStrUpd.setString(7, GUAR_CT);
			psStrUpd.setString(8, GUAR_AR);
			psStrUpd.setString(9, GUAR_ROAD);
			psStrUpd.setString(10, GUAR_NO);
			psStrUpd.setString(11, email2);
			psStrUpd.setString(12, cel);
			if (insdate != null) {
				long time = insdate.getTime();
				psStrUpd.setDate(13, new java.sql.Date(time));
			} else {
				psStrUpd.setDate(13, null);
			}
			psStrUpd.setString(14, Member_ID);
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
			"insert into member (Member_UID, Member_ID, name, acc_email, pwd, member_photo, gender, tel, GUAR_CT,GUAR_AR,NB_CODE, GUAR_NO, email2, cel, insdate) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public MemberBean insert(MemberBean bean) {
		MemberBean result = null;
		Connection conn = null;
		PreparedStatement psStrUpd = null;
		try {
			//conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = ds.getConnection();
			psStrUpd = conn.prepareStatement(INSERT);
			psStrUpd.setString(1, bean.getMember_ID());
			psStrUpd.setString(2, bean.getName());
			psStrUpd.setString(3, bean.getAcc_email());
			psStrUpd.setString(4, bean.getPsd());
			psStrUpd.setBlob(5, bean.getMember_photo());
			psStrUpd.setString(6, bean.getGender());
			psStrUpd.setString(7, bean.getTel());
			psStrUpd.setString(8, bean.getGUAR_CT());
			psStrUpd.setString(9, bean.getGUAR_AR());
			psStrUpd.setString(10, bean.getGUAR_ROAD());
			psStrUpd.setString(11, bean.getGUAR_NO());
			psStrUpd.setString(12, bean.getEmail2());
			psStrUpd.setString(13, bean.getCel());
			if (bean.getInsdate() != null) {
				long time = bean.getInsdate().getTime();
				psStrUpd.setDate(14, new java.sql.Date(time));
			} else {
				psStrUpd.setDate(14, null);
			}
			
			int i = psStrUpd.executeUpdate();
			if(i==1){
				result = select(bean.getMember_ID());
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
	
	private static final String DELETE = "delete from member where Member_ID=?";

	@Override
	public int delete(String Member_ID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			//conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			conn = ds.getConnection();
			stmt = conn.prepareStatement(DELETE);
			stmt.setString(1, Member_ID);
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