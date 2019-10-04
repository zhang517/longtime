package jdbcdemo4.dao;

import jdbcdemo4.entity.Master;

/**
 *  主人Dao接口
 */
public interface MasterDao {
	/**
	 * 保存主人信息。
	 * @param master 主人
	 */
	int save(Master master);
	
	/**
	 * 删除主人信息。
	 * @param master 主人
	 */
	int del(Master master);
	
	/**
	 * 更新主人信息。
	 * @param master 主人
	 */
	int update(Master master);
	
	/**
	 * 查找指定登录名和密码的主人
	 * @param master 要查找的主人
	 * @return 主人
	 */
	Master findMaster(Master master);
}
