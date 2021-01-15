// chapter 10 �׷��� �̷� - ũ�罺Į �˰���

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
	
	// ���� : cost ������ ����
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
		/* �ǽ� �ð� : 35�� ( 2114 ~ 2139 )
		 * ����� �� : ��� �θ� ���� �ʾƼ� value���� �ϴ� ������ �Ф� find�Լ����� ���� return�� x�� �ƴ� parenet[x]�� ���ִϱ� �� ���ư���.
		 * */
		
		Scanner keyboard = new Scanner(System.in);
		
		vertex = keyboard.nextInt();
		edge = keyboard.nextInt();
		parent = new int[vertex+1];
		int result = 0;
		
		for(int i=0;i<edge;i++) {
			edges.add(new Edge(keyboard.nextInt(),keyboard.nextInt(),keyboard.nextInt()));
		}

		/* �ڵ� ����ð� ��� */
		long beforeTime = System.currentTimeMillis(); 
		
		for(int i=1;i<=vertex;i++) {
			parent[i] = i;
		}
		
		Collections.sort(edges);
		
		for(int i=0;i<edge;i++) {
			int a = edges.get(i).getA();
			int b = edges.get(i).getB();
			int value = edges.get(i).getValue();
			
			// �θ� ���� ���� ��쿡�� ���Խ�Ŵ (����Ŭ ���� �� ��)
			if(find(a) != find(b)) {
				union(a,b);
				result += value;
			}
		}
		
		System.out.println(result);
		

		   /* �ڵ� ����ð� ��� */
	       long afterTime = System.currentTimeMillis();
	       long secDiffTime = (afterTime - beforeTime) / 1000;
	       System.out.println("\n����ð�(second) : " + secDiffTime);

	}

}
