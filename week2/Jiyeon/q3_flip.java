// part 3 �׸��� - 3��) ���ڿ� ������
package greedy;

import java.util.*;

public class q3_flip {

	public static void main(String[] args) {
		/* �ǽ� �ð� : 31 �� ( 0928 ~ 0959)
		 * ����� �� : for�� �� ��, ������ �ڲ� �򰥷��� index ������ ��� ��
		 * ������ ������ ��, n1�� n2�� ���ǰ� �ݴ�� �� �ݴ��� �ڵ尡 ���� ��~
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		String str = keyboard.nextLine();
		String[] num = str.split("");

		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis(); 
		
		int n1 = 0; // 0�� 1�� �ٲ� ��
		int n2 = 0; // 1�� 0���� �ٲ� ��
		
		if(str.charAt(0)-'0' == 0)
			n1++;
		else
			n2++;
		
		for(int i=0;i<str.length()-1;i++){
			
			// ���� ���ڶ� ���� ���ڶ� ���� ���� ���, ���ڿ� ������ ����
			if(str.charAt(i) != str.charAt(i+1)) {
				if(str.charAt(i)-'0' == 1) { // 0�� 1�� �ٲ� ��
					n1++;
				}
				else // 1�� 0���� �ٲ� ��
					n2++;
					
			}
		}
		
		if(n1>n2)
			System.out.println(n2);
		else
			System.out.println(n1);
		
	    /* �ڵ� ����ð� ��� */
	    long afterTime = System.currentTimeMillis();
	    long secDiffTime = (afterTime - beforeTime) / 1000;
	    System.out.println("\n����ð�(second) : " + secDiffTime);
	}

}
