/*
 * 전형적인 크루스칼 알고리즘 문제였던 것 같음.
 * 앞에 풀었던 예제와 완벽하게 같은 문제라 쉽게 풀 수 있었음.
 * !크루스칼 알고리즘 코드를 완벽하게 외우고 있을 것!
 * 
 * 처음에는 사이클이 있어도 된다고 생각했었음.
 */
import java.util.*;

class Edge implements Comparable<EEdge>{
	private int distance;
	private int nodeA;
	private int nodeB;
	
	public Edge(int distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	public int getNodeA() {
		return this.nodeA;
	}
	
	public int getNodeB() {
		return this.nodeB;
	}
	
	@Override
	public int 	compareTo(EEdge other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
}

public class Q43 {

	public static int n,m;
	public static int[] parent = new int[200001];
	public static ArrayList<EEdge> edges = new ArrayList<>();
	public static int result = 0;
	
	public static int findParent(int x) {
		if(x==parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
		
		//모든 간선 정보 입력 받기
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			edges.add(new EEdge(cost,a,b));
		}
		
		//오름차순 정렬
		Collections.sort(edges);
		int sum = 0; //전체 가로등 비용
		
		for(int i=0; i<edges.size(); i++) {
			//다른 클래스에 있기 때문에 이를 가져오기 위해서?
			int cost = edges.get(i).getDistance();
			int a = edges.get(i).getNodeA();
			int b = edges.get(i).getNodeB();
			sum += cost; //다 더해버림

			//사이클 발생 안하는 경우에만 집합에 포함
			if(findParent(a) != findParent(b)) {
				unionParent(a, b);
				result += cost;//비활성화가 되지 않은 것들
			}
			
		}
		System.out.println(sum - result);
	}

}
