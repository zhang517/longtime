package jdbcdemo5.test;

import java.util.List;

import jdbcdemo5.dao.PetDao;
import jdbcdemo5.dao.PetOwnerDao;
import jdbcdemo5.dao.PetStoreDao;
import jdbcdemo5.dao.impl.PetDaoImpl;
import jdbcdemo5.dao.impl.PetOwnerDaoImpl;
import jdbcdemo5.dao.impl.PetStoreDaoImpl;
import jdbcdemo5.entity.Pet;
import jdbcdemo5.entity.PetOwner;
import jdbcdemo5.entity.PetStore;

public class UseCaseDaoTest {

	public void startPetShop(){
		System.out.println("�����̵�����");
		System.out.println("Wonderland���������г����MySql������");
		System.out.println("******************************");
		System.out.println("���     ��������");
		
		PetDao petDao  = new PetDaoImpl();
		List<Pet> petList = petDao.getAllPet();
		for(Pet pet:petList){
			System.out.println(pet.getId()+"     "+pet.getName());
		}
		System.out.println("******************************");
		
		System.out.println("���г������˴�MySql������");
		PetOwnerDao petOwnerDao  = new PetOwnerDaoImpl();
		List<PetOwner> petOwnerList = petOwnerDao.getAllOwner();
		for(PetOwner petOwner:petOwnerList){
			System.out.println(petOwner.getId()+"     "+petOwner.getName());
		}
		System.out.println("******************************");
		
		System.out.println("���г����̵��MySql������");
		PetStoreDao petStoreDao  = new PetStoreDaoImpl();
		List<PetStore> petStoreList = petStoreDao.getAllStore();
		for(PetStore petStore:petStoreList){
			System.out.println(petStore.getId()+"     "+petStore.getName());
		}
		
		System.out.println("******************************");
		
		System.out.println("��ѡ�������¼ģʽ������1Ϊ�������˵�¼������2Ϊ�����̵��¼");

	}
	
	public static void main(String[] args) {
		UseCaseDaoTest useCaseTest = new UseCaseDaoTest();
		useCaseTest.startPetShop();			
	}

}
