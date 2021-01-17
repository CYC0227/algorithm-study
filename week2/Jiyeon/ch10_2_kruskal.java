// chapter 10 그래프 이론 - 크루스칼 알고리즘

import java.util.*;

class Edge implements Comparable<Edge> {
	private int a;
	private int b;
	private int value;
	
	public Edge(int a, int b, int value) {
		this.a = a;
		this.b = b;
		this.value = value;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getValue() {
		return value;
	}
	
	// 정렬 : cost 순으로 정렬
	@Override
	public int compareTo(Edge arg0) {
		return getValue() - arg0.getValue();
	}
	
}

public class ch10_2_kruskal {
	
	public static int vertex;
	public static int edge;
	public static ArrayList<Edge> edges = new ArrayList<>();
	public static int[] parent;
	
	public static int find(int x) {
		if(parent[x] != x)
			parent[x] = find(parent[x]);
		return parent[x];
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x < y)
			parent[y] = x;
		else
			parent[x] = y;	
	}
	
	public static void main(String[] args) {
		/* 실습 시간 : 35분 ( 2114 ~ 2139 )
		 * 어려운 점 : 계속 부모가 같지 않아서 value값이 싹다 더해짐 ㅠㅠ find함수에서 최종 return을 x가 아닌 parenet[x]로 해주니까 잘 돌아갔다.
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		vertex = keyboard.nextInt();
		edge = keyboard.nextInt();
		parent = new int[vertex+1];
		int result = 0;
		
		for(int i=0;i<edge;i++) {
			edges.add(new Edge(keyboard.nextInt(),keyboard.nextInt(),keyboard.nextInt()));
		}

		/* 코드 실행시간 계산 */
		long beforeTime = System.currentTimeMillis(); 
		
		for(int i=1;i<=vertex;i++) {
			parent[i] = i;
		}
		
		Collections.sort(edges);
		
		for(int i=0;i<edge;i++) {
			int a = edges.get(i).getA();
			int b = edges.get(i).getB();
			int value = edges.get(i).getValue();
			
			// 부모가 같지 않을 경우에만 포함시킴 (사이클 형성 안 함)
			if(find(a) != find(b)) {
				union(a,b);
				result += value;
			}
		}
		
		System.out.println(result);
		

		   /* 코드 실행시간 계산 */
	       long afterTime = System.currentTimeMillis();
	       long secDiffTime = (afterTime - beforeTime) / 1000;
	       System.out.println("\n실행시간(second) : " + secDiffTime);

	}

}
