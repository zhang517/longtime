package jdbcdemo5.dao;

import java.util.List;

import jdbcdemo5.entity.PetStore;

/**
 * @author Administrator
 * 宠物商店Dao
 */
public interface PetStoreDao {
	/**
	 * @return
	 * 查询所有宠物商店信息
	 */
	List<PetStore> getAllStore();
	
	/**
	 * 更新宠物商店信息：增加元宝数
	 * @param money
	 * @param petOwnerId
	 * @return
	 */
	public int addMoney(int money,int storeId);
	
	/**
	 * 更新宠物商店信息：减少元宝数
	 * @param money
	 * @param petOwnerId
	 * @return
	 */
	public int subMoney(int money,int storeId);
}
