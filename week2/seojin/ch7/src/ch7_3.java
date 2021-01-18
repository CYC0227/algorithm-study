/*
 35분_ (코드 짤 때)떡의 길이 빼는게 약간 헷갈림.
  	   (코딩 실수)sum 변수를 0으로 초기화하지 않은 상태로 계속 while문 돌게 함 + if문 조건 잘못적음
 */
import java.util.*;

public class ch7_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[]arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int start = 0;
		int end = arr[n-1];
		// 이진 탐색
		while(start <= end) {
			int mid = (start + end) / 2;
			int[] cut = new int[n];
			// 자른 후 ,합 구하기
			int sum = 0 ;
			for(int i=0; i<n; i++) {
				cut[i] = arr[i] - mid;
				if(cut[i]<0) cut[i] = 0;
				//System.out.println(cut[i]);
				sum += cut[i];
			}
			// m보다 큰 경우
			if(sum == m) { 
				System.out.println(mid);
				break;
			}
			else if(sum < m) end = mid - 1;
			else start = mid + 1;
		}
	
	}

}
