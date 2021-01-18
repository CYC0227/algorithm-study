// chapter 8 ���̳��� �ñ׷��� - ȿ������ ȭ�� ���� (p.226)

import java.util.*;

public class ch8_6_coin {
	
	public static void main(String[] args) {
		/* �ǽ� �ð� : �� ( 2221 ~ INF) - ������ ���� ��¥ ���� ���� ��Ƴ�.. ��ȭ�� �����
		 * �� �ʹ� �����. ������ ���̳����� �����.�Ф� ��¼��..
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();	// ȭ���� ��ġ�� �־��� n���� ��
		int m = keyboard.nextInt(); // m���� ��������
		
		// ���� �� �ִ� ȭ�� ���� ����
		int coin[] = new int[n];
		for(int i=0;i<n;i++) {   
			coin[i] = keyboard.nextInt();
		}
		
		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis(); 
		
		int dp[] = new int[m+1]; // 0���� m������ index�� ���� �迭 ����
		
		// 0�� ������ dp���� 10001�� �ʱ�ȭ���ش�. 0�� �ƹ��͵� ������� �ʾ��� ���̹Ƿ� 0�� ���� �� �´�.
		// 10001�� m�� ���� �� �ִ� �ִ밪�� 10000���� ū ������, INF�� �ǹ��Ѵ�.
		for(int i=1;i<=m;i++) {
			dp[i] = 10001;
		}
		
		for(int i=0;i<n;i++) { // ȭ����� ���� �ͺ��� ū ������ �ö󰡸� m�� �����غ���.
			for(int j=coin[i];j<=m;j++) { // ���� ���Ǵ� ȭ�� ���� coin[i]�� ���� dp index���� �����ؼ� m���� �ö󰡸� ���� ( bottom-up)
				
				// ���� �ִ� dp�������� ���� coin[i] ĭ��ŭ�� Ȯ���ؼ�, ���� �� �ִ� ����� �ִ��� ������ üũ
				if(dp[j-coin[i]] != 10001) // 10001�� �ƴϸ� ����� ����� �ִ°�.
					dp[j] = Math.min(dp[j], dp[j-coin[i]] + 1); // �� ��ȭ�� �˾Ƴ��°� very important & difficult
			}
		}
		
		System.out.println(dp[m]);
		
	   /* �ڵ� ����ð� ��� */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n����ð�(second) : " + secDiffTime);
	}

}
