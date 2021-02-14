// part3 chapter 16 - 다이나믹 프로그래밍 문제 : 31번) 금광
package dp;

import java.util.*;

public class q31_gold {

	public static int t; // test case T (test case가 몇개인지)
	public static int n;
	public static int m;
	public static int[][] arr = new int[20][20];
	public static int[][] dp = new int[20][20];
	
	public static void dp() {
		// 각 칸에서 세가지 값을 계산한다. ( 왼쪽 위에서 온 값, 왼쪽에서 온 값, 온쪽 아래에서 온 값 )
		// 그 중 가장 큰 값을 dp에 저장한다. -> 반복
		
		for(int i=1;i<m;i++) {
			for(int j=0;j<n;j++) {
				int a,b,c; // a: 왼쪽위, b: 왼쪽, c:왼쪽 아래
				
				// 왼쪽 위에서 오는 값 계산
				if(j == 0) a = 0; // 맨 윗줄일 경우, 왼쪽 위에서 오는 값은 없다
				else a = dp[j-1][i-1];
				
				// 왼쪽에서 오는 값 계산
				b = dp[j][i-1];
				
				// 왼쪽 아래에서 오는 값 계산
				if(j == n-1) c = 0; // 맨 마지막줄일 경우, 왼쪽 아래에서 오는 값은 없다
				else c = dp[j+1][i-1];
				
				dp[j][i] = dp[j][i] + Math.max(a, Math.max(b, c)); // a,b,c값 중 max값으로 업데이트
			}
		}
	}
	
	public static void main(String[] args) {
		/* 실습시간 : 29분 ( 2350 ~ 1219 )
		 * 누적 값을 dp테이블에 업데이트 하는 것이 중요! 어떻게? 현재 위치를 기준으로 해서 사방의 max값을 계산!
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
