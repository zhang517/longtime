package jdbcdemo4.test;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import jdbcdemo4.dao.MasterDao;
import jdbcdemo4.dao.PetDao;
import jdbcdemo4.dao.PetTypeDao;
import jdbcdemo4.dao.impl.MasterDaoMySQLImpl;
import jdbcdemo4.dao.impl.PetDaoMySQLImpl;
import jdbcdemo4.dao.impl.PetTypeMySQLImpl;
import jdbcdemo4.entity.Master;
import jdbcdemo4.entity.Pet;
import jdbcdemo4.entity.PetType;

public class work3 {

	public static void main(String[] args) {
		// 1、获得输入对象
		Scanner input = new Scanner(System.in);
		
		// 2、打印欢迎信息
		System.out.println("---- 欢迎光临宠物乐园 ----");
		
		// 3、获取用户输入的登录名、密码
		System.out.print("请输入登录名：");
		String loginId = input.next();
		System.out.print("请输入密码：");
		String password = input.next();
		
		Master paraMas = new Master();
		paraMas.setName(loginId);
		paraMas.setPassword(password);
		
		// 4、检查登录名、密码是否合法，并输出提示信息
		MasterDao masterDao = new MasterDaoMySQLImpl();
		Master retMas = masterDao.findMaster(paraMas);
		if (retMas != null) {
			System.out.println("登录成功！");
		} else {
			System.out.println("用户名或密码错误，登录失败！");
			return;
		}
		
		// 5、显示宠物类型
		PetTypeDao pTypeDao=new PetTypeMySQLImpl();
		List<PetType> list=pTypeDao.findPetType();
		System.out.println("请选择宠物类型：");
		for(PetType petType:list){
			System.out.print(petType.getName()+" | ");
		}
		System.out.println();
		
		// 6、获得宠物类型的编号
		String petTypeName=input.next();
		int petTypeId=pTypeDao.findIdByTypeName(petTypeName); 
		if(petTypeId!=0){
			System.out.print("请输入宠物昵称：");
			String petName = input.next();	
			
			Pet pet=new Pet();
			pet.setMasterId(retMas.getId());
			pet.setName(petName);
			pet.setTypeId(petTypeId);
			
			pet.setHealth(20);
			pet.setLove(50);
			pet.setAdoptTime(new Date());
				
			PetDao petDao = new PetDaoMySQLImpl();
			int result=petDao.save(pet); //添加宠物
			if(result > 0)
				System.out.println("领养成功！");

		}else{
			System.out.println("宠物类型有误！");
		}
	}

}
