// chapter 16 다이나믹 프로그래밍 - 32번) 정수 삼각형
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
				
				// 왼쪽 위의 값 더하기
				if(j == 0) left = 0; // 그림 상에서 젤 왼쪽에 위치한 것들은 왼쪽에서 내려올 값이 없는 것!
				else left = dp[i-1][j-1];
				
				// 오른쪽 위의 값 더하기
				if( j == n-1 ) right = 0; // 그림 상에서 젤 오른쪽에 위치한 것들은 오른쪽에서 내려올 값이 없는 것 !
				else right = dp[i-1][j];
				
				dp[i][j] = dp[i][j] + Math.max(left,right);
			}
		}
	}
	
	public static void main(String[] args) {
		/* 실습 시간 : 34분 ( 1221 ~ 1255 )
		 * 앞의 금광 문제랑 같음! 금광 문제가 세로 열을 따지는 문제였다면, 이번 문제는 가로열의 값들은 비교해서 따지는 문제!
		 * 왼쪽에서 내려오는 값과 오른쪽에서 내려오는 값이 언제 없는 지를 잘 알아야 함.
		 * 기준을 어디에 두는지 헷갈려서 시간 좀 걸림 ㅠ
		 * 나를 기준으로 왼쪽 오른쪽으로 내려가려고 하면 그때그때의 최대값밖에 구할 수가 없음!
		 * 나를 기준으로 왼쪽 위에서 온 값과 오른쪽 위에서 내려온 값 중 최대값을 구해야 최종 최대값을 구할 수 있음(나로부터 내려가는게 아니라, 어딘가로부터 내려온 게 나라는 생각을 해야함)
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<i+1;j++) {
				dp[i][j] = keyboard.nextInt(); // i번째 가로줄에 i번째 숫자들 입력
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
