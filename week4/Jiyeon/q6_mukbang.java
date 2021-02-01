// part3 - chapter 11 그리디 : 6번) 무지의 먹방 라이브
package greedy;

import java.util.*;

public class q6_mukbang {
	public static int n;
	public static int[] arr;
	
	public static int solution(int[] food_times, long k) {
		int answer = 0;
        int i = 1;
        while(i <= k){
            if(food_times[answer] == 0 ){
                answer = (answer+1) % food_times.length;
                continue;
            }
            
            food_times[answer]--;
            answer = (answer+1) % food_times.length;
            i++;
            
        }
        
        answer = (answer+1) % food_times.length;
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		/* 실습 시간 :  50 분 ( 1123 ~ 1213) 
		 * 기출 사이트에서 풀어보면, 반 정도 정답률 나옴! 시간 초과가 엄청 남 ㅠㅠㅠㅠ 
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		n = keyboard.nextInt();
		int k = keyboard.nextInt();
		arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = keyboard.nextInt();
		}
		
		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis();
		
		System.out.println(solution(arr,k));
		
	   /* 코드 실행시간 계산 */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n실행시간(second) : " + secDiffTime);

	}

}
