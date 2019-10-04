package jdbcdemo5.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbcdemo5.dao.PetStoreDao;
import jdbcdemo5.entity.PetStore;
import jdbcdemo5.util.BaseDao;

public class PetStoreDaoImpl  extends BaseDao implements PetStoreDao{

	@Override
	public List<PetStore> getAllStore() {
		List<PetStore> list=new ArrayList<PetStore>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from petstore";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PetStore petStore=new PetStore();
			    
				petStore.setId(rs.getInt(1));
				petStore.setName(rs.getString(2));
				
				list.add(petStore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	
	@Override
	public int addMoney(int money,int storeId) {	
		String sql="update petstore set balance=balance+"+money+" where id=?";
		
		Object[] param={storeId};
		
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
	
	@Override
	public int subMoney(int money,int storeId) {	
		String sql="update petstore set balance=balance-"+money+" where id=?";
		
		Object[] param={storeId};
		
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
}
