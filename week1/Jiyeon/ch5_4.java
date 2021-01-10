// BFS - �̷�Ż��

import java.util.*;

/* ����� x,y ��ǥ�� ����*/
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
	
	// �̵� : ��,��,��,��
	public static int dx[] = {-1,1,0,0};
	public static int dy[] = {0,0,-1,1};
	
	public static int bfs(int x, int y) {
		
		// ó�� queue�� �����ϰ�, ���� ��ġ�� (0,0)�� ������  �߰��Ѵ�.
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		
		// queue�� �� ������ �� ������ �ݺ� ( queue�� ����ٴ� ����, ������ ������ �Դٴ� ��! )
		while(!q.isEmpty()) {
			Node node = q.poll(); // ť���� �� �ϳ� ������
			x = node.getX();
			y = node.getY();
			
			// ��,��,��,�� Ȯ��
			for(int i=0;i<4;i++) {
				// ��,��,��,�� �� ������ ��ġ
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				// ������ ��� ���� ����
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) 
					continue;
				
				//��(����)�� ���� ��� ����
				if(graph[nx][ny] == 0)
					continue;
				
				// 1�� ��� = ó�� �湮�� ��� ���� ���� x,y ��ġ�� �ִ� graph������ 1��  �߰����ش�. ( ��� 1 ���� )
				if(graph[nx][ny] == 1) {
					graph[nx][ny] = graph[x][y] +1 ; 
					q.add(new Node(nx,ny)); // queue�� �־��ֱ�
				}
			}
		}
		
		
		return graph[n-1][m-1];
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		n = keyboard.nextInt();
		m = keyboard.nextInt();
		keyboard.nextLine(); // ���� �����
		
		// �׷��� ���� �Է� �ޱ�
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
