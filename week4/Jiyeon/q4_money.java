// part 3 - chapter11 그리디 : 4번) 만들 수 없는 금액
package greedy;

import java.util.*;

public class q4_money {

	public static void main(String[] args) {
		/* 실습시간 : 16분 ( 1134 ~ 1150 )
		 * 동전을 여러 번 사용할 수 있는 것이 아니라, 한 번씩만 사용할 수 있기 때문에 동전의 조합을 여러 개 생각할 필요가 없다. 그리디로 가능!
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int[] coin = new int[n];
		
		for(int i=0;i<n;i++) {
			coin[i] = keyboard.nextInt();
		}
		
		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis(); 
		
		Arrays.sort(coin); // 가지고 있는 동전을 오름차순으로 정렬
		
		int min = 1; // 초기 min값은 1 ( 최소값이니까 )
		/* 0부터 n-1까지 올라가면서, coin[i]로 만들 수 있는지 없는지 판단*/
		for(int i=0;i<n;i++) {
			/* 현재 min값이 coin[i]값보다 작으면 min값 찾은거임
			 * 만약 break가 한 번도 걸리지 않았다면 coin 배열에 있는 값 모두를 더한 수 +1 이 min값이 된다.(min 초기값이 1이었으니까)*/
			if(min < coin[i])
				break;
			
			min += coin[i]; // 현재 가진 돈으로 i값을 만들 수 없다면, min값에 coin[i]를 더함
		}
		
		System.out.println(min);
		
	   /* 코드 실행시간 계산 */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n실행시간(second) : " + secDiffTime);

	}

}
