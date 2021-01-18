// chapter 8 다이나믹 플그래밍 - 효율적인 화폐 구성 (p.226)

import java.util.*;

public class ch8_6_coin {
	
	public static void main(String[] args) {
		/* 실습 시간 : 분 ( 2221 ~ INF) - 답지ㅠ 보고도 진짜 토할 듯이 어렵네.. 점화식 어려움
		 * 걍 너무 어려움. 끝까지 다이나믹은 어려움.ㅠㅠ 어쩌지..
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();	// 화폐의 가치가 주어질 n개의 줄
		int m = keyboard.nextInt(); // m원을 만들어야함
		
		// 만들 수 있는 화폐 구성 저장
		int coin[] = new int[n];
		for(int i=0;i<n;i++) {   
			coin[i] = keyboard.nextInt();
		}
		
		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis(); 
		
		int dp[] = new int[m+1]; // 0부터 m까지의 index를 가진 배열 생성
		
		// 0을 제외한 dp값을 10001로 초기화해준다. 0은 아무것도 사용하지 않았을 때이므로 0이 들어가는 게 맞다.
		// 10001은 m이 가질 수 있는 최대값인 10000보다 큰 값으로, INF를 의미한다.
		for(int i=1;i<=m;i++) {
			dp[i] = 10001;
		}
		
		for(int i=0;i<n;i++) { // 화폐단위 작은 것부터 큰 것으로 올라가며 m을 구성해본다.
			for(int j=coin[i];j<=m;j++) { // 현재 계산되는 화폐 값인 coin[i]를 가진 dp index부터 시작해서 m까지 올라가며 수행 ( bottom-up)
				
				// 현재 있는 dp지점부터 앞의 coin[i] 칸만큼을 확인해서, 만들 수 있는 방법이 있는지 없는지 체크
				if(dp[j-coin[i]] != 10001) // 10001이 아니면 만드는 방법이 있는거.
					dp[j] = Math.min(dp[j], dp[j-coin[i]] + 1); // 이 점화식 알아내는게 very important & difficult
			}
		}
		
		System.out.println(dp[m]);
		
	   /* 코드 실행시간 계산 */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n실행시간(second) : " + secDiffTime);
	}

}
