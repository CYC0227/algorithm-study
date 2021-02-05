
import java.util.*;

/*
    걸린시간: 못푼거
    문제점:

 */

class Node{
    private int x,y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
public class Main {

    public static int N,M;
    public static int[][] graph;
    public static int[][] clone_graph;

    public static int[] dx = {-1,1,0,0};//상하좌우
    public static int[] dy = {0,0,-1,1};

    public static int cnt = 0;
    public static int dfs_result = -1;
    public static int bfs_result = 0;
    public static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));


        while(!q.isEmpty()){
            Node n = q.poll();
            int a = n.getX();
            int b = n.getY();

            for(int i = 0; i< 4; i++){
                int nx = a + dx[i];
                int ny = b + dy[i];

                if(nx <0||ny < 0|| nx >= N|| ny >= M ){
                    continue;
                }
                if(clone_graph[nx][ny] != 0)
                    continue;

                clone_graph[nx][ny] = 2;
                q.offer(new Node(nx,ny));
            }

        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(clone_graph[i][j] == 0)
                    bfs_result += 1;
            }
        }
        return bfs_result;
    }


    public static int dfs(int x, int y){
        if(graph[x][y] == 1 || graph[x][y] == 2){
            return -1;
        }

        graph[x][y] = 1;

        if(cnt == 3){
            clone_graph = graph.clone();

            int now = -1;
            now = bfs(x,y);
            dfs_result = Math.max(now,dfs_result);
        }

        for(int i = 0; i < 4; i++ ){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx <0||ny < 0|| nx >= N|| ny >= M ){
                continue;
            }

            cnt++;

            dfs(nx,ny);

            graph[x][y] = 0;

            cnt--;
        }





        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();





        return dfs_result;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                graph[i][j] = sc.nextInt();
            }
        }

        int res = 0;
        int cur = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                cur = dfs(i,j);
                res = Math.max(res,cur);
            }
        }



        System.out.println(res);

        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}