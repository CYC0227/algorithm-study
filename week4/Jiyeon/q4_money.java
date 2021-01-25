// part 3 - chapter11 �׸��� : 4��) ���� �� ���� �ݾ�
package greedy;

import java.util.*;

public class q4_money {

	public static void main(String[] args) {
		/* �ǽ��ð� : 16�� ( 1134 ~ 1150 )
		 * ������ ���� �� ����� �� �ִ� ���� �ƴ϶�, �� ������ ����� �� �ֱ� ������ ������ ������ ���� �� ������ �ʿ䰡 ����. �׸���� ����!
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int[] coin = new int[n];
		
		for(int i=0;i<n;i++) {
			coin[i] = keyboard.nextInt();
		}
		
		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis(); 
		
		Arrays.sort(coin); // ������ �ִ� ������ ������������ ����
		
		int min = 1; // �ʱ� min���� 1 ( �ּҰ��̴ϱ� )
		/* 0���� n-1���� �ö󰡸鼭, coin[i]�� ���� �� �ִ��� ������ �Ǵ�*/
		for(int i=0;i<n;i++) {
			/* ���� min���� coin[i]������ ������ min�� ã������
			 * ���� break�� �� ���� �ɸ��� �ʾҴٸ� coin �迭�� �ִ� �� ��θ� ���� �� +1 �� min���� �ȴ�.(min �ʱⰪ�� 1�̾����ϱ�)*/
			if(min < coin[i])
				break;
			
			min += coin[i]; // ���� ���� ������ i���� ���� �� ���ٸ�, min���� coin[i]�� ����
		}
		
		System.out.println(min);
		
	   /* �ڵ� ����ð� ��� */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n����ð�(second) : " + secDiffTime);

	}

}
