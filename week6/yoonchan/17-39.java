
import java.util.*;

/*
    걸린시간:   35분 19초
    문제점:    처음에 dfs로 했다가 망함. dfs는 그래프가 011011 이런식일때만 쓰는듯?

 */

class Node implements Comparable<Node>{
    private int x,y;
    private int distance;


    public Node(int x, int y, int distance){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.distance, o.distance);
    }
}
public class Main {


    public static int T,N;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] dx = {-1,1,0,0};//상하좌우
    public static int[] dy = {0,0,-1,1};


    public static void dijkstra(int x, int y){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x,y, graph[x][y]));
        visited[x][y] = true;

        while(!pq.isEmpty()){
            Node n = pq.poll();
            int a = n.getX();
            int b = n.getY();
            int dist = n.getDistance();


            for(int i = 0 ; i < 4; i++){
                int nx = a + dx[i];
                int ny = b + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >=N)
                    continue;
                if(!visited[nx][ny]){
                    int nCost = dist + graph[nx][ny];
                    graph[nx][ny] = nCost;
                    visited[nx][ny] = true;
                    pq.offer(new Node(nx,ny,nCost));
                }

            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for(int i = 0;  i< T; i++){
            N = sc.nextInt();
            graph = new int[N][N];
            visited = new boolean[N][N];

            for(int j = 0; j < N; j++){
                for(int k = 0;  k < N; k++){
                    graph[j][k] = sc.nextInt();
                }
            }
            dijkstra(0,0);

            list.add(graph[N - 1][N - 1]);
        }

        for (int a :
                list) {
            System.out.println(a);
        }

        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}