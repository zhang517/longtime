package jdbcdemo5.service.impl;

import java.util.List;

import jdbcdemo5.dao.AccountDao;
import jdbcdemo5.dao.PetDao;
import jdbcdemo5.dao.PetOwnerDao;
import jdbcdemo5.dao.PetStoreDao;
import jdbcdemo5.dao.impl.AccountDaoImpl;
import jdbcdemo5.dao.impl.PetDaoImpl;
import jdbcdemo5.dao.impl.PetOwnerDaoImpl;
import jdbcdemo5.dao.impl.PetStoreDaoImpl;
import jdbcdemo5.entity.Account;
import jdbcdemo5.entity.Pet;
import jdbcdemo5.entity.PetOwner;
import jdbcdemo5.service.PetOwnerService;

public class PetOwnerServiceImpl implements PetOwnerService{
	private PetOwnerDao petOwnerDao  = new PetOwnerDaoImpl();
	private PetDao petDao  = new PetDaoImpl();	
	private PetStoreDao petStoreDao = new PetStoreDaoImpl();	
	private AccountDao accountDao = new AccountDaoImpl();
	
	@Override
	public List<PetOwner> getAllOwner() {
		// TODO Auto-generated method stub
		return petOwnerDao.getAllOwner();
	}

	@Override
	public PetOwner login(String name, String password) {
		// TODO Auto-generated method stub
		return petOwnerDao.selectOwner(name, password);
	}

	@Override
	public void buyPet(int petId, int petOwnerId, int money){
		 Pet pet = petDao.getPetById(petId);
		
		 //1、更新宠物信息：指定ownerid
		 pet.setOwnerId(petOwnerId);
		 petDao.update(pet);
		 
		//2、更新宠物主人信息：减少元宝数
		 petOwnerDao.subMoney(money, petOwnerId);
		 
		//3、更新宠物商店信息：增加元宝数		
		int storeId = pet.getStoreId();
		petStoreDao.addMoney(money, storeId);
		
		//4、更新账目信息：添加新账目
		Account account = new Account();
		account.setBuyerId(petOwnerId);
		account.setDealType(1);//实际中可能定义为常量
		account.setPetId(petId);
		account.setSellerId(storeId);
		account.setPrice(money);
		
		accountDao.save(account); 
	}
}
