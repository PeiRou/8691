package _06_Seller.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.json.JSONObject;

public class _06_Sellerjdbc {	
	private DataSource dataSource;
	
	public _06_Sellerjdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/8691");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private final String SELECT_BY_UID = "select * from seller_visitor a join image p on p.image_ID = a.seller_photo join Address_CT b on a.GUAR_CT = b.GUAR_CT join Address_AR c on a.GUAR_AR = C.GUAR_AR join Address_ROAD d on a.GUAR_ROAD = d.GUAR_ROAD where account_UID = ?";
	public List select(String accountUID) {
		List JSONObjectList = null;
		ResultSet rset = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_UID);
			) {
			stmt.setString(1, accountUID);
			rset = stmt.executeQuery();
		
			JSONObjectList = new LinkedList();
			while(rset.next()) {
				JSONObject obj = new JSONObject();				
				obj.put("FEIN", rset.getString("FEIN"));
				obj.put("name", rset.getString("name"));
				obj.put("SellerPhoto", rset.getString("Seller_photo"));
				obj.put("ImageURL", rset.getString("Image_URL"));
				obj.put("tel", rset.getString("tel"));
				obj.put("GUARCT", rset.getString("GUAR_CT"));
				obj.put("GUARAR", rset.getString("GUAR_AR"));
				obj.put("GUARROAD", rset.getString("GUAR_ROAD"));
				obj.put("GuarCTName", rset.getString("GUAR_CT_name"));
				obj.put("GuarARName", rset.getString("GUAR_AR_name"));
				obj.put("GuarROADName", rset.getString("GUAR_ROAD_name"));
				obj.put("GUARNO", rset.getString("GUAR_NO"));
				obj.put("email2", rset.getString("email2"));
				obj.put("ConName", rset.getString("Con_name"));
				obj.put("ConCel", rset.getString("Con_cel"));
				obj.put("ReceiptsMetho", rset.getString("receipts_metho"));
				obj.put("SellerStatus", rset.getString("Seller_status"));
				obj.put("shipPrice", rset.getString("ship_price"));
				obj.put("LowestPrice", rset.getString("lowest_price"));
				JSONObjectList.add(obj);
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
		}
		return JSONObjectList;
	}	
	
	private final String SELECT_CATCH_STORE_NAME = "select name from seller_visitor where account_UID = ?";
	public String selectCatchName(String accountUID) {
		String rult = null;
		ResultSet rset = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_CATCH_STORE_NAME);
			) {
			stmt.setString(1, accountUID);
			rset = stmt.executeQuery();
					
			if(rset.next()) {
				rult = rset.getString("name");
				System.out.println("name:"+rset.getString("name"));
				return rult;
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
		}
		return null;
	}	
	
	private final String UPDATE = "update Prod_status_class3 set Prod_status_class3_name=?,Prod_status_class3_price=? where Prod_status_class3_ID=?";
	public int update(JSONObject JsonData){
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {				
				if(JsonData.getString("ProdStatusClass3ID") != "") {
					stmt.setString(1,JsonData.getString("ProdStatusClass3Name"));
					stmt.setString(2,JsonData.getString("ProdStatusClass3Price"));
					stmt.setString(3,JsonData.getString("ProdStatusClass3ID"));
					int i = stmt.executeUpdate();
					if(i == 1) {
						return i;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}
	
	private final String INSERT = "insert into Prod_status_class3(Prod_status_class2_ID,Prod_status_class3_name,Prod_status_class3_price) values(?,?,?)";
	public int insert(JSONObject JsonData){
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);) {				
				if(JsonData.getString("ProdStatusClass2ID") != "") {
					stmt.setString(1,JsonData.getString("ProdStatusClass2ID"));
					stmt.setString(2,JsonData.getString("ProdStatusClass3Name"));
					stmt.setString(3,JsonData.getString("ProdStatusClass3Price"));
					stmt.executeUpdate();
					ResultSet rs = stmt.getGeneratedKeys();
				    if(rs.next()){
				    	return rs.getInt(1);
				    }
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}
}
