package jdbcdemo4.test;

import java.util.Date;

import jdbcdemo4.dao.PetDao;
import jdbcdemo4.dao.impl.PetDaoMySQLImpl;
import jdbcdemo4.entity.Pet;

public class demo1 {

	public static void main(String[] args) {
		//接口的实现，左边接口右边实现类，相当于类的实例化
		PetDao petDao = new PetDaoMySQLImpl();
		
		//实体类
		Pet pet = new Pet();
		pet.setId(3);
		pet.setMasterId(1);
		pet.setName("花花2");
		pet.setTypeId(1);
		pet.setHealth(20);
		pet.setLove(50);
		pet.setAdoptTime(new Date());
		pet.setStatus("0");
		
		petDao.update(pet);
		
		System.out.println("更新成功");
		
	}

}
