// chapter 16 다이나믹 프로그래밍 - 35번) 못생긴 수
package dp;

import java.util.*;

public class q35_uglyNum {
	
	public static void main(String[] args) {
		/* 실습 시간 : 분 ( 1233 ~ INF)
		 * 답지 봄 ㅠㅠ
		 * 답지 보고도 사실 잘 모르겠긴 함...
		 * 나중엔 저런 생각을 할 수 있겠지..?
		 * 
		 * 못생긴 수 2,3,5를 기본으로 해서 arr값을 차례대로 쭉 곱해서 min값을 arr에 반영함
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int[] arr = new int[n]; // 못생긴 수 저장하는 배열
		
		int i2=0, i3=0, i5=0;
		
		int next2=2, next3=3, next5=5; // 배열에 들어갈 후보값 3개 ( 비교해서 min값이 추가됨 )
		
		arr[0] = 1; // 1은 못생긴 수로 가정
		
		for(int l=1;l<n;l++) {
			arr[l] = Math.min(next2, Math.min(next3, next5));
			
			// next2, next3, next5는 각각 2,3,5의 곱들로 이루어진 수들임
			
			if(arr[l] == next2) {
				i2+=1; // 2의 인덱스 1 증가
				next2 = arr[i2]*2; // 인덱스 증가 후 그 자리 값에 2를 곱한 것을 배열에 들어갈 후보값에 넣어주기
			}
			if(arr[l] == next3) {
				i3+=1;
				next3 = arr[i3]*3;
			}
			if(arr[l] == next5) {
				i5+=1;
				next5 = arr[i5]*5;
			}
		}
		
		System.out.println(arr[n-1]);
		
		

	}

}
