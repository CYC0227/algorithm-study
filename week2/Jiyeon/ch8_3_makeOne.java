// chapter 8 다이나믹 프로그래밍 - 1로 만들기

import java.util.*;

public class ch8_3_makeOne {

	public static void main(String[] args) {
		/* 실습 시간 : 66 분 ( 1016 ~ 1122)
		 * 점화식을 잘못 세움. dp[i/2] + 1 부분을 i /2로 함. 7까지는 잘 돌아가는데, 8부터는 값이 커져버림...
		 * i/2 로 하면 안되는 이유 : 예를 들어 8의 경우, 8/2=4이므로 dp[8]=4다.
		 * 근데 8을 2로 4번 나눌 필요 없이, 8을 2로 나눈 후 4의 dp값을 가지면 더 작아진다. dp[4]=2이므로, dp[4]에 +1(4로 만들 때 한 번 연산했으니까 +1)을 해서 가지는게 min이라는 것!
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int[] dp = new int[n+1];	// i번째 숫자까지 계산되는 최솟값
		
		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis(); 
		
		/* dp[1]은 이미 1이 되었기 때문에 연산 횟수가 0. for문에서 제외
		 * 2부터 n까지 for문을 돌면서, i번째 숫자가 1이 될 때까지 연산 횟수를 비교해서 min값을 저장한다.
		 * */
		for(int i=2;i<=n;i++) { // bottom-up
			// 일단 dp[i]에 1을 빼는 연산을 시킨 횟수를 저장. (i-1번째 값이 i보다 1 작은 값이니까, 일단 1만큼 빼면 i-1번째 연산 값을 사용하면 됨. i-1번째 연산 횟수에서 1을 더한 값이 i번째의 연산 횟수와 동일.)
			dp[i] = dp[i-1] + 1;
			
			/* 1을 빼는 것과, 나누기를 하는 것 중 더 연산 횟수가 적은 값으로 선택해서 dp[i]에 저장 : 현재 dp[i]에는 1을 빼는 연산 횟수가 저장되어 있음 */
			if(i % 2 == 0) {
				//System.out.println("i : "+i+" ,dp[i/2] : " + dp[i/2]);
				dp[i] = Math.min(dp[i], dp[i / 2] +1); // +1 : 나누기의 몫
			}
			if(i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			if(i % 5 == 0)
				dp[i] = Math.min(dp[i], dp[i / 5] + 1);
			System.out.print(dp[i] + " ");
		}System.out.println();
		
		System.out.println(dp[n]);
		
	   /* 코드 실행시간 계산 */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n실행시간(second) : " + secDiffTime);

	}

}
