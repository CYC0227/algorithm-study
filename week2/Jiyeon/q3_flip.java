// part 3 그리디 - 3번) 문자열 뒤집기
package greedy;

import java.util.*;

public class q3_flip {

	public static void main(String[] args) {
		/* 실습 시간 : 31 분 ( 0928 ~ 0959)
		 * 어려운 점 : for문 돌 대, 범위가 자꾸 헷갈려서 index 오류가 계속 남
		 * 답지랑 비교했을 떼, n1과 n2의 정의가 반대라서 딱 반대의 코드가 나옴 굳~
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		String str = keyboard.nextLine();
		String[] num = str.split("");

		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis(); 
		
		int n1 = 0; // 0을 1로 바꿀 때
		int n2 = 0; // 1을 0으로 바꿀 때
		
		if(str.charAt(0)-'0' == 0)
			n1++;
		else
			n2++;
		
		for(int i=0;i<str.length()-1;i++){
			
			// 현재 숫자랑 뒤의 숫자랑 같지 않을 경우, 문자열 뒤집기 실행
			if(str.charAt(i) != str.charAt(i+1)) {
				if(str.charAt(i)-'0' == 1) { // 0을 1로 바꿀 때
					n1++;
				}
				else // 1울 0으로 바꿀 때
					n2++;
					
			}
		}
		
		if(n1>n2)
			System.out.println(n2);
		else
			System.out.println(n1);
		
	    /* 코드 실행시간 계산 */
	    long afterTime = System.currentTimeMillis();
	    long secDiffTime = (afterTime - beforeTime) / 1000;
	    System.out.println("\n실행시간(second) : " + secDiffTime);
	}

}
