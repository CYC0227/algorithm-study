// part3 - chapter 12 구현 : 8번) 문자열 재정열

package greedy;

import java.util.*;

public class q8_string {

	public static void main(String[] args) {
		/* 실습 시간 : 26분 ( 1302 ~ 1328 )
		 * 어떻게 해야 잘 구현하는건지 몰라서 너무너무 어려웠다.. ㅎㅎㅎㅎ
		 * 나 : 새로운 결과list를 만들지 않고, 우선 입력 받은 배열을 정렬 -> 숫자는 모두 앞으로 감.
		 * -> 알파벳 시작하는 index부터 끝까지 출력하고, 숫자들은 다 더하기
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		String str = keyboard.nextLine();
		
		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis();
		
		char[] chars = str.toCharArray();
		
		Arrays.sort(chars);
		
		int sum = 0;
		int index = 0;
		
		for(int i=0;i<chars.length;i++) {
			if(chars[i]>=65 && chars[i]<=90) {
				index = i;
				break;
			}
			else
				sum += Character.getNumericValue(chars[i]);
		}
		
		for(int i=index;i<chars.length;i++) {
			System.out.print(chars[i]);
		}
		System.out.println(sum);

		/* 코드 실행시간 계산 */
	    long afterTime = System.currentTimeMillis();
	    long secDiffTime = (afterTime - beforeTime) / 1000;
	    System.out.println("\n실행시간(second) : " + secDiffTime);
	}

}
