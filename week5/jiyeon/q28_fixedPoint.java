// chapter 15 - 이진 탐색 문제 : 28번) 고정점 찾기
package binarySearch;

import java.util.*;

public class q28_fixedPoint {
	
	public static int n; // 서로다른 원소 n개
	public static int[] arr; // 수열 ( 오름차순 정렬 )
	
	public static int search(int start, int end) {
		if(start > end) return -1; // start가 end보다 클 때 : 고정점 없을 때
		
		int mid = (start + end) / 2;
		
		// 고정점을 찾은 경우
		if(arr[mid] == mid) 
			return mid;
		
		// 배열 값이 mid값보다 작을 때 : 오른쪽 탐색
		else if(arr[mid] < mid)
			return search(mid+1,end);
		
		else
			return search(start,mid-1);
	}
	
	public static void main(String[] args) {
		/* 실습 시간 : 10분 ( 1033 ~ 1043) 
		 * 솔직히 얻어 걸림. ㅋㅋㅋ
		 * 이진탐색 문제길래 이진탐색으로 해봤더니 그냥 되더라 ㅠㅠㅠ 
		 * 왜 왼쪽탐색하고 오른쪽 탐색하면 되는건지는 잘 모르겠음..
		 * */
		
		Scanner keyboard = new Scanner(System.in);

		n = keyboard.nextInt();
		arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = keyboard.nextInt();
		}
		
		System.out.println(search(0,n-1));

	}

}
