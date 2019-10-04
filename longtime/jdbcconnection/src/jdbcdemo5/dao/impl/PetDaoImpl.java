package jdbcdemo5.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbcdemo5.dao.PetDao;
import jdbcdemo5.entity.Pet;
import jdbcdemo5.util.BaseDao;

public class PetDaoImpl extends BaseDao implements PetDao{
	
	//下层调用上层----禁止这样写
	//private PetService petService = new PetServiceImpl();

	@Override
	public List<Pet> getAllPet() {
		List<Pet> list=new ArrayList<Pet>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from pet";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Pet pet=new Pet();
			    
				pet.setId(rs.getInt(1));
				pet.setName(rs.getString(2));
				pet.setTypeName(rs.getString(3));
				
				list.add(pet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}
	
	@Override
	public List<Pet> getStockPet() {
		List<Pet> list=new ArrayList<Pet>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from pet where owner_id is null";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Pet pet=new Pet();
			    
				pet.setId(rs.getInt(1));
				pet.setName(rs.getString(2));
				pet.setTypeName(rs.getString(3));
				
				list.add(pet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}
	
	@Override
	public List<Pet> getNewPet() {
		List<Pet> list=new ArrayList<Pet>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from pet where owner_id is null and typename not in('dog','penguin')";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Pet pet=new Pet();
			    
				pet.setId(rs.getInt(1));
				pet.setName(rs.getString(2));
				pet.setTypeName(rs.getString(3));
				
				list.add(pet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}
	
	@Override
	public Pet getPetById(int petId) {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from pet where id=?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, petId);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Pet pet=new Pet();
			    
				pet.setId(rs.getInt(1));
				pet.setName(rs.getString(2));
				pet.setTypeName(rs.getString(3));
				pet.setHealth(rs.getInt(4));
				pet.setLove(rs.getInt(5));
				pet.setBirthday(rs.getDate(6));
				pet.setOwnerId(rs.getInt(7));
				pet.setStoreId(rs.getInt(8));
				
				return pet;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		
		return null;
	}
	
	@Override
	public int update(Pet pet) {	
		String sql="update pet set name=?,typeName=?,"
				+ " health=?,love=?,birthday=?,"
				+ " owner_id=?,store_id=?"
				+ " where id=?";
		
		Object[] param={pet.getName(),pet.getTypeName(),
				pet.getHealth(),pet.getLove(),
				pet.getBirthday(),pet.getOwnerId(),
				pet.getStoreId(),pet.getId()};
		
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
	
}
