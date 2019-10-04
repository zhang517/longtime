package jdbcdemo5.dao;

import java.util.List;

import jdbcdemo5.entity.Pet;

/**
 * @author Administrator
 * 宠物Dao
 */
public interface PetDao {
	/**
	 * 查询所有宠物信息
	 * @return
	 */
	List<Pet> getAllPet();  
	
	/**
	 * 查询库存宠物
	 * 库存的宠物 
     *  ---是指pet表中owner_id为空的记录
	 * @return
	 */
	List<Pet> getStockPet();
	
	/**
	 * 新培育的库存宠物
     * ---是指pet表中owner_id为空 且 typename不是dog、penguin的宠物
	 * @return
	 */
	List<Pet> getNewPet();
	
	/**
	 * 查询指定的宠物
	 * @param petId
	 * @return
	 */
	public Pet getPetById(int petId);
	
	
	/**
	 * 更新宠物
	 * @param pet
	 * @return
	 */
	public int update(Pet pet);
}
