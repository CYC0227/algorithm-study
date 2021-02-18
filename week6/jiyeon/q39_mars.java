// chapter 17 최단 경로 문제 - 39번) 화성 탐사
package shortestPath;
import java.util.*;

class Mars implements Comparable<Mars>{
	private int x;
	private int y;
	private int dis;
	
	public Mars(int x, int y, int dis){
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getDis() {
		return this.dis;
	}

	@Override
	public int compareTo(Mars o) {
		// TODO Auto-generated method stub
		if(this.dis < o.dis)
			return -1;
		
		return 1;
	}
	
}

public class q39_mars {

	public static void main(String[] args) {
		/* 실습 시간 : 74분 ( 1050 ~ 1204 )
		 * 자꾸자꾸 10이 나왔다.
		 * 알고보니 INF값을 10으로 설정해놔서 10보다 큰 값이 생겨나면 무조건 10이 선택되기 때문이었다 ㅠㅠㅠ
		 * INF값을 최대한 높게 잡아야겠다 앞으로는..
		 * && 방문한 노드 처리할 때 방문처리보다 if문을 먼저 써서 계속 오류
		 * */
		Scanner keyboard = new Scanner(System.in);
		int t = keyboard.nextInt(); // test case 개수
		int n; // 탐사 공간의 크기
		int INF = 100000; // 크기의 최대 비용이 9니까 무한대를 10으로 설정 -> 했다가 망함. 단순히 최대비용 말고 합의 최대비용을 생각해야함 ㅠ
		
		// 상하좌우로 이동
		int[] x = {-1,1,0,0};
		int[] y = {0,0,-1,1};
		
		while(t>0) {
			
			n = keyboard.nextInt(); // 탐사 공간의 크기
			int[][] arr = new int[n][n];
			int[][] d = new int[n][n];
			int[][] visitied = new int[n][n]; // 방문 : 1
			
			PriorityQueue<Mars> q = new PriorityQueue<>();
			
			for(int i=0;i<n;i++) {
				Arrays.fill(d[i],INF);
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j] = keyboard.nextInt();
				}
			}
			
			int a=0,b=0; // 시작위치 a,b
			q.offer(new Mars(0,0,arr[0][0]));
			d[0][0] = arr[0][0];
			
			while(!q.isEmpty()) {
				Mars now = q.poll();
				a = now.getX();
				b = now.getY();
				int dist = now.getDis();
				
				// 이미 방문한 노드면 패스하기
				if(visitied[a][b] == 1) continue;
				
				visitied[0][0] = 1; // 현재 노드 방문처리 
				
				// 상하좌우로 비교
				for(int i=0;i<4;i++) {
					if(a+x[i]<0 || a+x[i]>=n || b+y[i]<0 || b+y[i]>=n) 	continue; // 범위 벗어나면 패스
					
					int cost = dist + arr[a+x[i]][b+y[i]]; // 현재 거리값에 상,하,좌,우 거리값 중 하나 더해주기 ( 바로가기 vs  거쳐가기 )
					
					// 거쳐가는 것이 바로 가는 것보다 작으면 업데이트
					if(cost < d[a+x[i]][b+y[i]]) {
						d[a+x[i]][b+y[i]] = cost;
						q.offer(new Mars(a+x[i],b+y[i],cost));
					}
				}
			}
			
			System.out.println(d[n-1][n-1]);
			t--;
		}
	}

}
