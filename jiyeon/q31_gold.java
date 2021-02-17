// part3 chapter 16 - ���̳��� ���α׷��� ���� : 31��) �ݱ�
package dp;

import java.util.*;

public class q31_gold {

	public static int t; // test case T (test case�� �����)
	public static int n;
	public static int m;
	public static int[][] arr = new int[20][20];
	public static int[][] dp = new int[20][20];
	
	public static void dp() {
		// �� ĭ���� ������ ���� ����Ѵ�. ( ���� ������ �� ��, ���ʿ��� �� ��, ���� �Ʒ����� �� �� )
		// �� �� ���� ū ���� dp�� �����Ѵ�. -> �ݺ�
		
		for(int i=1;i<m;i++) {
			for(int j=0;j<n;j++) {
				int a,b,c; // a: ������, b: ����, c:���� �Ʒ�
				
				// ���� ������ ���� �� ���
				if(j == 0) a = 0; // �� ������ ���, ���� ������ ���� ���� ����
				else a = dp[j-1][i-1];
				
				// ���ʿ��� ���� �� ���
				b = dp[j][i-1];
				
				// ���� �Ʒ����� ���� �� ���
				if(j == n-1) c = 0; // �� ���������� ���, ���� �Ʒ����� ���� ���� ����
				else c = dp[j+1][i-1];
				
				dp[j][i] = dp[j][i] + Math.max(a, Math.max(b, c)); // a,b,c�� �� max������ ������Ʈ
			}
		}
	}
	
	public static void main(String[] args) {
		/* �ǽ��ð� : 29�� ( 2350 ~ 1219 )
		 * ���� ���� dp���̺� ������Ʈ �ϴ� ���� �߿�! ���? ���� ��ġ�� �������� �ؼ� ����� max���� ���!
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		t = keyboard.nextInt();
		
		while(t>0) {
			n = keyboard.nextInt();
			m = keyboard.nextInt();
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					arr[i][j] = keyboard.nextInt();
					dp[i][j] = arr[i][j];
				}
			}
			
			dp();
			
			int max = 0;
			for(int i=0;i<n;i++) {
				if(dp[i][m-1] > max) max = dp[i][m-1];
			}
			
			System.out.println(max);
			
			t--;
		}
		
	}

}
