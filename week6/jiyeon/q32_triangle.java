// chapter 16 ���̳��� ���α׷��� - 32��) ���� �ﰢ��
package dp;

import java.util.*;

public class q32_triangle {
	public static int n;
	public static int[][] dp = new int[500][500];
	
	public static void dp() {
		int index = 0;
		for(int i=1;i<n;i++) {
			for(int j=0;j<i+1;j++) {
				int left,right;
				
				// ���� ���� �� ���ϱ�
				if(j == 0) left = 0; // �׸� �󿡼� �� ���ʿ� ��ġ�� �͵��� ���ʿ��� ������ ���� ���� ��!
				else left = dp[i-1][j-1];
				
				// ������ ���� �� ���ϱ�
				if( j == n-1 ) right = 0; // �׸� �󿡼� �� �����ʿ� ��ġ�� �͵��� �����ʿ��� ������ ���� ���� �� !
				else right = dp[i-1][j];
				
				dp[i][j] = dp[i][j] + Math.max(left,right);
			}
		}
	}
	
	public static void main(String[] args) {
		/* �ǽ� �ð� : 34�� ( 1221 ~ 1255 )
		 * ���� �ݱ� ������ ����! �ݱ� ������ ���� ���� ������ �������ٸ�, �̹� ������ ���ο��� ������ ���ؼ� ������ ����!
		 * ���ʿ��� �������� ���� �����ʿ��� �������� ���� ���� ���� ���� �� �˾ƾ� ��.
		 * ������ ��� �δ��� �򰥷��� �ð� �� �ɸ� ��
		 * ���� �������� ���� ���������� ���������� �ϸ� �׶��׶��� �ִ밪�ۿ� ���� ���� ����!
		 * ���� �������� ���� ������ �� ���� ������ ������ ������ �� �� �ִ밪�� ���ؾ� ���� �ִ밪�� ���� �� ����(���κ��� �������°� �ƴ϶�, ��򰡷κ��� ������ �� ����� ������ �ؾ���)
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<i+1;j++) {
				dp[i][j] = keyboard.nextInt(); // i��° �����ٿ� i��° ���ڵ� �Է�
			}
		}
		
		dp();
		
		int max = 0;
		for(int i=0;i<n;i++) {
			if(dp[n-1][i] > max) max = dp[n-1][i];
		}
		System.out.println(max);
	}

}
