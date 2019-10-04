package jdbcdemo5.dao;

import java.util.List;

import jdbcdemo5.entity.PetOwner;

/**
 * @author Administrator
 * 宠物主人Dao
 */
public interface PetOwnerDao {

	/**
	 * 查询所有宠物主人信息
	 * @return
	 */
	List<PetOwner>  getAllOwner();
		
	/**
	 * 查询指定的宠物主人
	 * @param name
	 * @param password
	 * @return
	 */
	PetOwner selectOwner(String name,String password);
	
	/**
	 * 根据ID查找
	 * @param petId
	 * @return
	 */
	public PetOwner getOwnerById(int petId);
	
	/**
	 * 更新宠物主人信息：增加元宝数
	 * @param money
	 * @param petOwnerId
	 * @return
	 */
	public int addMoney(int money,int petOwnerId);
	
	/**
	 * 更新宠物主人信息：减少元宝数
	 * @param money
	 * @param petOwnerId
	 * @return
	 */
	public int subMoney(int money,int petOwnerId);
	
}
