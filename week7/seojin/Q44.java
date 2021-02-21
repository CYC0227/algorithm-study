/*
 * �� �ڵ� �� �ȵ��ư�
 * int a = planets.get(i).getNodeA(); ���⿡�� 0���� ���ʴ�� ���ư��� �ϴµ� �׷��� ����.. ��..?
 * planets.add(new planet(cost, i, j)); �̷��� �ϸ� ���ʴ�� �� ���°� �ƴѰ�?
 * �ʹ� ȭ��
 * ���� �װ���
 * �׳� �ھ߰ڽ�
 * �ʹ� ȭ����
 * �� �ȵ��ư����� �𸣰���
 */
import java.util.*;

class EEdge{
	private int x;
	private int y;
	private int z;
	
	public EEdge(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getx() {
		return this.x;
	}
	public int gety() {
		return this.y;
	}
	public int getz() {
		return this.z;
	}
	
}

class planet implements Comparable<planet> {
	private int distance;
	private int nodeA;
	private int nodeB;
	
	public planet(int distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}
	
	//Ŭ���� ���� ������ private�� ����Ǿ�� �ϱ� ������ getter �̿�
	public int getDistance() {
		return this.distance;
	}
	
	public int getNodeA() {
		return this.nodeA;
	}
	
	public int getNodeB() {
		return this.nodeB;
	}
	
	//Collections�� sort�޼ҵ尡 ������ ���� ������ ã�� ���ؼ�(���� ������, ����)
	//�Ÿ�(���)�� ª�� ���� ���� �켱������ �������� ����
	@Override
	public int compareTo(planet other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
}

public class Q44 {
	
	public static int n;
	public static int[] parent = new int[100001];
	public static ArrayList<EEdge> edges = new ArrayList<>();
	public static ArrayList<planet> planets = new ArrayList<>();
	public static int result = 0;
	
	public static int solve(int ax, int ay, int az, int bx, int by, int bz) {
		int a = Math.abs(ax-bx);
		int b = Math.abs(ay-bx);
		int c = Math.abs(az-bz);
		
		int result1 = (a<b)?a:b;
		int result2 = (c<result1)?c:result1;
		return result2;
	}
	
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
		
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		//�༺�� 3���� ��ǥ
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			edges.add(new EEdge(x,y,z));
		}
		
		int cnt = 1; //4
		for(int i=0; i<n; i++) { //5��
			for(int j=cnt; j<=n-1; j++) { //4�� 3�� 2�� 1��
				int cost = solve(edges.get(i).getx(), edges.get(i).gety(), edges.get(i).getz(), edges.get(j).getx(), edges.get(j).gety(), edges.get(j).getz());
				planets.add(new planet(cost, i, j));
				
			}
			cnt++;
		}
		
		Collections.sort(planets);
		
		//���� �ϳ��� Ȯ���ϸ�
		for(int i=0; i<planets.size(); i++) {
			//�ٸ� Ŭ������ �ֱ� ������ �̸� �������� ���ؼ�?
			int cost = planets.get(i).getDistance();
			int a = planets.get(i).getNodeA();
			int b = planets.get(i).getNodeB();
			//�����
			System.out.print(planets.get(i).getNodeA() + " ");
			System.out.println(planets.get(i).getNodeB());
			//����Ŭ �߻� ���ϴ� ��쿡�� ���տ� ����
			if(findParent(a) != findParent(b)) {
				unionParent(a, b);
				result += cost;
			}
			
		}
		System.out.println(result);
	}

}
