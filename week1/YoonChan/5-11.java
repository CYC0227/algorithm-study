
import java.util.*;

/*
    걸린시간:
    문제점:
 */


class Node{

    private int x,y;

    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
public class Main {

    public static int[][] graph;

    public static int[] dx = {-1,1,0,0};//상하좌우
    public static int[] dy = {0,0,-1,1};
    public static int N,M;

    public static void bfs(int x,int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));


        while(!q.isEmpty()){
            Node n = q.poll();
            int a = n.getX();
            int b = n.getY();

            for(int i = 0; i < 4; i++){
                int nx = a + dx[i];// 무의식적으로 x + dx[i] 하지 않기
                int ny = b + dy[i];


                if(nx <= 0 || nx > N || ny <= 0 || ny > M)
                    continue;
                if(graph[nx][ny] == 0)
                    continue;

                if(graph[nx][ny] == 1){
                    graph[nx][ny] = graph[a][b] + 1;
                    q.offer(new Node(nx,ny));
                }

            }
        }

    }
    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        sc.nextLine();

        graph = new int[N+1][M+1];

        for(int i = 1 ; i <= N ; i++){
            String str  =sc.nextLine();
            for(int j = 1 ;  j <= M; j++){
                graph[i][j] = str.charAt(j - 1) - '0';
            }
        }


        bfs(1,1);
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ;  j <= M; j++){
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }

        System.out.println(graph[N][M]);
        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}