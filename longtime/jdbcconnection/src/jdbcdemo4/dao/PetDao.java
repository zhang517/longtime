package jdbcdemo4.dao;

import java.util.List;

import jdbcdemo4.entity.Pet;

/**
 * 宠物Dao接口。
 */
public interface PetDao {
	/**
	  * 保存宠物。
	  * @param pet 宠物
	  */
	 int save(Pet pet);
	/**
	 * 删除宠物。
	 * @param pet 宠物
	 */
	 int del(Pet pet);
	/**
	 * 更新宠物。
	 * @param pet 宠物
	 */
	int update(Pet pet);
	 /**
	 * 获取指定昵称的宠物,精确查询。
	 * @param name 昵称
	 * @return 宠物
	 */
	Pet getByName(String name);
	/**
	 * 获取指定昵称的宠物列表,模糊查询。
	 * @param name 昵称
	 * @return 宠物列表
	 */
	List<Pet> findByName(String name);
	/**
	 * 获取指定类型的宠物列表。
	 * @param type 宠物类型
	 * @return 宠物列表
	 */
	List<Pet> findByType(String type);

}
