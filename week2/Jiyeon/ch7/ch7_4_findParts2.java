// chapter 7 이진탐색 - 부품찾기 (계수정렬)

import java.util.Arrays;
import java.util.Scanner;

public class ch7_4_findParts2 {

	// 계수정렬 이용 : 가게가 가지고 있는 부품의 index를 1로 해줃다.
		
		public static void main(String[] args) {
			/* 실습 시간 : 6분 (2143 ~ 2149) 
			 * 어려운 점 : X
			 * */
			
			Scanner keyboard = new Scanner(System.in);
			
			// 가게 재고
			int n = keyboard.nextInt();
			int[] store = new int[1000000]; // 계수정렬에 이용할 배열
			for(int i=0;i<n;i++) {
				int check = keyboard.nextInt();
				store[check] = 1; // 가게가 가지고 있는 부품의 array는 1로 바꿔준다.
			}
			
			// 손님 요청
			int m = keyboard.nextInt();
			int[] customer = new int[m];
			for(int i=0;i<m;i++) {
				customer[i] = keyboard.nextInt();
			}
			
			
			// 손님이 요청한 부품 있는지 확인 & 출력
			for(int i=0;i<m;i++) {
				if(store[customer[i]] == 1)
					System.out.print("yes ");
				else
					System.out.print("no ");
			}
		}
}
