// part 3 - chapter 14 정렬 문제 : 26번 ) 카드 정렬하기
package sort;

import java.util.*;

public class q26_card {
	
	public static void main(String[] args) {
		/* 실습시간 : 9 분 ( 1044 ~ 1053 ) 
		 * 오름차순으로 정렬해서 앞에서부터 더하는 것이 가장 작은 결과값이라고 생각함.
		 * 예시로 나온 테스트케이스에는 잘 맞는데, 모든 케이스에 맞는 것인지는 잘 모르겠음
		 * */
		
		Scanner keyboard = new Scanner(System.in);

		int n; // 숫자카드 n개
		ArrayList<Integer> card = new ArrayList<>();
		
		n = keyboard.nextInt();
		
		for(int i=0;i<n;i++) {
			int a = keyboard.nextInt();
			card.add(a);
		}
		
		Collections.sort(card); // 오름착순으로 카드 묶음 정리하기
		
		int sum = card.get(0) + card.get(1); // 첫번째 연산 결과는 arraylist의 첫 번째와 두 번째 합친 것
		int now = sum;
		
		for(int i=2;i<n;i++) {
			now += card.get(i); // 현재까지의 계산 값에 i번째 값을 더해준다.
			sum += now; // 더한만큼을 전체 결과에 더해서 계산한다.
		}
		
		System.out.println(sum);
	}

}
