package jdbcdemo4.dao;

import java.util.List;

import jdbcdemo4.entity.Pet;

/**
 * ����Dao�ӿڡ�
 */
public interface PetDao {
	/**
	  * ������
	  * @param pet ����
	  */
	 int save(Pet pet);
	/**
	 * ɾ�����
	 * @param pet ����
	 */
	 int del(Pet pet);
	/**
	 * ���³��
	 * @param pet ����
	 */
	int update(Pet pet);
	 /**
	 * ��ȡָ���ǳƵĳ���,��ȷ��ѯ��
	 * @param name �ǳ�
	 * @return ����
	 */
	Pet getByName(String name);
	/**
	 * ��ȡָ���ǳƵĳ����б�,ģ����ѯ��
	 * @param name �ǳ�
	 * @return �����б�
	 */
	List<Pet> findByName(String name);
	/**
	 * ��ȡָ�����͵ĳ����б�
	 * @param type ��������
	 * @return �����б�
	 */
	List<Pet> findByType(String type);

}
