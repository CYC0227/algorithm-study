// chapter 9 최단 경로 - 플로이드 워셜 최단경로  

import java.util.*;

public class ch9_2_floydWarshall {
	
	public static int INF = 999;
	
	public static void main(String[] args) {
		/* 실습시간 : 37분 (1603 ~ 1640)
		 * 왜? i랑 j랑 헷갈려서... 
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		int vertex = keyboard.nextInt();
		int edge = keyboard.nextInt();
		int[][] arr = new int[vertex+1][vertex+1];
		
		// 처음 이차원 배열 0 혹은 INF로 초기화하기
		for(int i=1;i<=vertex;i++) {
			for(int j=1;j<=vertex;j++) {
				if(i==j)
					arr[i][j] = 0;
				else
					arr[i][j] = INF;
			}
		}
		
		// 간선 정보 2차원 배열에 입력받기
		for(int i=0;i<edge;i++) {
			int from = keyboard.nextInt();
			int to = keyboard.nextInt();
			int value = keyboard.nextInt();
			
			arr[from][to] = value;
		}
		
		// for문을 vertex 수만큼 돌려서 k를 지정한다.
		for(int k=1;k<=vertex;k++) {
			
			// k를 제외한 것들의 조합만큼 min값을 정해서 업데이트 한다.
			for(int i=1;i<=vertex;i++) {
				for(int j=1;j<=vertex;j++) {
					if(i==j || i==k || j==k)
						continue;
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
				
			}
		}
		
		for(int i=1;i<=vertex;i++) {
			for(int j=1;j<=vertex;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		

	}

}
