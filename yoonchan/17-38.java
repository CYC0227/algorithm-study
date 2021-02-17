
import java.util.*;

/*
    걸린시간:   53분 33초
    문제점:    처음에 생각해 낸 방법이 과연 맞는지 미리 천천히!!생각해보자... 항상 같은실수하네...
 */

class Node implements Comparable<Node>{
    private int index, distance;

    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
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

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] d;
    public static final int INF = (int) 1e9;

    public static void dijkstra(int start){
        Arrays.fill(d, INF);//!!!
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Node n = pq.poll();
            int now = n.getIndex();
            int dist = n.getDistance();


            if(d[now] < dist)
                continue;

            for(int i = 0; i < graph.get(now).size();i++){
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }
    public static void main(String[] args) {

        int N,M;

        Scanner sc=  new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        d = new int[N+1];

        Arrays.fill(d, INF);

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i< M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(new Node(b, 1));
        }

        List<Integer> list= new ArrayList<>();

        int cnt = 0;
        int result = 0;
        for(int i = 1; i <= N; i++){
            dijkstra(i);

            for(int j = 1; j <= N; j++){
                if(d[j] ==INF){//!!!!d 초기화 필요
                    list.add(j);
                }
            }
            for(int j = 0; j < list.size(); j++ ){
                dijkstra(list.get(j));
                if(d[i] != INF)
                    cnt++;
            }
            if(cnt == list.size())
                result++;

            cnt = 0;
           // Arrays.fill(d, INF);
            list = new ArrayList<>();
        }

        System.out.println(result);

        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}