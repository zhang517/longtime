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
		System.out.println("宠物商店启动");
		System.out.println("Wonderland醒来，所有宠物从MySql中醒来");
		System.out.println("******************************");
		System.out.println("序号     宠物名称");
		
		PetDao petDao  = new PetDaoImpl();
		List<Pet> petList = petDao.getAllPet();
		for(Pet pet:petList){
			System.out.println(pet.getId()+"     "+pet.getName());
		}
		System.out.println("******************************");
		
		System.out.println("所有宠物主人从MySql中醒来");
		PetOwnerDao petOwnerDao  = new PetOwnerDaoImpl();
		List<PetOwner> petOwnerList = petOwnerDao.getAllOwner();
		for(PetOwner petOwner:petOwnerList){
			System.out.println(petOwner.getId()+"     "+petOwner.getName());
		}
		System.out.println("******************************");
		
		System.out.println("所有宠物商店从MySql中醒来");
		PetStoreDao petStoreDao  = new PetStoreDaoImpl();
		List<PetStore> petStoreList = petStoreDao.getAllStore();
		for(PetStore petStore:petStoreList){
			System.out.println(petStore.getId()+"     "+petStore.getName());
		}
		
		System.out.println("******************************");
		
		System.out.println("请选择输入登录模式，输入1为宠物主人登录，输入2为宠物商店登录");

	}
	
	public static void main(String[] args) {
		UseCaseDaoTest useCaseTest = new UseCaseDaoTest();
		useCaseTest.startPetShop();			
	}

}
