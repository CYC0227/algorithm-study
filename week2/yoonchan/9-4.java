import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
    걸린시간: 22.35
    문제점: i <= N!!! 인거 의식하기, 문제 조건 동그라미 쳐놓고 다 썼는지 확인하기.
 */



public class Main {

    public static int[][] graph = new int[101][101];
    public static final int INF = (int) 1e9;

    public static void main(String[] args) {

        int N, M;
        int X, K;
        int result = 0;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for(int i =1; i<= N; i++){
            Arrays.fill(graph[i], INF);
        }

        for(int i = 0; i< M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        X = sc.nextInt();
        K = sc.nextInt();



        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++  ){
                if(i == j)
                    graph[i][j] = 0;
            }
        }

        for(int k = 1; k <=N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }


        result = graph[1][K] + graph[K][X];

        if(result >= INF)
            result = -1;

        System.out.println(result);







        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기


        long beforeTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
          System.out.println("시간차이(second) : " + secDiffTime);
    }
}