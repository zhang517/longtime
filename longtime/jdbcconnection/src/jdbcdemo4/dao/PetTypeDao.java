package jdbcdemo4.dao;

import java.util.List;

import jdbcdemo4.entity.PetType;

/**
 * ��������Dao�ӿڡ�
 */
public interface PetTypeDao {
	/**
	 * ��ѯ��������
	 * @return
	 */
	List<PetType> findPetType(); 
	/**
	 * �����������Ʋ�ѯ���ͱ��
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
