// part3 - chapter 12 구현 : 7번) 럭키 스트레이트
package greedy;

import java.util.*;

public class q7_lucky {

	public static void main(String[] args) {
		/* 실습시간 : 11 분 ( 1108 ~ 1119)  
		 * 나 : 왼쪽==오른쪽 비교 ( sum 변수 2 개 )
		 * 모범답안 : 왼쪽-오른쪽 = 0 으로 비교 ( summary 변수 1개 )
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		String n = keyboard.nextLine(); // 현재 캐릭터의 점수 n
		
		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis();
		
		int left = 0;
		int right = 0;
		
		for(int i=0;i<n.length()/2;i++) {
			left += n.charAt(i);
		}
		for(int i=n.length()/2;i<n.length();i++) {
			right+= n.charAt(i);
		}
		
		if(left==right)
			System.out.println("LUCKY");
		else
			System.out.println("READY");
	   /* 코드 실행시간 계산 */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n실행시간(second) : " + secDiffTime);
		

	}

}
