// chapter 8 다이나믹 프로그래밍 - 개미전사 (p.220)

import java.util.*;

public class ch8_4_ant {

	public static void main(String[] args) {
		/* 실습 시간 :  37 분 (2222 ~ 2259) 
		 * 처음 생각한 거 : arr[0]부터 두 칸 이상씩 더했을 때 가장 큰 값인 게 정답 아닌가? -> 아.. 어.. 아니네...
		 * !! 잊지 말아야 할거 : 다이나믹 프로그래밍은 큰 문제를 작은 문제로 푸는 것!!
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int[] arr = new int[n];  
		int[] dp = new int[n];	// 왼쪽부터 i번째까지 식량창고가 있다고 가정할 때, max로 얻을 수 있는 식량 수 ( 0부터 i번째까지만 고려한다 )
		
		// 식량 수 입력받아서 저장
		for(int i=0;i<n;i++) {
			arr[i] = keyboard.nextInt();
		}
		
		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis(); 
		
		dp[0] = arr[0]; // 0번째까지 있을때, 0번째를 터는 것이 max
		dp[1] = Math.max(arr[0], arr[1]); // 1번째까지 있을 때, 0번째나 1번째를 터는 것이 max
	
		// bottom-up ( 왼쪽부터 i번째까지 )
		for(int i=2;i<n;i++) {
			// 점화식 : i번째 식량창고까지 있을 때, i번째&i-2번째 식량창고를 터는 것과, i-1번째 식량창고를 터는 것 중 max를 dp[i]에 저장. i-3부터는 고려x (앞에서 이미 고려해서 저장함)
			dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
		}
				
		System.out.println(dp[n-1]);
		
	   /* 코드 실행시간 계산 */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n실행시간(second) : " + secDiffTime);
		
	}

}
