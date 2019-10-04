package jdbcdemo5.dao;

import java.util.List;

import jdbcdemo5.entity.Pet;

/**
 * @author Administrator
 * ����Dao
 */
public interface PetDao {
	/**
	 * ��ѯ���г�����Ϣ
	 * @return
	 */
	List<Pet> getAllPet();  
	
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
	
	/**
	 * ��ѯָ���ĳ���
	 * @param petId
	 * @return
	 */
	public Pet getPetById(int petId);
	
	
	/**
	 * ���³���
	 * @param pet
	 * @return
	 */
	public int update(Pet pet);
}
