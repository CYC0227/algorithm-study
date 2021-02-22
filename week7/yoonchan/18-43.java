import java.util.*;

/*
    걸린시간:   18분 38초
    문제점:    크루스칼 숙지 부족. 답지 살짝 봄


 */

class Edge implements Comparable<Edge>{
    private int a, b, cost;

    public Edge(int a, int b, int cost){
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.cost, o.cost);
    }
}
public class Main {

    public static int N,M;
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static int[] parent;


    public static int findParent(int x){
        if(parent[x] == x) return x;

        return parent[x] =  findParent(parent[x]);
    }
    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a <b ) parent[b] = a;
        else parent[a] = b;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        parent = new int[N + 1];

        for(int i = 1;  i<= N; i++){
            parent[i] = i;
        }

        for(int i = 0; i <M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            edges.add(new Edge(a, b, cost));
        }

        Collections.sort(edges);

        int sum = 0;
        for(int i = 0; i < M; i++){
            Edge e = edges.get(i);

            if(findParent(e.getA())  == findParent(e.getB())) continue;

            unionParent(e.getA(),e.getB());
            sum += e.getCost();
        }

        int result = 0;
        result -= sum;

        for(int i = 0; i< edges.size(); i++){
            result += edges.get(i).getCost();
        }

        System.out.println(result);


        //   long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기

        // long beforeTime = System.currentTimeMillis();
        //   long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        //  System.out.println("시간차이(second) : " + secDiffTime);
    }
}