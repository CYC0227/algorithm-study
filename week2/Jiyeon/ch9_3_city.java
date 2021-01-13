// chapter 9 최단 경로 - 미래도시 ( 플로이드 워셜 사용함 )

import java.util.*;

public class ch9_3_city {

	public static void main(String[] args) {
		/* 실습 시간 : 30 분 (1650 ~ 1719)
		 * 왜? X랑 K를 반대로 입력받음 ㅠㅠ 소개팅 장소랑 회사랑 헷갈렸다는거지... 
		 * 오예~ 답지랑 방법 똑같음~ good~
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		int INF = 999;
		
		int vertex = keyboard.nextInt();
		int edge = keyboard.nextInt();
		int[][] arr = new int[vertex+1][vertex+1];
		int visit; // value of x
		int dest; // value of k
		int result = 0;
		
		// 이차원 배열 초기화 ( 0 혹은 INF )
		for(int i=1;i<=vertex;i++) {
			for(int j=1;j<=vertex;j++) {
				if(i==j)
					arr[i][j] = 0;
				else
					arr[i][j] = INF;
			}
		}
		
		for(int i=0;i<edge;i++) {
			int a = keyboard.nextInt();
			int b = keyboard.nextInt();
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		dest = keyboard.nextInt();
		visit = keyboard.nextInt();

		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis(); 
		
		// floyd-Warshall사용해서 1부터 visit까지 값 + visit부터 dest까지 값을 더해서 결과 출력
		for(int k=1;k<=vertex;k++) {
			for(int i=1;i<=vertex;i++) {
				for(int j=1;j<=vertex;j++) {
					if(k==i || k==j || i==j)
						continue;
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		
		result = arr[1][visit] + arr[visit][dest];
		
		// 갈 방법이 없는 경우
		if(result>=INF) 
			System.out.println("-1");
		else
			System.out.println(result);
		
	   /* 코드 실행시간 계산 */
       long afterTime = System.currentTimeMillis(); 
       long secDiffTime = (afterTime - beforeTime) / 1000; 
       System.out.println("\n실행시간(second) : " + secDiffTime); 

	}

}
