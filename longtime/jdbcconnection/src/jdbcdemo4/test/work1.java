package jdbcdemo4.test;

import java.util.Scanner;

import jdbcdemo4.dao.MasterDao;
import jdbcdemo4.dao.impl.MasterDaoMySQLImpl;
import jdbcdemo4.entity.Master;

public class work1 {

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
		}

	}

}
