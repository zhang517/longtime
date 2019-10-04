package jdbcdemo4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbcdemo4.dao.PetTypeDao;
import jdbcdemo4.entity.PetType;
import jdbcdemo4.util.BaseDao;

/**
 * PetDao针对MySQL数据库的实现类。
 */
public class PetTypeMySQLImpl extends BaseDao implements PetTypeDao {
 
	@Override
	public List<PetType> findPetType() {
		List<PetType> list=new ArrayList<PetType>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from pet_type";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PetType petType=new PetType();
				petType.setId(rs.getInt("id"));
				petType.setName(rs.getString("name"));
				list.add(petType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}
 
	@Override
	public int findIdByTypeName(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int id=0;
		try {
			conn = this.getConnection();
			String sql="select id from pet_type where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				id=rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return id;
	}
 
	@Override
	public int save(PetType petType) {
		// TODO Auto-generated method stub
		return 0;
	}
}
