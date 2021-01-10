// chapter7 정렬 - 두 배열의 원소 교체

import java.util.*;

public class ch6_7 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int k = keyboard.nextInt();
		
		int[] a = new int[n];
		int[] b= new int[n];
		
		// 배열에 입력 받기
		for(int i=0;i<n;i++) {
			a[i] = keyboard.nextInt();
		}
		for(int i=0;i<n;i++) {
			b[i] = keyboard.nextInt();
		}
		
		// k번 반복
		for(int i=0;i<k;i++) {
			
			int min_index = 0;
			int max_index = 0;
			
			// a의 최소값과 b의 최대값 찾기
			for(int j=0;j<n;j++) {
				
				if(a[j] < a[min_index]) {
					min_index= j;
				}
				
				if(b[j]>b[max_index]) {
					max_index=j;
				}
				
			}
			
			// a의 최소값보다 b의 최대값이 크다면 교체
			if(a[min_index] < b[max_index]) {
				 int temp = a[min_index];
				 a[min_index] = b[max_index];
				 b[max_index] = temp;
			}
			
			// 더이상  배열에 a보다 큰 게 없으면 교체 종료
			else break;
			
		}
		
		int result = 0;
		for(int i=0;i<n;i++) {
			result+=a[i];
		}
		
		System.out.println(result); 

	}

}
