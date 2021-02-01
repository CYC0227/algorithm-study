// part3 - chapter 11 �׸��� : 6��) ������ �Թ� ���̺�
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
		
		/* �ǽ� �ð� :  50 �� ( 1123 ~ 1213) 
		 * ���� ����Ʈ���� Ǯ���, �� ���� ����� ����! �ð� �ʰ��� ��û �� �ФФФ� 
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		n = keyboard.nextInt();
		int k = keyboard.nextInt();
		arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = keyboard.nextInt();
		}
		
		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis();
		
		System.out.println(solution(arr,k));
		
	   /* �ڵ� ����ð� ��� */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n����ð�(second) : " + secDiffTime);

	}

}
