// chapter 16 다이나믹 프로그래밍 - 36번 ) 편집 거리
package dp;
import java.util.*;

public class q36_editDistance {

	public static void main(String[] args) {
		/* 실습 시간 : 28 분 ( 0956 ~ 1024) */
		Scanner keyboard = new Scanner(System.in);
		
		String str1; // 원래 string
		String str2; // 최종 string
		
		str1 = keyboard.nextLine();
		str2 = keyboard.nextLine();
		
		int[][] dp = new int[str2.length()+1][str1.length()+1]; // 가로줄에 원래 string, 세로줄에 최종 string 배치
		
		// 배열 초기화
		dp[0][0] = 0;
		for(int i=1;i<str1.length()+1;i++) {
			dp[0][i] = i;
		}
		for(int i=1;i<str2.length()+1;i++) {
			dp[i][0] = i;
		}
		
		// 삽입, 삭제, 교체시 1씩 증가한다. 
		// 이때 삽입은 위쪽에서 오고, 삭제는 왼쪽에서, 교체는 왼쪽 위에서 온다.
		// 배열의 각 칸에서 가로줄이 세로줄로 되기 위해서 필요한 최소값을 찾는 것
		
		for(int i=1;i<str2.length()+1;i++) {
			for(int j=1;j<str1.length()+1;j++) {
				// 두 문자가 일치하면, 아무 연산 안 함 ( 왼쪽 위에서 그대로 값 가져옴 )
				if(str1.charAt(j-1) == str2.charAt(i-1))
					dp[i][j] = dp[i-1][j-1];
				// 일치하지 않으면 왼,위,왼위 값 중 최소에서 1 증가 ( 위 : 삽입, 왼 : 삭제, 왼위 : 교체 )
				else {
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
				}
			}
		}
		
		System.out.println(dp[str2.length()][str1.length()]);
		
	}

}
