package jdbcdemo4.dao;

import java.util.List;

import jdbcdemo4.entity.PetType;

/**
 * 宠物类型Dao接口。
 */
public interface PetTypeDao {
	/**
	 * 查询宠物类型
	 * @return
	 */
	List<PetType> findPetType(); 
	/**
	 * 根据类型名称查询类型编号
	 * @param name
	 * @return
	 */
	int findIdByTypeName(String name); 
	
	/**
	 * @param petType
	 * @return
	 */
	int save(PetType petType);
}
