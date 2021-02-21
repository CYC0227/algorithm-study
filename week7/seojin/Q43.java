/*
 * �������� ũ�罺Į �˰��� �������� �� ����.
 * �տ� Ǯ���� ������ �Ϻ��ϰ� ���� ������ ���� Ǯ �� �־���.
 * !ũ�罺Į �˰��� �ڵ带 �Ϻ��ϰ� �ܿ�� ���� ��!
 * 
 * ó������ ����Ŭ�� �־ �ȴٰ� �����߾���.
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
		
		//��� ���� ���� �Է� �ޱ�
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			edges.add(new EEdge(cost,a,b));
		}
		
		//�������� ����
		Collections.sort(edges);
		int sum = 0; //��ü ���ε� ���
		
		for(int i=0; i<edges.size(); i++) {
			//�ٸ� Ŭ������ �ֱ� ������ �̸� �������� ���ؼ�?
			int cost = edges.get(i).getDistance();
			int a = edges.get(i).getNodeA();
			int b = edges.get(i).getNodeB();
			sum += cost; //�� ���ع���

			//����Ŭ �߻� ���ϴ� ��쿡�� ���տ� ����
			if(findParent(a) != findParent(b)) {
				unionParent(a, b);
				result += cost;//��Ȱ��ȭ�� ���� ���� �͵�
			}
			
		}
		System.out.println(sum - result);
	}

}
