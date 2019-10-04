package jdbcdemo5.test;

import java.util.List;
import java.util.Scanner;

import jdbcdemo5.entity.Pet;
import jdbcdemo5.entity.PetOwner;
import jdbcdemo5.entity.PetStore;
import jdbcdemo5.service.PetOwnerService;
import jdbcdemo5.service.PetStoreService;
import jdbcdemo5.service.impl.PetOwnerServiceImpl;
import jdbcdemo5.service.impl.PetStoreServiceImpl;

public class UseCaseServiceTest {
	private Scanner input = new Scanner(System.in);
	private PetStoreService petStoreService  = new PetStoreServiceImpl();
	private PetOwnerService petOwnerService  = new PetOwnerServiceImpl();
	private PetOwner petOwner = null;
	/**
	 * 启动程序
	 */
	public void startPetShop(){
		System.out.println("宠物商店启动");
		System.out.println("Wonderland醒来，所有宠物从MySql中醒来");
		System.out.println("******************************");
		System.out.println("序号     宠物名称");				
		List<Pet> petList = petStoreService.getAllPet();
		for(Pet pet:petList){
			System.out.println(pet.getId()+"     "+pet.getName());
		}
		System.out.println("******************************");
		
		System.out.println("所有宠物主人从MySql中醒来");		
		List<PetOwner> petOwnerList = petOwnerService.getAllOwner();
		for(PetOwner petOwner:petOwnerList){
			System.out.println(petOwner.getId()+"     "+petOwner.getName());
		}
		System.out.println("******************************");
		
		System.out.println("所有宠物商店从MySql中醒来");
		List<PetStore> petStoreList = petStoreService.getAllStore();
		for(PetStore petStore:petStoreList){
			System.out.println(petStore.getId()+"     "+petStore.getName());
		}
		
		System.out.println("******************************");
		
		System.out.println("请选择输入登录模式，输入1为宠物主人登录，输入2为宠物商店登录");
		
		String isPetOwner = input.next();
		if(isPetOwner.equals("1")){
			ownerLogin();
		}else{
			
		}
		
	}
	
	/**
	 * 宠物主人登录
	 */
	public void ownerLogin(){	
		System.out.println("请先登录，请您输入主人的名称：");
		String name = input.next();
		System.out.println("请您输入主人的密码：");
		String password = input.next();
			
		petOwner = petOwnerService.login(name, password);
		if(petOwner != null){
			System.out.println("-----恭喜您登录成功-----");	
			System.out.println("-----您的基本信息是：-----");
			
			System.out.print("名字：");
			System.out.println(petOwner.getName());
			System.out.print("元宝数：");
			System.out.println(petOwner.getMoney());
			System.out.println("登录成功，您可以购买和卖出宠物，如果您想购买宠物请输入1，如果想卖出宠物请输入2");
			System.out.println("1：购买宠物");
			System.out.println("2：卖出宠物");
			
			String isBuy =  input.next();
			if(isBuy.equals("1")){
				ownerBuy();
			}else{
				
			}
			
		}else{
			System.out.print("-----宠物主人登录失败-----");		
		}
	}
	
	/**
	 * 宠物主人购买宠物
	 */
	public void ownerBuy(){
		System.out.println("-----请输入选择要购买范围：只输入选择项的序号-----");	
		System.out.println("1：购买库存宠物");
		System.out.println("2：购买新培育宠物");
		String isStockPet =  input.next();
		
		System.out.println("----以下是库存宠物-----");
		//购买库存宠物
		if(isStockPet.equals("1")){
			
			System.out.println("序号     宠物名称    类型    元宝数");				
			List<Pet> petList = petStoreService.getStockPet();
			for(Pet pet:petList){
				System.out.println(
						pet.getId()+"     "+pet.getName()+"     "
				          +pet.getTypeName()+"   5.0" );
			}//end of for
			
			System.out.println("----请选择要购买哪个一个宠物，并输入选择的序号-----");
			int petId =  input.nextInt();
			petOwnerService.buyPet(petId, petOwner.getId(), 5);
			
			System.out.println("台账正确插入一条记录");
		}else{
			
		}
	}
	
	public static void main(String[] args) {
		UseCaseServiceTest useCaseTest = new UseCaseServiceTest();
		useCaseTest.startPetShop();
		
		
	}

}
