package somepackage;

import java.util.Random;

public class AssertTest {
	public static void main(String[] args) {
    String string = "LiYanwen I love you";
		
		int i;
		
		for( i = 0; i < 100; i++){
			System.out.println("i = " + i);
			if(i == 50){
				break;
				
			}
		}
		assert i == 100:"i�����ӹ����б��ж���";
		
		System.out.println(string);
    }
}
