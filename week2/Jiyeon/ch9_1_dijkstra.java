// chapter 9 최단 경로 - 간단한 다익스트라 알고리즘  
import java.util.*;

public class ch9_1_dijkstra {
	public static int INF = 999; // 무한 값 설정
	public static boolean[] visited;
	public static int[] dis;
	public static int vertex;
	public static int edge;
	public static int[] from;
	public static int[] to;
	public static int[] value;
	
	// 방문하지 않은 노드 중에서 가장 짧은 최단거리 찾아주기
	public static int shortest(int now) {
		
		for(int i=0;i<edge;i++) {
			if(from[i] == now && !visited[to[i]]) {
				int temp = dis[now] + value[i];
				if(temp < dis[to[i]]) {
					dis[to[i]] = temp;
				}
			}
		}
		
		int next = 0;
		int min = INF;
		for(int i=1;i<=vertex;i++) {
			if(!visited[i] && dis[i] < min) {
				min = dis[vertex];
				next = i;
			}
		}
		visited[next] = true;
		return next;
	}
	
	// vertex 개수만큼 노드를 거쳐서 최단거리를 구한다. 
	public static void dijkstra(int start) {
		int next = start;
		visited[start] = true;                                                                                                                                                                                                                                 
		
		for(int i=0;i<vertex;i++) {
			next = shortest(next);
		}
	}
	
	public static void main(String[] args) {
		/* 실습 시간 : 68분 (1010 ~ 1118)
		 * 어려운 점 : shortest에서 next 결정할 때 인덱스 값으로 i를 써야하는데 계속 vertex를 사용함... 
		 * */
		Scanner keyboard = new Scanner(System.in);
		
		vertex = keyboard.nextInt(); // 노드 개수
		edge = keyboard.nextInt(); // 간선 개수
		int start = keyboard.nextInt(); // 시작 노드
		visited = new boolean[vertex+1];
		dis = new int[vertex+1];
		from = new int[edge];
		to = new int[edge];
		value = new int[edge];

		// 간선 정보 입력받기
		for(int i=0;i<edge;i++) {
			from[i] = keyboard.nextInt();
			to[i] = keyboard.nextInt();
			value[i] = keyboard.nextInt();
		}
		
		// 방문확인 배열 false로 초기화
		for(int i=1;i<=vertex;i++) {
			visited[i] = false;
		}
		
		// 최단거리 배열 INF로 초기화
		for(int i=1;i<=vertex;i++) {
			if(i == start) // 시작점은 0으로 초기화
				dis[i] = 0;
			else
				dis[i] = INF;
		}
		
	    dijkstra(start);
	    
	    for(int i=1;i<=vertex;i++) {
			System.out.println(dis[i]);
		}
	}

}
