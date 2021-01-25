// part3 - chapter 11 �׸��� : 5��) ������ ����
package greedy;

import java.util.*;

public class q5_bowling {

	public static void main(String[] args) {
		/* �ǽ��ð� : 7�� ( 1111 ~ 1118)
		 * ���� for���� ����ߴµ�, �������� �װ� �ƴϳ�
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt(); // ���� �� ����
		int m = keyboard.nextInt(); // ���� �� �ִ� ����
		int[] arr = new int[n]; // �� �������� ����
		
		for(int i=0;i<n;i++) {
			arr[i] = keyboard.nextInt();
		}
		
		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis(); 
		
		int result = 0; // �� ����� �� �� �ִ� ����� ��
		
		/* ū for�� : 0���� n����
		 * ���� for�� : i���� n����
		 * ���鼭 �� ���ڸ� ��. �ٸ��� result+1
		 * */
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i] != arr[j])
					result++;
			}
		}
		
		System.out.println(result);
		
	   /* �ڵ� ����ð� ��� */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n����ð�(second) : " + secDiffTime);
	}

}
