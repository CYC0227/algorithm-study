// chapter 8 ���̳��� ���α׷��� - 1�� �����

import java.util.*;

public class ch8_3_makeOne {

	public static void main(String[] args) {
		/* �ǽ� �ð� : 66 �� ( 1016 ~ 1122)
		 * ��ȭ���� �߸� ����. dp[i/2] + 1 �κ��� i /2�� ��. 7������ �� ���ư��µ�, 8���ʹ� ���� Ŀ������...
		 * i/2 �� �ϸ� �ȵǴ� ���� : ���� ��� 8�� ���, 8/2=4�̹Ƿ� dp[8]=4��.
		 * �ٵ� 8�� 2�� 4�� ���� �ʿ� ����, 8�� 2�� ���� �� 4�� dp���� ������ �� �۾�����. dp[4]=2�̹Ƿ�, dp[4]�� +1(4�� ���� �� �� �� ���������ϱ� +1)�� �ؼ� �����°� min�̶�� ��!
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int[] dp = new int[n+1];	// i��° ���ڱ��� ���Ǵ� �ּڰ�
		
		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis(); 
		
		/* dp[1]�� �̹� 1�� �Ǿ��� ������ ���� Ƚ���� 0. for������ ����
		 * 2���� n���� for���� ���鼭, i��° ���ڰ� 1�� �� ������ ���� Ƚ���� ���ؼ� min���� �����Ѵ�.
		 * */
		for(int i=2;i<=n;i++) { // bottom-up
			// �ϴ� dp[i]�� 1�� ���� ������ ��Ų Ƚ���� ����. (i-1��° ���� i���� 1 ���� ���̴ϱ�, �ϴ� 1��ŭ ���� i-1��° ���� ���� ����ϸ� ��. i-1��° ���� Ƚ������ 1�� ���� ���� i��°�� ���� Ƚ���� ����.)
			dp[i] = dp[i-1] + 1;
			
			/* 1�� ���� �Ͱ�, �����⸦ �ϴ� �� �� �� ���� Ƚ���� ���� ������ �����ؼ� dp[i]�� ���� : ���� dp[i]���� 1�� ���� ���� Ƚ���� ����Ǿ� ���� */
			if(i % 2 == 0) {
				//System.out.println("i : "+i+" ,dp[i/2] : " + dp[i/2]);
				dp[i] = Math.min(dp[i], dp[i / 2] +1); // +1 : �������� ��
			}
			if(i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			if(i % 5 == 0)
				dp[i] = Math.min(dp[i], dp[i / 5] + 1);
			System.out.print(dp[i] + " ");
		}System.out.println();
		
		System.out.println(dp[n]);
		
	   /* �ڵ� ����ð� ��� */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n����ð�(second) : " + secDiffTime);

	}

}
