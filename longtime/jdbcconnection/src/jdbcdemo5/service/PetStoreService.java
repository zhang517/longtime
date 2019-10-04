package jdbcdemo5.service;

import java.util.List;

import jdbcdemo5.entity.Pet;
import jdbcdemo5.entity.PetStore;

/**
 * @author Administrator
 * �����̵�Dao
 */
public interface PetStoreService {
	/**
	 * @return
	 * ��ѯ���г����̵���Ϣ
	 */
	List<PetStore> getAllStore();
	
	/**
	 * ��ѯ���г�����Ϣ
	 * @return
	 */
	List<Pet>  getAllPet();
	
	/**
	 * ��ѯ������
	 * ���ĳ��� 
     *  ---��ָpet����owner_idΪ�յļ�¼
	 * @return
	 */
	List<Pet> getStockPet();
	
	/**
	 * �������Ŀ�����
     * ---��ָpet����owner_idΪ�� �� typename����dog��penguin�ĳ���
	 * @return
	 */
	List<Pet> getNewPet();
	

}
