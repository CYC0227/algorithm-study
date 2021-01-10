import java.util.Scanner;
public class _2_bignumRule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N, M, K;
		int[] arr = new int[999];
		Scanner sc = new Scanner(System.in);
		//입력
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		//큰 수 찾기 && 2번째 큰 수 찾기
		int max = 0;
		int max2 = 0;
		for(int j=0; j<N; j++) {
			if(arr[j]>=max) {
				max2 = max;
				max = arr[j];
			}
		}
		
		//큰 수 구하기
		int sum = 0;
		for(int i=0; i<M/K; i++) {
			
			for(int j=0; j<K; j++) {
				sum += max;
			}
		
		}
		
		//남은 M만큼 2번째로 큰 것 더하기
		for(int i=0; i<M%K; i++) {
			sum += max2;
		}
		
		//출력
		System.out.println(sum);
	}

}

//////////답지//////////
/*
import java.util.*;

public class _2_bignumRule {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N, M, K를 공백을 기준으로 구분하여 입력 받기
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		// N개의 수를 공백을 기준으로 구분하여 입력 받기
		int[] arr = new int[n];
		for(int i=0; i<n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		arrays.sort(arr);// 입력 받은 수들 정렬하기
		int first = arr[n-1];// 가장 큰 수
		int second = arr[n-2];// 두 번째로 큰 수
		
		// 가장 큰 수가 더해지는 횟수 계산
		int cnt = (m / (k+1)) * k;
		cnt += m % (k+1);
		
		int result = 0;
		result += cnt * first; // 가장 큰 수 더하기
		result += (m - cnt) * second;// 두 번째로 큰 수 더하기
		
		System.out.println(result);
		
	}
}
*/












