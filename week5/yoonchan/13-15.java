
import java.util.*;

/*
    걸린시간: 답지봄 36분 + a
    문제점:     for(int i = 0; i <=N; i++){//@@@@@@@@@@@@!!!!!!!!!!!!!!!!!!!!!@@@@@@@@@@@
            graph.add(new ArrayList<>());
        }
        이거 조심하기....

        안가본곳은 cost -1로 초기화하기

        visited 아닌 d 생각하기 - 그래프 종류 두가지 기억하기

        q.offer 할떄는 반드시 조건 붙는다

 */


public class Main {

    public static  int N,M,K,X;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] d;

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        d[start] = 0;

        while(!q.isEmpty()){
            int a = q.poll();


            for(int i = 0 ; i < graph.get(a).size(); i++){
                int b = graph.get(a).get(i);

                if(d[b] == -1) {
                    d[b] = d[a] + 1;
                    q.offer(b);
                }
            }

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();

        d = new int[N + 1];

        Arrays.fill(d,-1);

        for(int i = 0; i <=N; i++){//@@@@@@@@@@@@!!!!!!!!!!!!!!!!!!!!!@@@@@@@@@@@
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
        }

        bfs(X);

        int cnt = 0;
        for(int i = 1; i <= N; i++){
            if(d[i] == K){
                System.out.println(i);
                cnt++;
            }
        }

        if(cnt == 0)
            System.out.println(-1);


        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}