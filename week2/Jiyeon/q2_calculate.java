// part 3 �׸��� - 2��) ���ϱ� Ȥ�� ���ϱ�

package greedy;

import java.util.*;
public class q2_calculate {

	public static void main(String[] args) {
		/* �ǽ� �ð� : 11 �� ( 0834 ~ 0845 ) */
		Scanner keyboard = new Scanner(System.in);
		
		String str = keyboard.nextLine();
		
		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis(); 
		
		
		String[] arr = str.split("");
		int[] num = new int[arr.length];
		
		for(int i=0;i<num.length;i++) {
			num[i] = Integer.parseInt(arr[i]);
		}
		
		int i = 1;
		int result = num[0]; // ����� �ʱⰪ�� �迭�� ù��° ����
		
		while(i < num.length) {
			
			// 0�̳� 1�� ���ԵǾ� �ִٸ�, ���ϱ⸦ �ϴ� ���� �� ū ���� �����.
			if(num[i] == 0 || num[i] == 1 || result == 0 || result == 1) { // �ռ� ������� 0�̳� 1�̰ų�, ���� ����ؾ� �� ���ο� ���� 0�̳� 1�� ���
				result += num[i];
			}
			
			// �� ���� ���� ���Ѵ�.
			else {
				result *= num[i];
			}
			
			i++;
		}
		
		System.out.println(result);
		
		/* �ڵ� ����ð� ��� */
	    long afterTime = System.currentTimeMillis();
	    long secDiffTime = (afterTime - beforeTime) / 1000;
	    System.out.println("\n����ð�(second) : " + secDiffTime);
	    
	    
	    /* ��� ��� : ���ڿ��� �и��ؼ� �迭�� ���� �ʰ�, charAt() ��� & -'0' ����ؼ� ���ڷ� ����. �ڵ尡 ��~������ */

	}

}
