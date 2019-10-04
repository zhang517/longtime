package jdbcdemo5.dao;

import java.util.List;

import jdbcdemo5.entity.PetOwner;

/**
 * @author Administrator
 * ��������Dao
 */
public interface PetOwnerDao {

	/**
	 * ��ѯ���г���������Ϣ
	 * @return
	 */
	List<PetOwner>  getAllOwner();
		
	/**
	 * ��ѯָ���ĳ�������
	 * @param name
	 * @param password
	 * @return
	 */
	PetOwner selectOwner(String name,String password);
	
	/**
	 * ����ID����
	 * @param petId
	 * @return
	 */
	public PetOwner getOwnerById(int petId);
	
	/**
	 * ���³���������Ϣ������Ԫ����
	 * @param money
	 * @param petOwnerId
	 * @return
	 */
	public int addMoney(int money,int petOwnerId);
	
	/**
	 * ���³���������Ϣ������Ԫ����
	 * @param money
	 * @param petOwnerId
	 * @return
	 */
	public int subMoney(int money,int petOwnerId);
	
}
