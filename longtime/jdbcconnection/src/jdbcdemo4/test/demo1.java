package jdbcdemo4.test;

import java.util.Date;

import jdbcdemo4.dao.PetDao;
import jdbcdemo4.dao.impl.PetDaoMySQLImpl;
import jdbcdemo4.entity.Pet;

public class demo1 {

	public static void main(String[] args) {
		//�ӿڵ�ʵ�֣���߽ӿ��ұ�ʵ���࣬�൱�����ʵ����
		PetDao petDao = new PetDaoMySQLImpl();
		
		//ʵ����
		Pet pet = new Pet();
		pet.setId(3);
		pet.setMasterId(1);
		pet.setName("����2");
		pet.setTypeId(1);
		pet.setHealth(20);
		pet.setLove(50);
		pet.setAdoptTime(new Date());
		pet.setStatus("0");
		
		petDao.update(pet);
		
		System.out.println("���³ɹ�");
		
	}

}
