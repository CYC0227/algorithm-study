
import java.util.*;

/*
    걸린시간:   답지봄..
    문제점:    문제를 항상 정독하자...쉬운 문제도 다시보자

 */


public class Main {

    public static int[][] graph;
    public static final int INF = (int) 1e9;

    public static void main(String[] args) {

        int n,m;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n+1][n+1];

        for(int i = 0; i <= n; i++){
            Arrays.fill(graph[i], INF);
        }


        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j)
                    graph[i][j] = 0;
            }
        }

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if(c < graph[a][b])graph[a][b] = c;
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                int a = graph[i][j];

                if(a == INF)
                    System.out.print(0 + " ");
                else
                    System.out.print(a + " ");
            }
            System.out.println();
        }
        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}