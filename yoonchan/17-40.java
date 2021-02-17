
import java.util.*;

/*
    걸린시간:   28분 57초
    문제점:    처음에 시작할때 어떤알고리즘으로 풀지 생각이 들면 그것의 재료(변수, 자료형) 등등 떠올리기

 */

class Node implements Comparable<Node>{
    private int index, dist;

    public Node(int i, int d){
        this.index = i;
        this.dist = d;
    }

    public int getIndex() {
        return index;
    }

    public int getDist() {
        return dist;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.dist, o.dist);
    }
}
public class Main {

    public static int INF = (int) 1e9;
    public static int N,M;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] d;

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[1] = 0;

        while (!pq.isEmpty()){
            Node n = pq.poll();
            int now = n.getIndex();
            int dist = n.getDist();

            if(d[now] < dist)
                break;

            for(int i = 0 ; i < graph.get(now).size(); i++){
                int cost = d[now] + graph.get(now).get(i).getDist();

                if(cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));

                }
            }

        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N=  sc.nextInt();
        M = sc.nextInt();

        d = new int[N+1];

        Arrays.fill(d, INF);
        for(int i = 0; i<= N;i ++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0;  i< M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(new Node(b, 1));
            graph.get(b).add(new Node(a,1));
        }

        dijkstra(1);

        int max = -1;
        for(int i = 2; i < d.length; i++){
           max =  Math.max(max, d[i]);
        }


        int a = 0,b = 0,c = 0;

        for(int i = 2; i < d.length; i++){
            if(d[i] == max){
                a = i;
                break;
            }
        }
        for(int i = 2; i < d.length; i++){
            if(d[i] == max){
                b++;
            }
        }
        c  = max;


        System.out.print(a + " ");
        System.out.print(c + " ");
        System.out.print(b);

        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}