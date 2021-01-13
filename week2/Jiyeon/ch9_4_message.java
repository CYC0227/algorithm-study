// chapter 9 최단 경로 - 전보 ( floyd-warshall 사용 )

import java.util.*;

public class ch9_4_message {

	public static void main(String[] args) {
		/* 실습 시간 :  10분 ( 1724 ~ 1735)
		 * 원래 60분짜리 문젠데, 어 내가 야매?로 플로이드 사용해서 10분 걸린듯 ㅠㅠ 다익스트라 어려워....
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		int INF = 1001;
		
		int n = keyboard.nextInt(); // 도시 개수
		int m = keyboard.nextInt(); // 통로 개수
		int c = keyboard.nextInt(); // 메시지 보낼 도시
		int[][] arr = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j)
					arr[i][j] = 0;
				else
					arr[i][j] = INF;
			}
		}
		
		for(int i=0;i<m;i++) {
			int from = keyboard.nextInt();
			int to = keyboard.nextInt();
			int value = keyboard.nextInt();
			arr[from][to] = value;
		}
		
		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis(); 
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(k==1 || k==j || i==j)
						continue;
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		
		int num = 0;
		int time = 0;
		
		// floyd-warshall 사용해서 배열 값 업데이트
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				// 통로가 있다면
				if(arr[i][j]<INF && arr[i][j]!=0) {
					num++; // 전할 수 있는 도시 수 +1
					if(arr[i][j] > time) // 기존에 걸리던 시간보다 오래 걸리면 그 시간으로 update ( 모든 도시가 전달받으려면 제일 오래걸리는 도시의 시간 사용하면 됨 )
						time = arr[i][j];
				}
			}
		}
		
		System.out.println(num+" "+time);
	   /* 코드 실행시간 계산 */
       long afterTime = System.currentTimeMillis();
       long secDiffTime = (afterTime - beforeTime) / 1000;
       System.out.println("\n실행시간(second) : " + secDiffTime);

	}

}


/* 모범 답안 코드 - 다익스트라 사용
 * 
 * 
 import java.util.*;

class Node implements Comparable<Node> {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class Main {
    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    public static int n, m, start;
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // 최단 거리 테이블 만들기
    public static int[] d = new int[30001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()) { // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();
            int dist = node.getDistance(); // 현재 노드까지의 비용 
            int now = node.getIndex(); // 현재 노드
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < dist) continue;
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            // X번 노드에서 Y번 노드로 가는 비용이 Z라는 의미
            graph.get(x).add(new Node(y, z));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);
        
        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 도달할 수 있는 노드의 개수
        int count = 0;
        // 도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단 거리
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            // 도달할 수 있는 노드인 경우
            if (d[i] != INF) {
                count += 1;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }

        // 시작 노드는 제외해야 하므로 count - 1을 출력
        System.out.println((count - 1) + " " + maxDistance);
    }
}
 * */