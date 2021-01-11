// chapter 7 이진탐색 - 반복문으로 구현
import java.util.*;

public class ch7_3_binary2 {
	
	public static int binary(int[] arr, int number) {
		int start = 0;
		int end = arr.length -1;
		int mid = (start + end)/2;
		
		while(start<=end) {
			mid = (start + end)/2;
			
			if(arr[mid] == number)
				return mid;
			else if(number < arr[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		
		// 원소가 없으면
		return -1;
	}
	
	public static void main(String[] args) {
		/* 실습 시간 : 8분 */
		
		 Scanner keyboard = new Scanner(System.in);
		 
		 int size = keyboard.nextInt();
		 int search = keyboard.nextInt();
		 int arr[] = new int[size];
		 
		 for(int i=0;i<size;i++) {
			 arr[i] = keyboard.nextInt();
		 }
		 
		 /* 코드 실행시간 계산 */
			long beforeTime = System.currentTimeMillis(); 
			
			int result = binary(arr,search);
			
			if(result == -1)
				System.out.println("원소가 존재하지 않습니다.");
			else
				System.out.println(result+1);
			
		/* 코드 실행시간 계산 */
	       long afterTime = System.currentTimeMillis();
	       long secDiffTime = (afterTime - beforeTime) / 1000;
	       System.out.println("실행시간(second) : " + secDiffTime);
	}

}
