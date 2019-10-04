package jdbcdemo5.service;

import java.util.List;

import jdbcdemo5.entity.Pet;
import jdbcdemo5.entity.PetStore;

/**
 * @author Administrator
 * 宠物商店Dao
 */
public interface PetStoreService {
	/**
	 * @return
	 * 查询所有宠物商店信息
	 */
	List<PetStore> getAllStore();
	
	/**
	 * 查询所有宠物信息
	 * @return
	 */
	List<Pet>  getAllPet();
	
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
	

}
