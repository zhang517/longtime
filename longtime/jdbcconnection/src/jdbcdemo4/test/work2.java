package jdbcdemo4.test;

import java.util.List;
import java.util.Scanner;

import jdbcdemo4.dao.MasterDao;
import jdbcdemo4.dao.PetTypeDao;
import jdbcdemo4.dao.impl.MasterDaoMySQLImpl;
import jdbcdemo4.dao.impl.PetTypeMySQLImpl;
import jdbcdemo4.entity.Master;
import jdbcdemo4.entity.PetType;

public class work2 {

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
			return;
		}
		
		// 5����ʾ��������
		PetTypeDao pTypeDao=new PetTypeMySQLImpl();
		List<PetType> list=pTypeDao.findPetType();
		System.out.println("��ѡ��������ͣ�");
		for(PetType petType:list){
			System.out.print(petType.getName()+" | ");
		}
		System.out.println();
		
		// 6����ó������͵ı��
		String petName=input.next();
		int petTypeId=pTypeDao.findIdByTypeName(petName); 
		if(petTypeId!=0){
			System.out.println("��ѡ��ĳ������ͱ����"+petTypeId+"��");
		}else{
			System.out.println("������������");
		}
	}

}
