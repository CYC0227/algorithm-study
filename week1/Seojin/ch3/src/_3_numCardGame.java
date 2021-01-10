import java.util.*;

public class _3_numCardGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//각 행마다 가장 작은 수 찾기
		int[] minarr = new int[N];
		int min = 10000;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] < min)
					min = arr[i][j];
			}
			minarr[i] = min;
			min = 10000;
		}
		
		//minarr 중에서 가장 큰 수 찾기
		int max = 0;
		
		for(int i=0; i<N; i++) {
			if(minarr[i] > max)
				max = minarr[i];
		}
		
		System.out.println(max);
		
	}

}

//////////답지//////////
/*
import java.util.*;

public class _3_numCardGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N, M을 공백을 기준으로 구분하여 입력 받기
		int n = sc.nextInt();
		int m = sc.nextInt();
		int result = 0;
		
		//한 줄씩 입력 받아 확인하기
		for(int i=0; i<n; i++) {
			//현재 줄에서 '가장 작은 수' 찾기
			int min_value = 10001;
			for(int j=0; j<m; j++) {
				int x = sc.nextInt();
				min_value = Math.min(min_value,x);	
			}
			//'가장 작은 수'들 중에서 가장 큰 수 찾기
			result = Math.max(result, min_value);
		}
		
		System.out.println(result);// 최종 답안 출력
	}
}
*/







