package jdbcdemo4.dao.impl;

import java.util.List;

import jdbcdemo4.dao.PetDao;
import jdbcdemo4.entity.Pet;
import jdbcdemo4.util.BaseDao;

/**
 * PetDao针对MySQL数据库的实现类。
 */
public class PetDaoMySQLImpl extends BaseDao implements PetDao{
	public int update(Pet pet) {	
		String sql="update pet set master_id=?,name=?,"
				+ " type_id=?,health=?,love=?,"
				+ " adopt_time=?,status=?"
				+ " where id=?";
		
		Object[] param={pet.getMasterId(),pet.getName(),
				pet.getTypeId(),pet.getHealth(),
				pet.getLove(),pet.getAdoptTime(),
				pet.getStatus(),pet.getId()};
		
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
 
	@Override
	public List<Pet> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public Pet getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Pet> findByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public int save(Pet pet) {
		String sql
		   ="INSERT INTO pet (master_id,name,type_id,health,love,adopt_time)" +
                "VALUES (?,?,?,?,?,?)";  
		
		Object[] param={pet.getMasterId(),pet.getName(),
				pet.getTypeId(),pet.getHealth(),
				pet.getLove(),pet.getAdoptTime()};
		
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
 
	@Override
	public int del(Pet pet) {
		// TODO Auto-generated method stub
		return 0;
	}

}
