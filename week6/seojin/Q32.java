import java.util.*;

public class Q32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int col = 0;
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			col++;
			for(int j=0; j<col; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int[][] dp = new int[n][n];
		//dp 테이블 초기화
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				dp[i][j] = arr[i][j];
			}
		}
		
		//다이나믹 프로그래밍
		for(int i=1; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(j==0) {
					dp[i][j] = dp[i][j] + dp[i-1][j];
				}
				else
					dp[i][j] = dp[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
			}
		}
		
		int result = 0;
		for(int j=0; j<n; j++) {
			result = Math.max(result, dp[n-1][j]);
		}
		System.out.println(result);
		//디버깅
		/*
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		*/
	}

}
