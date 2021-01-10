// BFS - 미로탈출

import java.util.*;

/* 노드의 x,y 좌표를 저장*/
class Node {
	
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}

public class ch5_4 {

	public static int n;
	public static int m;
	public static int[][] graph = new int[200][200];
	
	// 이동 : 상,하,좌,우
	public static int dx[] = {-1,1,0,0};
	public static int dy[] = {0,0,-1,1};
	
	public static int bfs(int x, int y) {
		
		// 처음 queue를 선언하고, 시작 위치인 (0,0)의 정보를  추가한다.
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		
		// queue가 빈 공간이 될 때까지 반복 ( queue가 비었다는 것은, 마지막 노드까지 왔다는 것! )
		while(!q.isEmpty()) {
			Node node = q.poll(); // 큐에서 값 하나 꺼내기
			x = node.getX();
			y = node.getY();
			
			// 상,하,좌,우 확인
			for(int i=0;i<4;i++) {
				// 상,하,좌,우 로 움직인 위치
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				// 공간을 벗어난 경우는 제외
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) 
					continue;
				
				//벽(괴물)을 만난 경우 제외
				if(graph[nx][ny] == 0)
					continue;
				
				// 1인 경우 = 처음 방문한 경우 에는 현재 x,y 위치에 있는 graph값에서 1을  추가해준다. ( 경로 1 증가 )
				if(graph[nx][ny] == 1) {
					graph[nx][ny] = graph[x][y] +1 ; 
					q.add(new Node(nx,ny)); // queue에 넣어주기
				}
			}
		}
		
		
		return graph[n-1][m-1];
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		m = keyboard.nextInt();
		keyboard.nextLine(); // 버퍼 지우기
		
		// 그래프 정보 입력 받기
		for(int i=0;i<n;i++) {
			String str = keyboard.nextLine();
			for(int j=0;j<m;j++) {
				graph[i][j] = str.charAt(j) - '0';				
			}
		}
		
		int result = bfs(0,0);
		System.out.println(result);

	}

}
