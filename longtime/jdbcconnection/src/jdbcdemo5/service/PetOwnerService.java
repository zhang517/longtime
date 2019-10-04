package jdbcdemo5.service;

import java.util.List;

import jdbcdemo5.entity.PetOwner;

/**
 * @author Administrator
 * ��������Service
 */
public interface PetOwnerService {

	/**
	 * ��ѯ���г���������Ϣ
	 * @return
	 */
	List<PetOwner>  getAllOwner();
	
	/**
	 * �������˵�¼
	 * @param name
	 * @param password
	 * @return
	 */
	PetOwner login(String name,String password);
	
	/**
	 * �������
	 * @param petId
	 * @param petOwnerId
	 * @param money
	 */
	public void buyPet(int petId, int petOwnerId, int money);
	
}
