package jdbcdemo5.service;

import java.util.List;

import jdbcdemo5.entity.PetOwner;

/**
 * @author Administrator
 * 宠物主人Service
 */
public interface PetOwnerService {

	/**
	 * 查询所有宠物主人信息
	 * @return
	 */
	List<PetOwner>  getAllOwner();
	
	/**
	 * 宠物主人登录
	 * @param name
	 * @param password
	 * @return
	 */
	PetOwner login(String name,String password);
	
	/**
	 * 购买宠物
	 * @param petId
	 * @param petOwnerId
	 * @param money
	 */
	public void buyPet(int petId, int petOwnerId, int money);
	
}
