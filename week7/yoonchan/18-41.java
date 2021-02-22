
import java.lang.reflect.Array;
import java.util.*;

/*
    걸린시간:   20분 42초
    문제점:    union-find 알고리즘은 각 노드가 한집합에 있는지(서로 연결되어있는지) 알기에 유용하다 - 전부 같은 부모면 연결, 아니면 비연결 상태


 */


public class Main {

    public static int N,M;
    public static int[][] graph;
    public static int[] parent;

    public static int findParent(int x){
        if(parent[x] == x) return x;

        return parent[x] = findParent(parent[x]);
    }
    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a < b) parent[b] = a;
        else    parent[a] = b;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N + 1][ N + 1];
        parent = new int[N + 1];

        for(int i = 1; i<= N; i++){
            parent[i] = i;
        }


        for(int i = 1; i<= N; i++){
            for(int j = 1; j<= N; j++){
                int a = sc.nextInt();
                graph[i][j] = a;
            }
        }

        for(int i = 1; i<= N; i++){
            for(int j = i + 1; j<= N; j++){
                if(graph[i][j] == 1) unionParent(i, j);
            }
        }


        int[] arr = new int[M];

        for(int i = 0 ; i < M; i++){
            int now = sc.nextInt();
            now = findParent(now);
            arr[i] = now;
        }

        String answer = "YES";

        for(int i = 0 ; i < M - 1; i++){
            if(arr[i] != arr[i + 1])
                answer = "NO";
        }

        System.out.println(answer);


        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}