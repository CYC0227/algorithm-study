// part3 - chapter 12 ���� : 7��) ��Ű ��Ʈ����Ʈ
package greedy;

import java.util.*;

public class q7_lucky {

	public static void main(String[] args) {
		/* �ǽ��ð� : 11 �� ( 1108 ~ 1119)  
		 * �� : ����==������ �� ( sum ���� 2 �� )
		 * ������ : ����-������ = 0 ���� �� ( summary ���� 1�� )
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		String n = keyboard.nextLine(); // ���� ĳ������ ���� n
		
		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis();
		
		int left = 0;
		int right = 0;
		
		for(int i=0;i<n.length()/2;i++) {
			left += n.charAt(i);
		}
		for(int i=n.length()/2;i<n.length();i++) {
			right+= n.charAt(i);
		}
		
		if(left==right)
			System.out.println("LUCKY");
		else
			System.out.println("READY");
	   /* �ڵ� ����ð� ��� */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n����ð�(second) : " + secDiffTime);
		

	}

}
