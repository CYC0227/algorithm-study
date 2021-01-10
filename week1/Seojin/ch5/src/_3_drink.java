import java.util.*;

public class _3_drink {
	public static int n, m;
    public static int[][] graph = new int[1000][1000];

    // DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
    public static boolean dfs(int x, int y) {
        // 주어진 범위를 벗어나는 경우에는 즉시 종료
        if (x <= -1 || x >=n || y <= -1 || y >= m) {
            return false;
        }
        // 현재 노드를 아직 방문하지 않았다면
        if (graph[x][y] == 0) {
            // 해당 노드 방문 처리
            graph[x][y] = 1;
            // 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
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

        // N, M을 공백을 기준으로 구분하여 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // 모든 노드(위치)에 대하여 음료수 채우기
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치에서 DFS 수행
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }
        System.out.println(result); // 정답 출력 
    }

	/*
	public static boolean[][] visited;
	public static int[][] graph;//배열 선언
	public static int result = 0;
	
	public static void dfs(int x, int y) {
		if(x<0 || x>graph.length-1 || y<0 || y>graph[0].length-1) 
			return;
		
		visited[x][y] = true;
		System.out.println("(" + x + "," + y + ") : " + graph[x][y]);
		
		//for(int i=0; i<graph.length; i++) {//행 길이
		//	for(int j=0; j<graph[i].length; j++) {//열 길이
				if(!visited[x][y] && graph[x][y] == 0) {// 방문하지 않은 것 중에서
					dfs(x-1,y);//상
					dfs(x+1,y);//하
					dfs(x,y-1);//좌
					dfs(x,y+1);//우
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
		
		graph = new int[N][M];//배열 초기화
		visited = new boolean[N][M];
		
		// input값 graph에 넣기
		for(int i=0; i<N; i++) {
			String input = sc.next();
			for(int j=0; j<M; j++) {
				graph[i][j] = input.charAt(j) - '0';
			}
		}
		
		dfs(0,0);
		System.out.println(result);
		
		
		//디버깅
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	*/
}
