// part 3 greedy - 1번) 모험가 길드

package greedy;

import java.util.*;

public class q1_adventurer {

	public static void main(String[] args) {
		/* 실습 시간 : 11 분 ( 0818 ~ 0829 ) */
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int[] fear = new int[n];
		
		for(int i=0;i<n;i++) {
			fear[i] = keyboard.nextInt();
		}
		
		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis(); 
		
		Arrays.sort(fear); // 공포도를 오름차순으로 정렬
		
		int group = 0; // 그룹이 몇 개 만들어지는지 저장
		int i = n-1; // 그룹 지을 때 사용
		
		// 공포도가 큰 순서부터 작은 순서까지 진행하면서, 큰 그룹부터 묶어준다.
		while(i>=0) {
			
			int check = 0;
			// 공포도에 맞는 인원만큼 while문을 돌면서 다음 그룹의 첫 인덱스까지 i를 내려준다.
			while(check<fear[i]) {
				i--;
				check++;
			}
			group++; // 그룹이 하나 생성되었다. 
			i--;
		}
		
		System.out.println(group);
		
	   /* 코드 실행시간 계산 */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n실행시간(second) : " + secDiffTime);

	}

}
