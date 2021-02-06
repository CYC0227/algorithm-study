// part 3 - chapter 14 정렬문제  : 24번) 안테나
package sort;

import java.util.*;

public class q24_antenna {
	
	public static int n; // 집의 수
	public static int[] arr; // 집 배열
	
	public static void sort() {
		for(int i=0;i<n;i++) {
			for(int j=i;j<n-1;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		/* 실습 시간 : 17 분  ( 1014 ~ 1032) 
		 * 중간 값이 최소값이라는 것을 모르고, 하나씩 죄다 값을 구해보다가 n이 말도안되게 큰 것을 발견...
		 * 그리고 나는 sort를 만들었는데, 자바에서 만든 sort 사용하자 다음엔
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt(); // 집의 수 n
		arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = keyboard.nextInt(); // 집 위치
		}
		
		sort(); // 오름차순으로 정렬
		
		// 중간 값이 합을 가장 최소로 하는 지점이다
		if(n%2 == 0) // 짝수인 경우 둘 중 첫 번째 값
			System.out.println(arr[n/2 -1]); // n/2번째 집이니까 arr상에서는 -1한 지점 ( arr가 0부터 시작함 )
		else // 홀수인 경우
			System.out.println(arr[(n+1) / 2]);
	}

}
