// chapter 7 이진탐색 - 떡볶이 떡 만들기 (이진탐색o)
import java.util.*;

		public class ch7_5_make2 {
	
			public static void main(String[] args) {
				/* 실습 시간 : 12분 (1427~1439) */
				
				Scanner keyboard = new Scanner(System.in);
				
				int n = keyboard.nextInt(); // 떡의 개수
				int m = keyboard.nextInt(); // 떡의 길이
				int arr[] = new int[n];

				for(int i=0;i<n;i++) {
					arr[i] = keyboard.nextInt();
				}
				/* 코드 실행시간 계산 */
				long beforeTime = System.currentTimeMillis(); 
				
				// 떡 길이 배열 정렬
				Arrays.sort(arr);
				
				int start = 0;
				int end = arr[n-1];
				
				int result = 0;
				
				while(start <= end) {
					int mid = (start + end) / 2;
					int sum = 0;
					
					for(int i=0;i<n;i++) {
						if(arr[i] > mid)
							sum += arr[i] - mid;
					}
					
					// 떡이 m보다 클 때 (합격) -> 오른쪽 search
					if(sum >= m) {
						result = mid;	// 조금 더 나은 최대값이 있는지 확인하러 가기 전에, 현재 mid값 저장.(이 값이 최선일까봐)
						start = mid + 1; // 오른쪽 search
					}
					
					// 떡의 양이 m보다 작을 때 -> 기준을 더 낮춰서 많이 자를 수 있게 한다 (왼쪽 search)
					else {
						end = mid - 1;
					}
				}
				
				System.out.println(result);
				
			   /* 코드 실행시간 계산 */
		       long afterTime = System.currentTimeMillis();
		       long secDiffTime = (afterTime - beforeTime) / 1000;
		       System.out.println("\n실행시간(second) : " + secDiffTime);
				


	}
}
