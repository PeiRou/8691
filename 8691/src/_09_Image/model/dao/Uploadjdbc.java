package _09_Image.model.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _09_Image.model.UploadVO;

public class Uploadjdbc implements UploadDAO {
	private DataSource dataSource = null;
	public Uploadjdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/xxx");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String SELECT_ALL = "select * from products order by id asc";
	private static final String SELECT_BY_ID = "select * from products where id=?";
	private static final String UPDATE = "update products set photo=? where id=?";
	private static final String INSERT = "insert into products (id, photo) values (?, ?)";

	@Override
	public List<UploadVO> select() {
		List<UploadVO> result = null;
		ResultSet rset = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);) {
			rset = stmt.executeQuery();
			result = new ArrayList<UploadVO>();
			while(rset.next()) {
				UploadVO bean = new UploadVO();
				bean.setId(rset.getInt("id"));
				bean.setPhoto(rset.getBytes("photo"));
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;		
	}
	
	@Override
	public UploadVO select (int id){
		UploadVO result = null;
		ResultSet rset = null;
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {
			stmt.setInt(1, id);
			rset = stmt.executeQuery();
			if(rset.next()) {
				result = new UploadVO();
				result.setId(rset.getInt("id"));
				result.setPhoto(rset.getBytes("photo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;	
	}
	
	@Override
	public UploadVO update (UploadVO bean) {
		try(Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
				
				if(bean.getPhoto() != null && bean.getId() != 0) {
					stmt.setBytes(1, bean.getPhoto());
					stmt.setInt(2, bean.getId());
									
					int i = stmt.executeUpdate();
					System.out.println(i);
					if(i == 1) {
						System.out.println("update success!");
					}

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;			
	}
	
	@Override
	public UploadVO insert (UploadVO bean){
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(INSERT);) {
			
			if(bean!=null) {
				stmt.setInt(1, bean.getId());
				stmt.setBytes(2, bean.getPhoto());
								
				int i = stmt.executeUpdate();
				if(i==1) {
					return bean;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}	
}
