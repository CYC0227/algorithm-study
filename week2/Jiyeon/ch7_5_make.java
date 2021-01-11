// chapter 7 이진탐색 - 떡볶이 떡 만들기(이진탐색x)
import java.util.*;

public class ch7_5_make {

	public static void main(String[] args) {
		/* 실습 시간 : 26분 (1352~1418) */
		
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
		
		int result = 0;
		
		// 떡집이 가지고 있는 떡의 길이 중 최대 값 -1 부터 0까지 돌면서 확인한다.
		for(int i = arr[n-1]-1; i>=0;i--) {
			int sum = 0;
			
			for(int j=0;j<arr.length;j++) {
				if(arr[j] > i)
					sum += arr[j] - i;
			}
			
			if(sum >= m) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
		
	   /* 코드 실행시간 계산 */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n실행시간(second) : " + secDiffTime);
		

	}

}
