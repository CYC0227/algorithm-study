// chapter 8 ���̳��� ���α׷��� - �������� (p.220)

import java.util.*;

public class ch8_4_ant {

	public static void main(String[] args) {
		/* �ǽ� �ð� :  37 �� (2222 ~ 2259) 
		 * ó�� ������ �� : arr[0]���� �� ĭ �̻� ������ �� ���� ū ���� �� ���� �ƴѰ�? -> ��.. ��.. �ƴϳ�...
		 * !! ���� ���ƾ� �Ұ� : ���̳��� ���α׷����� ū ������ ���� ������ Ǫ�� ��!!
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int[] arr = new int[n];  
		int[] dp = new int[n];	// ���ʺ��� i��°���� �ķ�â�� �ִٰ� ������ ��, max�� ���� �� �ִ� �ķ� �� ( 0���� i��°������ ����Ѵ� )
		
		// �ķ� �� �Է¹޾Ƽ� ����
		for(int i=0;i<n;i++) {
			arr[i] = keyboard.nextInt();
		}
		
		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis(); 
		
		dp[0] = arr[0]; // 0��°���� ������, 0��°�� �ʹ� ���� max
		dp[1] = Math.max(arr[0], arr[1]); // 1��°���� ���� ��, 0��°�� 1��°�� �ʹ� ���� max
	
		// bottom-up ( ���ʺ��� i��°���� )
		for(int i=2;i<n;i++) {
			// ��ȭ�� : i��° �ķ�â����� ���� ��, i��°&i-2��° �ķ�â�� �ʹ� �Ͱ�, i-1��° �ķ�â�� �ʹ� �� �� max�� dp[i]�� ����. i-3���ʹ� ���x (�տ��� �̹� ����ؼ� ������)
			dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
		}
				
		System.out.println(dp[n-1]);
		
	   /* �ڵ� ����ð� ��� */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n����ð�(second) : " + secDiffTime);
		
	}

}
