package jdbcdemo5.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbcdemo5.dao.PetOwnerDao;
import jdbcdemo5.entity.Pet;
import jdbcdemo5.entity.PetOwner;
import jdbcdemo5.util.BaseDao;

public class PetOwnerDaoImpl extends BaseDao implements PetOwnerDao {

	@Override
	public List<PetOwner> getAllOwner() {
		List<PetOwner> list=new ArrayList<PetOwner>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from petowner";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PetOwner petOwner=new PetOwner();
			    
				petOwner.setId(rs.getInt(1));
				petOwner.setName(rs.getString(2));
				
				list.add(petOwner);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}
	
	@Override
	public PetOwner selectOwner(String name,String password){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from petowner where name = ? and password = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				PetOwner petOwner = new PetOwner();
				petOwner.setId(rs.getInt(1));
				petOwner.setName(rs.getString(2));
				petOwner.setPassword(rs.getString(3));
				petOwner.setMoney(rs.getInt(4));
				
				return petOwner;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		
		return null;
	}
	
	@Override
	public PetOwner getOwnerById(int petId){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from petowner where id = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, petId);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				PetOwner petOwner = new PetOwner();
				petOwner.setId(rs.getInt(1));
				petOwner.setName(rs.getString(2));
				petOwner.setPassword(rs.getString(3));
				petOwner.setMoney(rs.getInt(4));
				
				return petOwner;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		
		return null;
	}
	
	@Override
	public int addMoney(int money,int petOwnerId) {	
		String sql="update petowner set money=money+"+money+" where id=?";
		
		Object[] param={petOwnerId};
		
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
	
	@Override
	public int subMoney(int money,int petOwnerId) {	
		String sql="update petowner set money=money-"+money+" where id=?";
		
		Object[] param={petOwnerId};
		
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

}
