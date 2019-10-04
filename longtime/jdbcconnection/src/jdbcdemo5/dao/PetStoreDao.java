package jdbcdemo5.dao;

import java.util.List;

import jdbcdemo5.entity.PetStore;

/**
 * @author Administrator
 * �����̵�Dao
 */
public interface PetStoreDao {
	/**
	 * @return
	 * ��ѯ���г����̵���Ϣ
	 */
	List<PetStore> getAllStore();
	
	/**
	 * ���³����̵���Ϣ������Ԫ����
	 * @param money
	 * @param petOwnerId
	 * @return
	 */
	public int addMoney(int money,int storeId);
	
	/**
	 * ���³����̵���Ϣ������Ԫ����
	 * @param money
	 * @param petOwnerId
	 * @return
	 */
	public int subMoney(int money,int storeId);
}
