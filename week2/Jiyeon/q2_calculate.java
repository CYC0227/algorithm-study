// part 3 그리디 - 2번) 곱하기 혹은 더하기

package greedy;

import java.util.*;
public class q2_calculate {

	public static void main(String[] args) {
		/* 실습 시간 : 11 분 ( 0834 ~ 0845 ) */
		Scanner keyboard = new Scanner(System.in);
		
		String str = keyboard.nextLine();
		
		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis(); 
		
		
		String[] arr = str.split("");
		int[] num = new int[arr.length];
		
		for(int i=0;i<num.length;i++) {
			num[i] = Integer.parseInt(arr[i]);
		}
		
		int i = 1;
		int result = num[0]; // 결과의 초기값은 배열의 첫번째 숫자
		
		while(i < num.length) {
			
			// 0이나 1이 포함되어 있다면, 더하기를 하는 것이 더 큰 값을 만든다.
			if(num[i] == 0 || num[i] == 1 || result == 0 || result == 1) { // 앞선 결과값이 0이나 1이거나, 현재 계산해야 할 새로운 값이 0이나 1일 경우
				result += num[i];
			}
			
			// 그 외의 것은 곱한다.
			else {
				result *= num[i];
			}
			
			i++;
		}
		
		System.out.println(result);
		
		/* 코드 실행시간 계산 */
	    long afterTime = System.currentTimeMillis();
	    long secDiffTime = (afterTime - beforeTime) / 1000;
	    System.out.println("\n실행시간(second) : " + secDiffTime);
	    
	    
	    /* 모법 답안 : 문자열을 분리해서 배열에 담지 않고, charAt() 사용 & -'0' 사용해서 숫자로 변경. 코드가 깔~끔해짐 */

	}

}
