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
		
		 //1�����³�����Ϣ��ָ��ownerid
		 pet.setOwnerId(petOwnerId);
		 petDao.update(pet);
		 
		//2�����³���������Ϣ������Ԫ����
		 petOwnerDao.subMoney(money, petOwnerId);
		 
		//3�����³����̵���Ϣ������Ԫ����		
		int storeId = pet.getStoreId();
		petStoreDao.addMoney(money, storeId);
		
		//4��������Ŀ��Ϣ���������Ŀ
		Account account = new Account();
		account.setBuyerId(petOwnerId);
		account.setDealType(1);//ʵ���п��ܶ���Ϊ����
		account.setPetId(petId);
		account.setSellerId(storeId);
		account.setPrice(money);
		
		accountDao.save(account); 
	}
}
