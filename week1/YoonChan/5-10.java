
import java.util.*;

/*
    걸린시간: 21분 10초
    문제점:  dfs 함수 주석 참고
 */


public class Main {


    public static int[] dx = {-1,1,0,0};//상하좌우
    public static int[] dy = {0,0,-1,1};

    public static int N,M;

    public static int dfs(int [][] graph, int x, int y){
        if(graph[x][y] == 1){
            return 0;
        }

        graph[x][y] = 1;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                continue;
            else {
                dfs(graph, nx, ny);
            }

        }

        //        graph[x][y] = 1; 여기에 이렇게 쓰면 자식노드가 부모노드를 또 다시 탐색하게 됨.
        return 1;

    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        sc.nextLine();

        int[][] graph = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] a = sc.nextLine().split("");
            for(int j = 0; j < M; j++){
                graph[i][j] = a[j].charAt(0) - '0';
            }
        }

        int result = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
               result += dfs(graph, i,j);
            }
        }

        System.out.println(result);



        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}