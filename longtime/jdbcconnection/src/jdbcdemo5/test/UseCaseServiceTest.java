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
	 * ��������
	 */
	public void startPetShop(){
		System.out.println("�����̵�����");
		System.out.println("Wonderland���������г����MySql������");
		System.out.println("******************************");
		System.out.println("���     ��������");				
		List<Pet> petList = petStoreService.getAllPet();
		for(Pet pet:petList){
			System.out.println(pet.getId()+"     "+pet.getName());
		}
		System.out.println("******************************");
		
		System.out.println("���г������˴�MySql������");		
		List<PetOwner> petOwnerList = petOwnerService.getAllOwner();
		for(PetOwner petOwner:petOwnerList){
			System.out.println(petOwner.getId()+"     "+petOwner.getName());
		}
		System.out.println("******************************");
		
		System.out.println("���г����̵��MySql������");
		List<PetStore> petStoreList = petStoreService.getAllStore();
		for(PetStore petStore:petStoreList){
			System.out.println(petStore.getId()+"     "+petStore.getName());
		}
		
		System.out.println("******************************");
		
		System.out.println("��ѡ�������¼ģʽ������1Ϊ�������˵�¼������2Ϊ�����̵��¼");
		
		String isPetOwner = input.next();
		if(isPetOwner.equals("1")){
			ownerLogin();
		}else{
			
		}
		
	}
	
	/**
	 * �������˵�¼
	 */
	public void ownerLogin(){	
		System.out.println("���ȵ�¼�������������˵����ƣ�");
		String name = input.next();
		System.out.println("�����������˵����룺");
		String password = input.next();
			
		petOwner = petOwnerService.login(name, password);
		if(petOwner != null){
			System.out.println("-----��ϲ����¼�ɹ�-----");	
			System.out.println("-----���Ļ�����Ϣ�ǣ�-----");
			
			System.out.print("���֣�");
			System.out.println(petOwner.getName());
			System.out.print("Ԫ������");
			System.out.println(petOwner.getMoney());
			System.out.println("��¼�ɹ��������Թ�����������������빺�����������1���������������������2");
			System.out.println("1���������");
			System.out.println("2����������");
			
			String isBuy =  input.next();
			if(isBuy.equals("1")){
				ownerBuy();
			}else{
				
			}
			
		}else{
			System.out.print("-----�������˵�¼ʧ��-----");		
		}
	}
	
	/**
	 * �������˹������
	 */
	public void ownerBuy(){
		System.out.println("-----������ѡ��Ҫ����Χ��ֻ����ѡ��������-----");	
		System.out.println("1�����������");
		System.out.println("2����������������");
		String isStockPet =  input.next();
		
		System.out.println("----�����ǿ�����-----");
		//���������
		if(isStockPet.equals("1")){
			
			System.out.println("���     ��������    ����    Ԫ����");				
			List<Pet> petList = petStoreService.getStockPet();
			for(Pet pet:petList){
				System.out.println(
						pet.getId()+"     "+pet.getName()+"     "
				          +pet.getTypeName()+"   5.0" );
			}//end of for
			
			System.out.println("----��ѡ��Ҫ�����ĸ�һ�����������ѡ������-----");
			int petId =  input.nextInt();
			petOwnerService.buyPet(petId, petOwner.getId(), 5);
			
			System.out.println("̨����ȷ����һ����¼");
		}else{
			
		}
	}
	
	public static void main(String[] args) {
		UseCaseServiceTest useCaseTest = new UseCaseServiceTest();
		useCaseTest.startPetShop();
		
		
	}

}
