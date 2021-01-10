// 그리디 - 숫자 카드 게임

import java.util.*;
public class ch3_3 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int m = keyboard.nextInt();
		int result = 0; // 최소값 중 최대값을 저장할 변수
		
		for(int i=0; i<n; i++) {
			int min = 101;	// 각 행의 최소값
			
			/* 각 행에서 최소값을 찾는다 */
			for(int j=0; j<m; j++) {
				int a = keyboard.nextInt();
				if( a < min )
					min = a;
			}
			
			/* 찾은 최소값과 result를 비교하여 더 큰 값을 result에 저장 */
			if( min > result )
				result = min;
		}
		
		System.out.println(result);
		
	}
}
