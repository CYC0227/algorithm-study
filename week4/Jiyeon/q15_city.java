// part 3 chapter 12 dfs/bfs - 15번 ) 특정 거리의 도시 찾기 : bfs 이용

package dfs_bfs;

import java.util.*;

public class q15_city {
	
	public static int n; // 도시 개수
	public static int m; // 도로 개수
	public static int k; // 거리 정보
	public static int x; // 출발 도시 번호
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); // 도시 정보 그래프
	public static int[] dis; // 각 도시의 최단거리
	
	public static void bfs() {
		dis[x] = 0; // 출발 도시는 최단거리 0
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(x);
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			
			for(int i=0;i<graph.get(a).size();i++) {
				if(dis[graph.get(a).get(i)] == -1) { // 현재 node a와 연결된 노드가 -1이면 ( 방문 x면 )
					dis[graph.get(a).get(i)] = dis[a] + 1; // 현재 node a의 최단거리 +1을 해준다.
					queue.offer(graph.get(a).get(i)); // a와 연결되어있는 노드 하나를 queue에 넣어준다.
				}
			}
		}
		
		boolean flag = false;
		for(int i=1;i<=n;i++) {
			if( dis[i] == k ) {
				System.out.println(i);
				flag = true;
			}
		}
		
		if(!flag)
			System.out.println("-1");
	}
	
	public static void main(String[] args) {
		/* 실행 시간 : 19분 ( 1147 ~ 1208 ) */
		
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		m = keyboard.nextInt();
		k = keyboard.nextInt();
		x = keyboard.nextInt();
		dis = new int[n+1];
		
		for(int i=0;i<=n;i++) {
			dis[i] = -1; // 방문 안한 노드 체크
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<m;i++) {
			int a = keyboard.nextInt();
			int b = keyboard.nextInt();
			
			graph.get(a).add(b); // a에서 b로 갈 수 있음
		}
		
		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis();

		bfs();
		
	   /* 코드 실행시간 계산 */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n실행시간(second) : " + secDiffTime);

	}

}
