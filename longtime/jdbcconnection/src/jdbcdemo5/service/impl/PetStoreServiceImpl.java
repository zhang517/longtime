package jdbcdemo5.service.impl;

import java.util.List;

import jdbcdemo5.dao.PetDao;
import jdbcdemo5.dao.PetStoreDao;
import jdbcdemo5.dao.impl.PetDaoImpl;
import jdbcdemo5.dao.impl.PetStoreDaoImpl;
import jdbcdemo5.entity.Pet;
import jdbcdemo5.entity.PetStore;
import jdbcdemo5.service.PetStoreService;

public class PetStoreServiceImpl implements PetStoreService{
	private PetStoreDao petStoreDao  = new PetStoreDaoImpl();
	
	//属于上层调用下层，业务逻辑层调用Dao层
	private PetDao petDao  = new PetDaoImpl();
	
	@Override
	public List<PetStore> getAllStore() {
		// TODO Auto-generated method stub
		return petStoreDao.getAllStore();
	}
	
	@Override
	public List<Pet> getAllPet() {
		// TODO Auto-generated method stub
		return petDao.getAllPet();
	}

	@Override
	public List<Pet> getStockPet() {
		// TODO Auto-generated method stub
		return petDao.getStockPet();
	}

	@Override
	public List<Pet> getNewPet() {
		// TODO Auto-generated method stub
		return petDao.getNewPet();
	}
}
