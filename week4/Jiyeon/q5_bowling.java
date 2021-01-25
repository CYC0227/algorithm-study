// part3 - chapter 11 그리디 : 5번) 볼링공 고르기
package greedy;

import java.util.*;

public class q5_bowling {

	public static void main(String[] args) {
		/* 실습시간 : 7분 ( 1111 ~ 1118)
		 * 이중 for문을 사용했는데, 모범답안은 그게 아니네
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt(); // 볼링 공 개수
		int m = keyboard.nextInt(); // 볼링 공 최대 무게
		int[] arr = new int[n]; // 각 볼링공의 무게
		
		for(int i=0;i<n;i++) {
			arr[i] = keyboard.nextInt();
		}
		
		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis(); 
		
		int result = 0; // 두 사람이 고를 수 있는 경우의 수
		
		/* 큰 for문 : 0부터 n까지
		 * 작은 for문 : i부터 n까지
		 * 돌면서 두 숫자를 비교. 다르면 result+1
		 * */
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i] != arr[j])
					result++;
			}
		}
		
		System.out.println(result);
		
	   /* 코드 실행시간 계산 */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n실행시간(second) : " + secDiffTime);
	}

}
