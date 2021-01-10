import java.util.*;

public class _3_drink {
	public static int n, m;
    public static int[][] graph = new int[1000][1000];

    // DFS�� Ư�� ��带 �湮�ϰ� ����� ��� ���鵵 �湮
    public static boolean dfs(int x, int y) {
        // �־��� ������ ����� ��쿡�� ��� ����
        if (x <= -1 || x >=n || y <= -1 || y >= m) {
            return false;
        }
        // ���� ��带 ���� �湮���� �ʾҴٸ�
        if (graph[x][y] == 0) {
            // �ش� ��� �湮 ó��
            graph[x][y] = 1;
            // ��, ��, ��, ���� ��ġ�鵵 ��� ��������� ȣ��
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M�� ������ �������� �����Ͽ� �Է� �ޱ�
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // ���� �����

        // 2���� ����Ʈ�� �� ���� �Է� �ޱ�
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // ��� ���(��ġ)�� ���Ͽ� ����� ä���
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // ���� ��ġ���� DFS ����
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }
        System.out.println(result); // ���� ��� 
    }

	/*
	public static boolean[][] visited;
	public static int[][] graph;//�迭 ����
	public static int result = 0;
	
	public static void dfs(int x, int y) {
		if(x<0 || x>graph.length-1 || y<0 || y>graph[0].length-1) 
			return;
		
		visited[x][y] = true;
		System.out.println("(" + x + "," + y + ") : " + graph[x][y]);
		
		//for(int i=0; i<graph.length; i++) {//�� ����
		//	for(int j=0; j<graph[i].length; j++) {//�� ����
				if(!visited[x][y] && graph[x][y] == 0) {// �湮���� ���� �� �߿���
					dfs(x-1,y);//��
					dfs(x+1,y);//��
					dfs(x,y-1);//��
					dfs(x,y+1);//��
					result++;
				}
		//	}
		//}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //4
		int M = sc.nextInt(); //5
		
		graph = new int[N][M];//�迭 �ʱ�ȭ
		visited = new boolean[N][M];
		
		// input�� graph�� �ֱ�
		for(int i=0; i<N; i++) {
			String input = sc.next();
			for(int j=0; j<M; j++) {
				graph[i][j] = input.charAt(j) - '0';
			}
		}
		
		dfs(0,0);
		System.out.println(result);
		
		
		//�����
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	*/
}
