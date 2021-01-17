import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
    걸린시간: x
    문제점: 풀이방법은 알았는데 다익스트라 구현을 못해서 답봄..., N,M 잘 생각하기
 */

class Node implements Comparable<Node>{

    private int index;
    private int cost;

    Node(int index, int cost){
        this.index = index;
        this.cost = cost;
    }
    public int getIndex(){
        return index;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Node o) {
        if(this.cost < o.getCost() )
            return -1;
        else
            return 1;
    }
}

public class Main {


    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] d = new int[30001];
    public static final int INF = (int) 1e9;


    public static void dijkstra(int C){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(C, 0));
        d[C] = 0;



        while(!pq.isEmpty()){

            Node node = pq.poll();
            int index = node.getIndex();
            int cost = node.getCost();


            if(d[index] < cost)
                continue;


            for(int i = 0; i < graph.get(index).size(); i++){
                int cost2 = d[index] + graph.get(index).get(i).getCost();

                if(cost2 <  d[graph.get(index).get(i).getIndex()]){
                    d[graph.get(index).get(i).getIndex()] = cost2;
                    pq.offer(new Node(graph.get(index).get(i).getIndex(), cost2));
                }
            }



        }

    }
    public static void main(String[] args) {

        int N,M,C;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        C = sc.nextInt();

        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<Node>());
        }

        Arrays.fill(d, INF);

        for(int i = 1; i<= M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Node(b, c));
        }

        dijkstra(C);

        int city = 0;
        int time = 0;

        for(int i = 1; i<= N; i++){
            if(d[i] != INF) {
                city++;
                time = Math.max(time, d[i]);
            }
        }
        city += -1;

        System.out.print(city + " " + time);

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기


        long beforeTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}