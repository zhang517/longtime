package jdbcdemo4.dao;

import jdbcdemo4.entity.Master;

/**
 *  ����Dao�ӿ�
 */
public interface MasterDao {
	/**
	 * ����������Ϣ��
	 * @param master ����
	 */
	int save(Master master);
	
	/**
	 * ɾ��������Ϣ��
	 * @param master ����
	 */
	int del(Master master);
	
	/**
	 * ����������Ϣ��
	 * @param master ����
	 */
	int update(Master master);
	
	/**
	 * ����ָ����¼�������������
	 * @param master Ҫ���ҵ�����
	 * @return ����
	 */
	Master findMaster(Master master);
}
