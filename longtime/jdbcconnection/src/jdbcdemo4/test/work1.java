package jdbcdemo4.test;

import java.util.Scanner;

import jdbcdemo4.dao.MasterDao;
import jdbcdemo4.dao.impl.MasterDaoMySQLImpl;
import jdbcdemo4.entity.Master;

public class work1 {

	public static void main(String[] args) {
		// 1������������
		Scanner input = new Scanner(System.in);
		
		// 2����ӡ��ӭ��Ϣ
		System.out.println("---- ��ӭ���ٳ�����԰ ----");
		
		// 3����ȡ�û�����ĵ�¼��������
		System.out.print("�������¼����");
		String loginId = input.next();
		System.out.print("���������룺");
		String password = input.next();
		
		Master paraMas = new Master();
		paraMas.setName(loginId);
		paraMas.setPassword(password);
		
		// 4������¼���������Ƿ�Ϸ����������ʾ��Ϣ
		MasterDao masterDao = new MasterDaoMySQLImpl();
		Master retMas = masterDao.findMaster(paraMas);
		if (retMas != null) {
			System.out.println("��¼�ɹ���");
		} else {
			System.out.println("�û�����������󣬵�¼ʧ�ܣ�");
		}

	}

}
