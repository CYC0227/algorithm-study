// part 3 greedy - 1��) ���谡 ���

package greedy;

import java.util.*;

public class q1_adventurer {

	public static void main(String[] args) {
		/* �ǽ� �ð� : 11 �� ( 0818 ~ 0829 ) */
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int[] fear = new int[n];
		
		for(int i=0;i<n;i++) {
			fear[i] = keyboard.nextInt();
		}
		
		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis(); 
		
		Arrays.sort(fear); // �������� ������������ ����
		
		int group = 0; // �׷��� �� �� ����������� ����
		int i = n-1; // �׷� ���� �� ���
		
		// �������� ū �������� ���� �������� �����ϸ鼭, ū �׷���� �����ش�.
		while(i>=0) {
			
			int check = 0;
			// �������� �´� �ο���ŭ while���� ���鼭 ���� �׷��� ù �ε������� i�� �����ش�.
			while(check<fear[i]) {
				i--;
				check++;
			}
			group++; // �׷��� �ϳ� �����Ǿ���. 
			i--;
		}
		
		System.out.println(group);
		
	   /* �ڵ� ����ð� ��� */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n����ð�(second) : " + secDiffTime);

	}

}
