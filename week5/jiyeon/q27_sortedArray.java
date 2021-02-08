// part 3 - chapter 15 이진 탐색 문제 : 27번 ) 정렬된 배열에서 특정 수의 개수 구하기
package binarySearch;

import java.util.*;

public class q27_sortedArray {
	
	public static int n; // n개의 원소
	public static int x; // x가 등장하는 횟수 구하기
	public static int[] arr; // n개의 원소를 포함하는 수열 ( 오름차순으로 정렬되어 있음 )
	public static int result = 0; // x가 몇개 나오는지 저장하는 변수
	public static int index = -1;
	
	public static void search(int start, int end) {
		if( start > end ) return;
		
		int mid = (start + end) / 2;
		
		if(arr[mid] == x) {
			index = mid;
		}
		else if (arr[mid] < x) {
			search(mid+1, end);
		}
		else 
			search(start, mid);
	}
	
	public static void main(String[] args) {
		/* 실습 시간 : 21 분 ( 1116 ~ 1137 )
		 * for문 2개 써서 결과값 출력했는데, 시간 초과 날 
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		x = keyboard.nextInt();
		arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = keyboard.nextInt();
		}
		
		search(0,n-1);
		
		if(index == -1)
			System.out.println("-1");
		
		else {
			 for(int i=index; i>=0; i--) {
				 if(arr[i] == x)
					 result++;
				 else
					 break;
			 }
			 for(int i=index+1;i<n;i++) {
				 if(arr[i] == x)
					 result++;
				 else
					 break;
			 }
			 System.out.println(result);
		}
		

	}

}
